package jp.osk.attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** 部署テーブル (departments)。 */
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name", nullable = false, length = 50)
    private String departmentName;

    @Column(name = "max_members", nullable = false)
    private Integer maxMembers;

    protected Department() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getMaxMembers() {
        return maxMembers;
    }
}
