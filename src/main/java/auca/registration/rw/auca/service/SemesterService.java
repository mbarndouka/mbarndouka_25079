package auca.registration.rw.auca.service;

import auca.registration.rw.auca.Repository.SemesterRepository;
import auca.registration.rw.auca.domain.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    public String saveSemester(
            Semester semester
    ){
        if(semester != null){
            semesterRepository.save(semester);
            return "Semester saved successfully";
        }else{
            return null;
        }
    }
}
