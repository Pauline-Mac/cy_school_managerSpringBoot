package app.repositories;

import app.models.Course;
import app.models.Enrollment;
import app.models.Student;
import app.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
    List<Enrollment> findAll();

    Enrollment getEnrollmentByCourse(Course course);
    @Query("SELECT e FROM Enrollment e WHERE e.student = :student")
    List<Enrollment> getEnrollmentsByStudent(Student student);

    Enrollment getEnrollmentByCourseAndStudent(Course course, Student user);

    List<Enrollment> findAllByCourse(Course course);
}