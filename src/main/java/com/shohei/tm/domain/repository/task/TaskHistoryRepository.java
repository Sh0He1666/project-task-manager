/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.repository.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.model.User;

/**
 * タスク履歴リポジトリを表すインテーフェースです
 * @author shoheitokumaru
 *
 */
@Transactional
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
	/**
	 * 実装されるメソッド
	 * 
	 */ 
	
	@Query(value = "select x from TaskHistory x order by id, projectId asc")
	List<TaskHistory> queryAll();
	//List<TaskHistory> findByUser_id(User user);
	
	//タスク詳細情報をUPDATEする
	@Modifying
	@Query("update TaskHistory th set"
			+ " th.content =:content,"
			+ " th.problem =:problem,"
			+ " th.plan =:plan"
			+ " where th.id =:id") 
	public Integer updateTaskDetailById (
			@Param("content") String content,
			@Param("problem") String problem,
			@Param("plan") String plan,
			@Param("id") Integer id
			);
}
