package app.repositories;

import app.models.Student;
import app.models.StudentGroup;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT s FROM Student s WHERE " +
            "(:firstname IS NULL OR LOWER(s.firstName) LIKE LOWER(CONCAT(:firstname, '%'))) AND " +
            "(:lastname IS NULL OR LOWER(s.lastName) LIKE LOWER(CONCAT(:lastname, '%'))) AND " +
            "(:studentgroupname IS NULL OR LOWER(s.studentGroup.studentGroupName) LIKE LOWER(CONCAT(:studentgroupname, '%'))) AND " +
            "(:classname IS NULL OR EXISTS (" +
            "   SELECT e FROM Enrollment e " +
            "   JOIN e.course c " +
            "   WHERE e.student = s AND LOWER(c.className) LIKE LOWER(CONCAT(:classname, '%'))))")
    List<Student> searchStudentByCriteria(String firstname, String lastname, String studentgroupname, String classname);

    @Query("SELECT s FROM Student s")
    List<Student> getAllStudents();

    Student getStudentByUuidEquals(String uuid);

}