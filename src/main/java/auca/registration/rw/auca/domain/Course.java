package auca.registration.rw.auca.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "credits")
    private int credits;

    public Course() {
    }

    public Course(String courseCode, String courseName, Department department, String courseDescription, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.courseDescription = courseDescription;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
