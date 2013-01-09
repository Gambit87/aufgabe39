/**
 * Figur ist eine abstrakte Klasse für die Darstellung zweidimensionaler
 * geometrischer Figuren.
 *
 * Diese Klasse implementiert die Methode compareTo der Schnittstelle
 * Comparable und zwingt abgeleitete Klassen dazu, die Methoden inhalt und
 * umfang zu implementieren.
 * 
 * Die Implementierung der Schnittstelle Comparable basiert auf dem Vergleich
 * des Flächeninhalts von Objekten der Klasse Figur oder deren Ableitungen.
 *
 * @author Gregor Thill 4260617 Gruppe 3b
 */
abstract class Figur implements Comparable {
    /**
     * Werte kleiner EPS gelten als gleich
     */
    private static final double EPS = 0.0000001;

    /**
     * Liefert den Flächeninhalt eines Objekts zurück.
     * Muss in einer Unterklasse definiert werden.
     *
     * @return Flächeninhalt des Objekts
     */
    abstract double inhalt();
    
    /**
     * Liefert den Umfang eines Objekts zurück.
     * Muss in einer Unterklasse definiert werden.
     *
     * @return Umfang des Objekts
     */
    abstract double umfang();

    /**
     * Implementierung der compareTo-Methode des Comparable-Interface.
     * Objekte werden anhand ihres Flächeninhalts verglichen.
     *
     * @param x Objekt, mit dem verglichen wird
     * @return eine negative Ganzzahl, 0 oder eine positive Ganzzahl, abhängig
     *         davon, ob das dieses Objekt kleiner als, gleich oder größer als
     *         das angegebene Objekt ist.
     */
    public int compareTo(Object x) {
        // Führt bei Typunverträglichkeit direkt zu ClassCastException
        Figur temp = (Figur) x;
        double differenz;
        differenz = this.inhalt() - temp.inhalt();
        if (Math.abs(differenz) < EPS) {
            return 0;
        } else if (differenz < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

