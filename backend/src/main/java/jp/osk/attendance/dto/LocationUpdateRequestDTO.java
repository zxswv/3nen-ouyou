package jp.osk.attendance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/** PUT /api/user/location */
public record LocationUpdateRequestDTO(@NotBlank @Size(max = 50) String location) {
}
