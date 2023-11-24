package auca.registration.rw.auca.Repository;

import auca.registration.rw.auca.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
