package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/10/31 3:35
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LocalAuthDaoTest extends BaseTest {

	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testusername";
	private static final String password = "testpassword";

	@Test
	public void testInsertLocalAuth() throws Exception{
		//新增一条平台账号信息
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUserName(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
	}

	@Test
	public void testQueryLocalByUserNameAndPwd(){
		LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username,password);
	}

	@Test
	public void testQueryLocalByUserId(){
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
	}

	@Test
	public void testUpdateLocalAuth(){
		int effectedNum = localAuthDao.updateLocalAuth(1L,username,password,"newPassword",new Date());
	}

}
