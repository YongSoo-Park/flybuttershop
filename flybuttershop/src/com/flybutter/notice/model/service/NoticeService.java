package com.flybutter.notice.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.*;
import com.flybutter.notice.model.vo.Notice;
import com.flybutter.notice.model.dao.NoticeDao;

public class NoticeService {

	public ArrayList<Notice> entireSelectList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().entireSelectList(conn);
		close(conn);
		
		System.out.println("service lsit : " + list);
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);	
		System.out.println("result from service : " + result);
		return result;
	}

	public Notice selectNotice(int no) {
		Connection conn = getConnection();
		
		Notice n  = new NoticeDao().selectNotice(conn, no);
		System.out.println("service select n : " + n);
		close(conn);
		
		return n;
	}

	public Notice selectUpdateNotice(int no) {
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, no);
		close(conn);
		
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().updateNotice(conn, n);
		System.out.println("service");
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);	
		System.out.println("update result from service : " + result);
	
		return result;
		
	} 

	public int deleteNotice(int no) {
		Connection conn = getConnection();
		System.out.println("delete service no : " + no);
		int result = new NoticeDao().deleteNotice(conn, no);
		System.out.println("delete service result : " + result);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		System.out.println("delete service result2 : " + result);
		return result;
	}

	public ArrayList<Notice> noticeSelectList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().noticeSelectList(conn);
		close(conn);
		
		System.out.println("service lsit : " + list);
		return list;
	}

	public ArrayList<Notice> eventSelectList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().eventSelectList(conn);
		close(conn);
		
		System.out.println("service lsit : " + list);
		return list;
	}
	


}
