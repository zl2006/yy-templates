package org.yy.demo.dao;


import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.yy.demo.dto.UserDTO;
import org.yy.demo.model.User;
import org.yy.framework.base.test.AbstractSpringTest;
import org.yy.framework.basedata.query.Pagination;

public class UserDAOTest extends AbstractSpringTest {
    
    @Resource(name = "userDAO")
    private UserDao userDao;
   
    @Test
    public void testInsertUser(){
        /*
        User user = new User();
        user.setLoginID("zl2006");
        user.setName("zhouliang");
        user.setPassword("D3349D3349");
        user.setEmail("zl2006@gmail.com");
        user.setCreatePerson(1);
        user.setUpdatePerson(1);
        user.setExprieDate(new Date());
        user.setBirthday(new Date());
        user.setStatus(1);
        
        user = userDao.insertUser(user);
        System.out.println( user );*/
    }
    
    @Test
    public void testFindUserByLoginID()
        throws java.sql.SQLException {
       User user  =  userDao.findUser("18665867002");
       Assert.assertEquals("周亮", user.getName());
    }
    
    @Test
    public void testUpdateUser()
        throws java.sql.SQLException {
        userDao.updateUser(new User());
    }
    
    @Test
    public void testFindUser()
        throws java.sql.SQLException {
        
        UserDTO d = new UserDTO();
        userDao.findUser(d);
        d.setPagination(new Pagination(50, 3));
        userDao.findUser(d);
    }
    
}
