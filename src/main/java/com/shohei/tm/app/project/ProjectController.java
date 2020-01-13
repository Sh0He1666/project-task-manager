/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shohei.tm.domain.service.project.ProjectService;

/**
 * プロジェクトに関するコントローラークラスです。
 * @author shoheitokumaru
 *
 */
@Controller
//ひとまず、ルートコンテキストにきたリクエストを受け取る
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/")
	String testProject() {
		return "project/test_project";
	}
}
