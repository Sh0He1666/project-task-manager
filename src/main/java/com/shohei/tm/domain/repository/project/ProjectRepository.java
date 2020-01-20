/**
 * 20200113 初版
 * 
 */

package com.shohei.tm.domain.repository.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shohei.tm.domain.model.Project;

/**
 * プロジェクトエンティティ用のリポジトリです。
 * @author shoheitokumaru
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	//クエリをコンストラクタでマップしてみる
	List<Project> findAll();
}
