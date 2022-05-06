import java.util.ArrayList;

public class Bavard implements MessageListener {
    private final String pseudo;
    private final ArrayList<MessageListener> communityListeners = new ArrayList<>();

    public Bavard(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public ArrayList<MessageListener> getCommunityListeners() {
        return communityListeners;
    }

    @Override
    public String toString() {
        return "Bavard{" +
                "pseudo='" + pseudo + '\'' +
                ", gestionnaireListeners=" + communityListeners +
                '}';
    }

    public void addCMListeners(CommunityManager cm){
        communityListeners.add(cm);
    }

    public void newMessageEvent(String sujet, String corps, String topicDestination) {
        CommunityManager cmDestination = Gestionnaire.getCMbyTopic(topicDestination);
        MessageEvent message = new MessageEvent(this,sujet,corps);
        assert cmDestination != null;
        cmDestination.messageRecu(message);
    }

    @Override
    public void messageRecu(MessageEvent message) {
        System.out.println(this.pseudo + " reçoit : " + message);
    }

}
