/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.app.charge;

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

import com.shohei.tm.domain.model.ChargeCode;
import com.shohei.tm.domain.service.charge.ChargeService;

/**
 * プロジェクトに関するコントローラークラスです。
 * @author shoheitokumaru
 *
 */
@RequestMapping("charge")
@Controller
//ひとまず、ルートコンテキストにきたリクエストを受け取る
public class ChargeController {
	@Autowired
	ChargeService chargeService;
	
	/**
	 * ヘッダーメニュー選択→プロジェクト情報入力画面
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	String gotoChargeAddInfo(Model model) {
		List<ChargeCode> currentChargeList = chargeService.findAll();
		model.addAttribute("currentChargeList", currentChargeList);
		return "/charge/charge-add-info";
	}
	
	/**
	 * プロジェクト情報入力→データをINSERT→プロジェクト情報入力
	 * 渡す値：code, name
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	String insertChargeInfo(
			//フォームで入力された情報を保持
			@Validated ChargeForm form,
			//フォームクラスの入力チェック結果を保持
			BindingResult bindingResult,
			Model model
			) {
		
		if (bindingResult.hasErrors()) {
			return "redirect:/charge";
		}
		
		//プロジェクトインスタンスを生成
		ChargeCode charge = new ChargeCode();
		
		//プロジェクトにフォームから取得した値を格納
		charge.setCode(form.getCode());
		charge.setName(form.getName());
		
		//プロジェクトテーブルに保存
		chargeService.save(charge);
		
		return "redirect:/charge";
	}
	
	@ModelAttribute
	ChargeForm setUpChargeForm() {
		ChargeForm form = new ChargeForm();
		return form;
	}
	
}
