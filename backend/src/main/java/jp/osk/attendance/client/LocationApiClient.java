package jp.osk.attendance.client;

import org.springframework.stereotype.Component;

/**
 * 外部の逆ジオコーディングAPIとの通信だけを担当する（EXT-03）。
 * getLocationName(latitude, longitude): 緯度・経度から住所の文字列を返す。
 * APIキーは app.geocoding.api-key（環境変数 GEOCODING_API_KEY）から読む。
 */
@Component
public class LocationApiClient {
}
