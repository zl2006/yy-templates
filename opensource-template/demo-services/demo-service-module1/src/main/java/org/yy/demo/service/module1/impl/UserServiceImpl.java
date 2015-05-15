/*
 * 文 件 名:  UserServiceImpl.java
 * 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
 * 描    述:  用户访问服务
 * 修 改 人:  zhouliang
 * 修改时间:  2013年12月1日
 * 修改内容:  <修改内容>
 */
package org.yy.demo.service.module1.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.yy.demo.dao.UserDao;
import org.yy.demo.dto.UserDTO;
import org.yy.demo.model.User;
import org.yy.demo.service.module1.UserService;
import org.yy.framework.base.validator.ValidateError;
import org.yy.framework.base.validator.ValidateUtil;
import org.yy.framework.basedata.exception.ServiceException;
import org.yy.framework.basedata.query.ResultDto;

/**
 * 用户访问服务
 * 
 * @author zhouliang
 * @version [1.0, 2013年12月1日]
 * @since [app-user/1.0]
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDAO")
	protected UserDao userDao;

	/** {@inheritDoc} */
	@Override
	public User insertUser(User user) throws ServiceException {

		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		// 1,校验用户信息
		List<ValidateError> errors = ValidateUtil.validate(user);
		if (errors.size() > 0) {
			throw new ServiceException("USER_VALIDATE_ERROR", errors.toString());
		}

		if (exists(user.getLoginID())) {
			throw new ServiceException("USER_LOGINID_REPEAT", "用户登录ID重复");
		}

		// 2,插入用户信息
		user.setPassword(DigestUtils.sha1Hex(user.getPassword()));
		userDao.insertUser(user);

		return user;

	}

	/** {@inheritDoc} */
	@Override
	public void updateUser(User user) throws ServiceException {
		// 1,校验用户信息
		List<ValidateError> errors = ValidateUtil.validate(user, "userID",
				"loginID", "name");
		if (errors.size() > 0) {
			throw new ServiceException("USER_VLIDA_ERROR", errors.toString());
		}

		User userTemp = findUser(user.getLoginID());
		if (userTemp != null && !userTemp.getUserID().equals(user.getUserID())) {
			throw new ServiceException("USER_LOGINID_REPEAT", "用户登录ID重复");
		}

		// 2,更新用户信息
		userDao.updateUser(user);

	}

	/** {@inheritDoc} */
	@Override
	public User findUser(String loginID) throws ServiceException {
		if (StringUtils.isEmpty(loginID)) {
			throw new ServiceException("USER_LOGINID_EMPTY", "用户登录ID为空");
		}
		User user = userDao.findUser(loginID);
		return user;
	}

	/** {@inheritDoc} */
	@Override
	public ResultDto<User> findUser(UserDTO userDTO) throws ServiceException {
		return userDao.findUser(userDTO);
	}

	/** {@inheritDoc} */
	@Override
	public boolean exists(String loginID) throws ServiceException {
		if (StringUtils.isEmpty(loginID)) {
			throw new ServiceException("USER_LOGINID_EMPTY", "用户登录ID为空");
		}
		User user = userDao.findUser(loginID);
		return user != null;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
