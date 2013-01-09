/**
 * Gerade ist ein zweidimensionales Objekt aus zwei Punkten.
 *
 * Diese Klasse bietet Methoden zur Definition und Ausgabe einer Geraden
 * sowie die Berechnung eines Schnittpunktes mit einer anderen Geraden.
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 * @see Punkt
 */
public class Gerade {
    /**
     * Werte kleiner als EPS gelten als gleich
     */
    private static final double EPS = 0.0000001;

    /**
     * p ist ein Punkt der Geraden
     */
    private Punkt p;

    /**
     * q ist ein anderer Punkt der Geraden
     */
    private Punkt q;

    /**
     * Konstruktor speichert Punkte
     *
     * @param p Erster Punkt der Gerade
     * @param q Zweiter Punkt der Gerade
     */
    public Gerade(Punkt p, Punkt q) {
        this.p = p;
        this.q = q;
    }

    /**
     * @return Gibt Punkt p zurück
     */
    public Punkt getP() {
        return this.p;
    }

    /**
     * @return Gibt Punkt q zurück
     */
    public Punkt getQ() {
        return this.q;
    }

    /**
     * @param p setzt den Punkt p
     */
    public void setP(Punkt p) {
        this.p = p;
    }

    /**
     * @param q setzt den Punkt q
     */
    public void setQ(Punkt q) {
        this.q = q;
    }

    /**
     * Durch equals vergleicht sich die Gerade mit dem übergebenen Objekt.
     *
     * Diese Implementierung von equals betrachtet auch Geraden mit einer sehr
     * geringen Abweichung voneinander als gleich.
     *
     * @param x Objekt, mit dem sich verglichen wird
     * @return gibt true zurück, wenn Objekte gleich, sonst false
     */
    @Override
    public boolean equals(Object x) {
        Gerade temp = null;
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
        temp = (Gerade) x;
        if (this.p.equals(temp.p)) {
            if (this.q.equals(temp.q)) {
                return true;
            }
        }
        if (this.p.equals(temp.q)) {
            if (this.q.equals(temp.p)) {
                return true;
            }
        }
        if (Math.abs(this.konstante() - temp.konstante()) < EPS) {
            if (Math.abs(this.steigung() - temp.steigung()) < EPS) {
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
        return new Gerade(this.getP(), this.getQ());
    }

    /**
     * Ausgabe der Geradengleichung als String.
     *
     * Darstellung der Geradengleichung in der Form y = mx + n
     * Zahlendarstellung als Dezimalzahl mit einer Dezimalstelle
     *
     * @return Gibt die generierte Geradengleichung als String zurück.
     */
    @Override
    public String toString() {
        double m = this.steigung();
        double n = this.konstante();
        String ausgabe = "";
        // Ist die Gerade nicht senkrecht und auch nicht waagerecht?
        if (!Double.isInfinite(m) && m != 0.0) {
            // Gibt es einen positiven konstanten Anteil? + und Leerzeichen
            if (n > 0.0) {
                ausgabe = String.format("y = %1$.1fx + %2$.1f", m, n);
            // Gibt es einen negativen konstanten Anteil? - und Leerzeichen
            } else if (n < 0.0) {
                n = Math.abs(n);
                ausgabe = String.format("y = %1$.1fx - %2$.1f", m, n);
            } else {
                // Kein konstanter Anteil? Dann nur Steigung * x
                ausgabe = String.format("y = %.1fx", m);
            }
        } else if (m == 0.0) {
            // Die gerade ist waagerecht? Dann nur den konstanten Anteil
            ausgabe = String.format("y = %.1f", n);
        }
        // Hinweis bei einer senkrechten Geraden
        if (Double.isInfinite(m)) {
            ausgabe = String.format("Gerade ist senkrecht und verläuft "
                    + "durch x=%.1f.", this.p.getX());
        }
        return ausgabe;
    }

    /**
     * Berechne den Schnittpunkt mit einer anderen Geraden.
     *
     * @param g Gerade, mit der ein Schnittpunkt errechnet werden soll
     * @return Schnittpunkt s
     */
    public Punkt schnittPunkt(Gerade g) {
        double m1 = this.steigung();
        double m2 = g.steigung();
        double n1 = this.konstante();
        double n2 = g.konstante();
        Punkt s = new Punkt(0.0, 0.0);
        // Bei (fast) gleicher Steigung kein Schnittpunkt
        if (Math.abs(m1 - m2) < EPS) {
            return null;
        }
        // Beide Geraden sind keine Senkrechte
        if (!Double.isInfinite(m1) && !Double.isInfinite(m2)) {
            s.setX((n2 - n1) / (m1 - m2));
        }
        // Wenn eigene Gerade senkrecht
        if (Double.isInfinite(m1)) {
            s.setX(this.p.getX());
            // Übernehme Steigung und Konstante von g
            m1 = m2;
            n1 = n2;
        }
        // Wenn "zu schneidende" Gerade senkrecht
        if (Double.isInfinite(m2)) {
            s.setX(g.p.getX());
        }
        s.setY(m1 * s.getX() + n1);
        return s;
    }

    /**
     * steigung ist ein Hilfsmittel zur Berechnung der Steigung der Geraden.
     * Sie ermittelt, ob die Gerade eine Senkrechte, Waagerechte oder
     * "reguläre" Gerade ist und errechnet die Steigung von letzteren Typen.
     *
     * @return Die Steigung der Geraden als double
     */
    public double steigung() {
        if (this.p.getX() == this.q.getX()) {
            return Double.POSITIVE_INFINITY;
        } else if (this.p.getY() == this.q.getY()) {
            return 0.0;
        }
        double deltaX = this.p.getX() - this.q.getX();
        double deltaY = this.p.getY() - this.q.getY();
        return deltaY / deltaX;
    }

    /** konstante ist ein Hilfsmittel zur Berechnung des konstanten Anteils
     * einer Geradengleichung der Form y = mx + n.
     *
     * @return Gibt den konstanten Anteil der Geradengleichung zurück
     */
    public double konstante() {
        return this.p.getY() - (this.steigung() * this.p.getX());
    }
}

