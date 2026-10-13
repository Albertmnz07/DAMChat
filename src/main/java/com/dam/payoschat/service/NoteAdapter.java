package com.dam.payoschat.service;

import com.dam.payoschat.entity.Note;
import com.dam.payoschat.repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteAdapter implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return (List<Note>) noteRepository.findAll();
    }

    @Override
    public Optional<Note> findById(UUID id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }


    @Override
    @Transactional
    public Optional<Note> update(UUID id, Note note) {
        return noteRepository.findById(id)
                .map(notaExistente -> {
                    // Actualizamos los campos (sin tocar el ID)
                    notaExistente.update(note);

                    // Retornamos la nota. Hibernate hará el UPDATE en la BD automáticamente.
                    return notaExistente;
                });
    }

    @Override
    public Optional<Note> delete(UUID id) {
        var optionalNote = noteRepository.findById(id);

        if (optionalNote.isPresent()){
            noteRepository.delete(optionalNote.get());
        }

        return optionalNote;
    }
}
