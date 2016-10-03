/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplab1;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Haseeb Khizar
 */
public class Mat {
    static Scanner input = new Scanner(System.in);
	void multiplyMat(int [][] input1, int [][] input2, int [][] resultMat,
	        int resultRows, int resultCols, int mat1cols) 
	{
			for (int i = 0; i < resultRows; i++) 
			{
				resultMat[i] = new int[resultCols];
				for (int j = 0; j < resultCols; j++)
				{
					resultMat[i][j] = 0;
	            for (int k = 0; k < mat1cols; k++) 
	            {
	                resultMat[i][j] += input1[i][k] * input2[k][j];
	            }
	        }
	    }
	}
	
	void addMat(int [][] input1, int [][] input2, int [][] resultMat, int matSize) 
	{
	    for (int i = 0; i < matSize; i++) 
	    {
	        resultMat[i] = new int[matSize];
	        for (int j = 0; j < matSize; j++) 
	        {
	            resultMat[i][j] = input1[i][j] + input2[i][j];
	        }
	    }
	}
	
	void subMat(int [][] input1, int [][] input2, int [][] resultMat, int matSize) 
	{
	    for (int i = 0; i < matSize; i++)
	    {
	        resultMat[i] = new int[matSize];
	        for (int j = 0; j < matSize; j++) 
	        {
	            resultMat[i][j] = input1[i][j] - input2[i][j];
	        }
	    }
	}
	
