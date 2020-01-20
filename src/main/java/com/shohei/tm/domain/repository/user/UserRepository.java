/**
 * タスクリストエンティティを表すクラスです
 * @author shoheitokumaru
 *
 */
package com.shohei.tm.domain.repository.user;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shohei.tm.domain.model.User;

/**
 * ユーザーリポジトリを表すインターフェースです
 * @author shoheitokumaru
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
