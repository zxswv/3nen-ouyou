package jp.osk.attendance.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/** PUT /api/user/contact */
public record ContactUpdateRequestDTO(
        @Size(max = 20) String phone,
        @Email @Size(max = 255) String email) {
}