	void multiplyMatStras(int [][] input1, int [][] input2, int [][] resultMat, int matSize) 
	{
	    if (matSize <= 2) 
	    {
	        //  cout<<"matsize less than or equal to 2"<<endl;
	        multiplyMat(input1, input2, resultMat, matSize, matSize, matSize); //base condition.
	    }
	    else 
	    {
	        int matNewSize = matSize / 2;
	        /*
	         *  Creating A= A00 A01   and B= B00 B01
	         *              A10 A11          B10 B11
	         *  
	         */
	        int [][] A00 = new int [matSize][matSize];
	        int [][] A01 = new int [matSize][matSize];
	        int [][] A10 = new int [matSize][matSize];
	        int [][] A11 = new int [matSize][matSize];
	        int [][] B00 = new int [matSize][matSize];
	        int [][] B01 = new int [matSize][matSize];
	        int [][] B10 = new int [matSize][matSize];
	        int [][] B11 = new int [matSize][matSize];
	        //cout<<"init A and B"<<endl;
	        /*
	         * splitting the input arrays into 4 subarrays
	         */
	        
	        int[][] A = new int[matSize][matSize];
	        int[][] B = new int[matSize][matSize];
	        
	        for(int i=0; i<matSize; i++)
	        {
	        	for(int j=0; j<matSize; j++)
	        	{
	        		A[i][j]=0;
	        		B[i][j]=0;
	        	}
	        }
	        

	        for (int i = 0; i < matNewSize; i++)
	        {
	        	
	        		A00[i] = new int[matSize];
	        		A01[i] = new int[matSize];
	        		A10[i] = new int[matSize];
	        		A11[i] = new int[matSize];
	        		B00[i] = new int[matSize];
	        		B01[i] = new int[matSize];
	        		B10[i] = new int[matSize];
	        		B11[i] = new int[matSize];
	        		
	        		//A[i][j] = new int[matSize][matSize];
	        	
	            for (int j = 0; j < matNewSize; j++)
	            {

	                A00[i][j] = input1[i][j];
	                A01[i][j] = input1[i][j + matNewSize];
	                A10[i][j] = input1[i + matNewSize][j];
	                A11[i][j] = input1[i + matNewSize][j + matNewSize];

	                B00[i][j] = input2[i][j];
	                B01[i][j] = input2[i][j + matNewSize];
	                B10[i][j] = input2[i + matNewSize][j];
	                B11[i][j] = input2[i + matNewSize][j + matNewSize];

	            }
	        }
	        /*
	         * On to calculating matrices now
	         */

	        /*
	         * init temp variables(matrices)
	         */
	        int [][] addTemp1 = new int [matSize][matSize];
	        int [][] addTemp2 = new int [matSize][matSize];
	        int [][] addTemp3 = new int [matSize][matSize];
	        int [][] subTemp1 = new int [matSize][matSize];
	        int [][] subTemp2 = new int [matSize][matSize];
	        int [][] m1 = new int [matSize][matSize];
	        int [][] m2 = new int [matSize][matSize];
	        int [][] m3 = new int [matSize][matSize];
	        int [][] m4 = new int [matSize][matSize];
	        int [][] m5 = new int [matSize][matSize];
	        int [][] m6 = new int [matSize][matSize];
	        int [][] m7 = new int [matSize][matSize];

	        /*
	         * Calculating M1
	         */
	        addMat(A00, A11, addTemp1, matNewSize);
	        addMat(B00, B11, addTemp2, matNewSize);

	        multiplyMatStras(addTemp1, addTemp2, m1, matNewSize);

	        //cout<<"m1 done"<<endl;

	        /*
	         * Calculating M2
	         */
	        addMat(A10, A11, addTemp3, matNewSize);
	        multiplyMatStras(addTemp3, B00, m2, matNewSize);
	        //cout<<"m2 done"<<endl;

	        /*
	         * Calculating M3
	         */
	        subMat(B01, B11, subTemp1, matNewSize);
	        multiplyMatStras(A00, subTemp1, m3, matNewSize);
	        //cout<<"m3 done"<<endl;

	        /*
	         * Calculating M4
	         */
	        subMat(B10, B00, subTemp2, matNewSize);
	        multiplyMatStras(A11, subTemp2, m4, matNewSize);
	        //cout<<"m4 done"<<endl;

	        /*
	         * Calculating M5
	         */

	        addMat(A00, A01, addTemp1, matNewSize);
	        multiplyMatStras(addTemp1, B11, m5, matNewSize);
	        //cout<<"m5 done"<<endl;

	        /*
	         * Calculating M6
	         */
	        subMat(A10, A00, subTemp1, matNewSize);
	        addMat(B00, B01, addTemp2, matNewSize);
	        multiplyMatStras(subTemp1, addTemp2, m6, matNewSize);
	        //cout<<"m6 done"<<endl;

	        /*
	         * Calculating M7
	         */

	        subMat(A01, A11, subTemp2, matNewSize);
	        addMat(B10, B11, addTemp1, matNewSize);

	        multiplyMatStras(subTemp2, addTemp1, m7, matNewSize);
	        //cout<<"m7 done"<<endl;


	        /*
	         *  Now calculating sub matrices C = C00 C01
	         *                                   C10 C11
	         */

	        int [][]C00 = new int [matSize][matSize];
	        int [][]C01 = new int [matSize][matSize];
	        int [][]C10 = new int [matSize][matSize];
	        int [][]C11 = new int [matSize][matSize];

	        /*
	         * Calculating C00
	         */
	        addMat(m1, m4, addTemp1, matNewSize);
	        addMat(addTemp1, m7, addTemp2, matNewSize);
	        subMat(addTemp2, m5, C00, matNewSize);
	        //cout<<"C00 done"<<endl;
	        /*
	         * Calculating C01
	         */
	        addMat(m3, m5, C01, matNewSize);
	        //cout<<"C01 done"<<endl;
	        /*
	         * Calculating C10
	         */
	        addMat(m2, m4, C10, matNewSize);
	        //cout<<"C10 done"<<endl;
	        /*
	         * Calculating C11
	         */
	        addMat(m1, m3, addTemp1, matNewSize);
	        addMat(addTemp1, m6, addTemp2, matNewSize);
	        subMat(addTemp2, m2, C11, matNewSize);
	        //cout<<"C11 done"<<endl;

	        /*
	         * Combining the sub matrices now
	         */
	        for (int i = 0; i < matNewSize; i++)
	        {
	            resultMat[i] = new int[matSize];
	            resultMat[i + matNewSize] = new int[matSize];
	            for (int j = 0; j < matNewSize; j++)
	            {
	                resultMat[i][j] = C00[i][j];
	                resultMat[i][j + matNewSize] = C01[i][j];
	                resultMat[i + matNewSize][j] = C10[i][j];
	                resultMat[i + matNewSize][j + matNewSize] = C11[i][j];
	            }
	        }
	        //cout<<"sub-matrices combined"<<endl;

	    }
	}
	
	void initMat(int [][]matrix, int rows, int cols)
	{
	    for (int row_Ite = 0; row_Ite < rows; row_Ite++) 
	    {
	        matrix[row_Ite] = new int[cols];
	        for (int col_Ite = 0; col_Ite < cols; col_Ite++)
	        {
	            matrix[row_Ite][col_Ite] = row_Ite + col_Ite;
	        }
	    }
	}

