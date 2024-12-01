package app.repositories;

import app.models.Course;
import app.models.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    Iterable<Course> getCoursesByProfessor(Professor professor);
    @Query(
            value = "SELECT COUNT(student_id) FROM Enrollment WHERE class_id = ?1",
            nativeQuery = true
    )
    Integer getCountStudentByClass(long courseId);
}