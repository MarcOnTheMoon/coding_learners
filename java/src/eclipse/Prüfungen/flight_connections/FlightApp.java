package flight_connections;

import java.util.ArrayList;
import java.util.Collections;

/** Sample application provided for the final exam E3-OP.
 *
 * @version SoSe 2025
 * @author Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">http://www.haw-hamburg.de/marc-hensel</a>)
 */
public class FlightApp {
    public static void main(String[] args) {
        // Define airports
        Airport hamburg = new Airport("Hamburg", 53.630389, 9.988228);
        Airport frankfurt = new Airport("Franfurt/Main", 50.033306, 8.570456);
        Airport saoPaulo = new Airport("Sao Paulo", -23.432075, -46.469511);
        Airport curitiba = new Airport("Curitiba", -25.528475, -49.175775);

        // Define flight connections
        ArrayList<FlightConnection> connections = new ArrayList<>();
        connections.add(new FlightConnection(hamburg, frankfurt));
        connections.add(new FlightConnection(frankfurt, saoPaulo));
        connections.add(new FlightConnection(saoPaulo, curitiba));

        // Print flight connections
        System.out.println("Unsorted connections:");
        for (FlightConnection connection : connections)
            System.out.println(connection);

        // Sort and print flight connections
        System.out.println("\nConnections sorted by distance:");
        Collections.sort(connections);
        for (FlightConnection connection : connections)
            System.out.println(connection);
    }
}
