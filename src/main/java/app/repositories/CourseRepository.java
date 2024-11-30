package app.repositories;

import app.models.Course;
import app.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findAll();
}