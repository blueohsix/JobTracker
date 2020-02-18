package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.repositories.CohortRepository;

@Service
public class CohortServiceImpl implements CohortService {
	@Autowired
	private CohortRepository cohortRepo;

	@Override
	public Cohort createCohort(Cohort cohort) {
		try {
			if (!cohortRepo.findByName(cohort.getName()).isEmpty()) {
				System.err.println(cohort.getName() + " already exists");
				return null;
			}
			System.err.println(cohort);
			Cohort savedCohort;
			savedCohort = cohortRepo.saveAndFlush(cohort);
			return savedCohort;

		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public Cohort retrieveCohort(int id) {
		Optional<Cohort> cohort = cohortRepo.findById(id);
		if (cohort.isPresent()) {
			return cohort.get();
		}
		return null;
	}

	@Override
	public List<Cohort> findByName(String cohortName) {
		return cohortRepo.findByName(cohortName);

	}

	@Override
	public List<Cohort> indexCohorts() {
		return cohortRepo.findAll();
	}

	@Override
	public Cohort updateCohort(Cohort cohort) {
		Optional<Cohort> cohortOpt = cohortRepo.findById(cohort.getId());
		Cohort updatedCohort = null;
		try {
			if (cohortOpt.isPresent()) {
				updatedCohort = cohort;
				return cohortRepo.saveAndFlush(updatedCohort);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public boolean deleteCohort(int id) {
		if (cohortRepo.existsById(id)) {
			cohortRepo.deleteById(id);
			return true;
		} else {
			System.err.println("Cohort id " + id + " does not exist");
			return false;
		}

	}

}
