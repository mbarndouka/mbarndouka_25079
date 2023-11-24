package auca.registration.rw.auca.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_registration")
public class StudentRegistration {

    @Id
    @Column(name = "registration_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id")
    private Semester semester;



    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public StudentRegistration() {
    }

    public StudentRegistration(Long registrationId, Student student, Course course, Semester semester, LocalDate registrationDate) {
        this.registrationId = registrationId;
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.registrationDate = registrationDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
