package jp.osk.attendance.dto;

import jakarta.validation.constraints.NotBlank;

/** POST /api/auth/login。username にはメールアドレスを入れる。 */
public record LoginRequestDTO(
        @NotBlank String username,
        @NotBlank String password) {
}
