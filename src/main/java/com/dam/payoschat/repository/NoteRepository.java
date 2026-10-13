package com.dam.payoschat.repository;

import com.dam.payoschat.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, UUID> {
}
