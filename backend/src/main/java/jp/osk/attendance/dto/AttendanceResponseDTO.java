package jp.osk.attendance.dto;

import java.time.LocalDateTime;

/** 打刻結果。出勤時は clockOutTime が null、退勤時は clockInTime が null になる。 */
public record AttendanceResponseDTO(
        String status,
        LocalDateTime clockInTime,
        LocalDateTime clockOutTime,
        String resolvedAddress) {
}
