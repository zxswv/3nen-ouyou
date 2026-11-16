package jp.osk.attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 申請テーブル (applications)。
 * version 列による楽観的ロックで、複数管理者の同時承認・却下を防ぐ（詳細設計書 10章-2）。
 */
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_type", nullable = false, length = 20)
    private ApplicationType applicationType;

    @Column(name = "target_date_start", nullable = false)
    private LocalDate targetDateStart;

    @Column(name = "target_date_end", nullable = false)
    private LocalDate targetDateEnd;

    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ApplicationStatus status;

    @Column(name = "applied_at", nullable = false)
    private LocalDateTime appliedAt;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    protected Application() {
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public User getUser() {
        return user;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public LocalDate getTargetDateStart() {
        return targetDateStart;
    }

    public LocalDate getTargetDateEnd() {
        return targetDateEnd;
    }

    public String getReason() {
        return reason;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public Integer getVersion() {
        return version;
    }
}
