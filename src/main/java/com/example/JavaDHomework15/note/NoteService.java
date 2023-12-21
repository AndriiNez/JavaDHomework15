package com.example.JavaDHomework15.note;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;


    private final Map<Long, Note> notes = new HashMap<>();


    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> listAll() {
        return (List<Note>) noteRepository.findAll();
    }
}
