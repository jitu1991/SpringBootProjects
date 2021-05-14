package com.javabrains.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.ipldashboard.model.Match;
import com.javabrains.ipldashboard.model.Team;
import com.javabrains.ipldashboard.repository.MatchRepository;
import com.javabrains.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
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
	
	@GetMapping("/team/{teamName}/matches")
	public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
		//Method1
		/*
		 * List<Match> matches = this.matchRepository.getByTeam1OrTeam2(teamName,
		 * teamName); return matches.stream().filter(match ->
		 * match.getDate().getYear()==year).collect(Collectors.toList());
		 */
		
		//Method 2
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year + 1, 1, 1);
		
		/*return this.matchRepository.getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(teamName, startDate, endDate,
				teamName, startDate, endDate);*/
		
		return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
	}
}
