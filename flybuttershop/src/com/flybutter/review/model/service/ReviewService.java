package com.flybutter.review.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.review.model.dao.ReviewDao;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;

public class ReviewService {




	public int getMyListCount(int userNo) {
			
			Connection conn = getConnection();
			
			int listCount = new ReviewDao().reviewListCount(conn, userNo);
			
			close(conn);
			
			
			return listCount;
		
	}





	public ArrayList<Review> selectList(PageInfo pi, int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDao().selectList(conn, pi, userNo);
		
		close(conn);
		return list;
	}





	public Review reviewDetail(int no) {
		Connection conn = getConnection();
		
		Review r = new ReviewDao().reviewDetail(conn, no);
		
		
		close(conn);
		return r;
	}
	
}

	
