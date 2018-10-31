package com.imooc.o2o.service;
/*
 * Created by wxn
 * 2018/10/31 4:15
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.LocalAuthExecution;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalAuthServiceTest extends BaseTest {
	@Autowired
	private LocalAuthService localAuthService;

	@Test
	public void testBindLocalAuth(){
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String userName = "testusername";
		String password = "testpassword";
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUserName(userName);
		localAuth.setPassword(password);

		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);

		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());

		System.out.println(localAuth.getPersonInfo().getName() + " : " + localAuth.getPassword());
	}

	@Test
	public void testModifyLocalAuth(){
		long userId = 1;
		String username = "testusername";
		String password = "testpassword";
		String newPassword = "newPassword";
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId,username,password,newPassword);

	}

}
