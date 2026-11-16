package jp.osk.attendance.service;

import org.springframework.stereotype.Service;

/**
 * 管理者機能（詳細設計書 6章-4）。
 * ユーザーの登録・変更・削除（登録時は DepartmentRepository.findByIdForUpdate で人数上限を確認、10章-3）。
 * calculateMonthlySummary(month, deptId): 日別勤務時間・残業時間・月間合計を集計する（W07）。
 */
@Service
public class AdminService {
}
