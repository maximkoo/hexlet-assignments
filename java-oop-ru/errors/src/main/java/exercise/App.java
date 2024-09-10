package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle c) {
        Integer sq = null;
        try {
            sq = (int) Math.round(c.getSquare());
            System.out.println(sq);
        } catch (NegativeRadiusException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }

    }
}
// END
