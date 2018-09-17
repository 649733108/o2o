package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/8/24 10:55
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCategoryDaoTest extends BaseTest {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Test
	public void testQueryProductCategoryListByShopId(){
		long shopId = 2L;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryListByShopId(shopId);
	}

	@Test
	public void testBatchInsertProductCategory(){
		ProductCategory p1 = new ProductCategory();
		ProductCategory p2 = new ProductCategory();

		p1.setCreateTime(new Date());
		p1.setPriority(15);
		p1.setProductCategoryName("C1");
		p1.setShopId(2L);

		p2.setCreateTime(new Date());
		p2.setPriority(111);
		p2.setProductCategoryName("C2");
		p2.setShopId(2L);

		List<ProductCategory> list = new ArrayList<>();

		list.add(p1);
		list.add(p2);

		productCategoryDao.batchInsertProductCategory(list);
	}

	@Test
	public void testDeleteProductCategory(){
		productCategoryDao.deleteProductCategory(13,2);
	}


}
