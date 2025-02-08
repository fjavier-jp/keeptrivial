package io.keepcoding.trivial.controllers;

import java.io.IOException;

import io.keepcoding.trivial.Constants;
import io.keepcoding.trivial.cli.CLITrivial;
import io.keepcoding.trivial.models.Question;
import io.keepcoding.trivial.models.Team;
import io.keepcoding.trivial.models.Trivial;

/**
 * Controller Class that adds certain business logic to the Trivial's model and works as a bridge between the
 * Trivial's model and the CLI. 
 */
public class TrivialController
{
	/**
	 * Creates and initializes KeepTrivial with the questions in the file system and the teams inserted by the user.
	 * @throws IOException in case of files having a wrong name or not being able to read them. 
	 */
	public void create() throws IOException
	{
		CLITrivial.create();
		Trivial trivial = Trivial.getInstance();
		trivial.loadQuestions();
		
		TeamController teamController = new TeamController();
		for (int i = 0; i < Constants.N_TEAMS; i++)
		{
			trivial.addTeam(teamController.create(i));
		}
	}
	
	/**
	 * Primary function controlling the game's workflow.
	 * Loops repeatedly through all the teams until one wins the game.
	 * For every turn, it shows the question to the team, evaluates the answer and adds a cheese in case the answer was right.
	 * @return Winner Team.
	 */
	public Team play()
	{
		QuestionController questionController = new QuestionController();
		Trivial trivial = Trivial.getInstance();
		int index = 0;
		Team currentTeam;
		Question question;
		boolean isCorrectAnswer;
		do
		{
			currentTeam = trivial.getTeam(index);
			question = trivial.getQuestion(currentTeam);
			try
			{
				int option = Integer.parseInt(questionController.getUserAnswer(currentTeam, question));
				isCorrectAnswer = option == question.getRightOption();
			}
			catch (NumberFormatException exception)
			{
				isCorrectAnswer = false;
			}
			
			if (isCorrectAnswer)
			{
				currentTeam.addCheese(question.getType());
			}
			questionController.showEvaluation(isCorrectAnswer);
			CLITrivial.showScoreBoard(trivial.getScore());			// This should work with a request/response system but well...
			
			index = (index + 1) % Constants.N_TEAMS;
		}
		while (!trivial.isWinner(currentTeam));
		
		return currentTeam;
	}
}
