package auca.registration.rw.auca.controler;

import auca.registration.rw.auca.domain.Course;
import auca.registration.rw.auca.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/saveCourse")
    public ResponseEntity<?> saveCourse(
            @RequestBody Course course
            ){
        if (course != null){
            String saveCourse = courseService
                    .saveCourse(course);
            if (saveCourse != null){
                return new ResponseEntity<>(
                        "Course saved successfully",
                        HttpStatus.OK
                );
            }else{
                return new ResponseEntity<>(
                        "Something wrong",
                        HttpStatus.BAD_REQUEST
                );
            }
        }else{
            return new ResponseEntity<>(
                    "You are not allowed to send empty data",
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
