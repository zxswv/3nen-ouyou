package jp.osk.attendance.security;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * JWT の生成と検証（詳細設計書 6章-1、9章）。
 * generateToken(User): subject に userId、claim に role を入れて署名する。
 * validateToken(String): 署名と有効期限を確認する。
 * 署名鍵は環境変数 JWT_SECRET（HS256 のため 32 バイト以上）。
 */
@Component
public class JwtTokenProvider {

    private static final int MIN_SECRET_BYTES = 32;

    private final byte[] secret;
    private final long expirationMinutes;

    public JwtTokenProvider(
            @Value("${app.jwt.secret}") String secret,
            @Value("${app.jwt.expiration-minutes}") long expirationMinutes) {
        byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);
        if (bytes.length < MIN_SECRET_BYTES) {
            throw new IllegalStateException(
                    "JWT_SECRET は " + MIN_SECRET_BYTES + " バイト以上にしてください");
        }
        this.secret = bytes;
        this.expirationMinutes = expirationMinutes;
    }
}
