package kr.co.ckdgns.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Users implements UserDetails {
	private String user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_phone;
    private String role;

    public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	private List<GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
		
	}
	@Override
	public String getPassword() {
		return user_password;	
	}
	@Override
	public String getUsername() {
		// 
		return user_id;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true; // 계정 만료 여부
	}
	@Override
	public boolean isAccountNonLocked() {
		return true; // 계정 잠금 여부
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true; // 자격 증명 만료 여부
	}
	@Override
	public boolean isEnabled() {
		return true; // 활성화 여부
	}

}
