package labs.lab2.calendar;

/** Representation of date and time.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DateTime implements Comparable<DateTime> {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	/** Constructor setting date and time.
	 * 
	 * @param year Year of date
	 * @param month Month of date [1, 12]
	 * @param day Day of date [1, 31]
	 * @param hour Hour of time [0, 23]
	 * @param minute Minute of time [0, 59]
	 */
	public DateTime(int year, int month, int day, int hour, int minute) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	/** Get year.
	 * 
	 * @return year of date
	 */
	public int getYear() {
		return year;
	}

	/** Get month.
	 * 
	 * @return month of date
	 */
	public int getMonth() {
		return month;
	}

	/** Get day.
	 * 
	 * @return day of date
	 */
	public int getDay() {
		return day;
	}

	/** Get hour.
	 * 
	 * @return hour of time
	 */
	public int getHour() {
		return hour;
	}

	/** Get minute.
	 * 
	 * @return minute of time
	 */
	public int getMinute() {
		return minute;
	}

	/** Get string representation.
	 * 
	 *  @return date and time formatted "dd.mm.yyyy hh:mm"
	 */
	@Override
	public String toString() {
		return String.format("%02d.%02d.%04d %02d:%02d", day, month, year, hour, minute);
	}

	/** Compares with other object of class DateTime for sorting.
	 * 
	 * @return -1 if this is smaller, 1 if this is greater, 0 else
	 */
	@Override
	public int compareTo(DateTime other) {
		String thisDateTime = String.format("%04d.%02d.%02d %02d:%02d",
				year, month, day, hour, minute);
		String otherDateTime = String.format("%04d.%02d.%02d %02d:%02d",
				other.year, other.month, other.day, other.hour, other.minute);
		
		return thisDateTime.compareTo(otherDateTime);
	}

	/** Compares with other object of class DateTime for equality.
	 * 
	 * @return true if objects have same date and time
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateTime other = (DateTime) obj;
		if (day != other.day)
			return false;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
}
