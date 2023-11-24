package auca.registration.rw.auca.Repository;

import auca.registration.rw.auca.domain.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
}
