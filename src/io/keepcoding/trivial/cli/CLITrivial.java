package io.keepcoding.trivial.cli;

/**
 * CLI class dedicated to TrivialController I/O.
 */
public class CLITrivial
{
	/**
	 * Prints a message to indicate the creation of the game.
	 */
	public static void create()
	{
		System.out.println("Configure the teams");
	}

	/**
	 * Prints a message to show scores.
	 * (I doubt this is currently the best possible design, basically because there is nothing in the function that indicates
	 * it shows a score board. In fact, it just shows an array of strings. A better practice could be either leave this work
	 * to the controller, let the CLI classes interact with models or create a score or a score board type that this function
	 * would receive)
	 * @param an array with the scores to print.
	 */
	public static void showScoreBoard(String[] scores)
	{
		for (String score : scores)
		{
			System.out.println(score);
		}
		System.out.println();
	}
}
