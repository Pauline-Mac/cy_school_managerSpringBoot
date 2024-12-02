package app.repositories;

import app.models.Course;
import app.models.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Course> findAllByClassNameEquals(String className);

    @Query("SELECT c FROM Course c WHERE c.classId NOT IN (" +
            "   SELECT e.course.classId FROM Enrollment e WHERE e.student.userId = :studentId)")
    List<Course> getAvailableCoursesForStudent(long studentId);

    Course getCourseByClassNameEquals(String className);


    Course getCourseByClassIdEquals(Long classId);

    List<Course> findAllByProfessor(Professor professor);

    Course findCourseByClassNameEquals(String className);
}