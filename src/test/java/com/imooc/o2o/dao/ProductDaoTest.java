package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/8/26 21:09
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ProductDaoTest extends BaseTest {

	@Autowired
	private ProductDao productDao;

	@Test
	public void testInsertProduct(){
		Product product = new Product();

		Shop shop = new Shop();
		shop.setShopId(2L);

		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(1L);

		product.setProductName("product1");
		product.setEnableStatus(1);
		product.setImgAddr("addr");
		product.setCreateTime(new Date());
		product.setNormalPrice("1024");
		product.setPromotionPrice("998");
		product.setLastEditTime(new Date());
		product.setProductDesc("very good");
		product.setShop(shop);
		product.setProductCategory(productCategory);
		product.setPriority(100);

		productDao.insertProduct(product);

	}

	@Test
	public void testQueryProductList(){
		Product productCondition = new Product();

		Shop shop = new Shop();
		shop.setShopId(2L);

		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(1L);

		productCondition.setEnableStatus(1);
		productCondition.setShop(shop);
		productCondition.setProductCategory(productCategory);
		productCondition.setProductName("1");

		List<Product> productList = productDao.queryProductList(productCondition,0,5);
		System.out.println("num : " + productDao.queryProductCount(productCondition));
		for (Product product : productList) {
			System.out.println("productName : " + product.getProductName());
		}
	}
}
