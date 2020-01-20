/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.repository.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.model.User;

/**
 * タスク履歴リポジトリを表すインテーフェースです
 * @author shoheitokumaru
 *
 */
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
	/**
	 * 実装されるメソッド
	 * 
	 */ 
	
	@Query(value = "select x from TaskHistory x order by id, projectId asc")
	List<TaskHistory> queryAll();
	//List<TaskHistory> findByUser_id(User user);
}
