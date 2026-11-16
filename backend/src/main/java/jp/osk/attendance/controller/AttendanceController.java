package jp.osk.attendance.controller;

import jp.osk.attendance.service.AttendanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API仕様書（詳細設計書 4章）の担当エンドポイント:
 * No.2  POST /api/attendance/clock-in      出勤打刻
 * No.3  POST /api/attendance/clock-out     退勤打刻
 * No.4  GET  /api/attendance/status        当日の勤怠状況一覧
 */
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }
}
