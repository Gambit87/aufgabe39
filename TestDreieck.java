/**
 * Testet die Methoden der Klasse Dreieck
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Dreieck
 * @see Figur
 * @see Punkt
 */
public class TestDreieck {
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
              p7 = new Punkt(0.0, 1.0),
              p8 = new Punkt(3.0, 1.0),
              p9 = new Punkt(3.0, -3.0);
        Dreieck d1 = null,
                d2 = null,
                d3 = null,
                d4 = null;
        String s = "";
        d1 = new Dreieck(p1, p2, p3);
        if (d1 != null) {
            System.out.println("Konstruktor ok");
        } else {
            System.out.println("Konstruktor nicht ok");
        }
        d2 = (Dreieck) d1.clone();
        if (d2 != null && d1 != d2 && d1.equals(d2)) {
            System.out.println("clone ok");
        } else {
            System.out.println("clone nicht ok");
        }
        d2.setA(p3);
        d2.setB(p1);
        d2.setC(p2);
        if (p3.equals(d2.getA()) && p1.equals(d2.getB()) && p2.equals(d2.getC())) {
            System.out.println("setter und getter ok");
        } else {
            System.out.println("setter und getter nicht ok");
        }
        if (d1.equals(d2) && !(d2.equals(d3))) {
            d3 = new Dreieck(p4, p5, p6);
            d4 = new Dreieck(p7, p8, p9);
            if (d1.equals(d4) && !(d1.equals(d3))) {
                System.out.println("equals ok");
            } else {
                System.out.println("#2 equals nicht ok");
            }
        } else {
            System.out.println("#1 equals b nicht ok");
        }
        s = d1.toString();
        if (!(s.isEmpty())) {
            System.out.println("toString() ok: " + s);
        } else {
            System.out.println("toString() nicht ok");
        }
        if (d1.inhalt() == 6.0) {
            System.out.println("inhalt ok");
        } else {
            System.out.println("inhalt nicht ok");
        }
        if (d1.umfang() == 12.0) {
            System.out.println("umfang ok");
        } else {
            System.out.println("umfang nicht ok");
        }
    }
}

