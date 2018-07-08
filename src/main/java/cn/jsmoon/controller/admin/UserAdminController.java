package cn.jsmoon.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jsmoon.entity.Role;
import cn.jsmoon.entity.User;
import cn.jsmoon.service.RoleService;
import cn.jsmoon.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	/**
	 * 分页查询用户信息
	 * @param user
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> list(User user,@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{
		Map<String, Object> resultMap=new HashMap<>();
		List<User> userList = userService.list(user, page, rows, Direction.ASC, "id");
		for(User u:userList) {
			List<Role> roleList = roleService.findByUserId(u.getId());
			StringBuffer sb=new StringBuffer();
			for(Role r:roleList) {
				sb.append(","+r.getName());
			}
			u.setRoles(sb.toString().replaceFirst(",", ""));
		}
		Long total = userService.getCount(user);
		resultMap.put("rows", userList);
		resultMap.put("total", total);
		
		return resultMap;
	}
}