	void displayMat(int [][]matrix, int rows, int cols)
	{
	    for (int i = 0; i < rows; i++)
	    {

	        for (int j = 0; j < cols; j++) 
	        {
	            System.out.print(matrix[i][j] + "   ");
	        }
	        System.out.println();
	    }
	}
	
        static int log2(int x){
            return (int)((int) Math.log(x)/Math.log(2));
        }
	public static void main(String args[])
	{
            System.out.println("Enter row of first matrix");
            int r1 = input.nextInt();
            System.out.println("Enter column of first matrix");
            int c1 = input.nextInt();
            System.out.println("Enter row of second matrix");
            int r2 = input.nextInt();
            System.out.println("Enter column of second matrix");
            int c2 = input.nextInt();
            
            
            //revise user defined dimensions and make dimensions those of square matrix
            if (r1 != c1){
                if (log2(r1) > 1 && log2(c1) > 1){
                    if (r1 > c1){
                      int x = log2(r1)+1;
                      r1 = (int) Math.pow((double)2, (double)x);
                      c1 = (int) Math.pow((double)2, (double)x);
                    } else {
                      int x = log2(c1)+1;
                      r1 = (int) Math.pow((double)2, (double)x);
                      c1 = (int) Math.pow((double)2, (double)x);  
                    }
                }
            } else {
                if (log2(r1) > 1){
                    int x = log2(r1)+1;
                    r1 = (int) Math.pow((double)2, (double)x);
                    c1 = (int) Math.pow((double)2, (double)x);
                }
            }
            if (r2 != c2){
                if (log2(r2) > 1 && log2(c2) > 1){
                    if (r2 > c2){
                      int x = log2(r2)+1;
                      r2 = (int) Math.pow((double)2, (double)x);
                      c2 = (int) Math.pow((double)2, (double)x);
                    } else {
                      int x = log2(c2)+1;
                      r2 = (int) Math.pow((double)2, (double)x);
                      c2 = (int) Math.pow((double)2, (double)x);  
                    }
                }
            } else {
                if (log2(r2) > 1){
                    int x = log2(r2)+1;
                    r2 = (int) Math.pow((double)2, (double)x);
                    c2 = (int) Math.pow((double)2, (double)x);
                }
            }
            
            
                 
            if (r2 != c1)
	    {
	        System.out.print("columns of first is not equal to rows of second!");
	    }  
            
	    
	    
	    int mat1Rows = r1;
	    int mat1cols = c1;
	    int mat2Rows = r2;
	    int mat2cols = c2;
	    
	    
	    
	    int resultRows = mat1Rows;
	    int resultCols = mat2cols;
	    //cout<<resultRows<<"x"<<resultCols<<endl;
	    int [][] inputMat1 = new int [mat1Rows][mat1Rows];

	    int [][] inputMat2 = new int [mat2Rows][mat2Rows];
	    int [][] resultMat = new int [resultRows][resultRows];
	    int [][] resultMatStras = new int [resultRows][resultRows];

	    Mat obj = new Mat();

	    System.out.println("first Matrix");
	    obj.initMat(inputMat1, mat1Rows, mat1cols);
	    System.out.println("first Matrix display");
	    obj.displayMat(inputMat1, mat1Rows, mat1cols);
	    System.out.println("second Matrix");
	    obj.initMat(inputMat2, mat2Rows, mat2cols);
	    obj.displayMat(inputMat2, mat2Rows, mat2cols);
	    System.out.println("calling multiply");
	    obj.multiplyMat(inputMat1, inputMat2, resultMat, resultRows, resultCols, mat1cols);
	    System.out.println("result = ");
	    obj.displayMat(resultMat, resultRows, resultCols);
	    System.out.println("calling multiply by strassen's algorithm");

	    obj.multiplyMatStras(inputMat1, inputMat2, resultMatStras, resultRows);
	    System.out.println("strassen's result");
	    obj.displayMat(resultMatStras, resultRows, resultCols);
	    obj.subMat(resultMat, resultMatStras, inputMat2, resultRows);
	    System.out.println("diff between the two results");
	    obj.displayMat(inputMat2, resultRows, resultCols);

	}
}
