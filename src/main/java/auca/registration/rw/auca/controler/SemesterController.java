package auca.registration.rw.auca.controler;

import auca.registration.rw.auca.domain.Semester;
import auca.registration.rw.auca.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Semester",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping(value = "/saveSemester")
    public ResponseEntity<?> saveSemester(
            @RequestBody Semester semester
            ){
        if (semester != null){
            String saveSemester = semesterService
                    .saveSemester(semester);
            if(saveSemester != null){
                return new ResponseEntity<>(
                        "Semester saved successfully",
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
