package com.javabrains.ipldashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javabrains.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{
	
	Team findByTeamName(String name);
	List<Team> findAll();
}
