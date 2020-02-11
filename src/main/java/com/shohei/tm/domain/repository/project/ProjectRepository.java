/**
 * 20200113 初版
 * 
 */

package com.shohei.tm.domain.repository.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shohei.tm.domain.model.Project;

/**
 * プロジェクトエンティティ用のリポジトリです。
 * @author shoheitokumaru
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	//クエリをコンストラクタでマップしてみる
	List<Project> findAll();
	
	//プロジェクト情報を追加する
	/**
	@Modifying
	@Query("insert into Project (code, name)"
			+ " values (code =:code, name =:name)")
	public Integer insertProject(
			@Param("code") String code,
			@Param("name") String name			
			);
			**/
}
