package com.wangyuena.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangyuena.common.ConstClass;
import com.wangyuena.common.ResultMsg;
import com.wangyuena.entity.Commnent;
import com.wangyuena.service.CommnentService;

@Controller
public class CommnentController {

	@Autowired
	CommnentService commnentService;
	//添加评论
	@ResponseBody
	@RequestMapping("commnentinsert")
	public  ResultMsg commnentinsert(HttpServletRequest request, Commnent commnent ) {
		if(request.getSession().getAttribute(ConstClass.SESSION_USER_KEY)!=null) {
		int result =  commnentService.commnentinsert(commnent);
		if(result>0) {
			return new ResultMsg(1, "发布成功","");
		}else {
			return new ResultMsg(3, "发布失败，请稍候再试","");
		}
		}else {
			return new ResultMsg(2, "您尚未登录，不能评论","");
		}
	}
}
*/