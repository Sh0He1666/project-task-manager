/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shohei.tm.domain.service.project.ProjectService;

/**
 * プロジェクトに関するコントローラークラスです。
 * @author shoheitokumaru
 *
 */
@RequestMapping("/project/{code}/{name}")
@Controller
//ひとまず、ルートコンテキストにきたリクエストを受け取る
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	//フォームからの入力値をプロジェクトテーブルに格納し、タスクリスト画面に遷移するメソッド
	/**
	@RequestMapping(method=RequestMethod.POST)
	String reserve(
			//フォームで入力された情報を保持
			@Validated ProjectForm form, 
			//フォームクラスの入力チェック結果を保持
			BindingResult bindingResult,
			@PathVariable("code") String code,
			@PathVariable("name") String name,
			Model model
			) {
		if (bindingResult.hasErrors()) {
			return ;
		}
		
		return "";
	}
	**/
	
	
	
	
}
