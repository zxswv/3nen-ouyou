package jp.osk.attendance.dto;

/** GET /api/admin/users の1行（W06 ユーザー管理）。パスワードは含めない。 */
public record UserSummaryDTO(
        Integer userId,
        String name,
        Integer departmentId,
        String role,
        String email,
        String phoneNumber) {
}
