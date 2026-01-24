package formula1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * GUI application demonstrating formula-1 classes.
 * @author Marc Hensel
 * @version 2011-06-21
 */
public class RacingGUI {
	private JFrame frame;
	private JList<String> driverList, raceList;

	public RacingGUI() {
		RacingSeason season = createSeason2010();

		// Create frame
		frame = new JFrame("Racing Season 2010");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setLocation(50, 50);
		frame.setLayout(new GridLayout(1,3));
		Container contentPane = frame.getContentPane();
		
		// Create and layout lists
		DefaultListModel<String> driverListModel = new DefaultListModel<String>();
		driverList = new JList<String>(driverListModel);
		JScrollPane driverPane = new JScrollPane(driverList);
		driverPane.setPreferredSize(new Dimension(250, 400));

		DefaultListModel<String> raceListModel = new DefaultListModel<String>();
		raceList = new JList<String>(raceListModel);
		JScrollPane racePane = new JScrollPane(raceList);
		driverPane.setPreferredSize(new Dimension(250, 400));

		contentPane.add(racePane);
		contentPane.add(driverPane);

		// Add data to lists
		Driver[] drivers = season.getDriverRanking();
		driverListModel.addElement("Driver ranking:");
		driverListModel.addElement("----------------------------------------");
		for (int i = 0; i < drivers.length; i++) {
			Driver driver = drivers[i];
			driverListModel.addElement(
					String.format("%d. %s %s (%d Punkte)",
							i+1, driver.getFirstName(), driver.getSurname(), driver.getGrandPrixPoints()));
		}

		RaceResult[] races = season.getRaces();
		raceListModel.addElement("Races:");
		raceListModel.addElement("----------------------------------------");
		for (int i = 0; i < races.length; i++) {
			RaceResult race = races[i];
			raceListModel.addElement(String.format("%d. %s", i+1, race.getName()));
		}

		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		RacingGUI gui = new RacingGUI();
	}

