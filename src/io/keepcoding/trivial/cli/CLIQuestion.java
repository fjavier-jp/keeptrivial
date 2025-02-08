package io.keepcoding.trivial.cli;

import java.util.Arrays;
import java.util.Scanner;

import io.keepcoding.trivial.models.QuestionType;

/**
 * CLI Class dedicated to QuestionController I/O.
 */
public class CLIQuestion
{
	/**
	 * Shows the name of the next team, the question type, the question and its multiple options.
	 * @param teamName Team's name.
	 * @param type Question's type.
	 * @param question Question text.
	 * @param options Array of strings with every option.
	 * @return String the team's input.
	 */
	public static String ask(String teamName, QuestionType type, String question, String[] options)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Turno para el equipo ").append(teamName).append(".");
		System.out.println(stringBuilder.toString());
		stringBuilder.setLength(0);
		stringBuilder.append(type.toString()).append(" - ").append(question);
		System.out.println(stringBuilder.toString());
		stringBuilder.setLength(0);
		
		int optionsLength = options.length;
		int[] optionsIndexes = new int[optionsLength];
		for (int i = 0; i < optionsLength; i++)
		{
			stringBuilder.append(i + 1).append(". ").append(options[i]);
			System.out.println(stringBuilder.toString());
			stringBuilder.setLength(0);
			optionsIndexes[i] = i + 1;
		}
		stringBuilder.append("Select your answer ").append(Arrays.toString(optionsIndexes)).append(": ");
		System.out.print(stringBuilder.toString());

		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
	
	/**
	 * Shows the evaluation of the answer.
	 * @param answer
	 */
	public static void showEvaluation(boolean answer)
	{
		System.out.println(answer ? "\nRespuesta CORRECTA" : "\nRespuesta INCORRECTA");
	}
}
