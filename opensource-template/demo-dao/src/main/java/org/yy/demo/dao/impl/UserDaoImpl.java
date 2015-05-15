/*
 * 文 件 名:  UserDaoImpl.java
 * 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
 * 描    述:  用户访问DAO
 * 修 改 人:  zhouliang
 * 修改时间:  2013年11月21日
 * 修改内容:  <修改内容>
 */
package org.yy.demo.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;
import org.yy.demo.dao.AbsDaoAdapter;
import org.yy.demo.dao.UserDao;
import org.yy.demo.dto.UserDTO;
import org.yy.demo.model.User;
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
@Repository("userDAO")
public class UserDaoImpl extends AbsDaoAdapter implements UserDao {

	/** {@inheritDoc} */
	@Override
	@UpdateSingleCache(namespace = namespace, expiration = expiration)
	public User insertUser(
			@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		sqlSession.insert("user.INSERT_USER", user);
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
		user.setUpdateTime(new Date());
		return sqlSession.update("user.UPDATE_USER", user);
	}

	/** {@inheritDoc} */
	@Override
	@ReadThroughSingleCache(namespace = namespace, expiration = expiration)
	public User findUser(@ParameterValueKeyProvider String loginID) {
		return (User) sqlSession
				.selectOne("user.FIND_USER_BY_LOGINID", loginID);

	}

	/** {@inheritDoc} */
	@Override
	public ResultDto<User> findUser(UserDTO userDTO) {
		return findBypagination("user.FIND_USER_BY_DTO", userDTO);
	}
}
