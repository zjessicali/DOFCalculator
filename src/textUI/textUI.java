package textUI;

import model.DOFCalculator;
import model.Lens;
import model.LensManager;

import java.text.DecimalFormat;
import java.util.Scanner;

public class textUI {
    private LensManager manager;

    public textUI(LensManager manager) {
        this.manager = manager;

        manager.add(new Lens("Canon", 50, 1.8));
        manager.add(new Lens("Tamron", 90, 2.8));
        manager.add(new Lens("Sigma", 200, 2.8));
        manager.add(new Lens("Nikon", 200, 4));
    }

    private String formatM(double numInMM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(numInMM);
    }

    public void show(){
        boolean isDone = false;
        while(!isDone){
            System.out.println("Lenses to pick from: ");
            //print manager
            for(int i = 0; i < manager.size();i++){
                String iMake = manager.get(i).getMake();
                int iFocalLen = manager.get(i).getFocalLen();
                double iMaxAperture = manager.get(i).getMaxAperture();
                System.out.println("\t"+i + ". " + iMake + " " +iFocalLen + "mm F" + iMaxAperture );
            }
            System.out.println("(-1 to exit)");

            //User chooses camera lens
            Scanner in = new Scanner(System.in);
            System.out.print(": ");
            int lensChoice = in.nextInt();

            //if valid
            if(lensChoice >= 0 && lensChoice < manager.size()){
                //put chosen lens in variable
                Lens lens = manager.get(lensChoice);

                //take aperture and distance
                System.out.print("Aperture [the F number]: ");
                double aperture = in.nextDouble();
                //check max aperture
                if(aperture < lens.getMaxAperture()){
                    System.out.println("ERROR: This aperture is not possible with this lens\n");
                }
                //continue
                else{
                    System.out.print("Distance to subject [m]: ");
                    double distance_inM = in.nextDouble();

                    double HFP_inMM = DOFCalculator.calc_HFP(lens, aperture);
                    double NFP_inMM = DOFCalculator.calc_NFP(lens, distance_inM*1000, HFP_inMM);
                    double FFP_inMM = DOFCalculator.calc_FFP(lens, distance_inM*1000, HFP_inMM);
                    double DOF_inMM = DOFCalculator.calc_DOF(NFP_inMM, FFP_inMM);


                    System.out.println("\tIn focus: "+ formatM(NFP_inMM/1000)  + "m to " + formatM(FFP_inMM/1000)
                            + "m [DoF = " + formatM(DOF_inMM/1000) + "m]");
                    System.out.println("\tHyperfocal point: " + formatM(HFP_inMM/1000) + "m\n");
                }



            }
            else if(lensChoice == -1){
                isDone = true;
            }
            else{
                System.out.println("Error: Invalid lens index.\n");
                isDone = false;
            }
        }
    }
}
