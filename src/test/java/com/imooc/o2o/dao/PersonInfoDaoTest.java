package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/9/26 13:54
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class PersonInfoDaoTest extends BaseTest {

	@Autowired PersonInfoDao personInfoDao;

	@Test
	public void testInsertPersonInfo(){
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName("于北川");
		personInfo.setGender("男");
		personInfo.setUserType(1);
		personInfo.setCreateTime(new Date());
		personInfo.setLastEditTime(new Date());
		personInfo.setEnableStatus(1);
		personInfoDao.insertPersonInfo(personInfo);
	}

	@Test
	public void testQueryPersonInfoById(){
		PersonInfo personInfo = personInfoDao.queryPersonInfoById(2L);
		System.out.println(personInfo);
	}
}
