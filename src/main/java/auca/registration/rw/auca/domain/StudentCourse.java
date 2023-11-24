package auca.registration.rw.auca.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_course_id")
    private Long studentCourseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",
    foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_STUDENT"))
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code")
    private Course course;

//    @Column(name = "course_code")
//    private String courseCode;
    @Column(name = "credits")
    private Double credits;
    @Column(name = "results")
    private String results;

    public StudentCourse() {
    }

    public StudentCourse(
            Long studentCourseId,
            Student student,
            Course course,
            Double credits,
            String results
    ) {
        this.studentCourseId = studentCourseId;
        this.student = student;
        this.course = course;
        this.credits = credits;
        this.results = results;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(Long studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
