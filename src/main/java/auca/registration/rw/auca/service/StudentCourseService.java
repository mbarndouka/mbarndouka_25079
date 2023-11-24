package auca.registration.rw.auca.service;

import auca.registration.rw.auca.Repository.StudentCourseRepository;
import auca.registration.rw.auca.domain.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public String saveStudentCourse(StudentCourse stdCourse){
        if (stdCourse != null){
            studentCourseRepository.save(stdCourse);
            return "course saved successfully";
        }else
            return null;
    }
}
