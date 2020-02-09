/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.domain.service.project;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shohei.tm.domain.model.Project;
import com.shohei.tm.domain.repository.project.ProjectRepository;

/**
 * プロジェクトに関するビジネスロジック
 * @author shoheitokumaru
 *
 */
@Service
@Transactional
public class ProjectService {
	
	//projectRepositoryをインジェンクション
	@Autowired
	ProjectRepository projectRepository;
	//テスト用にひとまず、projectテーブルのデータを検索するメソッドを実装
	
	//登録されているプロジェクトのIDリストを返す
	public List<Project> findAll() {
		return projectRepository.findAll();
	}
	
	//select
	public Project findProject(Integer id) {
		return projectRepository.findById(id).orElse(null);
	}
	
	//update
	public void save(Project project) {
		projectRepository.save(project);
	}
	
}
