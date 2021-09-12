package com.flybutter.basket.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;
import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.product.model.vo.*;

public class BasketService {

	public ArrayList<Basket> selectBasketList() {
		Connection conn = getConnection();
		
		ArrayList<Basket> list = new BasketDao().selectBasketList(conn);
		close(conn);
		
		return list;
	}

	public int insertBasket(Basket b) {
		Connection conn = getConnection();
		
		int result = new BasketDao().insertBasket(conn, b);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<Product> selectBProduct(String pCode){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new BasketDao().selectBProduct(conn, pCode);
		close(conn);
		
		return pList;
	}

	public int deleteBasket(String ck) {
		Connection conn = getConnection();
		System.out.println("service");
		int result = new BasketDao().deleteBasket(conn, ck);
		
		
		
		close(conn);
		return result;
	}

}
