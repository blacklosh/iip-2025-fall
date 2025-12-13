package cmd.service;

import cmd.entity.NoteEntity;
import cmd.repository.NoteRepository;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class NoteService {

    private final NoteRepository noteRepository;

    private final Scanner scanner;

    public NoteService(NoteRepository noteRepository, Scanner scanner) {
        this.noteRepository = noteRepository;
        this.scanner = scanner;
    }

    public void processCommand() {
        System.out.println("Welcome to your notes! Select what you want:");
        System.out.println("1 - Create new note");
        System.out.println("2 - Update your note");
        System.out.println("3 - Delete your note");
        System.out.println("4 - Show all your notes (shortly)");
        System.out.println("5 - Show one of your notes");
        System.out.println("6 - Exit");

        int selection = scanner.nextInt();
        scanner.nextLine();

        switch (selection) {
            case 1:
                createNewNote();
                break;
            case 2:
                updateNote();
                break;
            case 3:
                deleteById();
                break;
            case 4:
                printAllNotes();
                break;
            case 5:
                printById();
                break;
            case 6:
                System.out.println("Terminating program...");
                System.exit(0);
            default:
                System.out.println("Incorrect number! Please try again");
        }
    }

    private void printAllNotes() {
        List<NoteEntity> allNotes = noteRepository.findAll();
        System.out.println("Showing all your notes:");
        for(NoteEntity note : allNotes) {
            System.out.print("ID: " + note.getId() + "; ");
            System.out.print("Title: " + note.getTitle() + "; ");
            if(note.getText().length() > 20) {
                System.out.println(note.getText().substring(0, 20) + "...");
            } else {
                System.out.println(note.getText());
            }
        }
    }

    private void printById() {
        System.out.println("Type in identifier of note that you want to see:");
        long id = scanner.nextLong();
        Optional<NoteEntity> optionalNote = noteRepository.findById(id);
        if(optionalNote.isEmpty()) {
            System.out.println("No note with id " + id);
            return;
        }
        NoteEntity note = optionalNote.get();
        System.out.println("Note id " + note.getId());
        System.out.println("Title: " + note.getTitle());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy 'at' hh:mm:ss");
        System.out.println("Created at: " + note.getCreatedAt().format(formatter));
        System.out.println("Updated at: " + note.getUpdatedAt().format(formatter));
        System.out.println("Content: " + note.getText());
    }

    private void createNewNote() {
        System.out.println("Creating new note... Please give title to it:");
        String title = scanner.nextLine();
        System.out.println("Provide text of the note:");
        String text = scanner.nextLine();
        NoteEntity note = new NoteEntity();
        note.setTitle(title);
        note.setText(text);
        note = noteRepository.save(note);
        System.out.println("Note saved successfully with id = " + note.getId());
    }

    private void updateNote() {
        System.out.println("Insert id of note that you want to edit:");
        long id = scanner.nextLong();
        scanner.nextLine();
        Optional<NoteEntity> optionalNote = noteRepository.findById(id);
        if(optionalNote.isEmpty()) {
            System.out.println("Note with id " + id + " not exists!");
            return;
        }
        NoteEntity note = optionalNote.get();
        System.out.println("Old title: " + note.getTitle() + ". New title: ");
        String newTitle = scanner.nextLine();
        note.setTitle(newTitle);
        System.out.println("New content: ");
        String newContent = scanner.nextLine();
        note.setText(newContent);
        boolean flag = noteRepository.update(note);
        System.out.println(flag ? "Note updated successfully" : "Error during update");
    }

    private void deleteById() {
        System.out.println("Insert id of note that you want to delete:");
        long id = scanner.nextLong();
        boolean flag = noteRepository.deleteById(id);
        System.out.println(flag ? "Note deleted successfully" : "Error during delete, not found");
    }

}
