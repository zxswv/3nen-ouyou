package jp.osk.attendance.repository;

import java.util.List;
import jp.osk.attendance.entity.Application;
import jp.osk.attendance.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByUserUserIdOrderByAppliedAtDesc(Integer userId);

    List<Application> findByStatusOrderByAppliedAtAsc(ApplicationStatus status);
}
