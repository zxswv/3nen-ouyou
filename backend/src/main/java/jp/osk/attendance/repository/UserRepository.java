package jp.osk.attendance.repository;

import java.util.List;
import java.util.Optional;
import jp.osk.attendance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    /** ログインID（email）で検索する。 */
    Optional<User> findByEmail(String email);

    List<User> findByDepartmentDepartmentId(Integer departmentId);

    long countByDepartmentDepartmentId(Integer departmentId);
}