	private static RacingSeason createSeason2010() {
		RacingSeason season = new RacingSeason();
		
		// Create teams
		RacingTeam mcLaren = new RacingTeam("Vodafone McLaren");
		RacingTeam petronas = new RacingTeam("Mercedes GP Petronas");
		RacingTeam redBull = new RacingTeam("Red Bull Racing");
		RacingTeam ferrari = new RacingTeam("Scuderia Ferrari");
		RacingTeam williams = new RacingTeam("AT&T Williams");
		RacingTeam renault = new RacingTeam("Renault F1 Team");
		RacingTeam forceIndia = new RacingTeam("Force India F1 Team");
		RacingTeam toroRosso = new RacingTeam("Scuderia Toro Rosso");
		RacingTeam lotus = new RacingTeam("Lotus Racing");
		RacingTeam hrt = new RacingTeam("HRT F1 Team");
		RacingTeam sauber = new RacingTeam("BMW Sauber F1 Team");
		RacingTeam virgin = new RacingTeam("Virgin Racing");

		// Create drivers
		Driver button = new Driver("Jenson", "Button", mcLaren);
		Driver hamilton = new Driver("Lewis", "Hamilton", mcLaren);
		mcLaren.addDriver(button);
		mcLaren.addDriver(hamilton);
		
		Driver schumacher = new Driver("Michael", "Schumacher", petronas);
		Driver rosberg = new Driver("Nico", "Rosberg", petronas);
		petronas.addDriver(schumacher);
		petronas.addDriver(rosberg);
		
		Driver vettel = new Driver("Sebastian", "Vettel", redBull);
		Driver webber = new Driver("Mark", "Webber", redBull);
		redBull.addDriver(vettel);
		redBull.addDriver(webber);
		
		Driver massa = new Driver("Felipe", "Massa", ferrari);
		Driver alonso = new Driver("Fernando", "Alonso", ferrari);
		ferrari.addDriver(massa);
		ferrari.addDriver(alonso);
		
		Driver barrichello = new Driver("Rubens", "Barrichello", williams);
		Driver huelkenberg = new Driver("Nico", "Hülkenberg", williams);
		williams.addDriver(barrichello);
		williams.addDriver(huelkenberg);
		
		Driver kubica = new Driver("Robert", "Kubica", renault);
		Driver petrow = new Driver("Witali", "Petrow", renault);
		renault.addDriver(kubica);
		renault.addDriver(petrow);
		
		Driver sutil = new Driver("Adrian", "Sutil", forceIndia);
		Driver liuzzi = new Driver("Vitantonio", "Liuzzi", forceIndia);
		forceIndia.addDriver(sutil);
		forceIndia.addDriver(liuzzi);
		
		Driver buemi = new Driver("Sébastien", "Buemi", toroRosso);
		Driver alguersuari = new Driver("Jaime", "Alguersuari", toroRosso);
		toroRosso.addDriver(buemi);
		toroRosso.addDriver(alguersuari);
		
		Driver trulli = new Driver("Jarno", "Trulli", lotus);
		Driver kovalainen = new Driver("Heikki", "Kovalainen", lotus);
		lotus.addDriver(trulli);
		lotus.addDriver(kovalainen);
		
		Driver chandhok = new Driver("Karun", "Chandhok", hrt);
		Driver yamamoto = new Driver("Sakon", "Yamamoto", hrt);
		Driver klien = new Driver("Christian", "Klien", hrt);
		Driver senna = new Driver("Bruno", "Senna", hrt);
		hrt.addDriver(chandhok);
		hrt.addDriver(yamamoto);
		hrt.addDriver(klien);
		hrt.addDriver(senna);
		
		Driver rosa = new Driver("Petro", "de la Rosa", sauber);
		Driver heidfeld = new Driver("Nick", "Heidfeld", sauber);
		Driver kobayashi = new Driver("Kamui", "Kobayashi", sauber);
		sauber.addDriver(rosa);
		sauber.addDriver(heidfeld);
		sauber.addDriver(kobayashi);
		
		Driver glock = new Driver("Timo", "Glock", virgin);
		Driver grassi = new Driver("Lucas", "di Grassi", virgin);
		virgin.addDriver(glock);
		virgin.addDriver(grassi);
		
		// Add teams
		season.addTeam(mcLaren);
		season.addTeam(petronas);
		season.addTeam(redBull);
		season.addTeam(ferrari);
		season.addTeam(williams);
		season.addTeam(renault);
		season.addTeam(forceIndia);
		season.addTeam(toroRosso);
		season.addTeam(lotus);
		season.addTeam(hrt);
		season.addTeam(sauber);
		season.addTeam(virgin);

		// Create races
		season.addRaceResults(new RaceResult("Sakhir, Bahrain GP", new Driver[]{alonso, massa, hamilton, vettel, rosberg, schumacher, button, webber, liuzzi}));
		season.addRaceResults(new RaceResult("Melbourne, Australien GP", new Driver[]{button, kubica, massa, alonso, rosberg, hamilton, liuzzi, barrichello, webber, schumacher}));
		season.addRaceResults(new RaceResult("Sepang, Malaysien GP", new Driver[]{vettel, webber, rosberg, kubica, sutil, hamilton, massa, button, alguersuari, huelkenberg}));
		season.addRaceResults(new RaceResult("Shanghai, China GP", new Driver[]{button, hamilton, rosberg, alonso, kubica, vettel, petrow, webber, massa, schumacher}));
		season.addRaceResults(new RaceResult("Barcelona, Spanien GP", new Driver[]{webber, alonso, vettel, schumacher, button, massa, sutil, kubica, barrichello, alguersuari}));
		season.addRaceResults(new RaceResult("Monaco, Monaco GP", new Driver[]{webber, vettel, kubica, massa, hamilton, alonso, rosberg, sutil, liuzzi, buemi}));
		season.addRaceResults(new RaceResult("Istanbul, Türkei GP", new Driver[]{hamilton, button, webber, schumacher, rosberg, kubica, massa, alonso, sutil, kobayashi}));
		season.addRaceResults(new RaceResult("Montreal, Kanada GP", new Driver[]{hamilton, button, alonso, vettel, webber, rosberg, kubica, buemi, liuzzi, sutil}));
		season.addRaceResults(new RaceResult("Valencia, Europa GP", new Driver[]{vettel, hamilton, button, barrichello, kubica, sutil, kobayashi, alonso, buemi, rosberg}));
		season.addRaceResults(new RaceResult("Silverstone, Großbritannien GP", new Driver[]{webber, hamilton, rosberg, button, barrichello, kobayashi, vettel, sutil, schumacher, huelkenberg}));
		season.addRaceResults(new RaceResult("Hockenheim, Deutschland GP", new Driver[]{alonso, massa, vettel, hamilton, button, webber, kubica, rosberg, schumacher, petrow}));
		season.addRaceResults(new RaceResult("Budapest, Ungarn GP", new Driver[]{webber, alonso, vettel, massa, petrow, huelkenberg, rosa, button, kobayashi, barrichello}));
		season.addRaceResults(new RaceResult("Spa, Belgien GP", new Driver[]{hamilton, webber, kubica, massa, sutil, rosberg, schumacher, kobayashi, petrow, liuzzi}));
		season.addRaceResults(new RaceResult("Monza, Italien GP", new Driver[]{alonso, button, massa, vettel, rosberg, webber, huelkenberg, kubica, schumacher, barrichello}));
		season.addRaceResults(new RaceResult("Singapur, Singapur GP", new Driver[]{alonso, vettel, webber, button, rosberg, barrichello, kubica, massa, sutil, huelkenberg}));
		season.addRaceResults(new RaceResult("Suzuka, Japan GP", new Driver[]{vettel, webber, alonso, button, hamilton, schumacher, kobayashi, heidfeld, barrichello, buemi}));
		season.addRaceResults(new RaceResult("Yeongam, Korea GP", new Driver[]{alonso, hamilton, massa, schumacher, kubica, liuzzi, barrichello, kobayashi, heidfeld, huelkenberg}));
		season.addRaceResults(new RaceResult("Sao Paulo, Brasilien GP", new Driver[]{vettel, webber, alonso, hamilton, button, rosberg, schumacher, huelkenberg, kubica, kobayashi}));
		season.addRaceResults(new RaceResult("Abu Dhabi, Abu Dhabi GP", new Driver[]{vettel, hamilton, button, rosberg, kubica, petrow, alonso, webber, alguersuari, massa}));
		
		return season;
	}
}
