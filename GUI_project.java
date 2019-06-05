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
import java.util.concurrent.TimeUnit;


public class GUI_project extends JFrame {

    private JMenuBar menuBar;
    private JButton button1;
    private JComboBox combobox1;
    private JPanel panel2;
    private JTextArea textarea1;
    private JLabel[] blocks = new JLabel[240];
   

    //Constructor 
    public GUI_project(){

        this.setTitle("GUI_project");
        this.setSize(600,800);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);
        
        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600,800));
        contentPane.setBackground(new Color(192,192,192));


        button1 = new JButton();
        button1.setBounds(419,495,150,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Start Game");
        button1.setVisible(true);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
               // try{
                startGame(evt);
            //}
            /*catch(InterruptedException ex){
                 button1.setText("Error");
            }*/
              }
          });

        combobox1 = new JComboBox();
        combobox1.setBounds(390,162,150,35);
        combobox1.setBackground(new Color(214,217,223));
        combobox1.setForeground(new Color(0,0,0));
        combobox1.setEnabled(true);
        combobox1.setFont(new Font("sansserif",0,12));
        combobox1.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(19,40,300,720);
        panel2.setBackground(new Color(214,217,223));
        panel2.setForeground(new Color(0,0,0));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        textarea1 = new JTextArea();
        textarea1.setBounds(390,215,150,250);
        textarea1.setBackground(new Color(255,255,255));
        textarea1.setForeground(new Color(0,0,0));
        textarea1.setEnabled(true);
        textarea1.setFont(new Font("sansserif",0,12));
        textarea1.setText("JTextArea");
        textarea1.setBorder(BorderFactory.createBevelBorder(1));
        textarea1.setVisible(true);
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 10; j++){
                blocks[10*i + j] = new JLabel();
                blocks[10*i + j].setBounds(30*j,30*i,30,30);
                blocks[10*i + j].setBackground(new Color(0,0,0));
                blocks[10*i + j].setForeground(new Color(0,0,0));
                blocks[10*i + j].setEnabled(true);
                blocks[10*i + j].setFont(new Font("sansserif",0,12));
                blocks[10*i +j].setOpaque(true);
                blocks[10*i + j].setText("");
                blocks[10*i + j].setVisible(false);
                contentPane.add(blocks[10*i+j]);
                panel2.add(blocks[10*i+j]);
              }
          }

        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(combobox1);
        contentPane.add(panel2);
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
    private void startGame(ActionEvent evt) {
        
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 10; j++){
                blocks[10*i + j].setVisible(true);
              }
          }
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 10; j++){
                
                blocks[10*i + j].setBackground(new Color(255,0,0));
                /*try{
                TimeUnit.SECONDS.sleep(2);
            }
                catch(InterruptedException ex){
                    
                }*/
                /*try{
                blocks[10*i + j].wait();
            }
                catch(InterruptedException ex){
                   blocks[10*i + j].interrupt();
                }
           */   }
              
           try{
           Thread.sleep(10);
             }
           catch(InterruptedException ex){
               Thread.currentThread().interrupt();
              }
             for(int j = 0; j < 10; j++){
               blocks[10*i + j].setForeground(new Color(0,0,0));
            }
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