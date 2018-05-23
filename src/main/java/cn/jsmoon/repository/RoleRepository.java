package cn.jsmoon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.jsmoon.entity.Role;

/**
 * 角色Repository接口
 * @author LTQ
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

	/**
	 * 根据用户ID查询对应角色集合
	 * @param id
	 * @return
	 */
	@Query(value="SELECT r.* FROM t_user u,t_role r,t_user_role ur WHERE ur.`user_id`=u.`id` AND ur.`role_id`=r.`id` AND u.`id`=?1",nativeQuery=true)
	public List<Role> findByUserId(Integer id);
}
