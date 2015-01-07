/*
* 文 件 名:  UserService.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  用户访问服务
* 修 改 人:  zhouliang
* 修改时间:  2013年11月21日
* 修改内容:  <修改内容>
*/
package org.yy.demo.service.module1;

import java.util.List;

import org.yy.demo.dto.UserDTO;
import org.yy.demo.model.User;
import org.yy.framework.basedata.exception.ServiceException;
import org.yy.framework.basedata.query.ResultDto;

/**
* 用户访问服务
* 
* @author  zhouliang
* @version  [0.1, 2013年11月21日]
* @since  [APP-DEMO/0.1]
*/
public interface UserService {
    
    /**
     *  注册用户
     * @param user　用户信息
     */
    public void registerUser(User user)throws ServiceException;
    
    /**
     * 查找用户
     * @param loginID 用户登录ID
     * @return 用户
     * @throws ServiceException {USER_LOGINID_EMPTY:用户登录ID为空}
     */
    public User findUser(String loginID)
        throws ServiceException;
    
    /**
     * 查找用户列表
     * @param userDTO  查询条件
     * @return 用户列表
     * @throws ServiceException
     */
    public ResultDto<User> findUser(UserDTO userDTO)
        throws ServiceException;
    
    /**
     * 是否存在某用户
     * @param loginID 用户标识
     * @return true,表示存在;false, 表示不存在;
     * @throws ServiceException {USER_LOGINID_EMPTY:用户登录ID为空}
     */
    public boolean exists(String loginID)
        throws ServiceException;
    
    /**
     * 配置用户与用户组及用户与角色的关系
     * 
     * @param loginID   用户ID
     * @param groupIDs 用户组ID列表
     * @param roleCodes 角色编码列表
     */
    public void config(String loginID, List<Long> groupIDs, List<String> roleCodes)
        throws ServiceException;
    
}
