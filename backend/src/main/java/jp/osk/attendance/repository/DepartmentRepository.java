package jp.osk.attendance.repository;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import jp.osk.attendance.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    /** 人数上限チェック用。SELECT ... FOR UPDATE で行ロックする（詳細設計書 10章-3）。 */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Department d WHERE d.departmentId = :id")
    Optional<Department> findByIdForUpdate(@Param("id") Integer id);
}
