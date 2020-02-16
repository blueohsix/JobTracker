package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.repositories.CohortRepository;


@Service
public class CohortServiceImpl implements CohortService {
//	@Autowired
//	private CohortRepository repo;

	@Override
	public Cohort createCohort(Cohort cohort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cohort readCohort(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cohort findByName(String cohortName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cohort> indexCohorts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cohort updateCohort(Cohort cohort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCohort(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
