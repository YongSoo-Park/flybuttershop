package com.flybutter.admin.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.admin.model.dao.AdminDao;
import com.flybutter.admin.model.vo.Admin;

public class AdminService {

	public ArrayList<Admin> memberList() {
		Connection conn = getConnection();
		ArrayList<Admin> memberList = null;
		memberList = new AdminDao().memberList(conn);
		
		close(conn);
		return memberList;
	}

	public ArrayList<Admin> sellerList() {
		Connection conn = getConnection();
		ArrayList<Admin> sellerList = null;
		sellerList = new AdminDao().sellerList(conn);
		close(conn);
		return sellerList;
	}

	public int memberListCount() {
		Connection conn = getConnection();
		int memberListCount =0;
		memberListCount = new AdminDao().memberListCount(conn);
		close(conn);
		return memberListCount;
	}

	public int sellerListCount() {
		Connection conn = getConnection();
		int sellerListCount = 0;
		sellerListCount = new AdminDao().sellerListCount(conn);
		close(conn);
		return sellerListCount;
	}

}
