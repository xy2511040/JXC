package cn.jsmoon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;


/**
 * 用户实体
 * @author LTQ
 *
 */
@Entity
@Table(name="t_user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;	//自增Id
	
	@Column(length=50)
	private String userName; //用户名
	
	@Column(length=50)
	private String password; //密码
	
	@Column(length=50)
	private String trueName; //真实姓名
	
	@Column(length=1000)
	private String remarks; //备注
}
