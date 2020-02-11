/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.domain.repository.code;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shohei.tm.domain.model.ChargeCode;
import com.shohei.tm.domain.model.Code;

/**
 * チャージコードレポジトリを表したインターフェースです
 * @author shoheitokumaru
 *
 */
public interface CodeRepository extends JpaRepository<Code, Integer> {
}
