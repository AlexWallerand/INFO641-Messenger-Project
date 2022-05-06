import java.nio.charset.CharacterCodingException;

public class TestClass {
    public static void main(String[] args) {

        Gestionnaire g = new Gestionnaire();
        CommunityManager furry = g.createCM("furrygai", "andrew");
        CommunityManager mein = g.createCM("meinQuanpf", "adhit");
        Bavard pedro = g.createBavard("pedro");
        Bavard robert = g.createBavard("robert");
        Bavard patrick = g.createBavard("patrick");

        g.addListener(pedro,furry);
        g.addListener(robert,furry);
        g.addListener(robert,mein);
        g.addListener(patrick,mein);

        pedro.newMessageEvent("pipi pasta","si si la pipi pasta wahou","furrygai");

    }
}
