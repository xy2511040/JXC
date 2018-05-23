package cn.jsmoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求首页Controller层
 * @author LTQ
 *
 */
@Controller
public class IndexController {
	
		@RequestMapping("/")
		public String root() {
			return "redirect:/login.html";
		}
}
