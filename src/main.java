import model.Lens;
import model.LensManager;


public class main {

    public static void main(String args[]){
        System.out.println("Testing lens and lens manager: ");

        LensManager testLenses = new LensManager();
        testLenses.add(new Lens( "Canon", 50, 1.8 ));

        for(Lens lens : testLenses){
            System.out.println("Lens is: " + lens);
        }

        System.out.println("Lens index 0 is: " + testLenses.get(0));


    }
}
