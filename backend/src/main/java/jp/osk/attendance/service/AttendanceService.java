package jp.osk.attendance.service;

import org.springframework.stereotype.Service;

/**
 * 打刻のメインロジック（詳細設計書 6章-2、5章 シーケンス図）。
 * recordClockIn / recordClockOut: LocationApiClient で住所を取得し attendances に保存する。
 * 住所取得に失敗しても打刻は行う（7章 ステップ5）。二重打刻は一意制約違反を 409 に変換する。
 * getTodayStatus: 所属部署メンバーの当日状況を返す（W03）。
 */
@Service
public class AttendanceService {
}
