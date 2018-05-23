package cn.jsmoon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jsmoon.entity.User;
import cn.jsmoon.repository.UserRepository;
import cn.jsmoon.service.UserService;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserRepository userRepository;
	
	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
