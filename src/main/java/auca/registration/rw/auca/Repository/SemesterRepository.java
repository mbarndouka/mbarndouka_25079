package auca.registration.rw.auca.Repository;

import auca.registration.rw.auca.domain.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends
        JpaRepository<Semester, Long> {
}
