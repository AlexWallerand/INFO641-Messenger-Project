package Structure;

import Ihm.Connexion;
import Ihm.Fenetre;

public class TestClass {
    public static void main(String[] args) {

        Gestionnaire g = new Gestionnaire();
        CommunityManager furry = g.createCM("furrygai", "andrew");
        CommunityManager mein = g.createCM("meinQuanpf", "adhit");
        Bavard pedro = g.createBavard("pedro","a");
        Bavard robert = g.createBavard("robert","b");
        Bavard patrick = g.createBavard("patrick","c");

        g.addListener(pedro,furry);
        g.addListener(robert,furry);
        g.addListener(robert,mein);
        g.addListener(patrick,mein);

        pedro.newMessageEvent("pipi pasta","si si la pipi pasta wahou","furrygai");

        Fenetre ihm = new Connexion(g);

    }
}
