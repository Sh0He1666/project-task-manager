package com.shohei.tm.domain.model;

import java.io.Serializable;
import java.util.Calendar;

public class CurrentDate implements Serializable {
	
	Calendar cal = Calendar.getInstance();
	
	String year;
	String month;
	String date;
	String flg;
	
	//getter setter
	public void setCurrentYear() {
		String v = String.valueOf(cal.get(Calendar.YEAR));
		if (v.length() == 1) {
			this.year = "0" + v;
		} else {
			this.year = v;			
		}
	}
	public String getCurrentYear() {
		return this.year;
	}

	public void setCurrentMonth() {
		String v = String.valueOf(cal.get(Calendar.MONTH));
		if (v.length() == 1) {
			this.month = "0" + v;
		} else {
			this.month = v;			
		}
	}
	public String getCurrentMonth() {
		return this.month;
	}

	public void setCurrentDate() {
		String v = String.valueOf(cal.get(Calendar.DATE));
		if (v.length() == 1) {
			this.date = "0" + v;
		} else {
			this.date = v;			
		}

	}
	public String getCurrentDate() {
		return this.date;
	}
}
