package utilPack;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class CalendarPrint {
	
	private int year;
	private int monthVal;
	private int date;
	private int day;
	private Month month;
	private LocalDate localDate = LocalDate.now();
	private int lengthOfMonth;
	
	public CalendarPrint() {
		this.year = localDate.getYear();
		this.month = localDate.getMonth();
		this.monthVal = this.month.getValue();
		this.date = localDate.getDayOfMonth();
		this.day = localDate.getDayOfWeek().getValue();
		this.lengthOfMonth = localDate.lengthOfMonth();
	}
	
	public CalendarPrint(int year, int month, int date) {
		localDate = LocalDate.of(year, month, date);
		this.year = localDate.getYear();
		this.month = localDate.getMonth();
		this.monthVal = this.month.getValue();
		this.date = localDate.getDayOfMonth();
		this.day = localDate.getDayOfWeek().getValue();
		this.lengthOfMonth = localDate.lengthOfMonth();
	}
	
	public int getMonth() {
		return this.monthVal;
	}
	public int getYear() {
		return this.year;
	}
	
	public List<String> getDayList() {
		List<String> dayList = new ArrayList<>();

		int firstDayOfThisMonth = LocalDate.of(this.year, this.monthVal, 1).getDayOfWeek().getValue();
		int lastDayOfThisMonth = LocalDate.of(this.year, this.monthVal, this.lengthOfMonth).getDayOfWeek().getValue();
		
		int yearOfPrevMonth = this.year;
		int yearOfNextMonth = this.year;
		
		int prevMonth = this.monthVal - 1;
		int nextMonth = this.monthVal + 1;
		
		if (prevMonth == 0) {
			yearOfPrevMonth -= 1;
			prevMonth = 12;
		}
		
		if (nextMonth == 13) {
			nextMonth = 1;
			yearOfNextMonth += 1;
		}
		
		int lastDateOfPrevMonth = LocalDate.of(yearOfPrevMonth, prevMonth, 1).lengthOfMonth();
		int prevMonthDayCount = firstDayOfThisMonth == 7 ? 0 : firstDayOfThisMonth;
		int nextMonthDayCount = lastDayOfThisMonth == 7 ? 6 : 7 - (lastDayOfThisMonth + 1);
		
		for(int i = lastDateOfPrevMonth - prevMonthDayCount + 1; i < lastDateOfPrevMonth + 1; i++) {
			dayList.add("prevMonth");
		}
		
		for(int i = 1; i < this.lengthOfMonth + 1; i++) {
			dayList.add(Integer.toString(i));
		}		
		
		for(int i = 1; i < nextMonthDayCount + 1; i++) {
			dayList.add("nextMonth");
		}
		return dayList;
	}
	
	public List<LocalDate> getDayToLocalDateList() {
		List<LocalDate> localDateList = new ArrayList<>();
		
		int firstDayOfThisMonth = LocalDate.of(this.year, this.monthVal, 1).getDayOfWeek().getValue();
		int lastDayOfThisMonth = LocalDate.of(this.year, this.monthVal, this.lengthOfMonth).getDayOfWeek().getValue();
		
		int yearOfPrevMonth = this.year;
		int yearOfNextMonth = this.year;
		
		int prevMonth = this.monthVal - 1;
		int nextMonth = this.monthVal + 1;
		
		if (prevMonth == 0) {
			yearOfPrevMonth -= 1;
			prevMonth = 12;
		}
		
		if (nextMonth == 13) {
			nextMonth = 1;
			yearOfNextMonth += 1;
		}
		
		int lastDateOfPrevMonth = LocalDate.of(yearOfPrevMonth, prevMonth, 1).lengthOfMonth();
		int prevMonthDayCount = firstDayOfThisMonth == 7 ? 0 : firstDayOfThisMonth;
		int nextMonthDayCount = lastDayOfThisMonth == 7 ? 6 : 7 - (lastDayOfThisMonth + 1);
		
		for(int i = lastDateOfPrevMonth - prevMonthDayCount + 1; i < lastDateOfPrevMonth + 1; i++) {
			localDateList.add(LocalDate.of(yearOfPrevMonth, prevMonth, i));
		}
		
		for(int i = 1; i < this.lengthOfMonth + 1; i++) {
			localDateList.add(LocalDate.of(this.year, this.monthVal, i));
		}		
		
		for(int i = 1; i < nextMonthDayCount + 1; i++) {
			localDateList.add(LocalDate.of(yearOfNextMonth, nextMonth, i));
		}
		
		return localDateList;
	}
}