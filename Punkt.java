/**
 * Punkt definiert Punkte in einer Ebene.
 *
 * Diese Klasse stellt Methoden bereit, um Punkte zu definieren, manipulieren,
 * anzuzeigen und den Abstand zu anderen Punkten zu ermitteln.
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 */
public class Punkt {
    /**
     * Werte kleiner EPS gelten als gleich
     */
    private static final double EPS = 0.0000001;

    /**
     * x-Koordinate des Punktes
     */
    private double x;

    /**
     * y-Koordinate des Punktes
     */
    private double y;

    /**
     * Konstruktor speichert Koordinaten
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return Gibt die x-Koordinate zurück
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return Gibt die y-Koordinate zurück
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x setzt die x-Koordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @param y setzt die y-Koordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Vergleich mit anderem Objekt
     *
     * @param x Objekt, mit dem sich verglichen wird
     * @return gibt true zurück, wenn Objekte gleich, sonst false
     */
    @Override
    public boolean equals(Object x) {
        // false, wenn x ein leeres Objekt
        if (x == null) {
            return false;
        }
        // true, wenn identisch
        if (this == x) {
            return true;
        }
        // false, wenn die Klasse nicht übereinstimmt
        if (getClass() != x.getClass()) {
            return false;
        }
        // true, wenn Abstand kleiner EPS, sonst false
        return (this.abstand((Punkt) x) < EPS); 
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
     * @return Kopie von sich selbst
     */
    @Override
    public Object clone() {
        return new Punkt(this.getX(), this.getY());
    }

    /**
     * Die Methode toString gibt die Koordinaten des Punktes aus.
     *
     * Darstellung folgt dem Schema (x,y)
     * Dezimaldarstellung mit einer Nachkommastelle
     *
     * @return Die Koordinaten als String der Form (x,y)
     */
    @Override
    public String toString() {
        double x = this.getX();
        double y = this.getY();
        return String.format("(%1$.1f,%2$.1f)", x, y);
    }

    /**
     * Abstand des Punktes zum Ursprung
     *
     * @return Abstand des Punktes zum Ursprung
     */
    public double abstand() {
        Punkt ursprung = new Punkt(0.0, 0.0);
        return this.abstand(ursprung);
    }

    /**
     * Ermittelt den Abstand des Punktes zu einem anderen Punkt
     *
     * @param p Der Punkt, zu dem der Abstand berechnet wird
     * @return Abstand des Punktes zum anderen Punkt
     */
    public double abstand(Punkt p) {
        //Abstände sind immer positiv, daher Umwandlung in Betrag
        double deltaX = Math.abs(this.getX() - p.getX());
        double deltaY = Math.abs(this.getY() - p.getY());
        if (this.getX() == p.getX()) {
            return deltaY;
        }
        if (this.getY() == p.getY()) {
            return deltaX;
        }
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}

