package auca.registration.rw.auca.service;

import auca.registration.rw.auca.Repository.CourseRepository;
import auca.registration.rw.auca.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public String saveCourse(Course course){
        if (course != null){
            courseRepository.save(course);
            return "Course saved successfully";
        }else{
            return null;
        }
    }
}
