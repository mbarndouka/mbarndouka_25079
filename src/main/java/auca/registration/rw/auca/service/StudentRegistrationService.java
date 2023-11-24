package auca.registration.rw.auca.service;

import auca.registration.rw.auca.Repository.StudentRegistrationRepository;
import auca.registration.rw.auca.domain.StudentRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public String saveStudentRegistration(StudentRegistration studentRegistration) {
        if (studentRegistration != null) {
//            StudentRegistration oneStudentRegistration = studentRegistrationRepository
//                    .findById(studentRegistration.getRegistrationId())
//                    .orElse(null);
            studentRegistrationRepository.save(studentRegistration);
            return "Student registration saved successfully";
        } else
            return null;
    }

    public List<StudentRegistration> getRegisteredStudents() {
        return studentRegistrationRepository.findAll();
    }
}
