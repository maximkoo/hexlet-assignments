package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle c) {
        Integer sq = null;
        try {
            sq = (int) Math.round(c.getSquare());
        } catch (NegativeRadiusException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sq);
        System.out.println("Вычисление окончено");
    }
}
// END
