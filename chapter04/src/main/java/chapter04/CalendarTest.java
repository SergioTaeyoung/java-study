package chapter04;

import java.util.Calendar;

public class CalendarTest {
	public static final int MONTH = 1;
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();	//팩토리 메소드
		
		
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH,11); // month(12)-1
		cal.set(Calendar.DATE,25);
		printDate(cal);
	}
	
	public static void printDate(Calendar cal) {
		String[] days = {"일", "월","화","수","목","금","토"};
		//	요일(1(일)~7(토)
		int day = cal.get(Calendar.DAY_OF_WEEK);
		//	년도 
		int year = cal.get(Calendar.YEAR);
		//	월(0~11, +1)
		int month = cal.get(Calendar.MONTH);
		//	일
		int date = cal.get(Calendar.DATE);
		// 	시간
		int hour = cal.get(Calendar.HOUR);
		// 	분
		int minutes = cal.get(Calendar.MINUTE);
		// 	초 
		int seconds = cal.get(Calendar.SECOND);
		System.out.println(year + "년 " + (month+1) + "월 " + date+ "일 " + days[day-1]+"요일"+hour+"시 " + minutes + "분" + seconds + "초"); 
	}

}
