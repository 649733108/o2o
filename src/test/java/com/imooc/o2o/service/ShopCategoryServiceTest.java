package com.imooc.o2o.service;
/*
 * Created by wxn
 * 2018/8/19 17:49
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryServiceTest extends BaseTest {

	@Autowired
	private ShopCategoryService shopCategoryService;

	@Test
	public void testGetShopCategoryList(){
		List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
		for (ShopCategory shopCategory :shopCategoryList){
			System.out.println(shopCategory.getShopCategoryId() + " : " + shopCategory.getShopCategoryName());
		}
	}
}
