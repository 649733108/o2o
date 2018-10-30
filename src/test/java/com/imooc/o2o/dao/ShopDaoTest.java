package com.imooc.o2o.dao;
/*
 * Created by wxn
 * 2018/8/20 16:48
 */


import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ShopDaoTest extends BaseTest {

	@Autowired
	private ShopDao shopDao;

	@Test
	@Ignore
	public void testInsertShop() {
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
		shop.setShopName("测试店铺1");
		shop.setShopDesc("测试1");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		shop.setPriority(1);

		int effectedNum = shopDao.insertShop(shop);
		System.out.println(effectedNum);
	}

	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(2L);
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺1");
		shop.setShopDesc("测试1");
		shop.setShopAddr("测试地址");
		shop.setPhone("测试电话");
		shop.setShopImg("测试图片");
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核通过");
		shop.setPriority(100);

		int effectedNum = shopDao.updateShop(shop);
		System.out.println(effectedNum);
	}

	@Test
	public void testQueryByShopId() {
		long shopId = 12L;
		Shop shop = shopDao.queryByShopId(shopId);
	}


	@Test
	public void testQueryShopList() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
//		shopCondition.setEnableStatus(1);
//		shopCondition.setShopName("华");
		ShopCategory shopCategory = new ShopCategory();
		ShopCategory parent = new ShopCategory();
		parent.setShopCategoryId(5L);
		shopCategory.setParent(parent);
		shopCondition.setShopCategory(shopCategory);


		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		for (Shop shop : shopList) {
			System.out.println(shop.getShopId() + " : " + shop.getShopName()
					+ "  priority : " + shop.getPriority());
		}

		System.out.println(shopDao.queryShopCount(shopCondition));
	}


}
