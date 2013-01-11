/**
 * Testet die Methoden der Klasse Kreis
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Kreis
 * @see Figur
 * @see Punkt
 */
public class TestKreis {
    /**
     * Hauptmethode für Konsolenaufruf
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Punkt p1 = new Punkt(1.0, 1.0),
              p2 = new Punkt(5.0, 7.0);
        double r = -1.0;
        Kreis k1 = null,
              k2 = null,
              k3 = null;
        String s = "";
        k1 = new Kreis(p1, r);
        if (k1 != null) {
            System.out.println("Konstruktor ok");
            System.out.println("k1: " + k1.toString());
        } else {
            System.out.println("Konstruktor nicht ok");
        }
        k2 = (Kreis) k1.clone();
        if (k2 != null && k1 != k2 && k1.equals(k2)) {
            System.out.println("clone ok");
            System.out.println("k1: " + k1.toString());
            System.out.println("k2: " + k2.toString());
        } else {
            System.out.println("clone nicht ok");
        }
        System.out.println("k2: " + k2.toString());
        k2.setP(p2);
        k2.setR(2.0);
        if (p2.equals(k2.getP()) && k2.getR() == 2.0) {
            System.out.println("setter und getter ok");
            System.out.println("k2: " + k2.toString());
        } else {
            System.out.println("setter und getter nicht ok");
        }
        if (!(k1.equals(k2)) && !(k2.equals(k3))) {
            System.out.println("equals ok");
        } else {
            System.out.println("equals nicht ok");
        }
        s = k1.toString();
        if (!(s.isEmpty())) {
            System.out.println("toString ok: " + s);
        } else {
            System.out.println("toString nicht ok");
        }
        s = String.format("%.5f", k1.inhalt());
        if (s.equals("3,14159")) {
            System.out.println("inhalt ok");
            System.out.println("Inhalt von k1: " + k1.inhalt());
        } else {
            System.out.println("inhalt nicht ok");
        }
        s = String.format("%.5f", k1.umfang());
        if (s.equals("6,28319")) {
            System.out.println("umfang ok");
            System.out.println("Umfang von k1: " + k1.umfang());
        } else {
            System.out.println("umfang nicht ok");
        }
    }
}

