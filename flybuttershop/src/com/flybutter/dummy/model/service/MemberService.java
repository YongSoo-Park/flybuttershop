package com.flybutter.dummy.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.flybutter.dummy.model.dao.MemberDao;
import com.flybutter.dummy.model.vo.Member;


public class MemberService {

	public Member loginMember(int no) {
		Connection conn = getConnection();

		Member loginUser = new MemberDao().loginMember(conn, no);
		close(conn);
		return loginUser;
	}
	
	public Member loginAdmin(int no) {
		Connection conn = getConnection();

		Member loginUser = new MemberDao().loginAdmin(conn, no);
		close(conn);
		return loginUser;
	}


}
