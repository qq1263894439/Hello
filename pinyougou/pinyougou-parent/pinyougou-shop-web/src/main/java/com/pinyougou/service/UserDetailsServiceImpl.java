package com.pinyougou.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import com.pinyougou.show.status.StaticStatus;



/**
 * 认证类
 * @author asus
 *
 */

public class UserDetailsServiceImpl implements UserDetailsService {
	private SellerService sellerServic;
	
	public void setSellerServic(SellerService sellerServic) {
		this.sellerServic = sellerServic;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("经过了UserDetailsServiceImpl");
		//构建角色列表
		List<GrantedAuthority> grantedAuths=new ArrayList();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		//得到商家对象
		TbSeller seller = sellerServic.findOne(username);
		if(seller!=null && StaticStatus.OK.getValue().equals(seller.getStatus())) {
			
				return new User(username,seller.getPassword(),grantedAuths);
		}else {
			return null;
		}

	}

}
