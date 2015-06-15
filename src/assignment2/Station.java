package assignment2;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Station {
	private Date arrival;
	private Date departure;
	private String city;

	/**
	 * @param arrival
	 * @param departure
	 * @param city
	 */
	public Station(Date arrival, Date departure, String city) {
		super();
		this.arrival = arrival;
		this.departure = departure;
		this.city = city;
	}

	public String getArrival() {
		if (arrival == null)
			return "";
		return new SimpleDateFormat("HH:mm").format(arrival);
	}

	/**
	 * @param arrival
	 *            the arrival to set
	 */
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public int getDate() {
		Calendar cal = new GregorianCalendar();
		if (departure == null)
			cal.setTime(arrival);
		else
			cal.setTime(departure);
		// potential bug here. If delay/pull-up over a year
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	public void displaySchedule() {
		System.out.printf("%16s\t%8s\t%8s\t%3d\n", getCity(), getArrival(),
				getDeparture(), getDate());
	}

	public void delay(int minutes) {
		// negative delay is allowed but no guarantee on the date part
		Calendar cal = new GregorianCalendar();
		if (arrival != null) {
			cal.setTime(arrival);
			cal.add(Calendar.MINUTE, minutes);
			arrival = cal.getTime();
		}
		if (departure != null) {
			cal.setTime(departure);
			cal.add(Calendar.MINUTE, minutes);
			departure = cal.getTime();
		}
	}

	public String getDeparture() {
		if (departure == null)
			return "";
		return new SimpleDateFormat("HH:mm").format(departure);
	}

	/**
	 * @param departure
	 *            the departure to set
	 */
	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
