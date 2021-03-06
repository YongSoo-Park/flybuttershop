package com.flybutter.consumerMyPage.model.dao;


import static com.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;
import com.flybutter.wishlist.model.vo.Wishlist;

public class MypageDao {
	
	
	
	private Properties prop = new Properties();
	
	public MypageDao() {
		String fileName = BasketDao.class.getResource("/sql/consumerMypage/mypage-query.properties").getPath();
		System.out.println("fileName : " + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	public int selectSumPrice(Connection conn, int userNo) {
		
		int sumPrice = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSumPrice");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sumPrice = rset.getInt("SUM_PRICE");
			
						
			}

			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  selectSumPrice : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return sumPrice;

	}





	public Member selectMember(Connection conn, int userNo) {
		
	Member m =  new Member();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m.setUserId(rset.getString("MEM_USER_ID"));
				m.setUserPwd(rset.getString("MEM_USER_PWD"));
				m.setUserName(rset.getString("MEM_USER_NAME"));
				m.setPhone(rset.getString("MEM_PHONE"));
				m.setEmail(rset.getString("MEM_EMAIL"));
				m.setAddress(rset.getString("MEM_ADDRESS"));
				System.out.println(m);		
			}

			
		} catch (SQLException e) {
			System.out.println("MEMBER 테이블  selectMember : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;

	}





	public int updateMember(Connection conn, Member m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getUserPwd());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setInt(5, m.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("MEMBER 테이블  updateMember : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;

	
	}





	public int orderListCount(Connection conn, int userNo) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = rset.getInt("COUNT(*)");
						
			}

			
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  orderListCount : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;

	}





	public ArrayList<OrderList> selectOrderList(Connection conn, PageInfo pi, int userNo) {
		ArrayList<OrderList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new OrderList(rset.getInt("PUR_NO"),
									rset.getString("PUR_INFO"),
									rset.getDate("PUR_DATE")
									
						));
			}
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  orderList : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}





	public String getpImage(Connection conn, String pNo) {
		String pImage = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getpImage");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pImage = rset.getString("PIMAGE_ORIGIN");
			
						
			}

			
		} catch (SQLException e) {
			System.out.println("PRODUCT 테이블  getpImage : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return pImage;
	}





	public String getpName(Connection conn, String pNo) {
		String pName = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getpName");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pName = rset.getString("PNAME");
			
						
			}

			
		} catch (SQLException e) {
			System.out.println("PRODUCT 테이블  getpImage : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return pName;
	}





	public OrderList selectOrderDetail(Connection conn, int purNo) {
		OrderList list = new OrderList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOrderDetail");
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, purNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.setPurNo(purNo);				
				list.setPurDate(rset.getDate("PUR_DATE"));
				list.setOrderInfo(rset.getString("PUR_INFO"));
				list.setDelNo(rset.getInt("DEL_NO"));
				list.setPurType(rset.getInt("PUR_TYPE"));
				list.setPurPrice(rset.getInt("PUR_PRICE"));
			}
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  selectOrderDetail : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}





	public int couponCount(Connection conn, int userNo) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("couponCount");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = rset.getInt("COUNT(*)");
						
			}

			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  couponCount : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}





	public Coupon checkCoupon(Connection conn, int cpNum) {
		Coupon c = new Coupon();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkCoupon");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, cpNum);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c.setCp_no(cpNum);
				c.setCp_name(rset.getString("CP_NAME"));
				c.setCp_date(rset.getDate("CP_DATE"));
				c.setCp_discount(rset.getInt("CP_DISCOUNT"));
				c.setMinPrice(rset.getInt("MINPRICE"));
				c.setCp_count(rset.getInt("CP_COUNT"));
						
			}

			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  checkCoupon : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}





	public int addCoupon(Connection conn, int cpNum, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("addCoupon");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, cpNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  addCoupon : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;

	}





	public ArrayList<Coupon> couponDetail(Connection conn, int userNo) {
		ArrayList<Coupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("couponDetail");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Coupon(rset.getInt("CP_NO"),
									rset.getInt("CP_COUNT"),
									rset.getInt("CP_DISCOUNT"),
									rset.getDate("CP_DATE"),
									rset.getString("CP_NAME"),
									rset.getInt("MINPRICE")
									
						));
			}
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  couponDetail : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;	
	}





	public ArrayList<Money> moneyDetail(Connection conn, int userNo) {
		ArrayList<Money> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("moneyDetail");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Money(rset.getInt("USER_NO"),
									rset.getInt("MONEY"),
									rset.getDate("MONEY_DATE"),
									rset.getInt("M_NO")
									
						));
			}
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  couponDetail : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;	
	}





	public int addWishList(Connection conn, String pCode, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("addWishList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, pCode);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("WISHLIST 테이블  addWishList : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;

	}





	public int checkWish(Connection conn, String pCode, int userNo) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkWish");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, pCode);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = rset.getInt("COUNT(*)");
						
			}

			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  checkWish : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}





	public int cancelOrder(Connection conn, OrderList list) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("cancelOrder");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, list.getOrderInfo());
			pstmt.setInt(2, list.getPurNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  cancelOrder : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public int updateSumPrice(Connection conn, int userNo, int purPrice) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateSumPrice");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, purPrice);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  updateSumPrice : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public int updateCoupon(Connection conn, int purNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateCoupon");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, purNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  updateCoupon : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public int updateMoney(Connection conn, int userNo, double d, int purNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateMoney");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, purNo);
			pstmt.setInt(2, userNo);
			pstmt.setDouble(3, d);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("MONEY 테이블  updateMoney : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public int updateAmount(Connection conn, String pCode, int amount) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateAmount");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, amount);
			pstmt.setString(2, pCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("PRODUCT 테이블  updateAmount : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public int getWishlistCount(Connection conn, int userNo) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getWishlistCount");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = rset.getInt("COUNT(*)");
						
			}

			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  checkWish : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}





	public ArrayList<Wishlist> selectWishlist(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Wishlist> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWishlist");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Wishlist(rset.getInt("WISH_NO"),
									rset.getString("PCODE"),
									rset.getString("PIMAGE_ORIGIN"),
									rset.getString("PNAME"),
									rset.getString("SCORE_AVG"),
									rset.getInt("PRICE")
									
						));
			}
		} catch (SQLException e) {
			System.out.println("WISHLIST 테이블  selectWishlist : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}





	public int deleteWish(Connection conn, int wNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("deleteWish");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, wNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("WISHLIST 테이블  deleteWish : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public String getPhone(Connection conn, int userNo) {
		String phone = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getPhone");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				phone = rset.getString("MEM_PHONE");
						
			}

			
		} catch (SQLException e) {
			System.out.println("MEMBER 테이블  getPhone : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return phone;
	}





	public int changeMember(Connection conn, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("changeMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  changeMember : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}





	public String checkUserCel(Connection conn, int userNo) {
		String result = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkUserCel");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString("USER_CEL");	
			}

			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  checkUserCel : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}





	public Review updateReviewForm(Connection conn, int reNo) {
		Review r = new Review();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("updateReviewForm");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, reNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r.setRe_no(reNo);
				r.setRe_title(rset.getString("RE_TITLE"));
				r.setRe_content(rset.getString("RE_CONTENT"));
				r.setScore(rset.getInt("SCORE"));
				r.setpName(rset.getString("PNAME"));
						
			}

			
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블  updateReviewForm : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}





	public int moneyCount(Connection conn, int userNo) {
		int money = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("moneyCount");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				money = rset.getInt("MONEY");
						
			}

			
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블  moneyCount : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return money;
	}

}
