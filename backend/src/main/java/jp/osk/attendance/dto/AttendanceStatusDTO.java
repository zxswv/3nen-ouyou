package jp.osk.attendance.dto;

/** GET /api/attendance/status の1行（W03 勤怠状況一覧）。 */
public record AttendanceStatusDTO(
        Integer userId,
        String name,
        String status,
        String workLocation,
        String phoneNumber,
        String email) {
}
