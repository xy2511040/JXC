package cn.jsmoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jsmoon.entity.Role;
import cn.jsmoon.repository.RoleRepository;
import cn.jsmoon.service.RoleService;

/**
 * 角色Service接口实现类
 * @author LTQ
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleRepository roleRepository;

	@Override
	public List<Role> findByUserId(Integer id) {
		return roleRepository.findByUserId(id);
	}

	@Override
	public Role findById(Integer id) {
		return roleRepository.findById(id).get();
	}
	


}
