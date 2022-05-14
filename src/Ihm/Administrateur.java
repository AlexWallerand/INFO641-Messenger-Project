package Ihm;

import Structure.Bavard;
import Structure.Gestionnaire;

import javax.swing.*;
import java.awt.*;
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
        JButton submitBavard = new JButton("inscrire");
        JLabel validationBavard = new JLabel("L'utilisateur est inscrit");
        JButton submitCM = new JButton("création");
        JLabel validationCM = new JLabel("Le groupe est créé");
        JList<Bavard> bavardList = new JList<>(new Vector<>(gestionnaire.getListBavard()));

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
        this.pan.add(bavardList,constraints);


        this.setVisible(true);


        submitBavard.addActionListener(e -> {
            String p = inputPseudo.getText();
            char[] mdpPassword = inputMdp.getPassword();
            String m = new String(mdpPassword);
            gestionnaire.createBavard(p,m);
            if(!containsComponent(pan,validationBavard)){
                constraints.gridx = 2;
                constraints.gridy = 3;
                validationBavard.setForeground(Color.getColor("forestGreen", Color.decode("#1B8E50")));
                pan.add(validationBavard,constraints);
            }

            bavardList.setListData(new Vector<>(gestionnaire.getListBavard()));
            setVisible(true);
        });

        submitCM.addActionListener(e -> {
            String t = inputTopic.getText();
            gestionnaire.createCM(t);
            if(!containsComponent(pan,validationCM)){
                constraints.gridx = 5;
                constraints.gridy = 3;
                validationCM.setForeground(Color.getColor("forestGreen", Color.decode("#1B8E50")));
                pan.add(validationCM,constraints);
                setVisible(true);
            }
        });

    }
}

