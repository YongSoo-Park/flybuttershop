package com.flybutter.help.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;


import com.flybutter.help.model.dao.HelpDao;
import com.flybutter.help.model.vo.Help;
import com.flybutter.help.model.vo.HelpReply;
import com.flybutter.help.model.vo.PageInfo;




public class HelpService {

	public ArrayList<Help> helpSelectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Help> list = new HelpDao().helpSelectList(conn, pi);
		close(conn);

		return list;
	}

	public Help selectHelp(int no) {
		Connection conn = getConnection();
		Help h = new HelpDao().selectHelp(conn, no);
		close(conn);
		return h;
	}

	public int insertHelp(Help h) {
		Connection conn = getConnection();
		int result = new HelpDao().insertHelp(conn, h);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);	
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

	

	

}
