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
        CommunityManager python = g.createCM("Python");
        Bavard kave = g.createBavard("Kavé","idu");
        Bavard alex = g.createBavard("Alex","abc");
        Bavard mael = g.createBavard("Maël","123");

        g.addListener(kave,idu);
        g.addListener(alex,idu);
        g.addListener(alex,python);
        g.addListener(mael,python);
        kave.setConnection(true);

        mael.newMessageEvent("Projet Java","Devons nous faire un rapport ?",idu);

        Fenetre ihm = new Connexion(g);

    }
}
