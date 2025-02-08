package io.keepcoding.trivial.controllers;

import io.keepcoding.trivial.cli.CLITeam;
import io.keepcoding.trivial.models.Team;

/**
 * Controller class as bridge between Team's model and the CLI.
 */
public class TeamController
{
	/**
	 * Returns a newly created team with the given name in the CLI.
	 * @param index Team's number.
	 * @return
	 */
	public Team create(int index)
	{
		String teamName = CLITeam.ask(index);
		return new Team(teamName);
	}
}
