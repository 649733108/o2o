package com.imooc.o2o.service;
/*
 * Created by wxn
 * 2018/8/21 12:06
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {

	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("华科1");
		shop.setShopDesc("华科1");
		shop.setShopAddr("华科1");
		shop.setPhone("华科1");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		shop.setPriority(1);

		File shopImg = new File("C:/Users/WuXinnan/Pictures/Saved Pictures/52.png");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
		ShopExecution se = shopService.addShop(shop, imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}

	@Test
	public void testModifyShop() throws FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(2L);
		shop.setShopName("我好饿啊");
		File shopImg = new File("C:\\Users\\WuXinnan\\Pictures\\Saved Pictures\\006HJgYYgy1fo3p3zqlzzg3064063tz4.gif");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
		shopService.modifyShop(shop,imageHolder);
	}

	@Test
	public void testGetShopList(){
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
//		shopCondition.setEnableStatus(1);
		shopCondition.setShopName("");

		ShopExecution shopExecution = shopService.getShopList(shopCondition, 5, 3);

		System.out.println("店铺总数为：" + shopExecution.getCount());
		System.out.println("店铺列表数为：" + shopExecution.getShopList().size());
	}






}
