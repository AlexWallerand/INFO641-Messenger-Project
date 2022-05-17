package Ihm;

import Structure.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class Utilisateur extends Fenetre implements BavardListener {

    private Bavard bavard;

    private DefaultListModel<MessageEvent> messages;
    private DefaultListModel<Bavard> bavardsConnecte;

    public Utilisateur(Bavard bavard, Gestionnaire gestionnaire) throws HeadlessException {
        super("Page utilisateur");
        this.bavard = bavard;
        this.bavard.addListener(this);

        JLabel labelBList = new JLabel("Liste des utilisateurs connectés");

        bavardsConnecte = new DefaultListModel<>();
        bavardsConnecte.addAll(gestionnaire.getListBavardConnectes());
        JList<Bavard> bavardList = new JList<>(bavardsConnecte);

        JLabel labelEnvoyer = new JLabel("Envoyer un message");
        JLabel choixTopic = new JLabel("Choix du topic");
        JComboBox<String> listeTopic = new JComboBox<String>(bavard.getCmTopics());

        JLabel labelSujet = new JLabel("Sujet du message :");
        JTextField sujet = new JTextField();

        JLabel labelCorps = new JLabel("Corps du message");
        JTextField corps = new JTextField();

        JButton submitMessage = new JButton("Envoyer");

        messages = new DefaultListModel<>();
        JList<MessageEvent> listMessage = new JList<>(messages);

        JTabbedPane ongletsMessagerie = new JTabbedPane();
        for(String topic : bavard.getCmTopics()){
            ongletsMessagerie.add(topic, new JPanel());
        }

        this.pan.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.pan.add(labelBList);
        this.pan.add(bavardList);
        this.pan.add(labelEnvoyer);
        this.pan.add(choixTopic);
        this.pan.add(listeTopic);
        this.pan.add(labelSujet);
        this.pan.add(sujet);
        this.pan.add(labelCorps);
        this.pan.add(corps);
        this.pan.add(submitMessage);
        this.pan.add(ongletsMessagerie);
        this.setVisible(true);

    }

    @Override
    public void onMessage(MessageEvent e) {
        this.messages.addElement(e);
    }
}
