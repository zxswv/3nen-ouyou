package jp.osk.attendance.service;

import org.springframework.stereotype.Service;

/**
 * 休暇・残業申請（詳細設計書 6章-3）。
 * createApplication / findMyApplications / updateStatus（承認・却下）。
 * 承認・却下は Application.version による楽観的ロックで競合を検出する（10章-2）。
 */
@Service
public class ApplicationService {
}
