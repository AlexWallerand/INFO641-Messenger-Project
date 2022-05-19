package Ihm;

import Structure.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Utilisateur extends Fenetre{

    private Bavard bavard;

    private DefaultListModel<MessageEvent> messages;

    public Utilisateur(Bavard bavard, Gestionnaire gestionnaire) throws HeadlessException {
        super("Page utilisateur "+bavard.getPseudo());
        this.bavard = bavard;


        JLabel choixTopic = new JLabel("Choix du topic :",JLabel.CENTER);
        JComboBox<String> listeTopic = new JComboBox<String>(bavard.getCmTopics());

        JLabel labelSujet = new JLabel("Sujet du message :",JLabel.CENTER);
        JTextField sujet = new JTextField();

        JLabel labelCorps = new JLabel("Corps du message :",JLabel.CENTER);
        JLabel sautLigne = new JLabel("           ",JLabel.CENTER);
        JTextField corps = new JTextField();

        JButton submitMessage = new JButton("Envoyer");
        JButton refresh = new JButton("Rafraichir");

        JTabbedPane ongletsMessagerie = new JTabbedPane();
        ArrayList<JPanel> listOnglets = new ArrayList<>();

        for(int i=0 ; i<bavard.getCommunityListeners().size() ; i++){
           JPanel onglet = new JPanel();
           listOnglets.add(onglet);
        }
        for(int i=0 ; i<listOnglets.size() ; i++){
            JList<MessageEvent> listMessage = new JList<>(bavard.getCommunityListeners().get(i).getListMessages());
            JScrollPane listScroll = new JScrollPane(listMessage);
            ongletsMessagerie.add(bavard.getCommunityListeners().get(i).getTopic(),listOnglets.get(i).add(listScroll));
        }

        this.pan.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.weightx = 10;
        constraints.ipadx = 0;
        constraints.ipady = 70;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        this.pan.add(choixTopic,constraints);

        constraints.ipady = 0;
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.pan.add(listeTopic,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.pan.add(labelSujet,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        this.pan.add(sujet,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        this.pan.add(labelCorps,constraints);

        constraints.ipady = 100;
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.pan.add(corps,constraints);

        constraints.ipady = 20;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        this.pan.add(submitMessage,constraints);

        constraints.ipady = 40;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        this.pan.add(sautLigne,constraints);

        constraints.ipady = 20;
        constraints.gridx = 0;
        constraints.gridy = 5;
        this.pan.add(ongletsMessagerie,constraints);

        constraints.ipady = 20;
        constraints.gridx = 1;
        constraints.gridy = 6;
        this.pan.add(refresh,constraints);

        submitMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = sujet.getText();
                String c = corps.getText();
                String cm = (String) listeTopic.getSelectedItem();
                CommunityManager destinataire = gestionnaire.getCMbyTopic(cm);
                bavard.newMessageEvent(s,c,destinataire);
            }
        });

        this.setVisible(true);

    }


}
