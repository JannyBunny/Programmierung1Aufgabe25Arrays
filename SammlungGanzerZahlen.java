/**
 * Die Klasse SammlungGanzerZahlen ist eine Sammlungsklasse, in deren Objekten ganze Zahlen abgelegt 
 * werden koennen. Die Sammlung hat eine maximale Kapazitaet, die bei der Objekterzeugung festgelegt wird. 
 * Die Klasse definiert Methoden, um die gespeicherten Zahlen hinzuzufuegen zu manipulieren. Alle Zahlen 
 * werden in einem Array gespeichert. Dabei sollen im Array keine Luecken gelassen werden. Die Klasse 
 * fuehrt Buch ueber die Anzahl der aktuell gespeicherten Zahlen. Sie definiert dazu ein geeignetes 
 * Datenfeld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SammlungGanzerZahlen
{
    // Arrayvariable fuer ein Array ganzer Zahlen.
    private int ganzeZahlen[]; 
    //Die Anzahl der im Array gespeicherten Zahlen
    private int anzahl = 0;
    /**
     * Bequemlichkeitskonstruktor fuer Objekte der Klasse SammlungGanzerZahlen
     */
    public SammlungGanzerZahlen()
    {
        // Erzeugt ein leeres Array ganzer Zahlen. Groesse nach Ermessen des Programmierers festgelegt.
        ganzeZahlen = new int [3];
    }

    /**
     * Konstruktor f�r Objekte der Klasse SammlungGanzerZahlen der angegebenen Kapazitaet (= maximale 
     * Zahl speicherbarer Zahlen).
     */
    public SammlungGanzerZahlen (int kapazitaet)
    {
        // Erzeugt ein leeres Array ganzer Zahlen. Groesse entspreched des Parameters kapaziaet.
//         if (kapazitaet <= 1 ) { 
//             kapazitaet=2;
//         }
        ganzeZahlen = new int [kapazitaet];
    }
    
    /**
     * Gibt die Anzahl der gespeicherten Zahlen zurueck.
     * @return Die Anzahl der aktuell gespeicherten Zahlen.
     */
    public int gibAnzahl()
    {
        //         for (int i = 0; i < ganzeZahlen.length; i++) {
        //             if (ganzeZahlen[i] > 0) { //null geht nicht..?
        //                 anzahl+=1;
        //             }
        //         }
       
        return anzahl;
    }
    
    /**
     * Gibt alle gespeicherten Zahlen im Konsolenfenster aus. Zahlen werden in einer Liste ausgegeben, 
     * einzelne Zahlen durch Komma und Leerzeichen getrennt. Sofern mehr als 10 Zahlen im Speicher sind,
     * beginnt nach jeweils 10 Zahlen eine neue Zeile.
     */
    public void zeigeZahlen()
    {
        for (int i=0; i < anzahl; i++) {
            if ( (i % 10 == 0) && (i>0) ) {
                System.out.println(ganzeZahlen[i]+", ");
            }
            else {
                System.out.print(ganzeZahlen[i]+", ");
            }
        }
    } 
    
    /**
     * Fuegt eine Zahl hinzu. Zahl wird hinter den bereits gespeicherten Zahlen abgelegt.
     * Falls der Vorgang nicht moeglich ist, wird eine Fehlermeldung ausgegeben.
     * @param neueZahl Die Zahl, die hinzugefuegt wird.
     * @return gibt treue zurueck, falls Hinzufuegen erfolgtreich, false sonst.
     */
    public boolean hinzufuegen (int neueZahl) 
    {
        if ( (anzahl<ganzeZahlen.length) && (ganzeZahlen.length > 0) ) {
            ganzeZahlen[anzahl]=neueZahl;
            anzahl++;
            return true;
        }
        return false;
    }

    /**
     * Gibt die Zahl des angegebenen Indexes zurueck.
     * @param index Der Index der gewuenschten Zahl.
     * @return Die Zahl zum Index index. Falls eine Fehler auftritt wird eine Fehlermeldung
     *         ausgegeben und die Zahl 9999 zurueckgegeben.
     */
    public int gibZahl(int index) 
    {
        if ( (index >= 0) && (index < anzahl) && (ganzeZahlen.length > 0) ) {
            return ganzeZahlen[index];
        }
        else {
            return 9999;
        }
    }
    
    /**
     * Loescht die Zahl des angegebenen Indexes. Alle nachfolgenden Zahlen werden nach vorne
     * verschoben, so dass die entstehende Luecke geschlossen wird.
     * @param index Der Index der zu loeschenden Zahl.
     * @return Gibt die geloschte Zahl zurueck. Falls eine Fehler auftritt wird eine Fehlermeldung
     *         ausgegeben und die Zahl 9999 zurueckgegeben.
     */
    public int loescheZahl(int index) 
    {
        if ( (index < anzahl) && (index >= 0) ) {
            int zuloeschen = ganzeZahlen[index];
            for (int i = index; i < anzahl-1 ;i++) {
                ganzeZahlen[i] = ganzeZahlen[i+1];
            }
            ganzeZahlen[anzahl-1]=0;
            anzahl--;
            return zuloeschen;
        }
        else {
            return 9999;
        }
    }
     
    /**
     * Fuegt neue Zahl an der Stelle mit dem angegebenen Index ein. Alle nachfolgenden Zahlen werden 
     * gegebenenfalls nach hinten verschoben. Falls eine Luecke entstehen wuerde, wir die Zahl direkt 
     * hinter den bereits gespeicherten Zahlern abgelegt. Falls der Index negativ ist, wird die Zahl
     * an den Anfang gestellt.
     * @param neueZahl Die Zahl, die eingefuegt werden soll.
     * @param index Der Index der gewuenschten Stelle.
     * @return Gibt true zurueck, falls der Vorgang erfolgreich war. Falls eine Fehler auftritt wird 
     *         eine Fehlermeldung ausgegeben und false zurueckgegeben.
     */
    public boolean fuegeZahlEin(int neueZahl, int index) 
    {
        if (anzahl<ganzeZahlen.length) {
            if (index <= 0) {
                for (int i=anzahl;i>0;i--) {
                    ganzeZahlen[i]=ganzeZahlen[i-1];
                }
                ganzeZahlen[0]=neueZahl;
                anzahl++;
            }
            if ( (index > 0) && (index < anzahl) ) {
                for (int i=anzahl;i>0;i--) {
                    ganzeZahlen[i]=ganzeZahlen[i-1];
                }
                ganzeZahlen[index]=neueZahl;
                anzahl++;
            }
            if ( index >= anzahl ) {
                ganzeZahlen[anzahl]=neueZahl;
                anzahl++;
            }
            return true;
        }
        else {
            System.err.println("Das Array ist voll, es kann leider keine Zahl eingefügt werden.");
            return false;
        }
    }
    
    /**
     * Findet groesste Zahl und gibt diese zurueck.
     * @return groesste Zahl im Array. Gibt 9999 zur�ck, falls es keine groesste Zahl gibt.
     */
    public int gibGroesste()
    {
        if (ganzeZahlen.length==0) {
            return 9999;
        }
        if (anzahl==1) {
            return ganzeZahlen[0];
        }
        int groesste = ganzeZahlen[0];
        int zweitgroesste = ganzeZahlen[1];
            for (int i = 1;i < anzahl;i++) {
                if (groesste <= ganzeZahlen[i]) {
                    zweitgroesste = groesste;
                    groesste = ganzeZahlen[i];
                }
                if ( groesste == zweitgroesste) {
                    return 9999;
                }
            }
        return groesste;
    }
    
    /**
     * Findet kleinste Zahl und gibt diese zurueck.
     * @return kleinste Zahl im Array. Gibt 9999 zurueck, falls es keine kleinste Zahl gibt.
     */
    public int gibKleinste()
    {
        if (ganzeZahlen.length==0) {
            return 9999;
        }
        if (anzahl==1) {
            return ganzeZahlen[0];
        }
        int kleinste = ganzeZahlen[0];
        int zweitkleinste = ganzeZahlen[1];
            for (int i = 1;i < anzahl;i++) {
                if (kleinste >= ganzeZahlen[i]) {
                    zweitkleinste = kleinste;
                    kleinste = ganzeZahlen[i];
                }
                if ( kleinste == zweitkleinste) {
                    return 9999;
                }
            }
        return kleinste;
    }
    
    /**
     * Kehrt Reihenfolge der Zahlen im Array um. Tauscht die erste Zahl mit der letzten, 
     * die zweite mit der vorletzten, usw.
     */
    public void kehreReihenfolgeUm()
    {
        int anfang = 0;
        int ende = anzahl-1;
        int x;
        while ( anfang <= ende ) {
            x=ganzeZahlen[anfang];
            ganzeZahlen[anfang]=ganzeZahlen[ende];
            ganzeZahlen[ende]=x;
            anfang++;
            ende--;
        }
    }

}
