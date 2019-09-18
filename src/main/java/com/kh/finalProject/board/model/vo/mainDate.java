package com.kh.finalProject.board.model.vo;

public class mainDate implements java.io.Serializable{
	private String sYear;
	private String sMonth;
	private String sDate;
	private String eYear;
	private String eMonth;
	private String eDate;
	private String title;
	
	public mainDate() {}

	public mainDate(String sYear, String sMonth, String sDate, String eYear, String eMonth, String eDate,
			String title) {
		super();
		this.sYear = sYear;
		this.sMonth = sMonth;
		this.sDate = sDate;
		this.eYear = eYear;
		this.eMonth = eMonth;
		this.eDate = eDate;
		this.title = title;
	}

	public String getsYear() {
		return sYear;
	}

	public void setsYear(String sYear) {
		this.sYear = sYear;
	}

	public String getsMonth() {
		return sMonth;
	}

	public void setsMonth(String sMonth) {
		if(sMonth.equals("01")) {
			sMonth="JANUARY";
		}else if(sMonth.equals("02")) {
			sMonth="FEBRUARY";
		}else if(sMonth.equals("03")) {
			sMonth="MARCH";
		}else if(sMonth.equals("04")) {
			sMonth="APRIL";
		}else if(sMonth.equals("05")) {
			sMonth="MAY";
		}else if(sMonth.equals("06")) {
			sMonth="JUNE";
		}else if(sMonth.equals("07")) {
			sMonth="JULY";
		}else if(sMonth.equals("08")) {
			sMonth="AUGUST";
		}else if(sMonth.equals("09")) {
			sMonth="SEPTEMBER";
		}else if(sMonth.equals("10")) {
			sMonth="OCTOBER";
		}else if(sMonth.equals("11")) {
			sMonth="NOVEMBER";
		}else {
			sMonth="DECEMBER";
		}
		this.sMonth = sMonth;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteYear() {
		return eYear;
	}

	public void seteYear(String eYear) {
		this.eYear = eYear;
	}

	public String geteMonth() {
		return eMonth;
	}

	public void seteMonth(String eMonth) {
		if(eMonth.equals("01")) {
			eMonth="JANUARY";
		}else if(eMonth.equals("02")) {
			eMonth="FEBRUARY";
		}else if(eMonth.equals("03")) {
			eMonth="MARCH";
		}else if(eMonth.equals("04")) {
			eMonth="APRIL";
		}else if(eMonth.equals("05")) {
			eMonth="MAY";
		}else if(eMonth.equals("06")) {
			eMonth="JUNE";
		}else if(eMonth.equals("07")) {
			eMonth="JULY";
		}else if(eMonth.equals("08")) {
			eMonth="AUGUST";
		}else if(eMonth.equals("09")) {
			eMonth="SEPTEMBER";
		}else if(eMonth.equals("10")) {
			eMonth="OCTOBER";
		}else if(eMonth.equals("11")) {
			eMonth="NOVEMBER";
		}else {
			eMonth="DECEMBER";
		}
		this.eMonth = eMonth;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "mainDate [sYear=" + sYear + ", sMonth=" + sMonth + ", sDate=" + sDate + ", eYear=" + eYear + ", eMonth="
				+ eMonth + ", eDate=" + eDate + ", title=" + title + "]";
	}

	
	
	
}
