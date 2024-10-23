package kr.co.ckdgns.users.service;

import org.springframework.security.core.userdetails.UserDetails;

import kr.co.ckdgns.vo.Users;

public interface UserService {
	Users login(String user_id, String user_password);
	UserDetails loadUserByUsername(String username);
	boolean checkPassword(String password, String user_password);
}
