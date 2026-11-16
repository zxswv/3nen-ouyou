# Web勤怠管理システム（OSK）

授業「システム開発応用」のチーム開発リポジトリです。
仕様は 要件定義書・基本設計書・詳細設計書・画面設計書・画面詳細設計書 に従います。

| 区分 | 技術 |
|---|---|
| フロントエンド | Next.js 16（App Router）/ TypeScript / Tailwind CSS |
| バックエンド | Java 21 / Spring Boot 3.5 / Spring Security（JWT）/ Spring Data JPA |
| データベース | **PostgreSQL 17**（全員同じバージョン） |
| 本番想定 | VirtualBox 上の Linux（Nginx → Spring Boot :8080 → PostgreSQL :5432） |

## フォルダ構成

```
backend/    Spring Boot（controller / service / repository / entity / dto / client / security / exception）
frontend/   Next.js（W01〜W08 の画面）
db/init.sql テーブル作成＋テストデータ
.env.example 環境変数の例
```

## 1. 必要なもの

- Java 21（JDK）
- Node.js 20 以上
- PostgreSQL 17（下記の手順で入れる）
- Git

Maven はインストール不要です（`backend/mvnw` が自動でダウンロードします）。

## 2. PostgreSQL 17 のインストール（全員共通）

1. https://www.postgresql.org/download/windows/ から EDB の **PostgreSQL 17.x** インストーラーをダウンロードする
2. インストーラーの設定
   - コンポーネント: PostgreSQL Server / pgAdmin 4 / Command Line Tools（Stack Builder は不要）
   - スーパーユーザー（postgres）のパスワード: 各自で決めて控えておく
   - ポート: **5432**（変更しない）
   - ロケール: Default
3. `psql` を使えるように、PATH に `C:\Program Files\PostgreSQL\17\bin` を追加する
4. 確認: `psql --version` で `psql (PostgreSQL) 17.x` と出ればOK

## 3. データベースの初期化（init.sql）

リポジトリ直下で実行します。

```bash
psql -U postgres -f db/init.sql
```

- `attendance` データベースを**削除して作り直し**、テーブルとテストデータを入れます
- テーブル定義を変えたら init.sql を更新してコミットし、全員がもう一度実行します

### テストユーザー（パスワードはすべて `password`）

| メールアドレス（ログインID） | 氏名 | 部署 | 権限 |
|---|---|---|---|
| admin@example.com | 管理者 太郎 | 総務部 | ADMIN |
| yamada@example.com | 山田 花子 | 開発部 | GENERAL |
| sato@example.com | 佐藤 一郎 | 開発部 | GENERAL（昨日の退勤打刻なし＝打刻漏れ確認用） |
| suzuki@example.com | 鈴木 次郎 | 開発部 | GENERAL |
| takahashi@example.com | 高橋 三郎 | 営業部 | GENERAL |

## 4. バックエンドの起動

環境変数を設定してから起動します（値の例は `.env.example`）。

PowerShell:

```powershell
cd backend
$env:DB_PASSWORD = "postgresのパスワード"
$env:JWT_SECRET  = "32文字以上のランダムな文字列"
.\mvnw.cmd spring-boot:run
```

Git Bash / Mac / Linux:

```bash
cd backend
export DB_PASSWORD=postgresのパスワード
export JWT_SECRET=32文字以上のランダムな文字列
./mvnw spring-boot:run
```

`http://localhost:8080` で起動します。テストは `./mvnw test`。

> Maven のダウンロードで `PKIX path building failed` が出る場合は、
> `MAVEN_OPTS=-Djavax.net.ssl.trustStoreType=Windows-ROOT` を設定してから実行してください（Windows）。

## 5. フロントエンドの起動

```bash
cd frontend
npm install
npm run dev
```

`http://localhost:3000` で開きます。API の接続先は `frontend/.env.local` の `NEXT_PUBLIC_API_BASE_URL`（省略時は `http://localhost:8080`）。

## 6. 開発の進め方

- `main` に直接 push しない。`feature/W02-top` のようにブランチを切って Pull Request を出す
- コミットメッセージは `feat: 〜` `fix: 〜` `docs: 〜` の形式
- `.env` やパスワード、APIキーはコミットしない

## 実装状況（ベースコード時点）

| 内容 | 状態 |
|---|---|
| テーブル定義・テストデータ（init.sql） | 済 |
| Entity・Repository（テーブルと一致することを起動時に検証） | 済 |
| Security 設定（JWT 前提のステートレス、`/api/admin/**` は ADMIN のみ、未ログインは 401） | 済 |
| DTO（API仕様書の項目） | 済 |
| Controller / Service / Client / JwtTokenProvider の中身 | **未実装**（各クラスのコメントに担当APIを記載） |
| 画面 W01〜W08 | **未実装**（ページの枠とTODOのみ） |

## 設計書からの補足・決定事項

- **ログインIDは email**。API仕様書の `username` にはメールアドレスを入れる（users テーブルに username 列がないため）。そのため `users.email` は NOT NULL
- `applications` に楽観ロック用の `version` 列を追加（詳細設計書 10章）
- `attendances` に `(user_id, target_date)` の一意制約（詳細設計書 10章）
- API のパスは API仕様書の表どおり `/api/...`（共通仕様の `/api/v1` ではなく）
- Spring Boot は設計書の「3.x」に合わせて 3.5 系を使用
