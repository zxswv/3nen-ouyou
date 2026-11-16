// バックエンド（Spring Boot）呼び出しの共通処理。
// 各画面からはこのファイルの apiFetch を使う。

export const API_BASE_URL =
  process.env.NEXT_PUBLIC_API_BASE_URL ?? "http://localhost:8080";

/** 共通エラー形式（詳細設計書 4章「API共通仕様」） */
export type ApiError = {
  timestamp: string;
  status: number;
  error: string;
  message: string;
  path: string;
};

/**
 * JSON API を呼び出す。token を渡すと Authorization: Bearer <JWT> を付ける。
 * 2xx 以外はサーバーの message を持つ Error を投げる。
 */
export async function apiFetch<T>(
  path: string,
  options: { method?: string; body?: unknown; token?: string } = {},
): Promise<T> {
  const headers: Record<string, string> = { "Content-Type": "application/json" };
  if (options.token) {
    headers.Authorization = `Bearer ${options.token}`;
  }

  const res = await fetch(`${API_BASE_URL}${path}`, {
    method: options.method ?? "GET",
    headers,
    body: options.body === undefined ? undefined : JSON.stringify(options.body),
  });

  if (!res.ok) {
    const err = (await res.json().catch(() => null)) as ApiError | null;
    throw new Error(err?.message ?? `通信に失敗しました（${res.status}）`);
  }
  return (await res.json()) as T;
}
