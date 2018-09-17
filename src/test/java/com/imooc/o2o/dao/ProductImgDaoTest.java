package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/8/26 21:19
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductImg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductImgDaoTest extends BaseTest {

	@Autowired
	private ProductImgDao productImgDao;

	@Test
	public void testBatchInsertProductImg(){
		ProductImg p1 = new ProductImg();
		ProductImg p2 = new ProductImg();

		p1.setImgAddr("p1");
		p1.setImgDesc("p1");
		p1.setPriority(1);
		p1.setProductId(1L);
		p1.setCreateTime(new Date());

		p2.setImgAddr("p2");
		p2.setImgDesc("p2");
		p2.setPriority(42);
		p2.setProductId(1L);
		p2.setCreateTime(new Date());

		List<ProductImg> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);

		productImgDao.batchInsertProductImg(list);
	}

	@Test
	public void testDeleteProductImgByProductId(){
		long productId = 2L;
		productImgDao.deleteProductImgByProductId(productId);
	}

	@Test
	public void testQueryProductImgList(){
		long productId = 1L;
		List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);
	}

}
