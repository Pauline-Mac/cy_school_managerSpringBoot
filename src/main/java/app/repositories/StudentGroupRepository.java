package app.repositories;

import app.models.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface StudentGroupRepository extends CrudRepository<StudentGroup, Integer> {
    StudentGroup getStudentGroupByStudentGroupName(String studentgroupname);
}