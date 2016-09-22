package cn.xurk.mcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信公众号 入口 控制器
 * @author XuRongkun
 *
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {
	
	@RequestMapping(value={"/vaild"}, method={RequestMethod.GET})
	@ResponseBody
	public String valid(String name) {
		return name;
	}
}
