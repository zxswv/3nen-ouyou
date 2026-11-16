package jp.osk.attendance.controller;

import jp.osk.attendance.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API仕様書（詳細設計書 4章）の担当エンドポイント:
 * No.1  POST /api/auth/login             ログイン（認証不要）
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }
}
