package com.dam.payoschat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    private String content;

    public Note(UUID id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }

    public Note() {

    }


    public Note update(Note updatedNote) {
        if (updatedNote.getTitle() != null) {
            this.title = updatedNote.getTitle();
        }
        if (updatedNote.getContent() != null) {
            this.content = updatedNote.getContent();
        }
        return this;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
