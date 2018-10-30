package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/8/21 16:38
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory(){
		ShopCategory shopCategoryCondition = new ShopCategory();
		shopCategoryCondition.setParent(new ShopCategory());
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println(shopCategoryList.size());
	}
}
