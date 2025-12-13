package cmd.repository.impl;

import cmd.entity.NoteEntity;
import cmd.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NoteRepositoryInMemoryImpl implements NoteRepository {

    private final List<NoteEntity> notes = new ArrayList<>();

    @Override
    public List<NoteEntity> findAll() {
        return new ArrayList<>(notes);
    }

    @Override
    public Optional<NoteEntity> findById(long id) {
        for(NoteEntity note : notes) {
            if(note.getId() == id) {
                return Optional.of(note);
            }
        }
        return Optional.empty();
    }

    @Override
    public NoteEntity save(NoteEntity note) {
        note.setId(findNextId());
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        notes.add(note);
        return note;
    }

    @Override
    public boolean update(NoteEntity note) {
        Optional<NoteEntity> optionalNote = findById(note.getId());
        if(optionalNote.isEmpty()) {
            return false;
        }
        NoteEntity noteFromDb = optionalNote.get();
        noteFromDb.setText(note.getText());
        noteFromDb.setTitle(note.getTitle());
        noteFromDb.setUpdatedAt(LocalDateTime.now());
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        Optional<NoteEntity> optionalNote = findById(id);
        if(optionalNote.isEmpty()) {
            return false;
        }
        NoteEntity note = optionalNote.get();
        notes.remove(note);
        return true;
    }

    private long findNextId() {
        long found = 1;
        for(NoteEntity note : notes) {
            if(note.getId() >= found) {
                found = note.getId() + 1;
            }
        }
        return found;
    }
}
