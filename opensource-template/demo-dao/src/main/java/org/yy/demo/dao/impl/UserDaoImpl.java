/*
 * 文 件 名:  UserDaoImpl.java
 * 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
 * 描    述:  用户访问DAO
 * 修 改 人:  zhouliang
 * 修改时间:  2013年11月21日
 * 修改内容:  <修改内容>
 */
package org.yy.demo.dao.impl;

import java.sql.SQLException;
import java.util.Date;

import org.yy.demo.dao.UserDao;
import org.yy.demo.dto.UserDTO;
import org.yy.demo.model.User;
import org.yy.framework.base.dao.AbstractMyBatisDao;
import org.yy.framework.basedata.exception.DaoException;
import org.yy.framework.basedata.query.ResultDto;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;

import static org.yy.demo.model.User.*;

/**
 * 用户访问DAO
 * 
 * @author zhouliang
 * @version [1.0, 2013年11月21日]
 * @since [app-user/1.0]
 */
public class UserDaoImpl extends AbstractMyBatisDao implements UserDao {

	/** {@inheritDoc} */
	@Override
	@UpdateSingleCache(namespace = namespace, expiration = expiration)
	public User insertUser(
			@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
		try {
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			sqlSession.insert("user.INSERT_USER", user);
		} catch (Exception e) {
			throw new DaoException("USER_ADD_ERROR", "保存用户异常", e);
		}
		return user;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return
	 */
	@Override
	@UpdateSingleCache(namespace = namespace, expiration = expiration)
	public int updateUser(
			@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
		try {
			user.setUpdateTime(new Date());
			return sqlSession.update("user.UPDATE_USER", user);
		} catch (Exception e) {
			throw new DaoException("USER_UPDATE_ERROR", "更新用户异常", e);
		}

	}

	/** {@inheritDoc} */
	@Override
	@ReadThroughSingleCache(namespace = namespace, expiration = expiration)
	public User findUser(@ParameterValueKeyProvider String loginID) {
		try {
			return (User) sqlSession.selectOne("user.FIND_USER_BY_LOGINID",
					loginID);
		} catch (Exception e) {
			throw new DaoException("USER_FIND_ERROR", "查询用户异常", e);
		}
	}

	/** {@inheritDoc} */
	@Override
	public ResultDto<User> findUser(UserDTO userDTO) {
		try {
			return findBypagination("user.FIND_USER_BY_DTO", userDTO);
		} catch (SQLException e) {
			throw new DaoException("USER_FIND_ERROR", "查询用户异常", e);
		}
	}
}
