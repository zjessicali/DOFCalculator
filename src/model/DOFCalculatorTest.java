package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DOFCalculatorTest {

    @Test
    void calc_HFP() {
        Lens lens = new Lens("Canon", 50, 1.8);
        double aperture = 1.8;
        assertEquals(47.89, DOFCalculator.calc_HFP(lens,aperture)/1000, 0.01 );
    }

    @Test
    void calc_NFP() {
        Lens lens = new Lens("Tamron", 90, 2.8);
        double aperture = 2.8;
        double distance = 2000;
        double HFP = DOFCalculator.calc_HFP(lens, aperture);
        assertEquals(1.96, DOFCalculator.calc_NFP(lens, distance, HFP)/1000, 0.01);

    }

    @Test
    void calc_FFP() {
        Lens lens = new Lens("Canon", 50, 1.8);
        double aperture = 11;
        double distance = 15;
        assertEquals(Double.POSITIVE_INFINITY, DOFCalculator.calc_FFP(lens, distance, aperture));
    }

    @Test
    void calc_DOF() {
        Lens lens = new Lens("Canon", 50, 1.8);
        double aperture = 8;
        double distance = 1000;
        double HFP = DOFCalculator.calc_HFP(lens,aperture);
        double NFP = DOFCalculator.calc_NFP(lens,distance,HFP);
        double FFP = DOFCalculator.calc_FFP(lens,distance,HFP);
        assertEquals(0.18, DOFCalculator.calc_DOF(NFP, FFP)/1000, 0.01);
    }
}