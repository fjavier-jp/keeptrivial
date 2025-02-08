package io.keepcoding.trivial.controllers;

import io.keepcoding.trivial.cli.CLIQuestion;
import io.keepcoding.trivial.models.Question;
import io.keepcoding.trivial.models.Team;

/**
 * Controller class as a bridge between the Question model and the CLI.
 */
public class QuestionController
{
	/**
	 * Returns the team's answer to the question.
	 * @param team
	 * @param question
	 * @return String with team's input
	 */
	public String getUserAnswer(Team team, Question question)
	{
		return CLIQuestion.ask(team.getName(), question.getType(), question.getQuestion(), question.getOptions());
	}
	
	/**
	 * Sends to the CLI the evaluation of the answer.
	 * @param evaluation
	 */
	public void showEvaluation(boolean evaluation)
	{
		CLIQuestion.showEvaluation(evaluation);
	}
}
