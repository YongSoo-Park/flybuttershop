package com.flybutter.consumerMyPage.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.consumerMyPage.model.dao.MypageDao;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;
import com.flybutter.wishlist.model.vo.Wishlist;



public class MypageService {

	
	public int selectSumPrice(int userNo) {
		
		Connection conn = getConnection();
		
		int sumPrice = new MypageDao().selectSumPrice(conn, userNo);
		close(conn);
		
		return sumPrice;
		

	}

	public Member selectMember(int userNo) {
		
		Connection conn = getConnection();
		
		Member m = new MypageDao().selectMember(conn, userNo);
		close(conn);
		
		return m;
	}

	public int updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MypageDao().updateMember(conn, m);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
			
		}
		
		
		return result;
	}

	public int getMyOrderListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MypageDao().orderListCount(conn, userNo);
		
		close(conn);
		
		
		return listCount;
	
	}

	public ArrayList<OrderList> selectOrderList(PageInfo pi, int userNo) {
		Connection conn = getConnection();
		
		ArrayList<OrderList> list = new MypageDao().selectOrderList(conn, pi, userNo);
		
		close(conn);
		return list;
	}

	public String getpImage(String pNo) {
		Connection conn = getConnection();
		
		String pImage = new MypageDao().getpImage(conn, pNo);
		
		close(conn);
		return pImage;
	}

	public String getpName(String pNo) {
		Connection conn = getConnection();
		
		String pName = new MypageDao().getpName(conn, pNo);
		
		close(conn);
		return pName;
	}

	public OrderList selectOrderDetail(int purNo) {
		Connection conn = getConnection();
		
		OrderList list = new MypageDao().selectOrderDetail(conn, purNo);
		
		close(conn);
		return list;
	}

	public int couponCount(int userNo) {

		Connection conn = getConnection();
		
		int count = new MypageDao().couponCount(conn, userNo);
		
		close(conn);
		
		
		return count;
	
	}

	public Coupon checkCoupon(int cpNum) {
		Connection conn = getConnection();
		
		Coupon c = new MypageDao().checkCoupon(conn, cpNum);
		
		
		close(conn);
		return c;
	}

	public int addCoupon(int cpNum, int userNo) {
		Connection conn = getConnection();
		
		int result = new MypageDao().addCoupon(conn, cpNum, userNo);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
			
		}
		
		
		return result;
	}

	public ArrayList<Coupon> couponDetail(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Coupon> list = new MypageDao().couponDetail(conn, userNo);
		
		close(conn);
		return list;
	}

	public ArrayList<Money> moneyDetail(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Money> list = new MypageDao().moneyDetail(conn, userNo);
		
		close(conn);
		return list;
	}

	public int addWishList(int userNo, String pCode) {
		Connection conn = getConnection();
		
		int result = new MypageDao().addWishList(conn, pCode, userNo);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
			
		}
		
		
		return result;
	}

	public int checkWish(int userNo, String pCode) {
		Connection conn = getConnection();
		
		int result = new MypageDao().checkWish(conn, pCode, userNo);
		
		
		close(conn);
		
		return result;
	}

	public int cancelOrder(OrderList list) {
		Connection conn = getConnection();
		
		int result = new MypageDao().cancelOrder(conn, list);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
			
		}
		
		
		return result;
	}

	public int refundOrder(OrderList list) {
		Connection conn = getConnection();
		
		int result = new MypageDao().cancelOrder(conn, list);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
			
		}
		
		
		return result;
	}

	public int updateSumPrice(int userNo, int purPrice) {
		Connection conn = getConnection();
		
		int result = new MypageDao().updateSumPrice(conn, userNo, purPrice);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		
		
		return result;
	}

	public int updateCoupon(int purNo) {
		Connection conn = getConnection();
		
		int result = new MypageDao().updateCoupon(conn, purNo);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		
		
		return result;
	}

	public int updateMoney(int userNo, double d, int purNo) {
		Connection conn = getConnection();
		
		int result = new MypageDao().updateMoney(conn, userNo, d, purNo);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		
		
		return result;
	}

	public int updateAmount(String pCode, int amount) {
		Connection conn = getConnection();
		
		int result = new MypageDao().updateAmount(conn, pCode, amount);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		
		
		return result;
	}

	public int getWishlistCount(int userNo) {
		Connection conn = getConnection();
		
		int listCount = new MypageDao().getWishlistCount(conn, userNo);
		
		close(conn);
		
		
		return listCount;
	}

	public ArrayList<Wishlist> selectWishlist(PageInfo pi, int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Wishlist> list = new MypageDao().selectWishlist(conn, pi, userNo);
		
		close(conn);
		return list;
	}

	public int deleteWish(int wNo) {
		Connection conn = getConnection();
		
		int result = new MypageDao().deleteWish(conn, wNo);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		
		
		return result;
	}

	public String getPhone(int userNo) {
		Connection conn = getConnection();
		
		String phone = new MypageDao().getPhone(conn, userNo);
		
		close(conn);
		
		return phone;
	}

	public int changeMember(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new MypageDao().changeMember(conn, userNo);
		
		
		if(result == 1) {
			commit(conn);
			close(conn);
		}else {
			rollback(conn);
			close(conn);
		}
		
		
		return result;
	}

	public String checkUserCel(int userNo) {
		Connection conn = getConnection();
		
		String result = new MypageDao().checkUserCel(conn, userNo);
		
		close(conn);
		
		return result;
	
	}

	public Review updateReviewForm(int reNo) {
		
		Connection conn = getConnection();
		
		Review r = new MypageDao().updateReviewForm(conn, reNo);
		
		close(conn);
		
		return r;
	}

	public int moneyCount(int userNo) {

		Connection conn = getConnection();
		
		int m = new MypageDao().moneyCount(conn, userNo);
		
		close(conn);
		
		return m;
	}

}
