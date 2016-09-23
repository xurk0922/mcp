package cn.xurk.mcp.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xurk.mcp.msg.WeChat;

/**
 * 微信公众号 入口 控制器
 * @author XuRongkun
 *
 */
@Controller
@RequestMapping("/wx")
public class WeChatController {
	
	@RequestMapping(value={"/vaild"}, method={RequestMethod.POST})
	@ResponseBody
	public String valid(WeChat weChat, HttpServletRequest request, HttpServletResponse response) {
		String token = "xurongkun";
		String timestamp = weChat.getTimestamp().toString();
		String nonce = weChat.getNonce()+"";
		
		List<String> check = new ArrayList<String>();
		check.add(token);
		check.add(timestamp);
		check.add(nonce);
		
		Collections.sort(check);
		String signature = new String(DigestUtils.shaHex(check.get(0)+check.get(1)+check.get(2)));

		System.out.println(signature);
		System.out.println(weChat.getSignature());
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.setCharacterEncoding("UTF-8"); 
		if (signature.equals(weChat.getSignature())) {
			return weChat.getEchostr();
		}
		
		return "success";
	}
}
