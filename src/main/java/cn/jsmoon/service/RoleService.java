package cn.jsmoon.service;

import java.util.List;

import cn.jsmoon.entity.Role;

/**
 * 角色Service接口
 * @author LTQ
 *
 */
public interface RoleService {
	
	/**
	 * 根据用户ID查询对应角色集合
	 * @param id
	 * @return
	 */
	public List<Role> findByUserId(Integer id);
	
	/**
	 * 通过ID查找角色实体
	 * @param id
	 * @return
	 */
	public Role findById(Integer id);
}
