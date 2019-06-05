/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class GUI_project extends JFrame {

    private JMenuBar menuBar;
    private JButton [] buttons = new JButton[9];
    private JButton button10;
    private JButton button11;
    
    private JComboBox combobox1;
    private JLabel [] labels = new JLabel[9];
    private int [] labelColors = new int[9];
    private int [] buttonColors = new int[9];
    private JTextArea textarea1;
    private int chosenGame;
    //Constructor 
    public GUI_project(){

        this.setTitle("GUI_project");
        this.setSize(800,600);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800,600));
        contentPane.setBackground(new Color(192,192,192));
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
            final int temp = 2 * j + i;
            buttons[2 * j + i] = new JButton();
            buttons[2 * j + i].setBounds((5 + 90 * i),(5 + 90 * j),90,90);
            buttons[2 * j + i].setBackground(new Color(214,217,223));
            buttons[2 * j + i].setForeground(new Color(0,0,0));
            buttons[2 * j + i].setEnabled(true);
            buttons[2 * j + i].setFont(new Font("sansserif",0,12));
            buttons[2 * j + i].setOpaque(true);
            buttons[2 * j + i].setVisible(false);
            buttons[2 * j + i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                changeColor(evt, temp);
              }
          });
            contentPane.add(buttons[2 * j + i]);
        }
    }
        for(int i = 4; i < 6; i++){
            final int temp = i;
            buttons[i] = new JButton();
            buttons[i].setBounds(185,5 + 90 * (i-4),90,90);
            buttons[i].setBackground(new Color(214,217,223));
            buttons[i].setForeground(new Color(0,0,0));
            buttons[i].setEnabled(true);
            buttons[i].setFont(new Font("sansserif",0,12));
            buttons[i].setOpaque(true);
            buttons[i].setVisible(false);
            buttons[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                changeColor(evt, temp);
              }
          });
            contentPane.add(buttons[i]);
        }
        for(int i = 6; i < 9; i++){
            final int temp = i;
            buttons[i] = new JButton();
            buttons[i].setBounds(5 + 90 * (i-6),185,90,90);
            buttons[i].setBackground(new Color(214,217,223));
            buttons[i].setForeground(new Color(0,0,0));
            buttons[i].setEnabled(true);
            buttons[i].setFont(new Font("sansserif",0,12));
            buttons[i].setOpaque(true);
            buttons[i].setVisible(false);
             buttons[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                changeColor(evt, temp);
              }
          });
            contentPane.add(buttons[i]);
        }

        

        button10 = new JButton();
        button10.setBounds(495,285,140,35);
        button10.setBackground(new Color(214,217,223));
        button10.setForeground(new Color(0,0,0));
        button10.setEnabled(true);
        button10.setFont(new Font("sansserif",0,12));
        button10.setText("Start Game");
        button10.setVisible(true);
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                startGame(evt);
              }
          });

        button11 = new JButton();
        button11.setBounds(495,391,140,35);
        button11.setBackground(new Color(214,217,223));
        button11.setForeground(new Color(0,0,0));
        button11.setEnabled(true);
        button11.setFont(new Font("sansserif",0,12));
        button11.setText("Check!");
        button11.setVisible(true);
        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                check(evt);
              }
          });

        
        
        String [] gameChoices = {"none selected", "2x2 game", "3x3 game"};
        combobox1 = new JComboBox(gameChoices);
        combobox1.setBounds(477,85,180,35);
        combobox1.setBackground(new Color(214,217,223));
        combobox1.setForeground(new Color(0,0,0));
        combobox1.setEnabled(true);
        combobox1.setFont(new Font("sansserif",0,12));
        combobox1.setVisible(true);
        combobox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                gameChoice(evt);
              }
          });
          for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
            labels[2 * j + i] = new JLabel();
            labels[2 * j + i].setBounds((5 + 90 * i),(305 + 90 * j),90,90);
            labels[2 * j + i].setBackground(new Color(214,217,223));
            labels[2 * j + i].setForeground(new Color(0,0,0));
            labels[2 * j + i].setEnabled(true);
            labels[2 * j + i].setFont(new Font("sansserif",0,12));
            labels[2 * j + i].setOpaque(true);
            labels[2 * j + i].setVisible(false);
            contentPane.add(labels[2 * j + i]);
        }
        }
        for(int i = 4; i < 6; i++){
            labels[i] = new JLabel();
            labels[i].setBounds(185,305 + 90 * (i-4),90,90);
            labels[i].setBackground(new Color(214,217,223));
            labels[i].setForeground(new Color(0,0,0));
            labels[i].setEnabled(true);
            labels[i].setFont(new Font("sansserif",0,12));
            labels[i].setOpaque(true);
            labels[i].setVisible(false);
            contentPane.add(labels[i]);
        }
        for(int i = 6; i < 9; i++){
            labels[i] = new JLabel();
            labels[i].setBounds(5 + 90 * (i-6),485,90,90);
            labels[i].setBackground(new Color(214,217,223));
            labels[i].setForeground(new Color(0,0,0));
            labels[i].setEnabled(true);
            labels[i].setFont(new Font("sansserif",0,12));
            labels[i].setOpaque(true);
            labels[i].setVisible(false);
            contentPane.add(labels[i]);
        }
        

        textarea1 = new JTextArea();
        textarea1.setBounds(470,130,200,150);
        textarea1.setBackground(new Color(255,255,255));
        textarea1.setForeground(new Color(0,0,0));
        textarea1.setEnabled(true);
        textarea1.setFont(new Font("sansserif",0,12));
        textarea1.setText("Stanley Jiang GUI Project" + "\n" + "\n" +
        "The goal of this game is to match" + "\n" + "the buttons with their corresponding" + "\n" + "labels!" + "\n" + "\n" +
        "Press a button to get a new color!" + "\n" + 
        "Press check when you are done!");
        textarea1.setBorder(BorderFactory.createBevelBorder(1));
        textarea1.setVisible(true);
        
        chosenGame = 0;

        //adding components to contentPane panel
        
        contentPane.add(button10);
        contentPane.add(button11);
        
        contentPane.add(combobox1);
        contentPane.add(textarea1);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");


        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }
    private void startGame(ActionEvent evt){
        if(chosenGame == 1){
            for(int i = 4; i < 9; i++){
                buttons[i].setVisible(false);
                labels[i].setVisible(false);
            }
            for(int i = 0; i < 4; i++){
                int temp = (int)(Math.random() * 4);
                labelColors[i] = temp;
                if(temp == 0){
                    labels[i].setBackground(new Color(255,0,0));
                    
                }
                else if(temp == 1){
                    labels[i].setBackground(new Color(0,255,0));
                }
                else if(temp == 2){
                    labels[i].setBackground(new Color(0,0,255));
                }
                else if(temp == 3){
                    labels[i].setBackground(new Color(255,255,0));
                }
                labels[i].setVisible(true);
            }
             for(int i = 0; i < 4; i++){
                int temp = (int)(Math.random() * 4);
                buttonColors[i] = temp;
                if(temp == 0){
                    buttons[i].setBackground(new Color(255,0,0));
                }
                else if(temp == 1){
                    buttons[i].setBackground(new Color(0,255,0));
                }
                else if(temp == 2){
                    buttons[i].setBackground(new Color(0,0,255));
                }
                else if(temp == 3){
                    buttons[i].setBackground(new Color(255,255,0));
                }
                buttons[i].setVisible(true);
            }
        }
        else if (chosenGame == 2){
            for(int i = 0; i < 9; i++){
                int temp = (int)(Math.random() * 4);
                labelColors[i] = temp;
                if(temp == 0){
                    labels[i].setBackground(new Color(255,0,0));
                }
                else if(temp == 1){
                    labels[i].setBackground(new Color(0,255,0));
                }
                else if(temp == 2){
                    labels[i].setBackground(new Color(0,0,255));
                }
                else if(temp == 3){
                    labels[i].setBackground(new Color(255,255,0));
                }
                labels[i].setVisible(true);
            }
             for(int i = 0; i < 9; i++){
                int temp = (int)(Math.random() * 4);
                buttonColors[i] = temp;
                if(temp == 0){
                    buttons[i].setBackground(new Color(255,0,0));
                }
                else if(temp == 1){
                    buttons[i].setBackground(new Color(0,255,0));
                }
                else if(temp == 2){
                    buttons[i].setBackground(new Color(0,0,255));
                }
                else if(temp == 3){
                    buttons[i].setBackground(new Color(255,255,0));
                }
                buttons[i].setVisible(true);
            }
        }
    }
    private void gameChoice(ActionEvent evt){
        if(combobox1.getSelectedItem().equals("none selected")){
            chosenGame = 0;
        }
        else if(combobox1.getSelectedItem().equals("2x2 game")){
            chosenGame = 1;
        }
        else if(combobox1.getSelectedItem().equals("3x3 game")){
            chosenGame = 2;
        }
    }
    private void changeColor(ActionEvent evt, int i){
        int temp = (int)(Math.random() * 4);
        buttonColors[i] = temp;
            if(temp == 0){
                    buttons[i].setBackground(new Color(255,0,0));
                }
                else if(temp == 1){
                    buttons[i].setBackground(new Color(0,255,0));
                }
                else if(temp == 2){
                    buttons[i].setBackground(new Color(0,0,255));
                }
                else if(temp == 3){
                    buttons[i].setBackground(new Color(255,255,0));
                }
    }
    private void check(ActionEvent evt){
        if(chosenGame == 1){
            for(int i = 0; i < 4; i++){
                if(labelColors[i] != (buttonColors[i])){
                    textarea1.setText("Incorrect. You lost!" + "\n" + "Press Start Game to play again!");
                    return;
                }
            }
            textarea1.setText("Correct. You win!" + "\n" + "Press Start Game to play again!");
            
                //textarea1.setText("" + labelColors[0] + labelColors[1] + labelColors[2] + labelColors[3] + "\n" + buttonColors[0] + buttonColors[1] + buttonColors[2] + buttonColors[3]);
            
        }
        else if(chosenGame == 2){
            for(int i = 0; i < 9; i++){
                if(labelColors[i] != buttonColors[i]){
                    textarea1.setText("Incorrect. You lost!" + "\n" + "Press Start Game to play again!");
                    return;
                }
            }
            textarea1.setText("Correct. You win!" + "\n" + "Press Start Game to play again!");
            
        }
    }

     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI_project();
            }
        });
    }

}