package com.hotelroombooking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotelroombooking.daoimpl.MeetingHallTransactionDaoImpl;
import com.hotelroombooking.daoimpl.WeddingHallTransactionDaoImpl;
import com.hotelroombooking.model.MeetingHallDetails;
import com.hotelroombooking.model.WeddingHallDetails;

/**
 * Servlet implementation class deleteMeetingHall
 */
@WebServlet("/DeleteMeetingHall")
public class DeleteMeetingHall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMeetingHall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		int meetingHallNumber = Integer.parseInt(request.getParameter("meetingHallNumber"));
		
		MeetingHallDetails meetingHallDetailsObj = new MeetingHallDetails(meetingHallNumber,null,null,null,0);
		MeetingHallTransactionDaoImpl meetingHallTransDaoObj = new MeetingHallTransactionDaoImpl();
		HttpSession session = request.getSession();
		session.setAttribute("deleteMeetingHallDetails", meetingHallDetailsObj);
		boolean flag = meetingHallTransDaoObj.deleteMeetingHallAdmin(session);
//		PrintWriter pw = response.getWriter();
//		pw.write(flag+"");
		
		
		if(flag)
		{
		  
			response.sendRedirect("AdminDashboard.jsp");
		}
		
		
//		doGet(request, response);
	}

}
