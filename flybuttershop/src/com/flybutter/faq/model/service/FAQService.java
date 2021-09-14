package com.flybutter.faq.model.service;

import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.faq.model.dao.FAQDao;
import com.flybutter.faq.model.vo.FAQ;


public class FAQService {

	public ArrayList<FAQ> deliverySelectList() {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().deliverySelectList(conn);
		close(conn);
		
		System.out.println("service lsit : " + list);
		return list;
	}

	public int insertFAQ(FAQ f) {
		Connection conn = getConnection(); 
		
		int result = new FAQDao().insertFAQ(conn, f);
		
		if(result > 0) {
			commit(conn);
		
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public FAQ selectFAQ(int no) {
		Connection conn = getConnection(); 

		FAQ f = new FAQDao().selectFAQ(conn, no);
		
		close(conn);
		return f;
	}

	public FAQ selectUpdateFAQ(int no) {
		Connection conn = getConnection(); 
		
		FAQ f = new FAQDao().selectFAQ(conn, no);
		close(conn);
		return f;
	}

	public int updateFAQ(FAQ f) {
		Connection conn = getConnection();
		
		int result = new FAQDao().updateFAQ(conn, f);
		if(result > 0) {
			commit(conn);	
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteFAQ(int no) {
		Connection conn = getConnection(); 
		
		int result = new FAQDao().deleteFAQ(conn, no);
		
		if(result > 0) {
			commit(conn);
		
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<FAQ> refundSelectList() {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().refundSelectList(conn);
		close(conn);
		return list;
	}

	public ArrayList<FAQ> orderSelectList() {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().orderSelectList(conn);
		close(conn);
		return list;
	}

	public ArrayList<FAQ> sellerSelectList() {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().sellerSelectList(conn);
		close(conn);
		return list;
	}

	public ArrayList<FAQ> memberSelectList() {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().memberSelectList(conn);
		close(conn);
		return list;
	}

}
