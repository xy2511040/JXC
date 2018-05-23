package cn.jsmoon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jsmoon.entity.Role;
import cn.jsmoon.entity.User;
import cn.jsmoon.service.RoleService;
import cn.jsmoon.service.UserService;
import cn.jsmoon.util.StringUtil;

/**
 * 用户Controller类
 * @author LTQ
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;

	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(String imageCode,@Valid User user,BindingResult bindingResult,HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		if(StringUtil.isEmpty(imageCode)) {
			map.put("success", false);
			map.put("errorInfo", "请输入验证码！");
			return map;
		}
		if(!session.getAttribute("checkcode").equals(imageCode)) {
			map.put("success", false);
			map.put("errorInfo", "验证码输入错误！");
			return map;
		}
		if(bindingResult.hasErrors()) {
			map.put("success", false);
			map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
			return map;
		}
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			subject.login(token);
			String userName = (String) SecurityUtils.getSubject().getPrincipal();
			User currentUser=userService.findByUserName(userName);
			session.setAttribute("currentUser", currentUser);
			List<Role> roleList = roleService.findByUserId(currentUser.getId());
			map.put("roleList", roleList);
			map.put("roleSize", roleList.size());
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("errorInfo", "用户名或者密码错误!");
			return map;
		}
	}
	
	@ResponseBody
	@RequestMapping("/saveRole")
	public Map<String, Object> saveRole(Integer roleId,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Role currentRole = roleService.findById(roleId);
		session.setAttribute("currentRole", currentRole);
		map.put("success", true);
		return map;
		
	}
}
