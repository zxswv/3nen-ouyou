package jp.osk.attendance.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import jp.osk.attendance.entity.ApplicationType;

/** POST /api/applications。endDate を省略した場合は startDate と同日として扱う。 */
public record ApplicationRequestDTO(
        @NotNull ApplicationType type,
        @NotNull LocalDate startDate,
        LocalDate endDate,
        String reason) {
}
