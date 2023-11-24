package auca.registration.rw.auca.service;

import auca.registration.rw.auca.Repository.DepartmentRepository;
import auca.registration.rw.auca.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public String saveDepartment(Department department){
        if (department != null) {
            departmentRepository.save(department);
            return "Department saved successfully";
        }else{
            return null;
        }
    }
}
