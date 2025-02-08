package io.keepcoding.trivial.cli;

import java.util.Scanner;

/**
 * CLI class dedicated to TeamController I/O.
 */
public class CLITeam
{
	/**
	 * Displays the CLI text to add a team, asking the user to insert its name.
	 * @param teamIndex Team's number. 
	 * @return String with the team's name.
	 */
	public static String ask(int teamIndex)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Team " + teamIndex + ": ");
		return scanner.next();
	}
}
