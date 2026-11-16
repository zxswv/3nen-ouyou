// W01 ログイン画面&打刻（画面詳細設計書 W01）
// TODO(W01): 以下を実装する
// - メールアドレス・パスワード → POST /api/auth/login。返ってきた role で W02 か W05 へ遷移
// - 「出勤」「退勤」ボタン（Geolocation API で位置情報を取得）
// - 二重クリック防止のため送信中はボタンを無効化する（詳細設計書 7章 ステップ1）

export default function LoginPage() {
  return (
    <main className="p-8">
      <h1 className="text-2xl font-bold">Web勤怠管理システム</h1>
      <p className="mt-2 text-sm text-gray-500">W01 ログイン画面&amp;打刻（未実装）</p>
    </main>
  );
}
