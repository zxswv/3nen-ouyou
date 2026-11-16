package jp.osk.attendance.entity;

/** users.role の値。Spring Security 上は "ROLE_" を付けて扱う（詳細設計書 9章）。 */
public enum Role {
    ADMIN,
    GENERAL;

    public String authority() {
        return "ROLE_" + name();
    }
}
