package Ihm;

import Structure.Bavard;
import Structure.Gestionnaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Connexion extends Fenetre{

    private JTextField inputPseudo = new JTextField();
    private JTextField inputMdp = new JTextField();
    private JLabel pseudo = new JLabel("Pseudo : ");
    private JLabel mdp = new JLabel("Mot de passe : ");
    private JButton submit = new JButton("Se connecter");
    private JLabel erreur = new JLabel("Login ou mot de passe incorrect");
    private Gestionnaire gestionnaire;


    public Connexion(Gestionnaire gestionnaire) throws HeadlessException {
        super("Page de connexion");
        this.gestionnaire = gestionnaire;
        setLayout(new GridLayout(3,2));
        this.pan.add(pseudo);
        this.pan.add(inputPseudo);
        this.pan.add(mdp);
        this.pan.add(inputMdp);
        this.pan.add(submit);
        this.setVisible(true);
        Connexion c = this;
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p = inputPseudo.getText();
                String m = inputMdp.getText();
                Bavard bavard = gestionnaire.searchBavard(p,m);
                if((Objects.equals(p, "admin")) && (Objects.equals(m, "admin"))){
                    Administrateur pageAdmin = new Administrateur();
                    c.dispose();
                }
                else if((bavard == null)){
                    if(!containsComponent(pan,erreur)){
                        pan.add(erreur);
                        setVisible(true);
                    }
                }
                else{
                    gestionnaire.connectionBavard(bavard);
                }
           }
       });
    }
    public Boolean containsComponent(Container container, JComponent component) {
        for (Component containedComponent : container.getComponents()) {
            if (containedComponent == component) {
                return true;
            }
        }
        return false;
    }
}
