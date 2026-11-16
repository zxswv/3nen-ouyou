package jp.osk.attendance.dto;

import java.time.OffsetDateTime;

/** 共通エラー形式（詳細設計書 4章「API共通仕様」）。 */
public record ErrorResponse(
        OffsetDateTime timestamp,
        int status,
        String error,
        String message,
        String path) {
}
