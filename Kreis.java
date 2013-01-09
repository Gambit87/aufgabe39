/**
 * Kreis stellt Kreis-Objekte auf einer Ebene dar.
 *
 * Diese Klasse stellt Methoden für Definition, Manipulation
 * und Verarbeitung von Kreisen bereit, wie beispielsweise
 * die Berechnung von Umfang und Inhalt sowie den Vergleich
 * mit anderen Objekten.
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Figur
 * @see Punkt
 */
public class Kreis extends Figur {
    /**
     * Werte kleiner EPS gelten als identisch
     */
    private static final double EPS = 0.0000001;

     /**
      * Übernahme der Konstanten PI für einfacheren Zugriff
      */
    private static final double PI = Math.PI;

    /**
     * Der Mittelpunkt des Kreises
     */
    private Punkt p;

    /**
     * Der Radius des Kreises
     */
    private double r;

    /**
     * Der Konstruktor definiert den Kreis aus Mittelpunkt und Radius
     *
     * @param p Mittelpunkt
     * @param r Radius
     */
    public Kreis(Punkt p, double r) {
        this.p = p;
        if (r < 0) {
            System.out.println("Radius negativ! Ändere Vorzeichen!");
            this.r = -r;
        } else {
            this.r = r;
        }
    }

    /**
     * @return den Mittelpunkt des Kreises
     */
    public Punkt getP() {
        return this.p;
    }

    /**
     * @return den Radius des Kreises
     */
    public double getR() {
        return this.r;
    }

    /**
     * Setzt den Mittelpunkt des Kreises neu
     *
     * @param p neuer Mittelpunkt
     */
    public void setP(Punkt p) {
        this.p = p;
    }

    /**
     * Setzt den neuen Radius des Kreises
     *
     * @param r neuer Radius
     */
    public void setR(double r) {
        this.r = r;
    }

    /**
     * Überprüft, ob dieses Objekt gleich dem übergebenen ist.
     *
     * Diese Implementierung von equals betrachtet Kreise gleich, deren
     * Radius (fast) gleich ist. Der Mittelpunkt kann gleich sein, muss
     * dies jedoch nicht.
     * 
     * @param x das Vergleichsobjekt
     * @return true falls gleich, sonst false
     */
    @Override
    public boolean equals(Object x) {
        Kreis temp = null;
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
        temp = (Kreis) x;
        if (this.p.equals(temp.p) || Math.abs(this.r - temp.r) < EPS) {
            return true;
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
        return new Kreis(this.p, this.r);
    }

    /**
     * Gibt eine Zeichenkette mit Mittelpunkt und Radius des Kreises aus
     *
     * Zahlen werden als Dezimalzahl mit zwei Nachkommastellen ausgegeben.
     *
     * @return String aus Mittelpunkt und Radius
     */
    public String toString() {
        return String.format("P" + this.p.toString() + ", %.2f", this.r);
    }

    /**
     * Berechnet den Flächeninhalt des Kreises
     *
     * @return Flächeninhalt als double
     */
    public double inhalt() {
        return (PI * this.r * this.r);
    }

    /**
     * Berechnet den Umfang des Kreises
     *
     * @return Umfang als double
     */
    public double umfang() {
        return (PI * 2 * this.r);
    }
}

