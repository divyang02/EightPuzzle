package eightpuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class PuzzleChecker {
	 public static void main(String[] args) {

	        // for each command-line argument
	        for (String filename : args) {

	            // read in the board specified in the filename
	            In in = new In(filename);
	            int n = in.readInt();
	            int[][] tiles = new int[n][n];
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n; j++) {
	                    tiles[i][j] = in.readInt();
	                }
	            }

	            // solve the slider puzzle
	            Board initial = new Board(tiles);
	            Solver solver = new Solver(initial);
	            StdOut.println(filename + ": " + solver.moves());
	            System.out.println("");
	            //Board fb = solver.solBoard();
	            //fb.printBoard();
	            Stack<Integer[][]> re = new Stack<>();
	            for(Board b : solver.solution()) {
	            	re.push(b.boardElements());
	            }
	            eigth_puz ei = new eigth_puz(re.pop());
	            while(!re.isEmpty()) {
	            	//Integer[][] b = re.pop();
	            	/*for(int i = 0; i < b.length; i++) {
	            		for(int j = 0; j < b.length; j++) {
	            			System.out.print(b[i][j] + " ");
	            		}
	            		System.out.println();
	            	}
	            	System.out.println();*/
	            	Integer[][] b = re.pop();
	            	ei.reprint(b);
	            	try{
	            		Thread.sleep(1000);
	            	}catch(Exception e){
	            		
	            	}
	            }
	            
	        }
	    }
}
