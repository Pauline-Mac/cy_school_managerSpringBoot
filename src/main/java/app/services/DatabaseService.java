package app.services;

import app.models.*;
import app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/database") // This means URL's start with / (after Application path)
public class DatabaseService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    StudentGroupRepository studentGroupRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    NoteRepository noteRepository;

    @GetMapping(path="/initialize")
    public String initialize() {
        // This creates a set of test entries in the schema
        try {
            StudentGroup studentGroup1 = new StudentGroup("GSI-1");
            StudentGroup studentGroup2 = new StudentGroup("GSI-2");
            StudentGroup studentGroup3 = new StudentGroup("GSI-3");

            studentGroupRepository.save(studentGroup1);
            studentGroupRepository.save(studentGroup2);
            studentGroupRepository.save(studentGroup3);

            userRepository.save(
                    new User(
                            "admin@admin.com",
                            "password",
                            "CY",
                            "Admin",
                            LocalDate.now(),
                            "000-0000",
                            "ADMIN"
                    )
            );

            Student student1 = new Student("jane.doe@example.com",
                    "password123",
                    "Doe",
                    "Jane",
                    LocalDate.of(2002, 3, 15),
                    "0612345678",
                    studentGroup1
            );

            Student student2 = new Student(
                    "john.smith@example.com",
                    "securePass!789",
                    "Smith",
                    "John",
                    LocalDate.of(2001, 5, 20),
                    "0654321876", studentGroup1
            );

            Student student3 = new Student(
                    "alice.brown@example.com",
                    "passAlice2023",
                    "Brown",
                    "Alice",
                    LocalDate.of(2003, 1, 10),
                    "0687654321",
                    studentGroup2
            );

            Student student4 = new Student(
                    "michael.jones@example.com",
                    "mikeJ!oneS",
                    "Jones",
                    "Michael",
                    LocalDate.of(2000, 12, 25),
                    "0678943212",
                    studentGroup2);

            Student student5 = new Student(
                    "emily.wilson@example.com",
                    "Emily$Wilson",
                    "Wilson",
                    "Emily",
                    LocalDate.of(2004, 7, 8),
                    "0643218765",
                    studentGroup3
            );

            Student student6 = new Student(
                    "david.johnson@example.com",
                    "D@vidJ123",
                    "Johnson",
                    "David",
                    LocalDate.of(1999, 11, 3),
                    "0698765432",
                    studentGroup3
            );

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
            studentRepository.save(student4);
            studentRepository.save(student5);
            studentRepository.save(student6);

            Professor professor1 = new Professor(
                    "cdumont@school.com",
                    "password123",
                    "Dumont",
                    "Clara",
                    LocalDate.of(1985, 3, 15),
                    "0123456789"
            );

            Professor professor2 = new Professor(
                    "mlefebvre@school.com",
                    "securepass",
                    "Lefebvre",
                    "Marc",
                    LocalDate.of(1978, 6, 22),
                    "0987654321"
            );

            Professor professor3 = new Professor(
                    "smartins@school.com",
                    "bioExpert!45",
                    "Martins",
                    "Sofia",
                    LocalDate.of(1990, 9, 10),
                    "0678901234"
            );

            Professor professor4 = new Professor(
                    "pnguyen@school.com",
                    "Code4Life!",
                    "Nguyen",
                    "Paul",
                    LocalDate.of(1983, 11, 5),
                    "0654321987"
            );

            Professor professor5 = new Professor(
                    "lcaron@school.com",
                    "LitMaster88",
                    "Caron",
                    "Lucie",
                    LocalDate.of(1992, 1, 20),
                    "0789123456"
            );

            professorRepository.save(professor1);
            professorRepository.save(professor2);
            professorRepository.save(professor3);
            professorRepository.save(professor4);
            professorRepository.save(professor5);

            Course course1 = new Course("Introduction to Mathematics", professor1);
            Course course2 = new Course("Advanced Physics", professor2);
            Course course3 = new Course("Biology for Beginners", professor3);
            Course course4 = new Course("Computer Science Basics", professor4);
            Course course5 = new Course("French Literature", professor5);

            courseRepository.save(course1);
            courseRepository.save(course2);
            courseRepository.save(course3);
            courseRepository.save(course4);
            courseRepository.save(course5);

            professor1.getCourses().add(course1);
            professor2.getCourses().add(course2);
            professor3.getCourses().add(course3);
            professor4.getCourses().add(course4);
            professor5.getCourses().add(course5);

            Enrollment enrollment1 = new Enrollment(student1, course1);
            Enrollment enrollment2 = new Enrollment(student2, course2);
            Enrollment enrollment3 = new Enrollment(student3, course3);
            Enrollment enrollment4 = new Enrollment(student4, course4);
            Enrollment enrollment5 = new Enrollment(student5, course5);
            Enrollment enrollment12 = new Enrollment(student1, course2);

            enrollmentRepository.save(enrollment1);
            enrollmentRepository.save(enrollment2);
            enrollmentRepository.save(enrollment3);
            enrollmentRepository.save(enrollment4);
            enrollmentRepository.save(enrollment5);
            enrollmentRepository.save(enrollment12);

            Note note1 = new Note(20.0, enrollment1); //student1
            Note note2 = new Note(15.0, enrollment1); //student 1
            Note note3 = new Note(12.0, enrollment2);
            Note note4 = new Note(15.0, enrollment12); // student 1 cours 2

            noteRepository.save(note1);
            noteRepository.save(note2);
            noteRepository.save(note3);
            noteRepository.save(note4);

            enrollment1.getNotes().add(note1);
            enrollment1.getNotes().add(note2);
            enrollment2.getNotes().add(note3);
            enrollment12.getNotes().add(note4);
        } catch (Exception e){
            System.err.println(e.getMessage());
            return "Error, check server logs or reach your administrator.";
        }
        return "Database initialized !";
    }
}
