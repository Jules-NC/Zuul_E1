package pkg_engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * Cette classe implémente une interface utilisateur graphique simple 
 * avec une zone de saisie de texte, une zone de sortie de texte et une image en option.
 * 
 * @author Jules Neghnagh
 * @version ProtoX-97BF999-C#38
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame myFrame;
    private JTextField entryField;
    private JTextArea log;
    private JLabel image;
    private JButton myButton;
    //private JButton myButton2;
    //private JButton bouton2; Test d'évent perso

    /**
     * Construire une interface utilisateur. Comme un paramètre, un moteur de jeu 
     * (un traitement de l'objet et l'exécution des commandes de jeu) est nécessaire.
     * 
     * @param gameEngine  Le gamengine qui va mettre en oueuvre la logique du jeu.
     */
    public UserInterface(GameEngine gameEngine)
    {
        this.aEngine = gameEngine;
        createGUI();
    }

    /**
     * @param texte a ecrire.
     * Imprime du texte dans l'area définie.
     */
    public void print(String text)
    {
        log.append(text);
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * @param texte a ecrire.
     * Imprime du texte dans l'area définie, suivi d'un retour a la ligne.
     */
    public void println(String text)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * @param image
     * Affiche une image dans l'interface.
     */
    public void showImage(String imageName)
    {
        URL imageURL = this.getClass().getClassLoader().getResource(imageName);
        if(imageURL == null)
            System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            image.setIcon(icon);
            myFrame.pack();
        }
    }

    /**
     * Enable or disable input in the input field.
     */
    public void enable(boolean on)
    {
        entryField.setEditable(on);
        if(!on)
            entryField.getCaret().setBlinkRate(0);
    }

    /**
     * Configure l'interface graphique de l'utilisateur.
     */
    private void createGUI()
    {
        myFrame = new JFrame("L'Occultance");
        entryField = new JTextField(34);
        myButton = new JButton("Help !");
        //myButton2 = new JButton("test");

        
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension(200, 200));
        listScroller.setMinimumSize(new Dimension(200,100));

        JPanel panel = new JPanel();
        panel.setSize(500,500);
        image = new JLabel();

        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entryField, BorderLayout.SOUTH);
        panel.add(myButton, BorderLayout.EAST);
        //panel.add(myButton2, BorderLayout.WEST);

        myFrame.getContentPane().add(panel, BorderLayout.CENTER);

        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {System.exit(0);}
            });

        entryField.addActionListener(this);
        myButton.addActionListener(this);

        myFrame.pack();
        myFrame.setVisible(true);
        entryField.requestFocus();
    }

    /**
     * @param l'ActionEvent voulu.
     * Actionlistener interface pour le textfield.
     */
    public void actionPerformed(ActionEvent e) 
    {
        // no need to check the type of action at the moment.
        // there is only one possible action: text entry
        Object source = e.getSource(); 
        if (source == entryField){
            processCommand();
        }
        if (e.getSource() == myButton)
            this.aEngine.interpretCommand("help");

        //this.aEngine.interpretCommand("help");

    }

    /**
     * Une commande a été saisie. Lire la commande et faire tout ce qui est nécessaire 
     * pour la traiter.
     */
    private void processCommand()
    {
        boolean finished = false;
        String input = entryField.getText();
        entryField.setText("");

        this.aEngine.interpretCommand(input);
    }
}
