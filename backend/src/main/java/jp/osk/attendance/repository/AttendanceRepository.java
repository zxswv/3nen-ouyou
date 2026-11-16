package jp.osk.attendance.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import jp.osk.attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    Optional<Attendance> findByUserUserIdAndTargetDate(Integer userId, LocalDate targetDate);

    List<Attendance> findByUserUserIdAndTargetDateBetweenOrderByTargetDate(
            Integer userId, LocalDate from, LocalDate to);
}
