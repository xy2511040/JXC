package cn.jsmoon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 角色菜单关联实体
 * @author LTQ
 *
 */
@Entity
@Table(name="t_roleMenu")
@Data
public class RoleMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //自增ID
	
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role; // 角色
	
	@ManyToOne
	@JoinColumn(name="menuId")
	private Menu menu; // 菜单
}
