package jp.osk.attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 勤怠テーブル (attendances)。
 * (user_id, target_date) の複合一意制約で二重打刻を防ぐ（詳細設計書 10章-1）。
 */
@Entity
@Table(name = "attendances",
        uniqueConstraints = @UniqueConstraint(name = "uq_attendances_user_date",
                columnNames = {"user_id", "target_date"}))
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Integer attendanceId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "target_date", nullable = false)
    private LocalDate targetDate;

    @Column(name = "clock_in_time")
    private LocalDateTime clockInTime;

    @Column(name = "clock_out_time")
    private LocalDateTime clockOutTime;

    @Column(name = "work_location", length = 50)
    private String workLocation;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    protected Attendance() {
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public LocalDateTime getClockInTime() {
        return clockInTime;
    }

    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
}
