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

}