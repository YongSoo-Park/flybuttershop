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

}
