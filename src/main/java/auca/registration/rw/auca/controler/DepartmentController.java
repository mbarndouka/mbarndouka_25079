package auca.registration.rw.auca.controler;

import auca.registration.rw.auca.Repository.DepartmentRepository;
import auca.registration.rw.auca.domain.Department;
import auca.registration.rw.auca.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/department",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/department")
    public ResponseEntity<?> saveDepart(
            @RequestBody Department department){
        if(department != null){
            String saveSemester = departmentService
                    .saveDepartment(department);
            if (saveSemester != null){
                return new ResponseEntity<>(
                        "Department saved successfully",
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
