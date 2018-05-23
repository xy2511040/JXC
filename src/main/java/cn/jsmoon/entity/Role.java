package cn.jsmoon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;


/**
 * 角色实体
 * @author LTQ
 *
 */
@Entity
@Table(name="t_role")
@Data
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;	//自增Id
	
	@Column(length=50)
	private String roleName; //角色名
	
	@Column(length=1000)
	private String remarks; //备注
}
