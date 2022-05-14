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
    private JPasswordField inputMdp = new JPasswordField();
    private JLabel pseudo = new JLabel("Pseudo : ");
    private JLabel mdp = new JLabel("Mot de passe : ");
    private JButton submit = new JButton("Se connecter");
    private JLabel erreur = new JLabel("Login ou mot de passe incorrect");
    private Gestionnaire gestionnaire;


    public Connexion(Gestionnaire gestionnaire) throws HeadlessException {
        super("Page de connexion");
        this.setSize(500,150);
        this.setResizable(false);
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
                char[] mdpPassword = inputMdp.getPassword();
                String m = new String(mdpPassword);
                Bavard bavard = gestionnaire.searchBavard(p,m);
                if((Objects.equals(p, "admin")) && (Objects.equals(m, "admin"))){
                    Administrateur pageAdmin = new Administrateur(gestionnaire);
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
}
