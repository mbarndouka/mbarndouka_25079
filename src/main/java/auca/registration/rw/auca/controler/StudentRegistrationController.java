package auca.registration.rw.auca.controler;

import auca.registration.rw.auca.domain.StudentRegistration;
import auca.registration.rw.auca.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/studentRegistration"
//        ,consumes = {MediaType.APPLICATION_JSON_VALUE}
//        ,produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentRegistrationController {

    private StudentRegistrationService studentRegistrationService;
    @Autowired
    public void setStudentRegistrationService(
            StudentRegistrationService studentRegistrationService
    ){
        this.studentRegistrationService = studentRegistrationService;
    }

    @PostMapping(value = "/saveStudentRegistration")
    public ResponseEntity<?> saveStudentRegistration(
            @RequestBody StudentRegistration studentRegistration
    ) {
        if (studentRegistration != null) {
            String saveStudentRegistrationResult = studentRegistrationService.
                    saveStudentRegistration(studentRegistration);
            if (saveStudentRegistrationResult != null)
                return new ResponseEntity<>
                        ("Student registration saved successfully",
                                HttpStatus.OK);
            else {
                return new ResponseEntity<>("Something is wrong",
                        HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(
                    "You are not allowed to send empty data",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping(value = "/registeredStudents")
    public ResponseEntity<List<StudentRegistration>> getRegisteredStudents(

    ){
        List<StudentRegistration> registeredStudents =
                studentRegistrationService.getRegisteredStudents();
        if(!registeredStudents.isEmpty()){
            return new ResponseEntity<>(registeredStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
