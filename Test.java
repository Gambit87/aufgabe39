/**
 * Hier werden nur die Beispiele aus der Aufgabe ausgeführt.
 * 
 * Die detaillierten Methodentests finden sich in den Klassen:
 * - TestPunkt
 * - TestGerade
 * - TestDreieck
 * - TestKreis
 * - TestFigur
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Figur
 * @see Dreieck
 * @see Kreis
 * @see Punkt
 */
public class Test {
    /**
     * Hauptmethode für Konsolenaufruf
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Punkt p1 = new Punkt(0.0, 0.0),
              p2 = new Punkt(3.0, 0.0),
              p3 = new Punkt(0.0, 4.0),
              p4 = new Punkt(5.0, 5.0);
        double r = 1.0;
        Figur f = new Dreieck(p1, p2, p3);
        System.out.printf("%9.5f%n", f.inhalt()); // Erwarteter Wert:  6.000000
        System.out.printf("%9.5f%n", f.umfang()); // Erwarteter Wert: 12.000000
        f = new Kreis(p4, r);
        System.out.printf("%9.5f%n", f.inhalt()); // Erwarteter Wert:  3.14159
        System.out.printf("%9.5f%n", f.umfang()); // Erwarteter Wert:  6.28319
        p1 = new Punkt(-2.250, 7.375);
        p2 = new Punkt(0.500, 0.500);
        p3 = new Punkt(3.750, -7.625);
        f = new Dreieck(p1, p2, p3);
        // Strecke {p1, p2} = 1/2*s (siehe Heron-Formel) und daher A=0
        System.out.printf("%9.5f%n", f.inhalt());
        System.out.printf("%9.5f%n", f.umfang());
    }
}

