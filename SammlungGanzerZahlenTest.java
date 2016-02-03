import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse SammlungGanzerZahlenTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SammlungGanzerZahlenTest
{
    private SammlungGanzerZahlen leer;
    private SammlungGanzerZahlen negativ;
    private SammlungGanzerZahlen mini;
    private SammlungGanzerZahlen klein;
    private SammlungGanzerZahlen groesser;

    /**
     * Konstruktor fuer die Test-Klasse SammlungGanzerZahlenTest
     */
    public SammlungGanzerZahlenTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        leer = new SammlungGanzerZahlen(0);
        
        negativ = new SammlungGanzerZahlen(5);
        negativ.hinzufuegen(-3);
        negativ.hinzufuegen(-5);
        negativ.hinzufuegen(-2);
        
        mini = new SammlungGanzerZahlen(1);
        
        klein = new SammlungGanzerZahlen(4);
        klein.hinzufuegen(6);
        klein.hinzufuegen(7);
        klein.hinzufuegen(8);
        
        groesser = new SammlungGanzerZahlen(50);
        for(int i = 0; i < 25; i++) {
            groesser.hinzufuegen(i+1);
        }
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGibZahlMitteArray()
    {
        assertEquals(7, klein.gibZahl(1));
    }
    
    @Test
    public void testGibZahlUntereGrenze()
    {
        assertEquals(6, klein.gibZahl(0));
    } 

    @Test
    public void testGibZahlObereGrenze()
    {
        assertEquals(8, klein.gibZahl(2));
    }
    
    @Test
    public void testGibZahlUnterhalb()
    {
        assertEquals(9999, klein.gibZahl(-1));
    }     
    
    @Test
    public void testGibZahlOberhalb()
    {
        assertEquals(9999, klein.gibZahl(3));
    }

    @Test
    public void testGibZahlWeitUnterhalb()
    {
        assertEquals(9999, klein.gibZahl(-101));
    }     

    @Test
    public void testGibZahlWeitOberhalb()
    {
        assertEquals(9999, klein.gibZahl(100));
    }     
    
    @Test
    public void testHinzufuegenArrayGroesse0()
    {
        assertEquals(false, leer.hinzufuegen(7));
        assertEquals(0, leer.gibAnzahl());
    }
    
    @Test
    public void testHinzufuegenUeberlauf()
    {
        assertEquals(true, klein.hinzufuegen(7));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(false, klein.hinzufuegen(8));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(7, klein.gibZahl(3));
    }
    
    @Test
    public void testHinzufuegen()
    {
        assertEquals(true, klein.hinzufuegen(7));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(7, klein.gibZahl(3));
    }
    
    @Test
    public void testHinzufuegen0()
    {
        assertEquals(true, klein.hinzufuegen(0));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(0, klein.gibZahl(3));
    }
    
    
    @Test
    public void testZeigen()
    {
        System.out.println("Hier muss jetzt eine Liste der Zahlen von 1..25 folgen:");
        groesser.zeigeZahlen();
        System.out.println("Hier muss jetzt eine Liste einer leeren Sammlung (also nichts) folgen:");        
        leer.zeigeZahlen();
    }

    @Test
    public void testLoescheZahl()
    {
        try {
            assertEquals(7, klein.loescheZahl(1));
            assertEquals(8, klein.gibZahl(1));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = 1 hat ein Problem verursacht!");
        }
    }
    
    @Test
    public void testLoescheZahlUntereGrenze()
    {
        try {
            assertEquals(6, klein.loescheZahl(0));
            assertEquals(7, klein.gibZahl(0));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = 0 hat ein Problem verursacht!");
        }
    }
    
        
    @Test
    public void testLoescheZahlUnterhalbGrenze()
    {
        try {
            assertEquals(9999, klein.loescheZahl(-1));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = -1 hat ein Problem verursacht!");
        }
    }
    
    @Test
    public void testLoescheZahlObereGrenze()
    {
        try {
            assertEquals(9999, klein.loescheZahl(3));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = 3 hat ein Problem verursacht!");
        }
    }
    
        
    @Test
    public void testLoescheZahlOberhalbGrenze()
    {
        try {
            assertEquals(9999, klein.loescheZahl(10));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = 10 hat ein Problem verursacht!");
        }
    }

    @Test
    public void testEinfuegen()
    {
        assertEquals(true, klein.fuegeZahlEin(13, 1));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(8, klein.gibZahl(3));
    }
    
    @Test
    public void testEinfuegenUntereGrenze()
    {
        assertEquals(true, klein.fuegeZahlEin(13, 0));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(8, klein.gibZahl(3));
        assertEquals(13, klein.gibZahl(0));
    }
    
    @Test
    public void testEinfuegenObereGrenze()
    {
        assertEquals(true, klein.fuegeZahlEin(13, 3));
        assertEquals(4, klein.gibAnzahl());
        assertEquals(13, klein.gibZahl(3));
    }
    
    @Test
    public void testEinfuegenOberhalb()
    {
        assertEquals(true, groesser.fuegeZahlEin(13, 30));
        assertEquals(26, groesser.gibAnzahl());
        assertEquals(13, groesser.gibZahl(25));
    }
    
    @Test
    public void testEinfuegenOberhalbZahl0()
    {
        assertEquals(true, groesser.fuegeZahlEin(0, 30));
        assertEquals(26, groesser.gibAnzahl());
        assertEquals(0, groesser.gibZahl(25));
    }
    
    @Test
    public void testEinfuegenUnterhalbGrenze()
    {
        try {
            assertEquals(true, klein.fuegeZahlEin(13, -1));
            assertEquals(4, klein.gibAnzahl());
            assertEquals(8, klein.gibZahl(3));
            assertEquals(13, klein.gibZahl(0));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = -1 hat ein Problem verursacht!");
        }

    } 
    
    @Test
    public void testEinfuegenWeitUnterhalbGrenze()
    {
        try {
            assertEquals(true, klein.fuegeZahlEin(13, -10));
            assertEquals(4, klein.gibAnzahl());
            assertEquals(8, klein.gibZahl(3));
            assertEquals(13, klein.gibZahl(0));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = -10 hat ein Problem verursacht!");
        }

    } 
    
    @Test
    public void testEinfuegenWeitOberhalbGrenze()
    {
        try {
            assertEquals(true, klein.fuegeZahlEin(13, 10));
            assertEquals(4, klein.gibAnzahl());
            assertEquals(13, klein.gibZahl(3));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = 10 hat ein Problem verursacht!");
        }
    }  
    
    @Test
    public void testEinfuegenArrayGroesse0()
    {
        try {
            assertEquals(false, leer.fuegeZahlEin(13, 0));
            assertEquals(0, leer.gibAnzahl());
            assertEquals(9999, leer.gibZahl(3));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Der Index = 0 hat ein Problem verursacht!");
        }
    }

    @Test
    public void gibGroesstePositiv()
    {
        assertEquals(8, klein.gibGroesste());
    }

    @Test
    public void testGroessteNegativ()
    {
         assertEquals(-2, negativ.gibGroesste());
    }

    @Test
    public void testGibGroessteLeer()
    {
        try {
            assertEquals(9999, leer.gibGroesste());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Problem beim Umgang mit leerem Array!");
        }    
    }
    
    @Test
    public void gibKleinstePositiv()
    {
        assertEquals(6, klein.gibKleinste());
    }

    @Test
    public void testKleinsteNegativ()
    {
         assertEquals(-5, negativ.gibKleinste());
    }

    @Test
    public void testGibKleinsteLeer()
    {
        try {
            assertEquals(9999, leer.gibKleinste());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail("Problem beim Umgang mit leerem Array!");
        }    
    }    

    @Test
    public void testKleinsteExtremKlein()
    {
        assertEquals(true, mini.hinzufuegen(Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE, mini.gibKleinste());
    }
    
    @Test
    public void testKleinsteExtremGross()
    {
        assertEquals(true, mini.hinzufuegen(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, mini.gibKleinste());
    }
    
    @Test
    public void testGroessteExtremKlein()
    {
        assertEquals(true, mini.hinzufuegen(Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE, mini.gibGroesste());
    }
    
    @Test
    public void testGroessteExtremGross()
    {
        assertEquals(true, mini.hinzufuegen(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, mini.gibGroesste());
    }    
    
    @Test
    public void testKehreReihenfolgeUm()
    {
        groesser.kehreReihenfolgeUm();
        assertEquals(25, groesser.gibZahl(0));
        assertEquals(24, groesser.gibZahl(1));
        assertEquals(13, groesser.gibZahl(12));
        assertEquals(2, groesser.gibZahl(23));
        assertEquals(1, groesser.gibZahl(24));
    }

    @Test
    public void testKehreReihenfolgeUmLeereSammlung()
    {
        try {
            leer.kehreReihenfolgeUm();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            fail("Problem bei Reihenfolge umkehren mit leerem Array!");
        }    
    }

    @Test
    public void testKehreReihenfolgeUmGeradeAnzahl()
    {
        klein.hinzufuegen(9);
        klein.kehreReihenfolgeUm();
        assertEquals(9, klein.gibZahl(0));
        assertEquals(8, klein.gibZahl(1));
        assertEquals(7, klein.gibZahl(2));
        assertEquals(6, klein.gibZahl(3));
    }
    
}














