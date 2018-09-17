package com.imooc.o2o.service;
/*
 * Created by wxn
 * 2018/8/19 17:49
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;

	@Test
	public void testGetAreaList(){
		List<Area> areaList = areaService.getAreaList();
		for (Area area :areaList){
			System.out.println(area.getAreaId() + " : " + area.getAreaName());
		}
	}
}
