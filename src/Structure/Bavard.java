package Structure;

import java.util.ArrayList;

public class Bavard implements MessageListener {
    private final String pseudo, mdp; // Pseudo unique requis
    private final ArrayList<CommunityManager> communityListeners = new ArrayList<>();
    private Boolean connection = false;
    private Gestionnaire gestionnaire;
    private BavardListener listener;

    public Bavard(String pseudo, String mdp, Gestionnaire gestionnaire) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.gestionnaire = gestionnaire;
    }

    public String getPseudo() {
        return pseudo;
    }
    public String getMdp() {
        return mdp;
    }
    public Boolean getConnection() {
        return connection;
    }

    public void setConnection(Boolean connection) {
        this.connection = connection;
    }

    public ArrayList<CommunityManager> getCommunityListeners() {
        return communityListeners;
    }

    public String[] getCmTopics(){
        ArrayList<CommunityManager> list_cm = getCommunityListeners();
        ArrayList<String> list_topic = new ArrayList<>();
        for(CommunityManager cm : list_cm){
            list_topic.add(cm.getTopic());
        }
        return list_topic.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return pseudo;
    }

    public void addCMListeners(CommunityManager cm){
        communityListeners.add(cm);
    }

    public void newMessageEvent(String sujet, String corps, CommunityManager cmDestination) {
        if(this.getConnection()) {
            MessageEvent message = new MessageEvent(this, sujet, corps);
            assert cmDestination != null;
            cmDestination.messageRecu(message);
            if(this.listener != null){
                this.listener.onMessage(message);
            }
        }
    }

    @Override
    public void messageRecu(MessageEvent message) {
        System.out.println(this.pseudo + " reçoit : " + message);
    }

    public void addListener(BavardListener bavardListener) {
        this.listener = bavardListener;
    }
}
