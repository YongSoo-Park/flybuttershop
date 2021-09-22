package com.flybutter.purchase.model.service;
 
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.consumer.model.dao.ConsumerDao;
import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;
import com.flybutter.purchase.model.dao.PurchaseDao;
import com.flybutter.purchase.model.vo.Purchase;

public class PurchaseService {

	public Member selectMember(int no) {
		Connection conn = getConnection();
		
		Member m = new PurchaseDao().selectMember(conn, no); 
		close(conn);
		
		return m;
	}

	public ArrayList<Coupon> selectCoupon(int no, int use) {
		Connection conn = getConnection();
		
		ArrayList<Coupon> list = new PurchaseDao().selectCoupon(conn, no, use); 
		close(conn);
		
		return list;
	}

	public Consumer selectMoney(int no) {
		Connection conn = getConnection();
		
		Consumer c = new PurchaseDao().selectMoney(conn, no); 
		close(conn);
		
		return c;
	}

	public int updateCoupon(int no, String cName, int use) {
		Connection conn = getConnection();
		
		int result = new PurchaseDao().updateCoupon(conn, no, cName, use);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int insertBankPur(Purchase bankPur, int no) {
		Connection conn = getConnection();
		
		int result = new PurchaseDao().insertBankPur(conn, bankPur, no);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int insertCardPur(Purchase cardPur, int no) {
		Connection conn = getConnection();
		
		int result = new PurchaseDao().insertCardPur(conn, cardPur, no);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Purchase selectPurNo (int no) {
		Connection conn = getConnection();
		
		Purchase purNo = new PurchaseDao().selectPurNo(conn, no); 
		close(conn);
		
		return purNo;
	}

	public int updateCMoney(int no, int resultMoney) {
		Connection conn = getConnection();
		
		int result = new PurchaseDao().updateCMoney(conn, no, resultMoney);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	

}
