package com.flybutter.review.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.NoticeFileRenamePolicy;
import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.member.model.vo.Member;
import com.flybutter.review.model.service.ReviewService;
import com.flybutter.review.model.vo.Review;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/insert.rv")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if(ServletFileUpload.isMultipartContent(request)) { 
			

			int maxSize = 10 * 1024 * 1024;
			
			
			String savePath = request.getServletContext().getRealPath("/resources/reviewUpfile");
		
			System.out.println("savePath" + savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new NoticeFileRenamePolicy());
			
			int purNo = Integer.parseInt(multiRequest.getParameter("purNo"));
			String pCode =  multiRequest.getParameter("pCode");
			
			
			int score = Integer.parseInt(multiRequest.getParameter("score"));
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			
			Review r = new Review();
			
			r.setScore(score);
			r.setRe_title(title);
			r.setRe_content(content);
			r.setUser_no(m.getUserNo());
			r.setpCode(pCode);
			r.setPur_no(purNo);
			
			
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				String originName = multiRequest.getOriginalFileName("upfile");
				String changeName = multiRequest.getFilesystemName("upfile");
				
				r.setRe_originFile(originName);
				
				r.setRe_changeFile(changeName);
				
				
			}
			
			System.out.println(multiRequest.getOriginalFileName("upfile") );
			
			int result = new ReviewService().insertReview(r);
			

			OrderList list = new MypageService().selectOrderDetail(purNo);
			
			//?????? ?????? ???????????? ?????? ??????????????????
			ArrayList<OrderInfo> info = new ArrayList<OrderInfo>();
			
			//???????????? ????????? ?????? ??? ???????????? ????????? ???????????? ??????
			String str = list.getOrderInfo();
			
			 String[] temp1 =str.split("/");
		      String[] temp2;
		      for(int j = 0 ; j <temp1.length; j++) {
		        if(temp1[j] != null) {
		        	
		          temp2=temp1[j].split(":");
		          
		          String pImage = new MypageService().getpImage(temp2[0]);
		          String pName = new MypageService().getpName(temp2[0]);
		     
		 
		          info.add(new OrderInfo(temp2[0],pName,Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]),temp2[3],Integer.parseInt(temp2[4]),list.getPurNo(),list.getPurDate(), pImage));
		          
		         
		        }
		          
		         }
		      
		      System.out.println(info);

		      String [] strArr = new String [info.size()];
		      
		      for(int i = 0; i < info.size(); i++) {
		    	  
		    	  if(info.get(i).getpCode().equals(pCode)) {
		    		  
		    		  String infoStr = "";
			    	  //??? ???????????? status ???
			    	  info.get(i).setState(7);
			    	  infoStr += info.get(i).getpCode() + ":";
			    	  infoStr += info.get(i).getSellerNo() + ":";
			    	  infoStr += info.get(i).getAmount()+ ":";
			    	  infoStr += info.get(i).getOption() + ":";
			    	  infoStr += info.get(i).getState();
			    	  
			    	  strArr[i] = infoStr;
		    		  
		    	  }else {
		    		  String infoStr = "";
			    	  infoStr += info.get(i).getpCode() + ":";
			    	  infoStr += info.get(i).getSellerNo() + ":";
			    	  infoStr += info.get(i).getAmount()+ ":";
			    	  infoStr += info.get(i).getOption() + ":";
			    	  infoStr += info.get(i).getState();
			    	  
			    	  strArr[i] = infoStr;
		    		  
		    	  }
		    	  
		    	  
		      }
		      
		      //?????? ????????? ?????? ?????? ???????????? ?????????
		      String result2 = String.join("/", strArr);	
		      
		      //?????? ???????????? ????????? ???????????? ????????? ????????? set
		      list.setOrderInfo(result2);
		      

		     int resultt = new MypageService().refundOrder(list);
			
			
			
			
			if(result > 0) {
				request.getSession().setAttribute("msg", "?????? ?????? ??????");

				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script charset='utf-8'> alert('????????? ?????????????????????'); location.href='reviewList.rv';</script>");
				
				out.flush();
				
				
			}else {
				if(multiRequest.getOriginalFileName("upfile") != null) {
					File failedFile = new File(r.getRe_originFile() +r.getRe_changeFile());
					failedFile.delete();
				}
				
				request.setAttribute("msg", "????????? ?????? ??????");
				
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
				
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
