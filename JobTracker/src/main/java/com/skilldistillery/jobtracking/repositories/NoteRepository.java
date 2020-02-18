package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
