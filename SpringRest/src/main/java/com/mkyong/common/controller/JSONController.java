package com.mkyong.common.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mkyong.common.model.Shop;

@RestController
@RequestMapping("/brands")
public class JSONController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable("name") String name) {
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return shop;
	}
}