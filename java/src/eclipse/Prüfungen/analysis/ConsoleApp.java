package analysis;

/** Sample console application provided for the final exam E3-OP.
*
* @version SoSe 2024
* @author Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">http://www.haw-hamburg.de/marc-hensel</a>)
*/
public class ConsoleApp {
    public static void main(String[] args) {
        QuadraticFunction f = new QuadraticFunction(1.0, -2.0, -3.0);

        System.out.println("Funktion:");
        System.out.println("f(x) = x^2 - 2x - 3\n");

        System.out.println("Nullstellen x_0 mit f(x_0) = 0:");
        for (double xStart : new double[]{-5.0, 5.0}) {
            double x = f.zeroCrossing(xStart, 1.0e-10, 100);
            System.out.printf("x_start = % .1f -> (x0, f(x0)) = (% .1f, %.1f)\n", xStart, x, f.f(x));
        }
    }
}
