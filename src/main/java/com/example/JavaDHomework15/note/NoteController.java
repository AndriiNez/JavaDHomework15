package com.example.JavaDHomework15.note;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView notesList() {
        ModelAndView result = new ModelAndView("all-notes");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create");
    }

    @PostMapping("/create")
    public ModelAndView create(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);
        noteService.add(newNote);
        return notesList();
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", noteService.getById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String content) {
        Note updatedNote = new Note();
        updatedNote.setId(id);
        updatedNote.setTitle(title);
        updatedNote.setContent(content);
        noteService.update(updatedNote);
        return notesList();
    }


    @PostMapping("/delete")
    public ModelAndView update(@RequestParam Long id) {
        noteService.deleteById(id);
        return notesList();
    }
}