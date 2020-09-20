package textUI;

import model.Lens;
import model.LensManager;

public class textUI {
    private LensManager manager;

    public textUI(LensManager manager) {
        this.manager = manager;

        manager.add(new Lens("Canon", 50, 1.8));
        manager.add(new Lens("Tamron", 90, 2.8));
        manager.add(new Lens("Sigma", 200, 2.8));
        manager.add(new Lens("Nikon", 200, 4));
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
                System.out.println(i + ". " + iMake + " " +iFocalLen + "mm F" + iMaxAperture );
            }

            System.out.println("(-1 to exit)");

            isDone =true;

        }
    }
}
