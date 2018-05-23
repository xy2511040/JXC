package cn.jsmoon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;


/**
 * 菜单实体
 * @author LTQ
 *
 */
@Entity
@Table(name="t_menu")
@Data
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;	//自增Id
	
	@Column(length=50)
	private String menuName; //菜单名
	
	@Column(length=200)
	private String url; //菜单地址
	
	private Integer state; //菜单状态  节点类型 1根节点 0叶子节点
	
	@Column(length=100)
	private String icon; // 图标
	
	private Integer pId; // 父菜单Id

}
