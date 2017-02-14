package eightpuzzle;

import java.util.ArrayList;
import java.util.Stack;

import edu.princeton.cs.algs4.MinPQ;

public class Solver {
	private class Move implements Comparable<Move> {
		private Board board;
		private Move previous;
		private int noMoves = 0;
		
		public Move(Board board) {
			this.board = board;
		}
		
		public Move(Board board, Move previous) {
			this.board = board;
			this.previous = previous;
			this.noMoves = previous.noMoves + 1;
		}
		
		public int compareTo(Move move) {
			return ((this.board.manhattan() - move.board.manhattan()) + (this.noMoves - move.noMoves));
		}
	}
	
	private Stack<Board> list = new Stack<Board>();
	private Move lastBoard;
	
    public Solver(Board initial) {
    	MinPQ<Move> qu= new MinPQ<>();
    	qu.insert(new Move(initial));
    	
    	MinPQ<Move> twins = new MinPQ<>();
    	twins.insert(new Move(initial.twin()));
    	while(true) {
    		lastBoard = expand(qu);
    		if(lastBoard != null || expand(twins) != null) return;
    	}
    }
    
    private Move expand(MinPQ<Move> a) {
    	if(a.isEmpty()) return null;
    	Move finalBoard = a.delMin();
    	if (finalBoard.board.isGoal()) return finalBoard;
    	for (Board neighbour : finalBoard.board.neighbors()) {
    		if(finalBoard.previous == null || !neighbour.equals(finalBoard.previous.board)) {
    			a.insert(new Move(neighbour, finalBoard));
    		}
    	}	
    	return null;
    }
    
    public boolean isSolvable() {
    	return lastBoard != null;
    }
    
    public int moves() {
    	if(isSolvable()) {
    		return lastBoard.noMoves;
    	} else {
    		return -1;
    	}
    }
    
    public Iterable<Board> solution() {
    	if(!isSolvable()) return null;
    	else {
    		while(lastBoard != null) {
    			list.push(lastBoard.board);
    			lastBoard = lastBoard.previous;
    		}
    		return list;
    	}
    }
    
    public static void main(String[] args) {
    	
    }

}
