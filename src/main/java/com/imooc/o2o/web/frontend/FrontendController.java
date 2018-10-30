package com.imooc.o2o.web.frontend;
/*
 * Created by wxn
 * 2018/9/19 14:20
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/frontend")
public class FrontendController {

	@RequestMapping(value = "/index" , method = RequestMethod.GET)
	private String index(){
		return "frontend/index";
	}

	@RequestMapping(value = "/shoplist" , method = RequestMethod.GET)
	private String shopList(){
		return "frontend/shoplist";
	}

	@RequestMapping(value = "/shopdetail" , method = RequestMethod.GET)
	private String shopDetail(){
		return "frontend/shopdetail";
	}
}
