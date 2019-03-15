package a04;
import edu.princeton.cs.algs4.Queue;

/**
 * This program creates an immutable data type Board for solving
 * the 8-puzzle problem.
 * @author Annie Ruiz & Nicholas Eloff
 */

public class Board {
	//initializing global variables
	private int size;
	private int[][] blocks;
	
	/**
	 * Constructs a board from an N-by-N array of blocks
	 * (where blocks[i][j] = blocks in row i, column j)
	 * 
	 */
	public Board(int[][] blocks) {						//BIG O OF Board() == (O)N^2
		size = blocks.length;						//initializes local size with the global size
		this.blocks = blocks;						//initializes local blocks with global blocks
		
		for (int i = 0; i < blocks.length; i++) {			//initializes each block in the global blocks
			for (int j = 0; j < blocks.length; j++) 
			{this.blocks[i][j] = blocks[i][j];}
		}
	}
	
	/**
	 * board size N
	 * @return the size of the board
	 */
	public int size() {							//BIG O OF size() == (O)N
		return size;							//returns the global variable size
	}
	
	/**
	 * number of blocks out of place
	 * @return the number of blacks out of place, 0 if there is none
	 */
	public int hamming() {							//BIG O OF hamming() == (O)N^2
        int numBlocksOutOfPlace = 0;						//counts the number of blocks out of place
        int correctValue = 1;							//the number that the block should be
        
        for (int i = 0; i < size; i++){						//goes through row
            for (int j = 0; j < size; j++){					//goes through column
                if (blocks[i][j] == 0) {   					//the zero block is a blank square     
                    correctValue++; 						//the block to check goes up one
                    continue;							//continue skips the following statements and keeps looping
                }
                if(blocks[i][j] != correctValue) 				//if this block is not equal to the value is should be         
                    {numBlocksOutOfPlace++;}        				//then it is a block out of place
                correctValue++;							//increments correct value
            }
        }
        return numBlocksOutOfPlace;						//return the number of blocks found out of place after the loops over
	}
	
	/**
	 * sum of Manhattan distances between blocks and goal
	 * Manhattan Distance - sum of vertical and horizontal distance
	 * @return the sum of distances between the blocks and the goal
	 */
	public int manhattan() {						//BIG O OF manhatten() == (O)N^2
        int correctValue = 1;							//the index that the block should be
        int manhattanDist = 0;							//the sum of the vertical and horizontal distance between blocks to goal
        
        for (int i = 0; i < size; i++){						//goes through row
            for (int j = 0; j < size; j++){					//goes through column
                if (blocks[i][j] == 0) {        		   		//the zero block is the blank square
                    correctValue++; 						//the block to check goes up one
                    continue;							//continue skips the following statements and keeps looping
                }
                if(blocks[i][j] != correctValue) {				//if this block is not equal to the correct value
                    int num = blocks[i][j];					//number is equal to whatever integer is in the following block
                    int row,column;					
                    row = (num - 1) / size;
                    column = (num - 1) % size;
                    manhattanDist += Math.abs(row - i) + Math.abs(column - j);	//added to the total sum of manhattanDist
                } 
                correctValue++;
            }            
        }
        return manhattanDist;
	}
	
	/**
	 * is this board the goal board?
	 * @return true if it is the goal board, false if it is not the goal board
	 */
	public boolean isGoal() {						//BIG O OF isGoal() == (O)N^2
		return hamming() == 0;						//if hamming() == 0, there are no blocks out of place.
	}

	/**
	 * is this board solvable?
	 * @return true if it is solvable, false if not
	 */
	public boolean isSolvable() {						//BIG OF OF isSolvable() == (O)N^2
		int hammingNum = hamming();					//an integer for hamming() so that we don't have to keep calling the method
		if ((size % 2 == 1) && (hammingNum % 2 == 1)) 			//if the board size is an odd integer and the board has an odd number of
			{return false;}						//inversions, then it CANNOT lead to the goal board, so it returns false
		if ((size % 2 == 1) && (hammingNum % 2 == 0))			//if the board size is an odd integer and the board has an even number of
			{return true;}						//inversions, then it CAN lead to the goal board, so it returns true
		
		int blankRowHammingSum = rowOfBlankBlock()+hammingNum;		//algorithm used to solve for even board sizes
		if ((size % 2 == 0) && (blankRowHammingSum % 2 == 0))
			{return false;}
		return true;
	}
	
	/**
	 * detects which row the blank block is in
	 * @return the row the blank block is in, -1 if it cannot find the block
	 */
	private int rowOfBlankBlock() {						//BIG O OF rowOfBlankBlock() == (O)N^2
		for (int i = 0; i < size; i++) {				//the row of the blocks
			for (int j = 0; j < size; j++) {			//the column of the blocks
				if (blocks[i][j] == 0)				//iterates through each block to find the blank one
					{return i;}				//returns the row that has the blank block
			}
		}
		return -1;		//if it cannot find the blank block, it returns -1 (should never occur)	
	}
	
	
	/**
	 * does this board equal y?
	 * @return true if it is equal, false if not equal
	 */
	public boolean equals(Object y) {							//BIG O OF equals() == (O)N^2
		if (y == null || y.getClass() != this.getClass())	{return false;}		//if y is null or the classes don't match, return false
		if (y == this) 						{return true;}		//if y is this board, then they are equal - return true
		Board that = (Board) y;								//initializes a copy of y
		if (this.size != that.size)				{return false;}		//if the boards are different sizes, then they're not equal
		
		for (int i = 0; i < this.size; i++) {						//if the blocks in the board are different,
			for (int j = 0; j < this.size; j++) {					//then they're not equal
				if (this.blocks[i][j] != that.blocks[i][j])	{return false;}	//so we return false
			}
		}
		return true;														//if none of this returns, then they're equal
	}
	
	/**
	 * all neighboring boards
	 * @return the neighboring boards
	 */
	public Iterable<Board> neighbors() {
		Queue<Board> neighBoard = new Queue<Board>();
		int blankBlock = blankBlockPosition();
		
		
		return null;//TODO
	}
	
	/**
	 * find the position of the blank block in the board
	 * @return
	 */
	private int blankBlockPosition() {
		for (int i = 0; i < size; i++) {			//i = row of board
			for (int j = 0; j < size; j++) {		//j = column of board
				if (blocks[i][j] == 0) 			//if the block is equal to zero
					{return (i * j) + j;}		//then we return the blank block position on the board
			}
		}
		return -1; 						//if it can't find the blank, return -1 (should never occur)
	}
	/**
	 * string representation of this board (in the output format specified)
	 */
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(size + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
	}

	/**
	 * unit test (not graded)
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
	

}
