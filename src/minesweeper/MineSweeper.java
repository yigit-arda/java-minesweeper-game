package minesweeper;

import java.util.Random;
import java.util.Scanner;

//This class contains the main logic of the Minesweeper game
public class MineSweeper {

	int rowNumber,columnNumber,size;
	int[][] map;			// Stores real mine locations
	int[][] board;			// Stores what the player sees
	boolean game = true;
	
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	// Constructor: creates game board with given dimensions
	public MineSweeper(int rowNumber,int columnNumber) {
		this.rowNumber=rowNumber;
		this.columnNumber=columnNumber;
		this.map= new int[rowNumber][columnNumber];
		this.board=new int[rowNumber][columnNumber];
		this.size=rowNumber*columnNumber;
	}
	
	// Main game loop
	public void run() {
		int row,col,success=0;
		
		prepareGame(); // Place mines randomly
		print(map);
		System.out.println("Game started !");
		
		while(game) {
			print(board);	// Show player's board
			System.out.print("Row: ");
			row = scan.nextInt();
			System.out.print("Column: ");
			col = scan.nextInt();
			
			// Check boundaries
			if(row<0 || row>=rowNumber) {
				System.out.println("Invalid coordinate! ");
				continue; 
			}
			
			if(col<0 || col>=columnNumber) {
				System.out.println("Invalid coordinate! ");
				continue; 
			}
			
			 // Win condition: opened all safe cells
			if(map[row][col] != -1) {
				checkMine(row,col);
				success++;
				if(success == (size - (size/4))) {
					System.out.println("Congratulations! You didn't hit any mines! ");
					break;
				}
			}else {
				game=false;
				System.out.println("Game over !");
			}
	
		}
	}
	
	// Counts mines around selected cell
	public void checkMine(int r, int c) {
		
		if(map[r][c] == 0) {
			
			if((c <columnNumber -1) && map[r][c+1] == -1) {	
				board[r][c]++;
			}
			if((c>0) && map[r][c-1] == -1) {
				board[r][c]++;
			}
			if((r< rowNumber -1) && map[r+1][c] == -1) {
				board[r][c]++;
			}
			if((r>0) && map[r-1][c] == -1) {
				board[r][c]++;
			}
			
			if(board[r][c] == 0) {
				board[r][c] = -2;
			}
			
		}
		
	}
	
	 // Randomly places mines on the board
	//-1 represents a mine
	public void prepareGame() {
		int randRow,randCol,count=0;
		
		while(count !=(size/4)) {
			randRow=rand.nextInt(rowNumber);
			randCol=rand.nextInt(columnNumber);
			if(map[randRow][randCol] !=-1) {
				map[randRow][randCol] =-1;
				count++;
			}
			
		}

	}
	
	
	// Prints any 2D array board
	public void print(int[][]arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]>=0) 
					System.out.print(" ");
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
