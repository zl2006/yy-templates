package org.yy.demo.controller;

/*
* 文 件 名:  UserController.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  用户操作控制层
* 修 改 人:  zhouliang
* 修改时间:  2013年11月26日
* 修改内容:  <修改内容>
*/

import static org.yy.framework.basedata.Constants.ADD_PAGE;
import static org.yy.framework.basedata.Constants.LIST_PAGE;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yy.demo.dto.UserDTO;
import org.yy.demo.model.User;
import org.yy.demo.service.module1.UserService;
import org.yy.framework.base.controller.AbstractController;
import org.yy.framework.basedata.exception.ServiceException;
import org.yy.framework.document.anno.Method;
import org.yy.framework.document.anno.Model;
import org.yy.framework.document.anno.Param;
import org.yy.framework.document.anno.Return;
import org.yy.framework.document.anno.Service;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
* 用户服务
* 
* @author  zhouliang
* @version  [1.0, 2013年11月26日]
* @since  [app-user/1.0]
*/
@Controller
@RequestMapping("user")
@Service(name = "用户服务", desc = "用户注册、注销、重置密码、维护等操作", role = "管理员、新注册用户", models = {@Model(name = "user", desc = "用户实体", clazz = User.class)})
public class UserController extends AbstractController {
    
    @Resource(name = "userService")
    private UserService userService;
    
    @Resource(name = "producer")
    private DefaultMQProducer producer;
    
    @RequestMapping(value = "list")
    @Method(name = "查询用户", desc = "查询用户,演示了RocketMQ的消息发送", returns = {@Return(name = "用户", clazz = User.class)})
    public ModelAndView list(@Param UserDTO userDTO)
        throws ServiceException, Exception {
        Message msg = new Message("USER",// topic
            "FIND",// tag
            "18665867002",// key
            ("zhouliang").getBytes());// body
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
        return processSuccess(moduleName + LIST_PAGE, userService.findUser(userDTO), userDTO);
    }
    
    @RequestMapping(value = "register")
    @Method(name = "注册用户", desc = "注册用户")
    public ModelAndView register(@Param User user)
        throws ServiceException, Exception {
        userService.registerUser(user);
        Message msg = new Message("USER",// topic
            "REGISTER",// tag
            "18665867002",// key
            ("zhouliang").getBytes());// body
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
        return processSuccess(moduleName + ADD_PAGE, null, user);
    }
    
    /** {@inheritDoc} */
    @Override
    protected void setModuleName() {
        this.moduleName = "module/user/";
    }
}
