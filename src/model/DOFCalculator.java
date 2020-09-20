package model;

public class DOFCalculator {
    private Lens lens;
    /*
    private double distance;
    private double aperture;
    */
    private double COC = 0.029;

    public double getHFP(double aperture ){//Hyper Focal Point
        return (lens.getFocalLen() * lens.getFocalLen())/(aperture*COC);
    }
}
