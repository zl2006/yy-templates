package org.yy.demo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.yy.demo.model.User;
import org.yy.framework.base.test.AbstractMVCSpringTest;
import org.yy.framework.basedata.query.ResultDto;

public class UserControllerTest extends AbstractMVCSpringTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testList() throws Exception {
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/user/list").param(
								"loginID", "18665867002"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		ResultDto<User> userResult = (ResultDto<User>) result.getModelAndView()
				.getModel().get("data");
		Assert.assertEquals(1, userResult.getResult().size());
	}

}