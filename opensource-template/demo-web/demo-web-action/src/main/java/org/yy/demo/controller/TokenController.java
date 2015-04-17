package org.yy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yy.framework.base.controller.AbstractTokenController;

@Controller
public class TokenController extends AbstractTokenController {

	@Override
	protected void setModuleName() {

	}

	@RequestMapping("/token")
	public String token() {
		if (tokenHandler.validToken(tokenHandler.fetchToken()))
			return "jsp/tiles";
		else {
			return "jsp/contact";
		}
	}

}
