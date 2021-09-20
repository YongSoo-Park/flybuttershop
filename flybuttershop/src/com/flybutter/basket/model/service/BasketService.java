package com.flybutter.basket.model.service;

 
import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;
import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.consumer.model.dao.ConsumerDao;
import com.flybutter.product.model.dao.ProductDao;
import com.flybutter.product.model.vo.Product;

public class BasketService {

	public ArrayList<Basket> selectBasketList(int no) {
		Connection conn = getConnection();
		
		ArrayList<Basket> list = new BasketDao().selectBasketList(conn, no);
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

	public int deleteBasket(String ck) {
		Connection conn = getConnection();
		System.out.println("service");
		int result = new BasketDao().deleteBasket(conn, ck);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<Basket> selectCheck(int no, String pCode) {
		Connection conn = getConnection();
		
		ArrayList<Basket> list = new BasketDao().selectCheck(conn, no,  pCode);
		close(conn);
		
		return list;
	}

	public int updateAmount(int plusAmount, String pCode) {
		Connection conn = getConnection();
		
		int result = new BasketDao().updateAmount(conn, plusAmount, pCode);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Basket selectInBasket(String pCode, int no) {
		Connection conn = getConnection();
		
		Basket b = new BasketDao().selectInBasket(conn, pCode, no);
		
		close(conn);
		
		return b;
	}

	public int updatePrice(int newPrice, String pCode) {
		Connection conn = getConnection();
		
		int result = new BasketDao().updatePrice(conn, newPrice, pCode);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
