package org.yy.demo.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.yy.framework.base.dao.AbstractMyBatisDao;

/**
 * 适配DAO以便注入sqlSession
 * 
 * @author zhouliang
 * @version [1.0, 2013年11月21日]
 * @since [app-user/1.0]
 */
@Repository
public abstract class AbsDaoAdapter extends AbstractMyBatisDao {

	@Override
	@Resource(name = "sqlSession")
	public void setSqlSession(SqlSession sqlSession) {
		super.setSqlSession(sqlSession);
	}
}
