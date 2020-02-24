/**
 * 20200113 初版
 * 
 */
package com.shohei.tm.domain.service.code;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shohei.tm.domain.model.Code;
import com.shohei.tm.domain.repository.code.CodeRepository;

/**
 * プロジェクトに関するビジネスロジック
 * @author shoheitokumaru
 *
 */
@Service
@Transactional
public class CodeService {
	
	//projectRepositoryをインジェンクション
	@Autowired
	CodeRepository codeRepository;
	//テスト用にひとまず、projectテーブルのデータを検索するメソッドを実装
	
	//登録されているプロジェクトのIDリストを返す
	public List<Code> findAll() {
		return codeRepository.findAll();
	}
	
	//genre='status'であるレコードを取得する
	public List<Code> getStatusList() {
		return codeRepository.getStatusList();
	}
	
	//genre='status'であるレコードを取得する
	public List<Code> getProgressRateList() {
		return codeRepository.getProgressRateList();
	}	
}
