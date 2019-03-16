package a04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	//initializing global variable
	private Board initial;
	private Board goal;
	private int size;
	private MinPQ<SearchNode> minpq;
	
	private class SearchNode implements Comparable<SearchNode>{
		private int moves;
		private Board board;
		private SearchNode prevNode;
		
		public SearchNode(Board board, SearchNode prevNode) {
			this.board = board;
			if (prevNode != null) {
				this.moves = prevNode.moves++;
				this.prevNode = prevNode;
			}
			else {
				moves = 0;
			}
		}
		
		@Override
		public int compareTo(SearchNode other) {
			int thisPriority = this.board.manhattan() + this.moves;
			int otherPriority = other.board.manhattan() + other.moves;
			
			return (thisPriority - otherPriority);
		}
	}
	
/**
 * find a solution to the initial board (using the A* algorithm)
 * @param initial
 */
	public Solver(Board initial) {
		//throws arguments if it is not solvable or a null
		if (!initial.isSolvable()) { throw new IllegalArgumentException("Board is not solvable"); }
		if (initial == null) { throw new NullPointerException("Board is null"); }
		
		//initialing local variables to global variables
		this.initial = initial;
		size = initial.size();
		minpq = new MinPQ<SearchNode>();
		
		if (initial.isGoal()) {

		}
	}
	
	/**
	 * min number of moves to solve initial board
	 * @return
	 */
	public int moves() {
		return -1; //TODO
	}
	
	/**
	 * sequence of boards in a shortest solution
	 * @return
	 */
	public Iterable<Board> solution() {
		
		//if (isSolvable()) 
		
		return null; //TODO
	}
	
	/**
	 * solve a slider puzzle
	 * @param args
	 */
	public static void main(String[] args) {
		   // create initial board from file
	    In in = new In(args[0]);
	    int N = in.readInt();
	    int[][] blocks = new int[N][N];
	    for (int i = 0; i < N; i++)
	        for (int j = 0; j < N; j++)
	            blocks[i][j] = in.readInt();
	    Board initial = new Board(blocks);
	    
		// check if puzzle is solvable; if so, solve it and output solution
	    if (initial.isSolvable()) {
	        Solver solver = new Solver(initial);
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	        	StdOut.println(board);
		   }
		    // if not, report unsolvable
	    else {
	        StdOut.println("Unsolvable puzzle");
	    }
	}
}
