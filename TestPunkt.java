/**
 * Testet die Methoden der Klasse Punkt
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Punkt
 */
public class TestPunkt {
    /**
     * Hauptmethode für Konsolenaufruf
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Punkt p1 = null,
              p2 = null,
              p3 = null;
        String s = "";
        p1 = new Punkt(1.0, 2.0);
        if (p1 != null) {
            System.out.println("Konstruktor ok");
        } else {
            System.out.println("Konstruktor nicht ok");
        }
        p2 = (Punkt) p1.clone();
        if (p2 != null && p1 != p2 && p1.equals(p2)) {
            System.out.println("clone ok");
        } else {
            System.out.println("clone nicht ok");
        }
        p1.setX(3.0);
        p2.setY(3.0);
        if (p1.getX() == 3.0 && p2.getY() == 3.0) {
            System.out.println("setter und getter ok");
        } else {
            System.out.println("setter und getter nicht ok");
        }
        if (!(p1.equals(p2)) && !(p2.equals(p3))) {
            System.out.println("equals ok");
        } else {
            System.out.println("equals nicht ok");
        }
        s = p1.toString();
        if (s.equals("(3.0,2.0)") || s.equals("(3,0,2,0)")) {
            System.out.println("toString ok");
        } else {
            System.out.println("toString nicht ok");
        }
        if (p1.abstand() > 0 && p2.abstand(p1) > 0) {
            System.out.println("abstand ok");
        } else {
            System.out.println("abstand nicht ok");
        }
    }
}

