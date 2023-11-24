package auca.registration.rw.auca.controler;

import auca.registration.rw.auca.Repository.StudentRepository;
import auca.registration.rw.auca.domain.Student;
import auca.registration.rw.auca.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student",
//        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value = "/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        if(student != null){
            Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
            if(existingStudent == null) {
                String saveStudent = studentService.saveStudent(student);
                if (saveStudent != null){
                    return new ResponseEntity<>
                            ("student saved successfully",
                                    HttpStatus.OK
                            );
                }else{
                    return new  ResponseEntity<>
                            ("something is wrong",
                                    HttpStatus.BAD_REQUEST
                            );
                }
            }else{
                return new ResponseEntity<>(
                  "Student with ID "+ student.getStudentId()+ " already start",
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

    @GetMapping(value = "/listOfStudent")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
