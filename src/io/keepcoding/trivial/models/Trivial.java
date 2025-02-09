package io.keepcoding.trivial.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import io.keepcoding.trivial.Constants;

/**
 * Singleton class representing KeepTrivial game.
 */
public class Trivial
{
	/**
	 * List of teams in the game.
	 */
	private List<Team> teams = new ArrayList<Team>();
	/**
	 * List of questions in the game.
	 */
	private List<Question> questions = new ArrayList<Question>();
	/**
	 * Instance of the game.
	 */
	private static Trivial trivial;

	/**
	 * Forbidden constructor to use a Singleton pattern.
	 */
	private Trivial() {}
	/**
	 * Returns the game as the unique instance of the class.
	 * @return Trivial
	 */
	public static Trivial getInstance()
	{
		if (trivial != null)
		{
			return trivial;
		}
		trivial = new Trivial();
		return trivial;
	}
	
	/**
	 * Loads all the questions in files if they are not already loaded.
	 * @throws IOException
	 */
	public void loadQuestions() throws IOException
	{
		if (questions.isEmpty())
		{
			File folder = new File("questions");
			List<Question> questionsList = new ArrayList<Question>();
			if (!folder.exists())
			{
				throw new NotDirectoryException("questions");
			}
			else
			{
				File[] files = folder.listFiles();
				for (File file : files)
				{
					if (!file.isFile() || !file.getName().endsWith(".txt"))
					{
						throw new FileNotFoundException(file.getAbsolutePath());
					}
					else
					{
						// We asume types are correct.
						QuestionType questionType = QuestionType.valueOf(file.getName().substring(0, file.getName().length() - 4).toUpperCase());
						
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						String line;
						List<String> block = new ArrayList<String>();
						while ((line = bufferedReader.readLine()) != null)
						{
							block.add(line);
							if (block.size() == 6)
							{
								String questionString = block.get(0);
								String[] options = { block.get(1), block.get(2), block.get(3), block.get(4) };
								int rightOption = Integer.parseInt(block.get(5));
								questionsList.add(new Question(
									questionString,
									questionType,
									rightOption,
									options
								));
								block.clear();	
							}
						}
						bufferedReader.close();
					}
				}
			}
			questions = questionsList;	
		}
	}
	
	/**
	 * Gets a question for the specific team.
	 * @param team
	 * @return Question
	 */
	public Question getQuestion(Team team)
	{
		EnumSet<QuestionType> questionTypesLeft = team.cheesesLeft();
		List<Question> questions = this.questions.stream()
			.filter(question -> questionTypesLeft.contains(question.getType()))
			.toList();
		Random random = new Random();
		return questions.get(random.nextInt(0, questions.size()));
	}
	
	/**
	 * Gets one of the teams in the list.
	 * @param index
	 * @return Team
	 */
	public Team getTeam(int index)
	{
		return teams.get(index);
	}

	/**
	 * Adds a team to the list.
	 * @param team
	 */
	public void addTeam(Team team)
	{
		teams.add(team);
	}
	
	/**
	 * Resets the teams in the game.
	 */
	public void resetTeams()
	{
		teams = new ArrayList<Team>();
	}
	
	/**
	 * Gets each team score.
	 * @return Array of strings.
	 */
	public String[] getScore()
	{
		String[] teamScore = new String[Constants.N_TEAMS];
		for (int i = 0; i < Constants.N_TEAMS; i++)
		{
			teamScore[i] = teams.get(i).toString();
		}
		return teamScore;
	}
	
	/**
	 * Indicates whether a team won the game or not.
	 * @param team
	 * @return boolean
	 */
	public boolean isWinner(Team team)
	{
		return team.cheesesLength() == Constants.N_TEAMS;
	}
}
