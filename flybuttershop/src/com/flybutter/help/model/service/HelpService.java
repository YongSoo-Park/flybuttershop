package com.flybutter.help.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;


import com.flybutter.help.model.dao.HelpDao;
import com.flybutter.help.model.vo.Help;
import com.flybutter.help.model.vo.HelpReply;
import com.flybutter.help.model.vo.PageInfo;




public class HelpService {

	

	public Help selectHelp(int no) {
		Connection conn = getConnection();
		Help h = new HelpDao().selectHelp(conn, no);
		close(conn);
		System.out.println("select Help h : " + h);
		return h;
	}

	public int insertHelp(Help h) {
		Connection conn = getConnection();
		System.out.println("userNO service1 : " + h.getUser_No());
		int result = new HelpDao().insertHelp(conn, h);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);	
		System.out.println("userNO service2 : " + h.getUser_No());
		return result;
	}

	public Help selectUpdateHelp(int no) {
		Connection conn = getConnection();
		
		Help h = new HelpDao().selectHelp(conn, no);
		close(conn);
		
		return h;
	}

	public int updateHelp(Help h) {
		Connection conn = getConnection();
		int result = new HelpDao().updateHelp(conn, h);
		System.out.println("service");
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);	
	
		return result;
		
	}

	public int deleteHelp(int no) {
		Connection conn = getConnection();
		
		int result = new HelpDao().deleteHelp(conn, no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new HelpDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public HelpReply selectReplyFormHelp(int no) {
		Connection conn = getConnection();
		
		HelpReply hr = new HelpDao().selectReplyFormHelp(conn, no);
		close(conn);
		
		return hr;
	}

	

	public int insertReplyHelp(HelpReply hr) {
		Connection conn = getConnection();
		int result = new HelpDao().insertReplyHelp(conn, hr);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);	
		return result;
	}

	public int changeStatusHelp(Help h) {
		Connection conn = getConnection();
		int result = new HelpDao().changeStatusHelp(conn, h);
		System.out.println("service");
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);	
	
		return result;
	}

	public HelpReply selectReplyHelp(int no) {
		Connection conn = getConnection();
		HelpReply hr = new HelpDao().selectReplyHelp(conn, no);
		close(conn);
		System.out.println("selectReplyHelp hr : " + hr);
		return hr;
	}

	public int updateReplyHelp(HelpReply hr) {
		Connection conn = getConnection();
		int result = new HelpDao().updateReplyHelp(conn, hr);
		System.out.println("service");
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);	
	
		return result;
	}

	public int deleteReplyHelp(int no) {
		Connection conn = getConnection();
		System.out.println("delete reply no in service : " + no);
		int result = new HelpDao().deleteReplyHelp(conn, no);
		System.out.println("delete reply result in service : " + result);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		System.out.println("delete reply result in service 22222 : " + result);
		return result;
	}

	public int changeStatusDeleteHelp(Help h) {
		Connection conn = getConnection();
		int result = new HelpDao().changeStatusDeleteHelp(conn, h);
		System.out.println("service");
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);	
	
		return result;
	}

	public ArrayList<Help> helpSelectList(PageInfo pi, int userNo) {
		Connection conn = getConnection();
		ArrayList<Help> list = new HelpDao().helpSelectList(conn, pi, userNo);
		close(conn);

		return list;
	}

	public ArrayList<Help> helpSelectAllList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Help> list = new HelpDao().helpSelectAllList(conn, pi);
		close(conn);

		return list;
	}

	

	

	

}
