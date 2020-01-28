package assignment7;

/*Program to perform operation on sparse matrix
 * @author Akshay
 * */
public class SparseMatrix 
{
	private final int sparse[][];
	private int countNonZero;
	private int row;
	private int col;

	/*
	 * assign initialzing array to spare array(in sparse form)
	 * @param intializingArray
	 */
	SparseMatrix(int[][] intializingArray)
	{
		if ( intializingArray.length == 0)
		{
			throw new AssertionError();
		}
		if ( !checkSparseValid(intializingArray))
		{
			throw new AssertionError();
		}
		this.sparse = createSpare(intializingArray);
	}

	/*
	 * create sparse matrix from the 2d matrix(taken from user)
	 * @param arr as a array of int type
	 * @return sparseMatrix as a sparse matrix(row,column,value)
	 */
	private int[][] createSpare(int[][] arr) 
	{
		int sparseMatrix[][] = new int[this.countNonZero][3], k=0;
		for ( int i=0; i<this.row; i++ )
		{
			for ( int j=0; j<this.col; j++ )
			{
				if ( arr[i][j] != 0 )
				{
					sparseMatrix[k][0] = i;
					sparseMatrix[k][1] = j;
					sparseMatrix[k][2] = arr[i][j];
					k++;
				}
			}
		}
		return sparseMatrix;
	}

	/*
	 * find 2d matrix is correct or not
	 * @param arr as a array of int type
	 * @return true if 2d matrix contains non zero element less than zero element 
	 * @return false if not less than zero element
	 */
	private boolean checkSparseValid(int[][] arr)
	{
		this.row = arr.length; int countZero=0;
		this.col = arr[0].length;
		for ( int i=0; i<row; i++ )
		{
			for ( int j=0; j<col; j++ )
			{
				if ( arr[i][j] == 0 )
				{
					countZero++;
				}
			}
		}
		this.countNonZero = row*col-countZero;
		if ( countZero < this.countNonZero)
			return false;
		return true;
	}

	/*
	 * find transpose of sparse matrix
	 * @return transpose matrix as a arrray of int type in sparse form(row,column,value)
	 */
	public int[][] transpose()
	{
		int rowLen = this.sparse.length;
		int tranposeMatrix[][] = new int[rowLen][3];
		for ( int i=0; i<rowLen; i++ )
		{
			tranposeMatrix[i][1] = this.sparse[i][0];
			tranposeMatrix[i][0] = this.sparse[i][1];
			tranposeMatrix[i][2] = this.sparse[i][2];
		}
		return tranposeMatrix;
	}

	/*
	 * check sparse matrix is symmetric or not
	 * @return true if sparse matrix is symmetric otherwise false
	 * @throws Assertion Error if row is not equal to column of called object this function
	 */
	public boolean symmetric()
	{
		int rowValue, colValue, value, j;
		int rowLen = this.sparse.length;
		if ( !(this.row == this.col) )
		{
			throw new AssertionError();
		}
		for ( int i=0; i<rowLen; i++ )
		{
			rowValue = this.sparse[i][0];
			colValue = this.sparse[i][1];
			if ( rowValue == colValue )
				continue;
			value = this.sparse[i][2];
			for ( j=0; j<rowLen; j++ )
			{
				if ( rowValue==this.sparse[j][1] && colValue==this.sparse[j][0] && value==this.sparse[j][2])
					break;
			}
			if ( j == rowLen)
				return false;
		}
		return true;
	}

	/*
	 * find the addition of two sparse matrix 
	 * @param objFirst as a second object and first object is function called
	 * @return addmatrix as a array of int type in sparse form(row,column,value)
	 * @throws Assertion Error if row of first matrix is not equal to row of second matrix or smae for column
	 */
	public int[][] additionSparse(SparseMatrix objFirst) throws AssertionError{
		if(row!=objFirst.row && col!=objFirst.col)
			throw new AssertionError();
		int rowLenFirst = sparse.length, rowLenSecond = objFirst.sparse.length, k=0, j, i;
		int addMatrix[][] = new int[rowLenFirst+rowLenSecond][3];
		for(i=0 ; i<rowLenFirst ; i++)
		{	
			for(j=0 ; j<rowLenSecond ; j++)
			{
				if(sparse[i][0]==objFirst.sparse[j][0] && sparse[i][1]==objFirst.sparse[j][1])
				{
					addMatrix[k][0]=sparse[i][0]; 
					addMatrix[k][1]=sparse[i][1];
					addMatrix[k][2]=sparse[i][2] + objFirst.sparse[j][2];
					k++;
					break;
				}
			}
			if ( j == rowLenSecond )
			{
				addMatrix[k][0]=sparse[i][0]; 
				addMatrix[k][1]=sparse[i][1]; 
				addMatrix[k][2]=sparse[i][2];
				k++;
			}
		}
		for(j=0 ; j<rowLenSecond ; j++)
		{
			for(i=0 ; i<rowLenFirst ; i++)
			{
				if(sparse[i][0]==objFirst.sparse[j][0] && sparse[i][1]==objFirst.sparse[j][1])
					break;
			}
			if ( i == rowLenFirst )
			{
				addMatrix[k][0]=objFirst.sparse[j][0]; 
				addMatrix[k][1]=objFirst.sparse[j][1]; 
				addMatrix[k][2]=objFirst.sparse[j][2];
				k++;
			}
		}		
		return addMatrix;
	}

	/*
	 * find multiply of two matrix in sparse form
	 * @param objFirst as a first object of SparseMatrix type
	 * @param objSecond as a second object of SparseMatrix type
	 * @return newMatrix as a 2d-array of int type
	 * @throws AssertionError if col of first object array is not equal to row of second array
	 */
	public  int[][] multiplySparse(SparseMatrix objFirst, SparseMatrix objSecond) throws AssertionError{
		int rowLenFirst = objFirst.row, rowLenSecond = objSecond.row, colLenFirst = objFirst.col;
		if(colLenFirst != rowLenSecond)
			throw new AssertionError("Mismatch in dimensions of col*row of matrices.");

		int[][] newMatrix = new int[rowLenFirst][colLenFirst];

		for ( int i =0; i<objFirst.sparse.length; i++ )
		{
			for ( int j=0; j<objSecond.sparse.length; j++ )
			{
				if(objFirst.sparse[i][1] == objSecond.sparse[j][0])
				{
					newMatrix[objFirst.sparse[i][0]][objSecond.sparse[j][1]] += objFirst.sparse[i][2] * objSecond.sparse[j][2];
				}
			}
		}
		return newMatrix;
	}
}


