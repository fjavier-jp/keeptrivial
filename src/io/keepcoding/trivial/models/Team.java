package io.keepcoding.trivial.models;

import java.util.EnumSet;

/**
 * Represents a KeepTrivial Team.
 */
public class Team
{
	/**
	 * Set with the cheeses acquired by the team. Each cheese is represented by a QuestionType.
	 */
	private EnumSet<QuestionType> cheeses;
	/**
	 * Team's name.
	 */
	private String name;
	
	/**
	 * Constructor.
	 * Initializes the cheeses set to an empty EnumSet.
	 * @param name
	 */
	public Team(String name)
	{
		this.name = name;
		this.cheeses = EnumSet.noneOf(QuestionType.class);
	}
	
	/**
	 * Gets the amount of cheeses acquired by the team.
	 * @return
	 */
	public int cheesesLength()
	{
		return cheeses.size();
	}
	
	/**
	 * Gets the amount of cheeses left for a team.
	 * @return
	 */
	public EnumSet<QuestionType> cheesesLeft()
	{
		return EnumSet.complementOf(this.cheeses);
	}
	
	/**
	 * Adds a cheese to the team.
	 * @param cheese
	 */
	public void addCheese(QuestionType cheese)
	{
		cheeses.add(cheese);
	}

	/**
	 * Gets the team's name.
	 * @return String with the team's name.
	 */
	public String getName()
	{
		return name;
	}

	@Override
	/**
	 * Returns a string representation of the team including its name, amount of cheeses and the type of cheeses acquired.
	 * @return String.
	 */
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name).append("\t").append(cheesesLength()).append("\t").append(cheeses.toString());
		return stringBuilder.toString();
	}
}
