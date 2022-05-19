package Ihm;

import Structure.Bavard;
import Structure.CommunityManager;
import Structure.Gestionnaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class Administrateur extends Fenetre{
    private Gestionnaire gestionnaire;


    public Administrateur(Gestionnaire gestionnaire) throws HeadlessException {
        super("Page administrateur");
        this.gestionnaire = gestionnaire;

        JTextField inputPseudo = new JTextField();
        JTextField inputTopic = new JTextField();
        JPasswordField inputMdp = new JPasswordField();
        JLabel inscrBavard = new JLabel("Inscription d'utilisateurs : ");
        JLabel inscrCM = new JLabel("Création d'un groupe : ");
        JLabel pseudo = new JLabel("Pseudo : ",JLabel.CENTER);
        JLabel mdp = new JLabel("Mot de passe : ",JLabel.CENTER);
        JLabel topic = new JLabel("Nom du topic : ",JLabel.CENTER);
        JButton submitBavard = new JButton("Inscrire");
        JLabel validationBavard = new JLabel("L'utilisateur est inscrit.");
        JLabel existBavard = new JLabel("Ce pseudo est déjà pris.");
        JLabel existCM = new JLabel("Ce topic existe déjà.");
        JButton submitCM = new JButton("Créer");
        JLabel validationCM = new JLabel("Le groupe est créé.");
        JLabel bList = new JLabel("Liste des utilisteurs : ");
        JLabel cmList = new JLabel("Liste des groupes : ");
        JList<Bavard> bavardList = new JList<>(new Vector<>(gestionnaire.getListBavard()));
        JList<CommunityManager> CommunityManagerList = new JList<>(new Vector<>(gestionnaire.getListCM()));
        JLabel ajoutBavardToCM = new JLabel("Abonner un utilisateur à un topic : ");
        JComboBox<String> bavardDeroulant = new JComboBox<>(gestionnaire.getTabBavardPseudo());
        JComboBox<String> cmDeroulant = new JComboBox<>(gestionnaire.getTabCmTopic());
        JButton incrireBavard = new JButton("Abonner");
        JLabel validationInscr = new JLabel("L'utilisateur est abonné.");
        JLabel existInscr = new JLabel("L'utilisateur est déjà abonné.");

        this.pan.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 10;
        constraints.ipadx = 0;
        constraints.ipady = 50;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.pan.add(inscrBavard,constraints);


        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        this.pan.add(new JLabel("       "),constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.pan.add(inscrCM,constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        this.pan.add(new JLabel("        "),constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.pan.add(pseudo,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        this.pan.add(inputPseudo,constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        this.pan.add(topic,constraints);

        constraints.gridx = 4;
        constraints.gridy = 1;
        this.pan.add(inputTopic,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        this.pan.add(mdp,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        this.pan.add(inputMdp,constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        this.pan.add(submitBavard,constraints);

        constraints.gridx = 4;
        constraints.gridy = 3;
        this.pan.add(submitCM,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        this.pan.add(bList,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        this.pan.add(bavardList,constraints);

        constraints.gridx = 4;
        constraints.gridy = 4;
        this.pan.add(cmList,constraints);

        constraints.gridx = 4;
        constraints.gridy = 5;
        this.pan.add(CommunityManagerList,constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;
        this.pan.add(ajoutBavardToCM,constraints);

        constraints.gridx = 2;
        constraints.gridy = 7;
        this.pan.add(bavardDeroulant,constraints);

        constraints.gridx = 2;
        constraints.gridy = 8;
        this.pan.add(cmDeroulant,constraints);

        constraints.gridx = 2;
        constraints.gridy = 9;
        this.pan.add(incrireBavard,constraints);

        this.setVisible(true);


        submitBavard.addActionListener(e -> {
            String p = inputPseudo.getText();
            char[] mdpPassword = inputMdp.getPassword();
            String m = new String(mdpPassword);
            if(createBavardCheck(p,m)){
                Bavard newBavard = gestionnaire.createBavard(p,m);
                bavardDeroulant.addItem(newBavard.getPseudo());
                if(!containsComponent(pan,validationBavard)){
                    constraints.gridx = 2;
                    constraints.gridy = 3;
                    validationBavard.setForeground(Color.getColor("forestGreen", Color.decode("#1B8E50")));
                    pan.remove(existBavard);
                    pan.add(validationBavard,constraints);
                }
            }
            else {
                if(!containsComponent(pan,existBavard)){
                    constraints.gridx = 2;
                    constraints.gridy = 3;
                    existBavard.setForeground(Color.getColor("darkRed", Color.decode("#B30000")));
                    pan.remove(validationBavard);
                    pan.add(existBavard,constraints);
                }
            }
            bavardList.setListData(new Vector<>(gestionnaire.getListBavard()));
            setVisible(true);
        });

        submitCM.addActionListener(e -> {
            String t = inputTopic.getText();
            if (createCmCheck(t)) {
                CommunityManager newCM = gestionnaire.createCM(t);
                cmDeroulant.addItem(newCM.getTopic());
                if (!containsComponent(pan, validationCM)) {
                    constraints.gridx = 5;
                    constraints.gridy = 3;
                    validationCM.setForeground(Color.getColor("forestGreen", Color.decode("#1B8E50")));
                    pan.remove(existCM);
                    pan.add(validationCM, constraints);
                }
            }
            else {
                if (!containsComponent(pan, existCM)) {
                    constraints.gridx = 5;
                    constraints.gridy = 3;
                    existCM.setForeground(Color.getColor("darkRed", Color.decode("#B30001")));
                    pan.remove(validationCM);
                    pan.add(existCM, constraints);
                }
            }
            CommunityManagerList.setListData(new Vector<>(gestionnaire.getListCM()));
            setVisible(true);
        });

        incrireBavard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p = (String) bavardDeroulant.getSelectedItem();
                String t = (String) cmDeroulant.getSelectedItem();
                Bavard bavard = gestionnaire.getBavardbyPseudo(p);
                CommunityManager cm = gestionnaire.getCMbyTopic(t);
                if(ajoutBavardToCMCheck(bavard,cm)) {
                    gestionnaire.addListener(bavard,cm);
                    if(!containsComponent(pan,validationInscr)){
                        constraints.gridx = 3;
                        constraints.gridy = 9;
                        validationInscr.setForeground(Color.getColor("forestGreen", Color.decode("#1B8E50")));
                        pan.remove(existInscr);
                        pan.add(validationInscr,constraints);
                    }
                }
                else {
                    if(!containsComponent(pan,existInscr)){
                        constraints.gridx = 3;
                        constraints.gridy = 9;
                        existInscr.setForeground(Color.getColor("darkRed", Color.decode("#B30000")));
                        pan.remove(validationInscr);
                        pan.add(existInscr,constraints);
                    }
                }
                setVisible(true);
            }
        });


    }

    private boolean createCmCheck(String topic) {
        for(CommunityManager cm : gestionnaire.getListCM()){
            if (Objects.equals(topic, cm.getTopic())){
                return false;
            }
        }
        return true;
    }

    public boolean createBavardCheck(String pseudo,String mdp){
        for(Bavard bavard : gestionnaire.getListBavard()){
            if (Objects.equals(pseudo, bavard.getPseudo())){
                return false;
            }
        }
        return true;
    }

    public boolean ajoutBavardToCMCheck(Bavard bavard,CommunityManager communityManager){
        for(CommunityManager cm : bavard.getCommunityListeners()){
            if (Objects.equals(cm, communityManager)){
                return false;
            }
        }
        return true;
    }


}

