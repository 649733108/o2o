package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/9/26 13:54
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.WechatAuth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class WechatAuthDaoTest extends BaseTest {

	@Autowired
	PersonInfoDao personInfoDao;

	@Autowired
	WechatAuthDao wechatAuthDao;


	@Test
	public void testInsertWechatAuth(){
		WechatAuth wechatAuth = new WechatAuth();
		wechatAuth.setPersonInfo(personInfoDao.queryPersonInfoById(2L));
		wechatAuth.setOpenId("afsdfasdfa");
		wechatAuth.setCreateTime(new Date());
		wechatAuthDao.insertWechatAuth(wechatAuth);
		System.out.println(wechatAuth.getWechatAuthId());
	}

	@Test
	public void testQueryWechatInfoByOpenId(){
		WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("afsdfasdfa");
		System.out.println(wechatAuth);
	}
}
