package jp.osk.attendance.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 例外を共通エラー形式（dto.ErrorResponse）に変換する（詳細設計書 7章）。
 * 400 入力エラー / 401・403 認証権限 / 409 業務ルール違反（二重打刻・楽観ロック）/ 500 システムエラー。
 * 500 の場合はスタックトレースを画面に返さず、ログにだけ出す。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
}
