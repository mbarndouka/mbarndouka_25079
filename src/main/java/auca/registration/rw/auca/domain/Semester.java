package auca.registration.rw.auca.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semesterId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Semester() {
    }

    public Semester(
            Long semesterId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        this.semesterId = semesterId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
