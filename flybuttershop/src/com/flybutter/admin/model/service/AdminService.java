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
		int memberListCount = 0;
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

	public int memberListNextCount(String sWord, int sKind) {
		Connection conn = getConnection();
		int memberListCount = 0;
		memberListCount = new AdminDao().memberListNextCount(conn, sWord, sKind);
		close(conn);
		return memberListCount;
	}

	public ArrayList<Admin> memberListNext(String sWord, int sKind, int start, int end) {
		Connection conn = getConnection();
		ArrayList<Admin> memberList = null;
		memberList = new AdminDao().memberListNext(conn, sWord, sKind, start, end);

		close(conn);
		return memberList;
	}

	public int sellerListNextCount(String sWord, int sKind) {
		Connection conn = getConnection();
		int sellerListCount = 0;
		sellerListCount = new AdminDao().sellerListNextCount(conn, sWord, sKind);
		close(conn);
		return sellerListCount;
	}

	public ArrayList<Admin> sellerNextList(String sWord, int sKind, int start, int end) {
		Connection conn = getConnection();
		ArrayList<Admin> sellerList = null;
		sellerList = new AdminDao().sellerNextList(conn, sWord, sKind, start, end);
		close(conn);
		return sellerList;
	}

	public int sellerFListCount() {
		Connection conn = getConnection();
		int sellerFListCount = 0;
		sellerFListCount = new AdminDao().sellerFListCount(conn);
		close(conn);
		return sellerFListCount;
	}

	public ArrayList<Admin> sellerFList() {
		Connection conn = getConnection();
		ArrayList<Admin> sellerFList = null;
		sellerFList = new AdminDao().sellerFList(conn);
		close(conn);
		return sellerFList;
	}

	public int sellerFListNextCount(int sKind, String sWord) {
		Connection conn = getConnection();
		int sellerFListCount = 0;
		sellerFListCount = new AdminDao().sellerFListNextCount(conn, sKind, sWord);
		close(conn);
		return sellerFListCount;
	}

	public ArrayList<Admin> sellerFListNext(int sKind, String sWord, int start, int end) {
		Connection conn = getConnection();
		ArrayList<Admin> sellerFList = null;
		sellerFList = new AdminDao().sellerFListNext(conn, sKind, sWord, start, end);
		close(conn);
		return sellerFList;
	}

	public int memberDel(int userNo, int category) {
		Connection conn = getConnection();
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		if (category == 2) {
			result1 = new AdminDao().memberDel(conn, userNo);
			result2 = new AdminDao().sellerMemberDel(conn, userNo);
			result = result1 * result2;
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			result = new AdminDao().memberDel(conn, userNo);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		close(conn);
		return result;
	}

	public int sellerMemberDel(int userNo) {
		Connection conn = getConnection();
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		result1 = new AdminDao().sellerMemberDel(conn, userNo);
		result2 = new AdminDao().changeToNomalMember(conn, userNo);
		result = result1 * result2;
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return result;
	}

	public int storeConfirm(int userNo) {
		
		Connection conn = getConnection();
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		result1 = new AdminDao().changeToSellerMember(conn, userNo);
		result2 = new AdminDao().storeConfirm(conn, userNo);
		result = result1 * result2;
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return result;
	}

}
