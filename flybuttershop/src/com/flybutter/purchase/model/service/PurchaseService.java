package com.flybutter.purchase.model.service;
 
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;
import com.flybutter.purchase.model.dao.PurchaseDao;
import com.flybutter.purchase.model.vo.Purchase;

public class PurchaseService {

	public int insertPurInfo(Purchase p) {
		Connection conn = getConnection();
		
		int result = new PurchaseDao().insertPurInfo(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Member selectMember(int no) {
		Connection conn = getConnection();
		
		Member m = new PurchaseDao().selectMember(conn, no); 
		close(conn);
		
		return m;
	}

	public ArrayList<Coupon> selectCoupon(int no) {
		Connection conn = getConnection();
		
		ArrayList<Coupon> list = new PurchaseDao().selectCoupon(conn, no); 
		close(conn);
		
		return list;
	}

	public Consumer selectMoney(int no) {
		Connection conn = getConnection();
		
		Consumer c = new PurchaseDao().selectMoney(conn, no); 
		close(conn);
		
		return c;
	}

	

}
