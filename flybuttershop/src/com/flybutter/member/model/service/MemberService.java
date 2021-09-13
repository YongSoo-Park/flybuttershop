package com.flybutter.member.model.service;


import java.sql.Connection;

import com.flybutter.member.model.dao.MemberDao;
import com.flybutter.member.model.vo.Member;

import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;



public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member loginUser = new MemberDao().loginMember(conn,userId, userPwd);
		close(conn);
		
		return loginUser;
	}

	public int insertCMember(Member mem) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertCMember(conn, mem);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int insertSMember(Member mem) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertSMember(conn, mem);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int idCheck(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().idCheck(conn, userId);
		close(conn);
		
		return result;
	}

	public int idFind(Member mem) {
		Connection conn = getConnection();
		
		int result = new MemberDao().idFind(conn, mem);
		close(conn);
		return result;
	}
	
	public Member selectMember(Member mem) {
		Connection conn = getConnection();
		
		Member member = new MemberDao().selectMember(conn, mem);
		close(conn);
		return member;
	}
	
	
	public Member selectCMember(Member mem) {
		Connection conn = getConnection();
		
		Member member = new MemberDao().selectCMember(conn, mem);
		close(conn);
		return member;
	}
	
	public Member selectSMember(Member mem) {
		Connection conn = getConnection();
		
		Member member = new MemberDao().selectSMember(conn, mem);
		close(conn);
		return member;
	}
	

}
