import model.Lens;
import model.LensManager;
import textUI.textUI;


public class main {

    public static void main(String args[]){
        System.out.println("Testing the UI: ");
        //create model
        LensManager manager = new LensManager();

        //create ui
        textUI ui = new textUI(manager);

        //launch
        ui.show();

    }
}
