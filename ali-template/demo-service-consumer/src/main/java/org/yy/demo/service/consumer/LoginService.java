/*
* 文 件 名:  LoginService.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhouliang
* 修改时间:  2014年7月23日
* 修改内容:  <修改内容>
*/
package org.yy.demo.service.consumer;

import org.yy.demo.model.User;
import org.yy.demo.service.module1.UserService;
import org.yy.framework.basedata.exception.ServiceException;

/**
* 通过登录服务来验证Dubbo服务的使用
* 
* @author  zhouliang
* @version  [0.1, 2014年7月23日]
* @since  [APP-DEMO/0.1]
*/
public class LoginService {
    
    private UserService userService;
    
    public boolean login(String loginID)
        throws ServiceException {
        User user = userService.findUser(loginID);
        return user != null;
    }
    
    /**
    * @return 返回 userService
    */
    public UserService getUserService() {
        return userService;
    }
    
    /**
    * @param 对userService进行赋值
    */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
}
