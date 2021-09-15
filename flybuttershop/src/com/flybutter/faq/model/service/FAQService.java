package com.flybutter.faq.model.service;

import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.faq.model.dao.FAQDao;
import com.flybutter.faq.model.vo.FAQ;
import com.flybutter.faq.model.vo.PageInfo;



public class FAQService {

	public ArrayList<FAQ> deliverySelectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().deliverySelectList(conn, pi);
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

	public ArrayList<FAQ> refundSelectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().refundSelectList(conn, pi);
		close(conn);
		return list;
	}

	public ArrayList<FAQ> orderSelectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().orderSelectList(conn, pi);
		close(conn);
		return list;
	}

	public ArrayList<FAQ> sellerSelectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().sellerSelectList(conn, pi);
		close(conn);
		return list;
	}

	public ArrayList<FAQ> memberSelectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().memberSelectList(conn, pi);
		close(conn);
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new FAQDao().getListCount(conn);
		close(conn);
		return listCount;
	}

}
