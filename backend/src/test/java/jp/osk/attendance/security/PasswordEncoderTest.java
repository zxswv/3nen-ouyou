package jp.osk.attendance.security;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

class PasswordEncoderTest {

    /** db/init.sql が pgcrypto の crypt('password', gen_salt('bf', 10)) で作るのと同じ形式のハッシュ。 */
    private static final String PGCRYPTO_HASH_OF_PASSWORD =
            "$2a$10$Ajt/0ACrtL7KT6aEjLVdYOEDM2S6GdOZNBduyHAz53mDSXu2dsUu6";

    private final PasswordEncoder encoder = new SecurityConfig().passwordEncoder();

    @Test
    void initSqlのテストユーザーのハッシュを照合できる() {
        assertThat(encoder.matches("password", PGCRYPTO_HASH_OF_PASSWORD)).isTrue();
    }

    @Test
    void 誤ったパスワードは照合に失敗する() {
        assertThat(encoder.matches("wrong-password", PGCRYPTO_HASH_OF_PASSWORD)).isFalse();
    }

    @Test
    void 同じパスワードでも毎回異なるハッシュになる() {
        String first = encoder.encode("password");
        String second = encoder.encode("password");

        assertThat(first).isNotEqualTo(second);
        assertThat(encoder.matches("password", first)).isTrue();
    }
}
