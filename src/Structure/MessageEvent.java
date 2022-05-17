package Structure;

import java.util.EventObject;

public class MessageEvent extends EventObject {
    private final String sujet;
    private final String corps;
    private CommunityManager cm;

    public MessageEvent(Object source, String sujet, String corps) {
        super(source);
        this.sujet = sujet;
        this.corps = corps;
    }

    public String getSujet() {
        return sujet;
    }

    public String getCorps() {
        return corps;
    }

    public CommunityManager getCm() {
        return cm;
    }

    public void setCm(CommunityManager cm) {
        this.cm = cm;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return "Structure.MessageEvent{" +
                "sujet='" + sujet + '\'' +
                ", corps='" + corps + '\'' +
                '}';
    }
}
