package com.skilldistillery.jobtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpajobtracker.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
