/**
 * Dreieck stellt dreieckige Objekte auf einer Ebene dar.
 *
 * Diese Klasse stellt Methoden bereit, um Dreiecke zu definieren, verändern
 * sowie Flächeninhalt und Umfang zu berechnen. Durch die Erweiterung der
 * Superklasse Figur sind auch Größenvergleiche abhängig vom Flächeninhalt
 * möglich.
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Figur
 * @see Punkt
 */
public class Dreieck extends Figur {
    /**
     * Werte kleiner EPS gelten als identisch
     */
    private static final double EPS = 0.0000001;

    /**
     * a ist eine Ecke des Dreiecks
     */
    private Punkt a;

    /**
     * b ist eine Ecke des Dreiecks
     */
    private Punkt b;

    /**
     * c ist eine Ecke des Dreiecks
     */
    private Punkt c;

    /**
     * Konstruktor erzeugt ein Dreieck aus drei Punkten
     *
     * @param a Erster Punkt des Dreiecks
     * @param b Zweiter Punkt des Dreiecks
     * @param c Dritter Punkt des Dreiecks
     */
    public Dreieck(Punkt a, Punkt b, Punkt c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return Gibt Punkt a zurück
     */
    public Punkt getA() {
        return this.a;
    }

    /**
     * @return Gibt Punkt b zurück
     */
    public Punkt getB() {
        return this.b;
    }

    /**
     * @return Gibt Punkt c zurück
     */
    public Punkt getC() {
        return this.c;
    }

    /**
     * @param a setzt den Punkt a
     */
    public void setA(Punkt a) {
        this.a = a;
    }

    /**
     * @param b setzt den Punkt b
     */
    public void setB(Punkt b) {
        this.b = b;
    }


    /**
     * @param c setzt den Punkt c
     */
    public void setC(Punkt c) {
        this.c = c;
    }

    /**
     * Überprüft die Gleichheit dieses Objekts mit einem Anderen.
     *
     * Diese Implementierung von equals betrachtet Dreiecke gleich, bei denen
     * - Identität zum Vergleichsobjekt besteht
     * - alle Koordinaten gleich sind (auch in geänderter Anordnung)
     * - alle Seiten (fast) gleich lang sind.
     *
     * @param x Objekt, mit dem sich verglichen wird
     * @return gibt true zurück, wenn Objekte gleich, sonst false
     */
    @Override
    public boolean equals(Object x) {
        Dreieck temp = null;
        // diesA, diesB, diesC sind die Seiten dieses Dreiecks
        double diesA = this.b.abstand(this.c),
               diesB = this.a.abstand(this.c),
               diesC = this.a.abstand(this.b);
        // tempA, tempB, tempC sind die Seiten des Vergleichsobjekts
        double tempA = 0.0,
               tempB = 0.0,
               tempC = 0.0;
        // false, wenn x ein leeres Objekt
        if (x == null) {
            return false;
        }
        // true, wenn wirklich identisch
        if (this == x) {
            return true;
        }
        // false, wenn die Klasse nicht übereinstimmt
        if (getClass() != x.getClass()) {
            return false;
        }
        temp = (Dreieck) x;
        // Vergleich der Koordinaten
        if (this.a.equals(temp.a)) {
            if (this.b.equals(temp.b) && this.c.equals(temp.c)) {
                return true;
            }
            if (this.b.equals(temp.c) && this.c.equals(temp.b)) {
                return true;
            }
        }
        if (this.a.equals(temp.b)) {
            if (this.b.equals(temp.a) && this.c.equals(temp.c)) {
                return true;
            }
            if (this.b.equals(temp.c) && this.c.equals(temp.a)) {
                return true;
            }
        }
        if (this.a.equals(temp.c)) {
            if (this.b.equals(temp.a) && this.c.equals(temp.b)) {
                return true;
            }
            if (this.b.equals(temp.b) && this.c.equals(temp.a)) {
                return true;
            }
        }
        tempA = temp.b.abstand(temp.c);
        tempB = temp.a.abstand(temp.c);
        tempC = temp.a.abstand(temp.b);
        // Vergleich der Seitenlängen
        if (Math.abs(diesA - tempA) < EPS) {
            if (Math.abs(diesB - tempB) < EPS
                    && Math.abs(diesC - tempC) < EPS) {
                return true;
            }
            if (Math.abs(diesB - tempC) < EPS
                    && Math.abs(diesC - tempB) < EPS) {
                return true;
            }
        }
        if (Math.abs(diesA - tempB) < EPS) {
            if (Math.abs(diesB - tempA) < EPS
                    && Math.abs(diesC - tempC) < EPS) {
                return true;
            }
            if (Math.abs(diesB - tempC) < EPS
                    && Math.abs(diesC - tempA) < EPS) {
                return true;
            }
        }
        if (Math.abs(diesA - tempC) < EPS) {
            if (Math.abs(diesB - tempA) < EPS
                    && Math.abs(diesC - tempB) < EPS) {
                return true;
            }
            if (Math.abs(diesB - tempB) < EPS
                    && Math.abs(diesC - tempA) < EPS) {
                return true;
            }
        }
        return false;
    }

    /**
     * Dummy-Implementierung von hashCode wegen überschriebenem equals.
     *
     * @return Gibt immer 0 zurück
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * Erzeugt eine Kopie von sich selbst.
     *
     * @return Objekt als Kopie von sich selbst.
     */
    @Override
    public Object clone() {
        return new Dreieck(this.a, this.b, this.c);
    }

    /**
     * Gibt die Koordinaten der Punkte als Zeichenkette zurück.
     *
     * @return Punktkoordinaten als String
     */
    @Override
    public String toString() {
        return ("A" + this.a.toString()
            + "; B" + this.b.toString()
            + "; C" + this.c.toString());
    }

    /**
     * Errechnet den Flächeninhalt des Dreiecks mit Hilfe der Heron-Formel
     *
     * @return Flächeninhalt als double
     */
    public double inhalt() {
        // x, y, z sind die Seiten des Dreiecks
        double x = this.b.abstand(this.c);
        double y = this.a.abstand(this.c);
        double z = this.a.abstand(this.b);
        double s = 0.5 * (x + y + z);
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }

    /**
     * Errechnet den Umfang des Dreiecks
     *
     * @return Umfang als double
     */
    public double umfang() {
        return (this.b.abstand(this.c)
                + this.a.abstand(this.c)
                + this.a.abstand(this.b));
    }
}

