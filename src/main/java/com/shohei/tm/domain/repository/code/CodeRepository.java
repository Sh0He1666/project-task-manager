/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.domain.repository.code;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shohei.tm.domain.model.ChargeCode;
import com.shohei.tm.domain.model.Code;

/**
 * チャージコードレポジトリを表したインターフェースです
 * @author shoheitokumaru
 *
 */
public interface CodeRepository extends JpaRepository<Code, Integer> {
	
	//ステータスを取得するメソッド
	@Query(value="select x from Code x where genre = 'status'")
	List<Code> getStatusList();

	//進捗率を取得するメソッド
	@Query(value="select x from Code x where genre = 'progress_rt'")
	List<Code> getProgressRateList();
	
}

