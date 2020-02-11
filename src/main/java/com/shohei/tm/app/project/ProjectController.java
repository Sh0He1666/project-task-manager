/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.app.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shohei.tm.domain.model.Project;
import com.shohei.tm.domain.service.project.ProjectService;

/**
 * プロジェクトに関するコントローラークラスです。
 * @author shoheitokumaru
 *
 */
@RequestMapping("project")
@Controller
//ひとまず、ルートコンテキストにきたリクエストを受け取る
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	/**
	 * ヘッダーメニュー選択→プロジェクト情報入力画面
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	String gotoProjectAddInfo(Model model) {
		List<Project> currentProjectList = projectService.findAll();
		model.addAttribute("currentProjectList", currentProjectList);
		return "/project/project-add-info";
	}
	
	/**
	 * プロジェクト情報入力→データをINSERT→プロジェクト情報入力
	 * 渡す値：code, name
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	String insertProjectInfo(
			//フォームで入力された情報を保持
			@Validated ProjectForm form,
			//フォームクラスの入力チェック結果を保持
			BindingResult bindingResult,
			Model model
			) {
		
		if (bindingResult.hasErrors()) {
			return "redirect:/project";
		}
		
		//プロジェクトインスタンスを生成
		Project project = new Project();
		
		//プロジェクトにフォームから取得した値を格納
		project.setCode(form.getCode());
		project.setName(form.getName());
		
		//プロジェクトテーブルに保存
		projectService.save(project);
		
		return "redirect:/project";
	}
	
	@ModelAttribute
	ProjectForm setUpProjectForm() {
		ProjectForm form = new ProjectForm();
		return form;
	}
	
}
