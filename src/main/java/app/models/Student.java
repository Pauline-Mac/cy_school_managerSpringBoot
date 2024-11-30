package app.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup studentGroup;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Student() {
        super();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Student(
            String email,
            String password,
            String lastName,
            String firstName,
            LocalDate birthDate,
            String phone,
            StudentGroup studentGroup
    ) {
        super(
                email,
                password,
                lastName,
                firstName,
                birthDate,
                phone,
                "STUDENT"
        );
        this.studentGroup = studentGroup;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }


    // Getters et setters

    /*public Long getStudentId() {
        return studentId;
    }*/

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
