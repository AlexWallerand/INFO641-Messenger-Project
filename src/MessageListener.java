import java.util.EventListener;

public interface MessageListener extends EventListener {

    void messageRecu(MessageEvent message);

}
