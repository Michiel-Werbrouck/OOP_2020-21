package domain;

import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {
    private Point2D.Double geldigMiddelpunt;
    private double geldigeStraal;
    private Cirkel cirkel;
    @Before
    public void setUp(){
        this.geldigMiddelpunt = new Point2D.Double(9,9);
        this.geldigeStraal = 4;
        this.cirkel = new Cirkel(geldigMiddelpunt,geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Middelpunt_met_Null_als_getal(){
        new Cirkel(null,geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Straal_met_negatief_getal_gooit_exception_op(){
        new Cirkel(geldigMiddelpunt,-4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Straal_met_getal_groter_dan_X_As_gooit_exception_op(){
        new Cirkel(geldigMiddelpunt,10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Straal_met_getal_groter_dan_Y_As_gooit_exception_op(){
        new Cirkel(geldigMiddelpunt,10);
    }

    @Test
    public void test_Cirkel_met_geldige_waarde_voor_parameters_maakt_object_met_geldige_eigenschappen(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt,geldigeStraal);
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigeStraal, cirkel.getStraal(), 0.1);

    }

    @Test
    public void test_Cirkel_Met_straal_gelijk_aan_minimum_van_de_coordinaten_van_het_middelpunt_maakt_object(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt,geldigMiddelpunt.getY());
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigMiddelpunt.getY(), cirkel.getStraal(), 0.1);
    }

    @Test
    public void test_ligtPuntInCirkel_met_punt_buiten_cirkel_geeft_false(){
        assertFalse(cirkel.ligtPuntInCirkel(new Point2D.Double(9,2)));
    }

    @Test
    public void test_ligtPuntInCirkel_met_punt_in_cirkel_geeft_true(){
        assertTrue(cirkel.ligtPuntInCirkel(new Point2D.Double(2,2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_vergrootStraal_ongeldige_uitkomst_straal(){
        cirkel.vergrootStraal(3);
    }

    @Test
    public void test_vergrootStraal_met_geldige_uitkomst_straal_maakt_cirkel_object_aan(){
        assertEquals(geldigeStraal*2,cirkel.vergrootStraal(2).getStraal(),0.1);
    }
}