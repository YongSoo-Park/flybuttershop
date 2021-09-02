package com.flybutter.dummy.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.flybutter.dummy.model.dao.MemberDao;
import com.flybutter.dummy.model.vo.Member;


public class MemberService {

	public Member loginMember() {
		Connection conn = getConnection();

		Member loginUser = new MemberDao().loginMember(conn);
		close(conn);
		return loginUser;
	}


}
