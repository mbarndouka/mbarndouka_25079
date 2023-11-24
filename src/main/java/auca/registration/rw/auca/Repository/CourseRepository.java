package auca.registration.rw.auca.Repository;

import auca.registration.rw.auca.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends
        JpaRepository<Course, String> {
}
