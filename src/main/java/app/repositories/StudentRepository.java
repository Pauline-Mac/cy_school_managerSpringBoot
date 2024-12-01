package app.repositories;

import app.models.Student;
import app.models.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> getStudentsByStudentGroup(StudentGroup studentGroup);

    List<Student> getStudentsByLastNameAndFirstNameAndStudentGroup(String last_name, String first_name, StudentGroup studentGroup);
    Student getStudentByEmail(String email);

    Student getStudentByUserId(Long userId);
}