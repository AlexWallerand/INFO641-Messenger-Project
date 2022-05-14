package Structure;

import java.util.ArrayList;

public class CommunityManager implements MessageListener{
    private final String topic;
    private final ArrayList<MessageListener> listListeners = new ArrayList<>();

    public CommunityManager(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public ArrayList<MessageListener> getListListeners() {
        return listListeners;
    }

    @Override
    public String toString() {
        return "Structure.CommunityManager{" +
                "topic='" + topic + '\'' +
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
