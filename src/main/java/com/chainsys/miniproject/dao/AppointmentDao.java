package com.chainsys.miniproject.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.miniproject.pojo.Appointment;


public class AppointmentDao {
	
		private static Connection getConnection() {
			String drivername = "oracle.jdbc.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "Arivu9384@36";
			try {
				Class.forName(drivername);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection(dbUrl, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}

		private static java.sql.Date convertTosqlDate(java.util.Date date) {
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			return sqldate;
		}

		public static int insertAppointment(Appointment newapp) {
			String insertquery = "insert into appointment (APP_ID,APP_DATE,DOC_ID,PATIENT_NAME,FEES_COLLECTED) values (?,?,?,?,?)";
			Connection con = null;
			int rows = 0;
//			int rows ;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(insertquery);
				ps.setInt(1, newapp.getApp_id());
				// convert java.util.Date to java.sql.date
				ps.setDate(2, convertTosqlDate(newapp.getApp_date()));
				ps.setInt(3,newapp.getDoc_id());
				ps.setString(4, newapp.getPatient_name());
				ps.setFloat(5, newapp.getFees_collected());
				

				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}

		public static int updateAppointment(Appointment newapp) {
			String updatequery = "update appointment set APP_DATE=?,DOC_ID=?,PATIENT_NAME=?,FEES_COLLECTED=? where APP_ID=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(updatequery);
				ps.setInt(5, newapp.getApp_id());
				// convert java.util.Date to java.sql.date
				ps.setDate(1, convertTosqlDate(newapp.getApp_date()));
				ps.setInt(2, (newapp.getDoc_id()));
				ps.setString(3, newapp.getPatient_name());
				ps.setFloat(4, newapp.getFees_collected());				
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return rows;
		}

		// to update only one column of the table
		public static int updateAppointmentFirstName(int id, String appname) {
			String updatequery = "update appointment set APP_NAME=? where APP_id=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(updatequery);
				ps.setString(1, appname);
				ps.setInt(2, id);
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return rows;
		}

		public static int updateAppointmentFees(int id, float fees) {
			String updatequery = "update appointment set fees=? where app_id=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(updatequery);
				ps.setDouble(1, fees);
				ps.setInt(2, id);
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}

		public static int deleteAppointment(int id) {
			String deletequery = "delete from appointment where APP_ID=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;

			try {
				con = getConnection();
				ps = con.prepareStatement(deletequery);
				ps.setInt(1, id);
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}

		public static Appointment getAppointmentById(int id) {
			Appointment app = null;
			String selectquery = "select APP_ID,APP_DATE,DOC_ID,PATIENT_NAME,FEES_COLLECTED from appointment where APP_ID=?";
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				ps.setInt(1, id);
				rs = ps.executeQuery();

				if (rs.next()) {
					app = new Appointment();
					app.setApp_id(rs.getInt(1));
					java.util.Date date = new java.util.Date(rs.getDate(2).getTime());
					app.setApp_date(date);
					app.setDoc_id(rs.getInt(3));
					app.setPatient_name(rs.getString(4));
					app.setFees_collected(rs.getFloat(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return app;

		}

		public static List<Appointment> getAllAppointment() {
			List<Appointment> listOfAppointment = new ArrayList<Appointment>();
			Appointment app = null;
			String selectquery = "select APP_ID,APP_DATE,DOC_ID,PATIENT_NAME,FEES_COLLECTED from appointment ";
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				rs = ps.executeQuery();

				while (rs.next()) {
					app = new Appointment();
					app.setApp_id(rs.getInt(1));
					java.util.Date date = new java.util.Date(rs.getDate(2).getTime());
					app.setApp_date(date);
					app.setDoc_id(rs.getInt(3));
					app.setPatient_name(rs.getString(4));
					app.setFees_collected(rs.getFloat(5));
					listOfAppointment.add(app);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return listOfAppointment;
		}

	}

