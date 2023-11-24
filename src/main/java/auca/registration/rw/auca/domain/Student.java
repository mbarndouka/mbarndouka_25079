package auca.registration.rw.auca.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
//    @GeneratedValue()
    private Integer studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;


    public Student() {
    }

    public Student(Integer studentId, String studentName, String dateOfBirth) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
