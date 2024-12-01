package app.repositories;

import app.models.Enrollment;
import app.models.Note;
import app.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
    List<Note> getNotesByEnrollment(Enrollment enrollment);
}