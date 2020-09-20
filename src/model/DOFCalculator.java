package model;

public class DOFCalculator {
    private static final double COC = 0.029;

    public static double calc_HFP(Lens lens, double aperture ){//Hyper Focal Point
        return (lens.getFocalLen() * lens.getFocalLen())/(aperture*COC);
    }

    public static double calc_NFP(Lens lens, double distance, double HFP){
        return (HFP * distance)/(HFP+ (distance - lens.getFocalLen()) );
    }

    public static double calc_FFP(Lens lens, double distance, double HFP){
        return (HFP * distance)/(HFP - (distance - lens.getFocalLen()));
    }

    public static double calc_DOF(double NFP, double FFP){
        return FFP - NFP;
    }


}
