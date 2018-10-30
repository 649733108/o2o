package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/9/19 12:24
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HeadLineDaoTest extends BaseTest {
	@Autowired
	private HeadLineDao headLineDao;

	@Test
	public void testQueryHeadLine(){
		HeadLine headLineCondition = new HeadLine();
		headLineCondition.setEnableStatus(1);
		List<HeadLine>headLineList = headLineDao.queryHeadLine(headLineCondition);
		System.out.println(headLineList.size());
	}
}
