package io.keepcoding.trivial.cli;

import java.io.IOException;

import io.keepcoding.trivial.controllers.TrivialController;
import io.keepcoding.trivial.models.Team;
import io.keepcoding.trivial.models.Trivial;

/**
 * Main class to boot KeepTrivial.
 */
public class Main
{
	/**
	 * The main function creates the game and starts it, showing the winner at the end.
	 * In case KeepTrivial files are not correctly configured, it will print an error message.
	 * @param args
	 */
	public static void main(String[] args)
	{
		TrivialController trivialController = new TrivialController();
		try
		{
			trivialController.create();
		}
		catch (IOException exception)
		{
			System.out.println("There seems to be some problem with KeepTrivial files. Fix them and come back later (please).");
			return;
		}

		System.out.println("WINNER: " + trivialController.play().getName());
	}
}
