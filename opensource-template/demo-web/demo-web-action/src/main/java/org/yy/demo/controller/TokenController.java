package org.yy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yy.demo.model.User;
import org.yy.framework.base.controller.AbstractTokenController;

@Controller
public class TokenController extends AbstractTokenController {

	@Override
	protected void setModuleName() {

	}

	@RequestMapping("/token")
	public ModelAndView token() {
		if (tokenHandler.validToken(tokenHandler.fetchToken()))
			return processSuccess("jsp/tiles", "123");
		else {
			return processSuccess("jsp/contact", new User());
		}
	}

}
