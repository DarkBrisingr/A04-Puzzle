package a04;

public class Board {
	
	private int size;
	private int[][] blocks;
	
	/**
	 * Constructs a board from an N-by-N array of blocks
	 * (where blocks[i][j] = blocks in row i, column j)
	 * @return
	 */
	public Board(int[][] blocks) {
		size = blocks.length;
		this.blocks = blocks;
		
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				this.blocks[i][j] = blocks[i][j];
			}
		}
	}
	
	/**
	 * board size N
	 * @return the size of the board
	 */
	public int size() {
		return size;
	}
	
	/**
	 * number of blocks out of place
	 */
	public int hamming() {
		return -99999; //TODO
	}
	
	/**
	 * sum of Manhattan distances between blocks and goal
	 */
	public int manhattan() {
		return -99999; //TODO
	}
	
	/**
	 * is this board the goal board?
	 */
	public boolean isGoal() {
		return false; //TODO
	}
	
	/**
	 * is this board solvable?
	 * @return
	 */
	public boolean isSolvable() {
		return false; //TODO
	}
	
	/**
	 * does this board equal y?
	 */
	public boolean equals(Object y) {
		return false; //TODO
	}
	
	/**
	 * all neighboring boards
	 * @return
	 */
	public Iterable<Board> neighbors() {
		return null;//TODO
	}
	
	/**
	 * string representation of this board (in the output format specified)
	 */
	@Override
	public String toString() {
		return "";//TODO
	}

	/**
	 * unit test (not graded)
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	

}
