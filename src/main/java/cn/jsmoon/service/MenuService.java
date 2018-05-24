package cn.jsmoon.service;

import java.util.List;

import cn.jsmoon.entity.Menu;


/**
 * 菜单Service层
 * @author LTQ
 *
 */
public interface MenuService {

	/**
	 * 根据父节点以及用户角色id查询子节点
	 * @param parentId
	 * @param roleId
	 * @return
	 */
	public List<Menu> findByParentIdAndRoleId(int parentId,int roleId);
}
