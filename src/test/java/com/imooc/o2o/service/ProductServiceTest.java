package com.imooc.o2o.service;
/*
 * Created by wxn
 * 2018/8/27 0:46
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ProductStateEnum;
import com.imooc.o2o.exception.ProductOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceTest extends BaseTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testAddProduct() throws ProductOperationException, FileNotFoundException {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(2L);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(2L);
		product.setShop(shop);
		product.setProductCategory(productCategory);
		product.setProductName("测试商品2");
		product.setProductDesc("测试商品2");
		product.setPriority(24);
		product.setCreateTime(new Date());
		product.setLastEditTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());

		//创建缩略图文件流
		File thumbnailFile = new File("C:/Users/WuXinnan/Pictures/Saved Pictures/52.png");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);

		//创建两个商品详情图文件流 并添加到详情图列表中
		File productImg1 = new File("C:\\Users\\WuXinnan\\Pictures\\Saved Pictures\\006HJgYYgy1fo3p3zqlzzg3064063tz4.gif");
		File productImg2 = new File("C:\\Users\\WuXinnan\\Pictures\\Saved Pictures\\timg.jpg");

		InputStream is1 = new FileInputStream(productImg1);
		InputStream is2 = new FileInputStream(productImg2);

		List<ImageHolder>imageHolderList = new ArrayList<>();
		imageHolderList.add(new ImageHolder(productImg1.getName(),is1));
		imageHolderList.add(new ImageHolder(productImg2.getName(),is2));

		ProductExecution pe = productService.addProduct(product,thumbnail,imageHolderList);
		System.out.println(pe.getProduct().getProductName());
	}

	@Test
	public void testModifyProduct() throws FileNotFoundException {
		Product product = new Product();
		Shop shop = new Shop();
		ProductCategory pc = new ProductCategory();

		shop.setShopId(2L);
		pc.setProductCategoryId(2L);
		product.setProductId(6L);

		product.setShop(shop);
		product.setProductCategory(pc);

		product.setProductName("珍珠奶茶");
		product.setProductDesc("珍珠奶茶");

		File thumbnailFile = new File("C:\\Users\\WuXinnan\\Pictures\\Saved Pictures\\006HJgYYgy1fo3p3tt62kg305606jncw.gif");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);

		File productImg1 = new File("C:\\Users\\WuXinnan\\Pictures\\Saved Pictures\\006HJgYYgy1fo3p3tt62kg305606jncw.gif");
		File productImg2 = new File("C:\\Users\\WuXinnan\\Pictures\\Saved Pictures\\006HJgYYgy1fo3p3tt62kg305606jncw.gif");

		InputStream is1 = new FileInputStream(productImg1);
		InputStream is2 = new FileInputStream(productImg2);

		List<ImageHolder>productImgList = new ArrayList<>();
		productImgList.add(new ImageHolder(productImg1.getName(),is1));
		productImgList.add(new ImageHolder(productImg2.getName(),is2));

		ProductExecution pe = productService.modifyProduct(product,thumbnail,productImgList);


	}

}
