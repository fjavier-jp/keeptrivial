package io.keepcoding.trivial.cli;

import java.io.IOException;

import io.keepcoding.trivial.controllers.TrivialController;

/**
 * Main class to boot KeepTrivial.
 */
public class Main
{
	/**
	 * App bootstrap.
	 * @param args
	 */
	public static void main(String[] args)
	{
		TrivialController trivialController = new TrivialController();
		try
		{
			trivialController.start();
		}
		catch (IOException e)
		{
			System.out.println("There seems to be some problem with KeepTrivial files. Fix them and come back later (please).");
		}
	}
}
