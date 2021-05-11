package com.javabrains.ipldashboard.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.ipldashboard.model.Match;
import com.javabrains.ipldashboard.model.Team;
import com.javabrains.ipldashboard.repository.MatchRepository;
import com.javabrains.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {
	
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;

	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}
	
	@GetMapping("/teams")
	public List<Team> getTeams() {
		return this.teamRepository.findAll();
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = this.teamRepository.findByTeamName(teamName);
		team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));
		return team;
	}
}