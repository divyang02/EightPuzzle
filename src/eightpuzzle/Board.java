package eightpuzzle;

import java.util.ArrayList;

public class Board {
	private int[][] blocks;
	//private int count = 0;
	//private int countMan = 0;
	private static final int emptySpace = 0;
	
    public Board(int[][] blocks) {
    	this.blocks = copyArr(blocks);
    }
    
    private int[][] copyArr(int[][] givenArr) {
    	int[][] copy = new int[givenArr.length][givenArr.length];
    	for(int i = 0; i < givenArr.length; i++) {
    		for (int j = 0; j < givenArr.length; j++) {
    			copy[i][j] = givenArr[i][j];
    		}
    	}
    	return copy;
    }
    
    public int dimension() {
    	return blocks.length;
    }
    public int hamming() {
    	int count = 0;
    	for(int i = 0; i < blocks.length; i++) {
    		for (int j = 0; j < blocks.length; j++) {
    			if (blocks[i][j] != emptySpace && blocks[i][j] != i*dimension() + j + 1)  count++;
    		}
    	}
    	return count;
    }
    public int manhattan() {
    	int countMan = 0;
    	for(int i = 0; i < blocks.length; i++) {
    		for (int j = 0; j < blocks.length; j++) {
    			if (blocks[i][j] != emptySpace && blocks[i][j] != i*dimension() + j + 1) {
    				countMan += countDistances(blocks[i][j], i, j); 
    			}
    		}
    	}
    	return countMan;
    }
    
    private int countDistances(int element, int row, int col) {
    	return Math.abs(row - realRow(element)) + Math.abs(col - realCol(element));
    }
    
    private int realRow(int element) {
    	return (element - 1) / dimension();
    }
    
    private int realCol(int element) {
    	return (element - 1) % dimension();
    }
    
    public boolean isGoal() {
    	for(int i = 0; i < blocks.length; i++) {
    		for(int j = 0; j < blocks.length; j++) {
    			if(blocks[i][j] != emptySpace && blocks[i][j] != i*dimension() + j + 1) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public Board twin() {
    	Board twin;
    	for (int i = 0; i < blocks.length; i++) {
    		for(int j = 0; j < blocks.length - 1; j++) {
    			if(blocks[i][j] != emptySpace && blocks[i][j+1] != emptySpace) {
    				twin = new Board(swap(i,j,i,j+1));
    				return twin;
    			}
    		}
    	}
    	return null;
    }
    
    private int[][] swap(int row, int col, int secRow, int secCol) {
    	int copy[][] = copyArr(blocks);
    	int swap = copy[row][col];
    	copy[row][col] = copy[secRow][secCol];
    	copy[secRow][secCol] = swap;
    	return copy;
    }
    
    public boolean equals(Object y) {
    	//if(y == this) return true;
    	//if(y == null) return false;
    	//if(y.getClass() != this.getClass()) return false;
    	if (y==this) return true;
    	if (y==null || !(y instanceof Board) || ((Board)y).blocks.length != blocks.length) return false;
    	Board that = (Board) y;
    	return findEquals(that);
    }
    
    private boolean findEquals(Board that) {
    	for(int i = 0; i < blocks.length; i++) {
    		for(int j = 0; j < blocks.length; j++) {
    			if(blocks[i][j] != that.blocks[i][j]) return false;
    		}
    	}
    	return true;
    }
    
    public Iterable<Board> neighbors() {
    	ArrayList<Board> neighbours = new ArrayList<>();
    	for (int row = 0; row < blocks.length; row++) {
    		for(int col = 0; col < blocks.length; col++) {
    			if(row > 0 && blocks[row][col] != emptySpace && blocks[row - 1][col] == emptySpace) {
    				 neighbours.add(new Board(swap(row, col, row - 1, col)));
    			}
    			if(col > 0 && blocks[row][col] != emptySpace && blocks[row][col - 1] == emptySpace) {
    				neighbours.add(new Board(swap(row, col, row, col - 1)));
    			}
    			if(row < dimension() - 1 && blocks[row][col] != emptySpace && blocks[row + 1][col] == emptySpace) {
    				neighbours.add(new Board(swap(row, col, row + 1, col)));
    			}
    			if(col < dimension() - 1 && blocks[row][col] != emptySpace && blocks[row][col + 1] == emptySpace) {
    				neighbours.add(new Board(swap(row, col, row, col + 1)));
    			}
    		}
    	}
    	return neighbours;
    }
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	s.append(dimension() + "\n");
    	for (int i = 0; i < blocks.length; i++) {
    		for (int j = 0; j < blocks.length; j++) {
    			s.append(String.format("%2d ", blocks[i][j]));
    	    }
    	    s.append("\n");
    	}
    	return s.toString();
    }
    public static void main(String[] args) {
    	
    }
    
    public void printBoard() {
    	for(int i = 0; i < this.dimension(); i++) {
    		for(int j = 0; j < this.dimension(); j++) {
    			System.out.print(this.blocks[i][j] + " ");
    		}
    		System.out.println("");
    	}
    	System.out.println("");
    }
    
    public Integer[][] boardElements() {
    	int n = this.blocks.length;
    	Integer[][] r = new Integer[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			r[i][j] = this.blocks[i][j];
    		}
    	}
    	return r;
    }
    
}
