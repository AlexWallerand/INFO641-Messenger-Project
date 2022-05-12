package Structure;

import java.util.ArrayList;

public class CommunityManager implements MessageListener{
    private final String topic, pseudoCM;
    private final ArrayList<MessageListener> listListeners = new ArrayList<>();

    public CommunityManager(String topic, String pseudoCM) {
        this.topic = topic;
        this.pseudoCM = pseudoCM;
    }

    public String getTopic() {
        return topic;
    }

    public String getPseudoCM() {
        return pseudoCM;
    }

    public ArrayList<MessageListener> getListListeners() {
        return listListeners;
    }

    @Override
    public String toString() {
        return "Structure.CommunityManager{" +
                "topic='" + topic + '\'' +
                ", pseudoCM='" + pseudoCM + '\'' +
                '}';
    }

    @Override
    public void messageRecu(MessageEvent message) {
        for(MessageListener listener : listListeners){
            if(message.getSource() != listener) {
                listener.messageRecu(message);
            }
        }
    }

}
