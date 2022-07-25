package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointment;



/**
 * Servlet implementation class Appointments
 */
public class Appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Appointments() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		List<Appointment> allAppointments = AppointmentDao.getAllAppointment();
		Iterator<Appointment> apIterator = allAppointments.iterator();
		while (apIterator.hasNext()) {
			Appointment ap = apIterator.next();
	
		out.println("<br>"+ap.getApp_id() + "<br>" + ap.getApp_date() + "<br>" + ap.getDoc_id() + "<br>"
					+ ap.getPatient_name() + "<br>" + ap.getFees_collected());
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("click").equals("ADD_APP")) {
		PrintWriter out = response.getWriter();
		Appointment newapp = null;
		int result = 0;
		int apId = 0;
		try {
			newapp = new Appointment();
			String id = request.getParameter("id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newapp.setApp_id(apId);
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = request.getParameter("date");
			try {
				Validator.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				Validator.CheckNofutureDate(newDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			newapp.setApp_date(newDate);
			String doc_id = request.getParameter("docId");
			try {
				Validator.checkStringForParse(doc_id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();

			}
			int apId1 = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId1);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();

			}
			newapp.setDoc_id(Integer.parseInt(doc_id));
			String name = request.getParameter("name");
			try {
				Validator.checkStringOnly(name);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();

			}
			newapp.setPatient_name(name);
			String fees = request.getParameter("fees");
			float feess = Float.parseFloat(fees);
			try {
				Validator.checkfee(feess);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newapp.setFees_collected(feess);
			result = AppointmentDao.insertAppointment(newapp);
			out.println(result + " row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		 else if (request.getParameter("click").equals("UPDATE_APP")) {
				doPut(request, response);
			} else if (request.getParameter("click").equals("DELETE_APP")) {
				doDelete(request, response);
			}
			
		
	}	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			Appointment newap = new Appointment();
			String id = request.getParameter("id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setApp_id(apId);
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = request.getParameter("date");
			// Date hire_date=hire_dateFormate.parse(emp_HireDate);
			try {
				Validator.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				Validator.CheckNofutureDate(newDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			newap.setApp_date(newDate);
			String id1 = request.getParameter("doc_id");
			try {
				Validator.checkStringForParse(id1);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int docId = Integer.parseInt(id1);
			try {
				Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setDoc_id(docId);
			String name = request.getParameter("name");
			try {
				Validator.checkStringOnly(name);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setPatient_name(name);
			String feess = request.getParameter("fees");
			float fees = Float.parseFloat(feess);
			try {
				Validator.checkfee(fees);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setFees_collected(fees);
			int result = AppointmentDao.updateAppointment(newap);
			out.println("<div> Update Appointment: " + result + "</div>");
		}catch(Exception e)
		{
			e.printStackTrace();
			}
	}
	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		Appointment newapp = null;
		int result = 0;
		int appId = 0;
		try {
			newapp = new Appointment();
			String id = request.getParameter("id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			appId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(appId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newapp.setApp_id(appId);
			result = AppointmentDao.deleteAppointment(appId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		out.println("<div> Delete Appointment: " + result + "</div>");
	}

}