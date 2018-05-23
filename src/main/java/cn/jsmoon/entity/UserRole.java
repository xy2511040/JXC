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
 * 用户角色关联实体
 * @author LTQ
 *
 */
@Entity
@Table(name="t_userRole")
@Data
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //自增ID
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user; // 用户
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role; // 角色
}
