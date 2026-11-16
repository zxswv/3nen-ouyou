// W02 一般ユーザー トップ（画面詳細設計書 W02）
// TODO(W02): 以下を実装する
// - 現在日時 / 勤務場所プルダウン / 連絡先の入力・表示 / 打刻漏れ通知エリア
// - 「勤務場所・連絡先を保存する」: PUT /api/user/location, PUT /api/user/contact
// - 「出勤」「退勤」: Geolocation API で緯度経度を取得し POST /api/attendance/clock-in|clock-out

export default function TopPage() {
  return (
    <main className="p-8">
      <h1 className="text-2xl font-bold">一般ユーザー トップ</h1>
      <p className="mt-2 text-sm text-gray-500">W02（未実装）</p>
    </main>
  );
}
