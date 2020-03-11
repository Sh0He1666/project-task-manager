/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.domain.service.charge;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shohei.tm.domain.model.ChargeCode;
import com.shohei.tm.domain.model.Project;
import com.shohei.tm.domain.repository.chargeCode.ChargeCodeRepository;
import com.shohei.tm.domain.repository.project.ProjectRepository;

/**
 * プロジェクトに関するビジネスロジック
 * @author shoheitokumaru
 *
 */
@Service
@Transactional
public class ChargeService {
	
	//projectRepositoryをインジェンクション
	@Autowired
	ChargeCodeRepository chargeCodeRepository;
	//テスト用にひとまず、projectテーブルのデータを検索するメソッドを実装
	
	//登録されているプロジェクトのIDリストを返す
	public List<ChargeCode> findAll() {
		return chargeCodeRepository.findAll();
	}
	
	//select
	public ChargeCode findProject(Integer id) {
		return chargeCodeRepository.findById(id).orElse(null);
	}
	
	//update
	@Transactional
	public void save(ChargeCode charge) {
		chargeCodeRepository.save(charge);
	}
	
	//delete
	@Transactional
	public void deleteChargeInfoById(Integer id) {
		chargeCodeRepository.deleteById(id);
	}
}
