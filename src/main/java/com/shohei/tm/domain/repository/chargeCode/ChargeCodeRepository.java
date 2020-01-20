/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.domain.repository.chargeCode;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shohei.tm.domain.model.ChargeCode;

/**
 * チャージコードレポジトリを表したインターフェースです
 * @author shoheitokumaru
 *
 */
public interface ChargeCodeRepository extends JpaRepository<ChargeCode, Integer> {
}
