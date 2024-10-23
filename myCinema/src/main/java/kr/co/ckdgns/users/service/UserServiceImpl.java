package kr.co.ckdgns.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ckdgns.users.dao.UserDAO;
import kr.co.ckdgns.vo.Users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Users login(String user_id, String user_password) {
		Users user = userDao.findByUserId(user_id);
        if (user != null && passwordEncoder.matches(user_password, user.getPassword())) {
            return user; // 인증 성공
        }
        return null; // 인증 실패
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Users user = userDao.findByUserId(username);
		if (user == null) {
			System.out.println("제발");
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUser_id(), user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean checkPassword(String password, String user_password) {
		return passwordEncoder.matches(password, user_password);
	}
	
	

}
