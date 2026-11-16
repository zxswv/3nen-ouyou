# frontend（Next.js / TypeScript）

起動方法などはリポジトリ直下の README.md を参照してください。

| URL | 画面 |
|---|---|
| `/` | W01 ログイン画面&打刻 |
| `/top` | W02 一般ユーザー トップ |
| `/status` | W03 勤怠状況一覧 |
| `/applications` | W04 申請 |
| `/admin` | W05 管理者ダッシュボード |
| `/admin/users` | W06 ユーザー管理 |
| `/admin/summary` | W07 勤怠・残業・休暇集計 |
| `/admin/approvals` | W08 申請承認 |

API呼び出しは `src/lib/api.ts` の `apiFetch` を使います。
