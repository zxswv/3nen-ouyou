package jp.osk.attendance.service;

import org.springframework.stereotype.Service;

/**
 * 打刻漏れ防止の通知（要件定義書 3.2.1 / EXT-02 SMTP）。
 * 打刻漏れの検知（定期実行）と、申請結果のメール通知を行う。
 */
@Service
public class NotificationService {
}
