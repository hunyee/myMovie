package kr.co.ckdgns.users.dao;

import org.springframework.stereotype.Repository;

import kr.co.ckdgns.vo.Users;

@Repository
public interface UserDAO {
	public Users findByUserId(String user_id);
}
