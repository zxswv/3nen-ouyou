package jp.osk.attendance.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ApplicationResponseDTO(
        Integer applicationId,
        String type,
        LocalDate startDate,
        LocalDate endDate,
        String reason,
        String status,
        LocalDateTime appliedAt) {
}
