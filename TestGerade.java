/**
 * Testet die Methoden der Klasse Gerade
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Gerade
 * @see Punkt
 */
public class TestGerade {
    /**
     * Hauptmethode für Konsolenaufruf
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Punkt p1 = new Punkt(1.0, 4.0),
              p2 = new Punkt(3.0, 8.0),
              p3 = new Punkt(5.0, 14.0),
              p4 = new Punkt(7.0, 18.0),
              p5 = new Punkt(-1.0, -2.0),
              p6 = new Punkt(-3.0, -4.0),
              p7 = new Punkt(1.0, 3.0),
              p8 = new Punkt(4.0, 4.0);
        Gerade g1 = null,
               g2 = null,
               g3 = null,
               g4 = null;
        String s = "";
        g1 = new Gerade(p1, p2);
        if (g1 != null) {
            System.out.println("Konstruktor ok");
        } else {
            System.out.println("Konstruktor nicht ok");
        }
        g2 = (Gerade) g1.clone();
        if (g2 != null && g1 != g2 && g1.equals(g2)) {
            System.out.println("clone ok");
        } else {
            System.out.println("clone nicht ok");
        }
        g2.setP(p3);
        g2.setQ(p4);
        if (p3.equals(g2.getP()) && p4.equals(g2.getQ())) {
            System.out.println("setter und getter ok");
        } else {
            System.out.println("setter und getter nicht ok");
        }
        if (!(g1.equals(g2)) && !(g2.equals(g3))) {
            System.out.println("equals ok");
        } else {
            System.out.println("equals nicht ok");
        }
        g3 = new Gerade(p5, p6);
        g4 = new Gerade(p1, p7);
        if (g1.schnittPunkt(g2) == null && g1.schnittPunkt(g3) != null) {
            if (g1.schnittPunkt(g4) != null) {
                g4.setQ(p8);
                if (g1.schnittPunkt(g4) != null) {
                    System.out.println("schnittPunkt, steigung, konstante ok");
                } else {
                    System.out.println("#3 schnittPunkt, steigung, konstante nicht ok");
                }
            } else {
                System.out.println("#2 schnittPunkt, steigung, konstante nicht ok");
            }
        } else {
            System.out.println("#1 schnittPunkt, steigung, konstante nicht ok");
        }
        s = g1.toString();
        if (!(s.isEmpty())) {
            System.out.println("toString ok: " + s);
        } else {
            System.out.println("toString nicht ok");
        }
    }
}

