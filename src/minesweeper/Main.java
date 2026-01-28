package minesweeper;

import java.util.Scanner;

public class Main {

	//Starts the Minesweeper game
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int row,column;
		
		System.out.println("Welcome to Minesweeper !");
		System.out.println("Please enter the board dimensions !");
		System.out.println("Row Number: ");
		row = scan.nextInt();
		
		System.out.println("Column Number: ");
		column = scan.nextInt();
		
		MineSweeper ms = new MineSweeper(row,column);
		ms.run();
	

		scan.close();
	}
}
