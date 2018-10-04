package com.sriram.apps.springbootapp.rest;

import com.sriram.apps.springbootapp.model.Notes;
import com.sriram.apps.springbootapp.repository.NotesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class NotesController {
    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/notes")
    public List<Notes> getAllNotes() {
        log.info("inside getAllNotes");
        return notesRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Notes getNotes(@PathVariable("id") int id) {
        log.info("inside getNote with id : {}", id);
        return notesRepository.findById(id)
                .orElse(new Notes(0, "No Notes found with id : " + id, ""));
    }

    @PostMapping("/notes")
    public Notes createNotes(@RequestBody Notes notes) {
        log.info("Inside createNotes with {}", notes);
        return notesRepository.save(notes);
    }
}
