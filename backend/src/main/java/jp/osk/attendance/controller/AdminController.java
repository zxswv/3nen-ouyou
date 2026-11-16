package jp.osk.attendance.controller;

import jp.osk.attendance.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API仕様書（詳細設計書 4章）の担当エンドポイント:
 * No.9  GET  /api/admin/users                    ユーザー一覧（ADMIN）
 * No.10 PUT  /api/admin/applications/{id}/approve 申請の承認（ADMIN）
 * No.11 GET  /api/admin/summary?month=&deptId=     月次勤怠集計（ADMIN）
 * ユーザーの登録・変更・削除（W06）もここに追加する。
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }
}
