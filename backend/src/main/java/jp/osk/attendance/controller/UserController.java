package jp.osk.attendance.controller;

import jp.osk.attendance.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API仕様書（詳細設計書 4章）の担当エンドポイント:
 * No.5  PUT  /api/user/location           勤務場所の登録・更新
 * No.6  PUT  /api/user/contact            連絡先の登録・更新
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
}
