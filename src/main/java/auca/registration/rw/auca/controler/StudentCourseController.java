package auca.registration.rw.auca.controler;

import auca.registration.rw.auca.domain.StudentCourse;
import auca.registration.rw.auca.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/studentCourse",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentCourseController {

    @Autowired
    private StudentCourseService stdCrseService;

    @PostMapping(value = "/saveCourse")
    public ResponseEntity<?> saveStudentCourse(
            @RequestBody StudentCourse studentCourse
            ){
        if (studentCourse != null){
            String saveStudentCourse = stdCrseService
                    .saveStudentCourse(studentCourse);
            if (saveStudentCourse != null){
                return new ResponseEntity<>
                        ("student course saved successfully",
                        HttpStatus.OK);
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
