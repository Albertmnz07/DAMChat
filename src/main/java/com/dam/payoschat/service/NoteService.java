package com.dam.payoschat.service;

import com.dam.payoschat.entity.Note;
import com.dam.payoschat.repository.NoteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteService {
    List<Note> findAll();
    Optional<Note> findById(UUID id);
    Note create(Note note);
    Optional<Note> update(UUID id, Note note);
    Optional<Note> delete(UUID id);
}
