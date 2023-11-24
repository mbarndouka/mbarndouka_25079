package auca.registration.rw.auca.service;

import auca.registration.rw.auca.Repository.StudentRepository;
import auca.registration.rw.auca.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public String saveStudent(Student student){
        if(student != null){
                studentRepository.save(student);
            return "student save successfully";
        }else
            return null;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public String updateStudent(Student student){
        if(student !=null){
            studentRepository.save(student);
            return "Student updated successfully";
        }else{
            return null;
        }
    }

    public String deleteStudentById(Integer id) {
        if (id != null) {
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        } else {
            return null;
        }
    }
}
