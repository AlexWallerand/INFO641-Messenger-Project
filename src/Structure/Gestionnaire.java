package Structure;

import java.util.ArrayList;
import java.util.Objects;

public class Gestionnaire {
    private final ArrayList<Bavard> listBavard = new ArrayList<>();
    private final ArrayList<CommunityManager> listCM = new ArrayList<>();

    public Gestionnaire() {
    }

    public ArrayList<Bavard> getListBavard() {
        return listBavard;
    }

    public String[] getTabBavardPseudo() {
        ArrayList<String> listPseudo =  new ArrayList<>();
        for(Bavard b : listBavard){
            listPseudo.add(b.getPseudo());
        }
        return listPseudo.toArray(new String[0]);
    }

    public ArrayList<Bavard> getListBavardConnectes(){
        ArrayList<Bavard> bavard_connectes = new ArrayList<>();
        for(Bavard bavard : listBavard){
            if (bavard.getConnection()){
                bavard_connectes.add(bavard);
            }
        }
        return bavard_connectes;
    }

    public ArrayList<CommunityManager> getListCM() {
        return listCM;
    }

    public CommunityManager getCMbyTopic(String topic){
        for(CommunityManager cm : listCM){
            if (Objects.equals(cm.getTopic(), topic)){
                return cm;
            }
        }
        System.out.println("Aucun topic existant ne porte ce nom");
        return null;
    }

    public Bavard getBavardbyPseudo(String pseudo){
        for(Bavard b : listBavard){
            if (Objects.equals(b.getPseudo(), pseudo)){
                return b;
            }
        }
        System.out.println("Aucun utilisteur ne porte ce nom");
        return null;
    }

    public String[] getTabCmTopic() {
        ArrayList<String> listTopic =  new ArrayList<>();
        for(CommunityManager cm : listCM){
            listTopic.add(cm.getTopic());
        }
        return listTopic.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return "Structure.Gestionnaire{" +
                "listBavard=" + listBavard +
                ", listCM=" + listCM +
                '}';
    }

    public Bavard searchBavard(String pseudo, String mdp){
        for(Bavard bavard : listBavard){
            if((Objects.equals(bavard.getPseudo(), pseudo)) && (Objects.equals(bavard.getMdp(), mdp))){
                return bavard;
            }
        }
        return null;
    }

    public CommunityManager searchCM(String topic){
        for(CommunityManager cm : listCM){
            if(Objects.equals(cm.getTopic(), topic)){
                return cm;
            }
        }
        return null;
    }


    public Bavard createBavard(String pseudo, String mdp){
        Bavard bavard = new Bavard(pseudo, mdp, this);
        listBavard.add(bavard);
        return bavard;
    }

    public void deleteBavard(String pseudo, String mdp){
        Bavard bavard = searchBavard(pseudo,mdp);
        listBavard.remove(bavard);
    }

    public CommunityManager createCM(String topic){
        CommunityManager cm = new CommunityManager(topic);
        listCM.add(cm);
        return cm;
    }

    public void deleteCM(String topic){
        CommunityManager cm = searchCM(topic);
        listCM.remove(cm);
    }

    public void addListener(Bavard bavard, CommunityManager cm){
        cm.getListListeners().add(bavard);
        bavard.getCommunityListeners().add(cm);
    }

    public void removeListener(Bavard bavard, CommunityManager cm){
        cm.getListListeners().remove(bavard);
    }

    public void connectionBavard(Bavard bavard){
        bavard.setConnection(true);

    }

    public void deconnectionBavard(Bavard bavard){
        bavard.setConnection(false);
    }


}
