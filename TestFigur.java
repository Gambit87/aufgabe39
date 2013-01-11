/**
 * Testet die Methoden der abstrakten Klasse Figur
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Figur
 * @see Dreieck
 * @see Kreis
 * @see Punkt
 */
public class TestFigur {
    /**
     * Hauptmethode für Konsolenaufruf
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Punkt p1 = new Punkt(-1.0, 1.0),
              p2 = new Punkt(2.0, 1.0),
              p3 = new Punkt(2.0, -3.0),
              p4 = new Punkt(0.0, 1.0),
              p5 = new Punkt(2.0, 1.0),
              p6 = new Punkt(2.0, 4.0),
              p7 = new Punkt(1.0, 1.0);
        double r = 1.0;
        Figur f1 = new Dreieck(p1, p2, p3),
              f2 = new Dreieck(p4, p5, p6),
              f3 = new Kreis(p7, r);
        double inhalt1 = f1.inhalt(),
               inhalt2 = f2.inhalt(),
               inhalt3 = f3.inhalt();
        System.out.println("Inhalt f1: " + inhalt1);
        System.out.println("Inhalt f2: " + inhalt2);
        System.out.println("Inhalt f3: " + inhalt3);
        try {
            if (f1.compareTo(f1) == 0) {
                System.out.println("f1 ist so groß wie f1");
            } else {
                System.out.println("f1 ist nicht genauso groß wie f1?!");
            }
            if (f1.compareTo(f2) > 0 && f2.compareTo(f1) < 0) {
                System.out.println("f1 ist größer als f2");
            } else {
                System.out.println("Regelverletzung bei x=y <-> y=x");
            }
            if (f1.compareTo(f3) > 0) {
                System.out.println("f1 ist größer als f3");
            } else if (f1.compareTo(f3) > 0) {
                System.out.println("Vorzeichenfehler im Rückgabewert!");
            } else {
                System.out.println("f1 und f3 sind gleich groß?!");
            }
            System.out.println(f1.compareTo(p1));
        } catch (ClassCastException ex) {
            System.out.println("Nicht vergleichbare Objekte verglichen");
        }
    }
}

