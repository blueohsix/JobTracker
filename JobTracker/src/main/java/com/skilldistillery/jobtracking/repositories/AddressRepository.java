package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
