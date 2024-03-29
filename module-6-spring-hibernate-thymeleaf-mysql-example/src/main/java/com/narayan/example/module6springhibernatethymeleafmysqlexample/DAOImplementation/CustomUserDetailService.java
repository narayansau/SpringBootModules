package com.narayan.example.module6springhibernatethymeleafmysqlexample.DAOImplementation;

import com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities.Users;
import com.narayan.example.module6springhibernatethymeleafmysqlexample.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service  @Transactional
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository  userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail( userName ) .
				orElseThrow(()  -> new UsernameNotFoundException(
						 "Email "  +  userName + "  Not Found")) ;
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(), getAuthorities(user));
		
		
		
		
	}
	
	private static Collection <? extends GrantedAuthority> getAuthorities(Users user) {
		
		String[] userRoles = user.
				getRoles().
				stream().
				map((role) -> role.getName()).toArray(String[]::new);
		
		Collection<GrantedAuthority> authorities = AuthorityUtils.
				                        createAuthorityList(userRoles);
		return authorities;
	}
}
