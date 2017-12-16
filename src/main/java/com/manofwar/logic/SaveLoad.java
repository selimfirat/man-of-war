package com.manofwar.logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveLoad {
	//readLoad returns integer list which include 3 specification
	// which are levelNo, player health and player attack power
	//it reads from txt file...
	
	public SaveLoad() {
	}
	public static ArrayList<Integer> readLoad() throws FileNotFoundException {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		@SuppressWarnings("resource")
		Scanner fileScanner = new Scanner(new File("D:/CODE/eclipse/save2.txt"));
		while (fileScanner.hasNextInt()){
		   integers.add(fileScanner.nextInt());
		}
		return integers;
		//returns 3 content arrayList
	}

	public static int getLevel() throws FileNotFoundException {
		ArrayList<Integer> integers1 = readLoad();
		return integers1.get(0);
	}
	
	public static int getHealth() throws FileNotFoundException {
		ArrayList<Integer> integers1 = readLoad();
		return integers1.get(1);
	}
	
	public static int getAttack() throws FileNotFoundException {
		ArrayList<Integer> integers1 = readLoad();
		return integers1.get(2);
	}
	
	public static int getPlayerX() throws FileNotFoundException {
		ArrayList<Integer> integers1 = readLoad();
		return integers1.get(3);
	}
	
	public static int getPlayerY() throws FileNotFoundException {
		ArrayList<Integer> integers1 = readLoad();
		return integers1.get(4);
	}
	
	public static void writeSave(int levelNo, int CharHealth, int CharAttack,int X, int Y) throws UnsupportedEncodingException, FileNotFoundException {
		/*
		 *  This methods gets 3 parameter and writes
		 *  them into a .txt file for later uses (Loading previous game)
		 */
		PrintWriter writer = new PrintWriter("D:/CODE/eclipse/save2.txt", "UTF-8");
		writer.println(levelNo+" "+CharHealth+" "+CharAttack+" "+X+" "+Y);
		System.out.println("New save file created");
		writer.close();
	}
}

