package com.skilldistillery.jobtracker.services;

import java.util.List;

import com.skilldistillery.jpajobtracker.entities.Cohort;

public interface CohortService {
	public Cohort createCohort(Cohort cohort);

	public Cohort retrieveCohort(int id);

	public List<Cohort> indexCohorts();

	public List<Cohort> findByName(String cohortName);

	public Cohort updateCohort(Cohort cohort);

	public boolean deleteCohort(int id);

}
