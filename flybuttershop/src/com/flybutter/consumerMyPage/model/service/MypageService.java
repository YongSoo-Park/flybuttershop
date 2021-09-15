package com.flybutter.consumerMyPage.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.flybutter.consumerMyPage.model.dao.MypageDao;
import com.flybutter.dummy.model.vo.Member;


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

}
