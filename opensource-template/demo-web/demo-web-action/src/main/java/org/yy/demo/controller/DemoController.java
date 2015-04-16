package org.yy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yy.framework.base.controller.AbstractController;

@Controller
public class DemoController extends AbstractController {

	protected String moduleName;

	@Override
	protected void setModuleName() {
		this.moduleName = "";
	}

	@RequestMapping("/tiles")
	public String testTiles() {
		return "jsp/contact";
	}
	
	@RequestMapping("/tiles1")
	public String testTiles1() {
		return "jsp/tiles";
	}
}
