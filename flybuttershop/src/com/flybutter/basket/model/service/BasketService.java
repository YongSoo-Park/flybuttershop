package com.flybutter.basket.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.basket.model.vo.Basket;

public class BasketService {

	public ArrayList<Basket> selectBasketList() {
		Connection conn = getConnection();
		
		ArrayList<Basket> list = new BasketDao().selectBasketList(conn);
		close(conn);
		
		return list;
	}

}
