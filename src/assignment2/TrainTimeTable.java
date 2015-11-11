package assignment2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class TrainTimeTable {
	private LinkedList<Station> schedule;

	public void delay(String station, int minutes) {
		// negative delay in minutes are allowed but no guarantee of the
		// consistency of schedules of previous stations
		boolean startDelay = false;
		ListIterator<Station> sIt = schedule.listIterator();
		while (sIt.hasNext()) {
			// first find out the index of station
			Station currStation = sIt.next();
			if (!startDelay && currStation.getCity().equals(station)) {
				startDelay = true;
			}
			if (startDelay) {
				currStation.delay(minutes);
			}
		}
	}

	public String getCities() {
		String cities = "";
		for (Station ast : schedule) {
			cities += ast.getCity() + "\n";
		}
		return cities;
	}

	public void displaySchedule() {
		System.out.printf("%16s\t%8s\t%8s\t%3s\n", "Station", "Arrival",
				"Departure", "Day");
		for (int i = 0; i < schedule.size(); i++) {
			schedule.get(i).displaySchedule();
		}
	}

	public TrainTimeTable(LinkedList<Station> schedule) {
		super();
		this.schedule = schedule;
	}

	public static void main(String[] args) throws ParseException {
		LinkedList<Station> schedule = new LinkedList<Station>();
		SimpleDateFormat sdf = new SimpleDateFormat("d HH:mm");
		schedule.add(new Station(null, sdf.parse("1 20:30"), "Vancouver"));
		schedule.add(new Station(sdf.parse("2 06:00"), sdf.parse("2 06:35"),
				"Kamloops"));
		schedule.add(new Station(sdf.parse("2 16:00"), sdf.parse("2 17:30"),
				"Jasper"));
		schedule.add(new Station(sdf.parse("2 23:00"), sdf.parse("2 23:59"),
				"Edmonton"));
		schedule.add(new Station(sdf.parse("3 08:00"), sdf.parse("3 08:25"),
				"Saskatoon"));
		schedule.add(new Station(sdf.parse("3 20:45"), sdf.parse("3 22:30"),
				"Winnipeg"));
		schedule.add(new Station(sdf.parse("4 05:02"), sdf.parse("4 05:42"),
				"Sioux Lookout"));
		schedule.add(new Station(sdf.parse("4 15:35"), sdf.parse("4 16:10"),
				"Hornepayne"));
		schedule.add(new Station(sdf.parse("5 00:18"), sdf.parse("5 00:48"),
				"Capreol"));
		schedule.add(new Station(sdf.parse("5 09:30"), null, "Toronto"));

		TrainTimeTable ttt = new TrainTimeTable(schedule);
		Scanner inp = new Scanner(System.in);
		String cmd = "";
		while (!cmd.equalsIgnoreCase("Quit")) {
			System.out.println("Please input command [Quit | Delay | Show]:");
			cmd = inp.next();
			if (cmd.equalsIgnoreCase("Show")) {
				ttt.displaySchedule();
			} else if (cmd.equalsIgnoreCase("Delay")) {
				System.out.println("Please input Station to delay:");
				String station = inp.next();
				System.out.println("Please input Minutes to delay:");
				int minutes = inp.nextInt();
				ttt.delay(station, minutes);
			}
		}
		inp.close();
	}

}
