package com.flybutter.review.model.service;

import static com.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.review.model.dao.ReviewDao;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;
import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

public class ReviewService {


	
	public ArrayList<Review> seletList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDao().seleteList(conn, pi);
		
		close(conn);
		return list;
	}





	public int getMyListCount(int userNo) {
			
			Connection conn = getConnection();
			
			int listCount = new ReviewDao().reviewListCount(conn, userNo);
			
			close(conn);
			
			
			return listCount;
		
	}
	
}

	
