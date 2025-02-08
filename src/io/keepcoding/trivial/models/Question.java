package io.keepcoding.trivial.models;

import io.keepcoding.trivial.Constants;

/**
 * Question Model.
 */
public class Question
{
	/**
	 * Question formula.
	 */
	private String question;
	/**
	 * Question type according to QuestionType Enum.
	 */
	private QuestionType type;
	/**
	 * Array of strings with every option available.
	 */
	private String[] options = new String[Constants.N_OPTIONS];
	/**
	 * Index of the correct option.
	 */
	private int rightOption;
	
	/**
	 * Constructor.
	 * @param question
	 * @param type
	 * @param answer
	 * @param options
	 */
	public Question(String question, QuestionType type, int answer, String[] options)
	{
		this.question = question;
		this.type = type;
		this.rightOption = answer;
		this.options = options;
	}
	
	/**
	 * Gets question's type.
	 * @return QuestionType enum value
	 */
	public QuestionType getType()
	{
		return this.type;
	}

	/**
	 * Gets question's text.
	 * @return String with the question formula.
	 */
	public String getQuestion()
	{
		return question;
	}

	/**
	 * Gets question's options.
	 * @return
	 */
	public String[] getOptions()
	{
		return options;
	}

	/**
	 * Gets the index of the correct option.
	 * @return int
	 */
	public int getRightOption()
	{
		return rightOption;
	}
}
