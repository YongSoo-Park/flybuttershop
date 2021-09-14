package com.flybutter.help.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;


import com.flybutter.help.model.dao.HelpDao;
import com.flybutter.help.model.vo.Help;
import com.flybutter.notice.model.dao.NoticeDao;


public class HelpService {

	public ArrayList<Help> helpSelectList() {
		Connection conn = getConnection();
		ArrayList<Help> list = new HelpDao().helpSelectList(conn);
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

}
