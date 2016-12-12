package servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Scanner;

public class highScore {
	static Scanner scanner;

	public static void updateHiScore(int score) throws IOException {

		String Score = String.valueOf(score);
		PrintWriter output;

		try {
			scanner = new Scanner(new File(".user.txt"));

			String a = scanner.nextLine();

			if (a.length() == 0) {
				output = new PrintWriter(new FileWriter(".user.txt", false));
				// output.write("");
				output.flush();
				output.print(Score);
			}

			if (Integer.valueOf(Score) > Integer.valueOf(a)) {
				output = new PrintWriter(new FileWriter(".user.txt", false));
				output.flush();
				output.print(Score);
				output.close();

			}

		} catch (Exception e) {
			output = new PrintWriter(new FileWriter(".user.txt", true));
			// output.write("");
			output.print(Score);
			output.close();
			System.out.println("file not found");
		}

	}

	public static String highScore(int score) throws IOException {
		highScore.updateHiScore(score);
		return null;

	}

	public static void main(String[] args) throws IOException {
		highScore(50);
		System.out.println("ks");
	}

}
