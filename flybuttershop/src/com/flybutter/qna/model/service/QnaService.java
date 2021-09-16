package com.flybutter.qna.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.flybutter.qna.model.dao.QnaDao;
import com.flybutter.qna.model.vo.Qna;

public class QnaService {

	public int insertQna(Qna q) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, q);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Qna selectQna(int qNo) {
		
		Connection conn = getConnection();
		
		Qna q = new QnaDao().selectQna(conn, qNo);
		
		System.out.println("다오다오다ㅗㅇ  " + q);
		
		close(conn);
		
		return q;
	}

	public Qna replyQna(Qna q) {

		Connection conn = getConnection();
		
		Qna reQna = null;
		
		System.out.println("댓글 서비스으으으으ㅡㅇ : " + q.getQna_Comment());
		System.out.println("댓글 서비스으으으으ㅡㅇ : " + q.getQna_No());

		int result = new QnaDao().replyQna(conn, q);
		
		System.out.println("댓글 서비스으으으으ㅡㅇ : " + result);
		
		if(result > 0) {
			
			commit(conn);
			
			reQna = new QnaDao().selectQna(conn, q.getQna_No());
			
			System.out.println("qna답변~~~" + reQna);
			
		}else {
			rollback(conn);
		}
	
		close(conn);
		
		return reQna;
	}

}
