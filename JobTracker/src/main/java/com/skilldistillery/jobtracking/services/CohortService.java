package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Cohort;

public interface CohortService {
	public Cohort createCohort(Cohort cohort);
	public Cohort readCohort(int id);
	public Cohort findByName(String cohortName);
	public List<Cohort> indexCohorts();
	public Cohort updateCohort(Cohort cohort);
	public boolean deleteCohort(int id);

}
