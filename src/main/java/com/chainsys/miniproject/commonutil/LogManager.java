package com.chainsys.miniproject.commonutil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class LogManager {
	 public static void logException(Exception ex, String source, String exMessage) {
	        Calendar vCalendar = Calendar.getInstance();
	        String logDate = vCalendar.get(Calendar.DATE)+""+(vCalendar.get(Calendar.MONTH)+1)+""+vCalendar.get(Calendar.YEAR);
	        String logDateTime =logDate+""+vCalendar.get(Calendar.HOUR)+""+vCalendar.get(Calendar.MINUTE);
	       
	        if (source == null) {
	            source = "source not provided";
	        }
	        if (exMessage == null) {
	            exMessage = "custom message not provided";
	        }
	        String message = "Exception: " + logDateTime + " Message: " + ex.getMessage();
	        message += "\n Source: " + source + " custom message: " + exMessage+"\n";
	        String fileName = "ExcpetionMessages" + logDateTime + ".log";
	        writeToFile(fileName, message);
	    }

	   /* public static void logException(Exception ex, String source) {
	        Calendar vCalendar = Calendar.getInstance();
	        String logDate = vCalendar.get(Calendar.DATE)+""+(vCalendar.get(Calendar.MONTH)+1)+""+vCalendar.get(Calendar.YEAR);
	        String logDateTime =logDate+""+vCalendar.get(Calendar.HOUR)+""+vCalendar.get(Calendar.MINUTE);
	        if (source == null) {
	            source = "source not provided";
	        }
	        String message = "Exception: " + logDateTime+"Message:"+ex.getMessage();
	        message += "\n Source: " + source+"\n";
	        String fileName = "ExcpetionMessages" + logDateTime + ".log";
	        writeToFile(fileName, message);

	    }*/
	    private static void writeToFile(String fileName, String message ) {
	      
	          File f=new File("d:/Exception//"+fileName+".txt");
	          FileWriter fw=null;
	          try {
	             fw= new FileWriter(f,true);
	            fw.write(message );
	        } catch (IOException e) {
	            
	            e.printStackTrace();
	        }finally {
	            try {
	                fw.close();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        
	    }
	}

