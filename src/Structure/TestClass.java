package Structure;

import Ihm.Administrateur;
import Ihm.Connexion;
import Ihm.Fenetre;
import Ihm.Utilisateur;
import jdk.jshell.execution.Util;

public class TestClass {
    public static void main(String[] args) {

        Gestionnaire g = new Gestionnaire();
        CommunityManager idu = g.createCM("IDU-3");
        CommunityManager java = g.createCM("Java");
        CommunityManager cafet = g.createCM("Caféretia Polytech");

        Bavard kave = g.createBavard("Kavé","idu");
        Bavard flavien = g.createBavard("Flavien","password");
        Bavard alex = g.createBavard("Alex","abc");
        Bavard mael = g.createBavard("Maël","123");

        g.addListener(kave,idu);
        g.addListener(alex,idu);
        g.addListener(mael,idu);

        g.addListener(alex,java);
        g.addListener(mael,java);

        g.addListener(mael,cafet);
        g.addListener(kave,cafet);
        g.addListener(alex,cafet);
        g.addListener(flavien,cafet);


        mael.newMessageEvent("Projet Java","Devons nous faire un rapport ?",java);
        alex.newMessageEvent("Repas midi","Il reste des paninis ?",cafet);
        mael.newMessageEvent("Repas midi","juste un oui",cafet);
        kave.newMessageEvent("Report du cours de demain","Je serais absent pour le TD de demain.",idu);

        Fenetre c = new Connexion(g);


    }
}
