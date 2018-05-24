package cn.jsmoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jsmoon.entity.Menu;
import cn.jsmoon.repository.MenuRepository;
import cn.jsmoon.service.MenuService;

/**
 * 菜单Service实现类
 * @author LTQ
 *
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Resource
	private MenuRepository menuRepository;
	
	@Override
	public List<Menu> findByParentIdAndRoleId(int parentId, int roleId) {
		return menuRepository.findByParentIdAndRoleId(parentId, roleId);
	}

}
