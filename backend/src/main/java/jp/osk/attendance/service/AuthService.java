package jp.osk.attendance.service;

import org.springframework.stereotype.Service;

/**
 * 認証ロジック（詳細設計書 6章-1）。
 * authenticate(email, password): email でユーザーを検索し BCrypt で照合、JwtTokenProvider でトークンを発行する。
 */
@Service
public class AuthService {
}
