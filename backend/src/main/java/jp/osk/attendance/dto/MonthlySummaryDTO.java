package jp.osk.attendance.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/** GET /api/admin/summary の1行（W07 勤怠・残業・休暇集計）。 */
public record MonthlySummaryDTO(
        LocalDate date,
        LocalDateTime clockInTime,
        LocalDateTime clockOutTime,
        double workHours,
        double overtimeHours) {
}
