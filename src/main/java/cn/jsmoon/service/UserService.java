package cn.jsmoon.service;

import cn.jsmoon.entity.User;

/**
 * 用户Service层
 * @author LTQ
 *
 */
public interface UserService {
	
	/**
	 * 根据用户名查找用户实体
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
