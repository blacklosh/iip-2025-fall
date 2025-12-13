package cmd.repository;

import cmd.entity.NoteEntity;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    List<NoteEntity> findAll();

    Optional<NoteEntity> findById(long id);

    NoteEntity save(NoteEntity note);

    boolean update(NoteEntity note);

    boolean deleteById(long id);


}
