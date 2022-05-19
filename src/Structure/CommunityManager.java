package Structure;

import javax.swing.*;
import java.util.ArrayList;

public class CommunityManager implements MessageListener{
    private final String topic;
    private final ArrayList<MessageListener> listListeners = new ArrayList<>();
    private DefaultListModel<MessageEvent> listMessages = new DefaultListModel<>();


    public CommunityManager(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public ArrayList<MessageListener> getListListeners() {
        return listListeners;
    }

    public DefaultListModel<MessageEvent> getListMessages() {
        return listMessages;
    }

    @Override
    public String toString() {
        return topic;
    }

    @Override
    public void messageRecu(MessageEvent message) {
        listMessages.addElement(message);
        message.setCm(this);
        for(MessageListener listener : listListeners){
            if(message.getSource() != listener) {
                System.out.println(listener);
                listener.messageRecu(message);
            }
        }
    }

}
