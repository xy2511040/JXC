package cn.jsmoon.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

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
	
	/**
	 * 根据条件分页查询用户信息集合
	 * @param user
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<User> list(User user,Integer page,Integer pageSize,Direction direction,String...properties);
	
	/**
	 * 获取用户总记录数
	 * @param user
	 * @return
	 */
	public Long getCount(User user);
}
