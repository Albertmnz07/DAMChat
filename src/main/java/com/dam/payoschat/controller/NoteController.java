package com.dam.payoschat.controller;

import com.dam.payoschat.entity.Note;
import com.dam.payoschat.service.NoteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> allNotes(){
        return noteService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> postNote(@RequestBody Note note){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.create(note));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable UUID id, @RequestBody Note note) {
        noteService.update(id, note);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        noteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
