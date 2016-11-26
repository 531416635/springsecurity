package com.yao.security;

import java.util.ArrayList;
import java.util.Collection;





import net.sf.ehcache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yao.model.UserModel;
import com.yao.model.UserModelExample;
import com.yao.model.UserModelExample.Criteria;
import com.yao.service.UserService;
import com.yao.utils.EhcacheUtils;

@Component
public class MyUserDetailService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	// 登陆验证时，通过username获取用户的所有权限信息，
	// 并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User user =  (User) EhcacheUtils.getCache(username);
		logger.debug("从缓存中取出{},对应的值{}", username, user);
		if (user == null) {
			System.out.println(username + "============UserDetailsService");
			UserModelExample example = new UserModelExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			UserModel domainUser = userService.selectByExample(example).get(0);
			logger.debug("从数据库中取出{},对应的值{}", username, domainUser);
			Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			GrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
			GrantedAuthority auth3 = new SimpleGrantedAuthority(
					"ROLE_ANONYMOUS");
			GrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");

			if (username.equals("yao")) {
				auths = new ArrayList<GrantedAuthority>();
				auths.add(auth1);
				auths.add(auth2);
				auths.add(auth3);
			}
			user = new User(username, domainUser.getPassword(), true, true,
					true, true, auths);
			EhcacheUtils.putCache(username, user);
		}
		return user;
	}

}
