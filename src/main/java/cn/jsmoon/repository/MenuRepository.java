package cn.jsmoon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.jsmoon.entity.Menu;

/**
 * 菜单Repository接口
 * @author LTQ
 *
 */
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	/**
	 * 根据父节点以及用户角色id查询子节点
	 * @param id
	 * @return
	 */
	@Query(value="SELECT * FROM t_menu WHERE p_id=?1 AND id IN (SELECT menu_id FROM t_role_menu WHERE role_id=?2)",nativeQuery=true)
	public List<Menu> findByParentIdAndRoleId(int parentId,int roleId);
}
