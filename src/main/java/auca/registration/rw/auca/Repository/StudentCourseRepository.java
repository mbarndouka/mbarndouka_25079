package auca.registration.rw.auca.Repository;

import auca.registration.rw.auca.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends
        JpaRepository<StudentCourse, Long> {
}
