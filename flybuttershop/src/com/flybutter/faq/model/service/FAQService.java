package com.flybutter.faq.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.faq.model.dao.FAQDao;
import com.flybutter.faq.model.vo.FAQ;


public class FAQService {

	public ArrayList<FAQ> deliverySelectList() {
		Connection conn = getConnection();
		ArrayList<FAQ> list = new FAQDao().deliverySelectList(conn);
		close(conn);
		
		System.out.println("service lsit : " + list);
		return list;
	}

}
