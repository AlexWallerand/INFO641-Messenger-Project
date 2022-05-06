import java.util.EventObject;

public class MessageEvent extends EventObject {
    private final String sujet;
    private final String corps;

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

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "sujet='" + sujet + '\'' +
                ", corps='" + corps + '\'' +
                '}';
    }
}
