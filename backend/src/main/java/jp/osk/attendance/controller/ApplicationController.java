package jp.osk.attendance.controller;

import jp.osk.attendance.service.ApplicationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API仕様書（詳細設計書 4章）の担当エンドポイント:
 * No.7  POST /api/applications            休暇・残業の新規申請
 * No.8  GET  /api/applications            自身の申請履歴
 */
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }
}
