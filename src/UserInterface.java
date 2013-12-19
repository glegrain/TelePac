import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * View ??
 * The view recognizes that a GUI action
 * for example, pushing a button or dragging a scroll bar 
 * has occurred, using a listener method that is registered to be called when such an action occurs.
 * 
 * The view calls the appropriate method on the controller.
 * 
 * View objects, as always, use the controller to translate user actions into property updates on the model.
 * In addition, changes in model state are communicated to view objects through an application's controller objects.
 * 
 * @author Michael Kolling & Guillaume Legrain
 * @version 1.0 (Jan 2003) Updated:2010-10-05
 */
public class UserInterface implements ActionListener
{
    
    private GameEngine engine; //Controller ?
    private JFrame myFrame;
    private JTextField entryField;
    private JTextArea log;
    private JLabel image;
    private JButton helpButton;
    private JButton quitButton;
    private JButton backButton;
    private JButton lookButton;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(GameEngine gameEngine)
    {
        engine = gameEngine;
        createGUI();
    }

    /**
     * Print out some text into the text area.
     */
    public void print(String text)
    {
        log.append(text);
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println(String text)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }
    
    /**
     * Print line break into text area
     */
    public void println()
    {
        log.append("\n");
        log.setCaretPosition(log.getDocument().getLength());
    }
    
    /**
     * Show an image file in the interface.
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
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        myFrame = new JFrame(Game.NAME);
        entryField = new JTextField(34);

        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension(200, 100));
        listScroller.setMinimumSize(new Dimension(100,100));

        JPanel panel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        image = new JLabel();
        
        helpButton = new JButton("Help");
        quitButton = new JButton("Quit");
        backButton = new JButton("Back");
        lookButton = new JButton("look");

        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entryField, BorderLayout.SOUTH);
        
        buttonsPanel.add(helpButton, BorderLayout.PAGE_END);
        buttonsPanel.add(backButton, BorderLayout.PAGE_END);
        buttonsPanel.add(lookButton, BorderLayout.PAGE_END);
        buttonsPanel.add(quitButton, BorderLayout.SOUTH);

        myFrame.getContentPane().add(panel, BorderLayout.CENTER);
        myFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        // add keyListener
        // TODO: remove focus hack (button depedent)
        helpButton.addKeyListener(new MyKeyListener(engine));
        backButton.addKeyListener(new MyKeyListener(engine));
        lookButton.addKeyListener(new MyKeyListener(engine));
        quitButton.addKeyListener(new MyKeyListener(engine));
        
        entryField.addKeyListener(new MyKeyListener(engine));
        
        // add some event listeners to some components
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        entryField.addActionListener(this);
        
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.interpretCommand( CommandWord.HELP.toString() );
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.interpretCommand( CommandWord.BACK.toString() );
            }
        });
        
        lookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.interpretCommand( CommandWord.LOOK.toString());
            }
        });
        
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.interpretCommand( CommandWord.QUIT.toString() );
                myFrame.dispose();
            }
        });
        

        myFrame.pack();
        myFrame.setVisible(true);
        entryField.requestFocus();
    }

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(ActionEvent e) 
    {
        // no need to check the type of action at the moment.
        // there is only one possible action: text entry
        processCommand();
    }

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        boolean finished = false;
        String input = entryField.getText();
        entryField.setText("");

        engine.interpretCommand(input);
    }
}
