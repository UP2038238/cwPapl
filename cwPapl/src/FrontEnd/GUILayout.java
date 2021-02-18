package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import DecisionFiles.*;

public class GUILayout {

    JFrame mainFrame;

    // JPanels
    JPanel mainPanel;
    JPanel bottomPanel;
    JPanel descPanel;
    JPanel quesPanel;
    JPanel imagePanel;

    // JLabels
    JLabel imgLabel;

    // JTextAreas
    JTextArea desc;
    JTextArea ques;

    JTextArea prompt1;
    JTextArea prompt2;
    JTextArea prompt3;

    // JButtons
    JButton choice1;
    JButton choice2;
    JButton choice3;

    DecisionMap house = new DecisionMap();
    DecisionNode node;



    public GUILayout() throws FileNotFoundException {
        buildGUI();
    }



    private void buildGUI() {
        // Initiating JFrame
        mainFrame = new JFrame();
        mainFrame.setSize(800, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Horror Interactive Game");
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);


        ImageIcon icon = new ImageIcon("src/FrontEnd/img/logo.jpg");
        mainFrame.setIconImage(icon.getImage());

        // Initiating main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());



        // Initiating desc&ques panel
        descPanel = new JPanel();
        descPanel.setLayout(new BorderLayout());


        quesPanel = new JPanel();
        quesPanel.setLayout(new BorderLayout());




        // Initiating the textAreas and buttons
        desc = new JTextArea("");
        ques = new JTextArea("");
        desc.setFont(new Font("Serif", Font.BOLD, 30));
        ques.setFont(new Font("Serif", Font.ITALIC, 25));
        desc.setLineWrap(true);
        ques.setLineWrap(true);
        desc.setWrapStyleWord(true);
        ques.setWrapStyleWord(true);
        desc.setEditable(false);
        ques.setEditable(false);



        prompt1 = new JTextArea("");
        prompt2 = new JTextArea("");
        prompt3 = new JTextArea("");
        prompt1.setLineWrap(true);
        prompt2.setLineWrap(true);
        prompt3.setLineWrap(true);
        prompt1.setWrapStyleWord(true);
        prompt2.setWrapStyleWord(true);
        prompt3.setWrapStyleWord(true);
        prompt1.setEditable(false);
        prompt2.setEditable(false);
        prompt3.setEditable(false);

        choice1 = new JButton("");
        choice2 = new JButton("");
        choice3 = new JButton("");



        //giving buttons a layout and add the textAreas to button
        choice1.setLayout(new BorderLayout());
        choice2.setLayout(new BorderLayout());
        choice3.setLayout(new BorderLayout());


        choice1.add(prompt1,BorderLayout.SOUTH);
        choice2.add(prompt2,BorderLayout.SOUTH);
        choice3.add(prompt3,BorderLayout.SOUTH);


        // Adding desc & ques to each panel


        descPanel.add(desc);
        quesPanel.add(ques);


        // Initiating bottom panel & set up grid layout between words & buttons
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3,3,0));



        // Adding buttons to the bottom panel

        bottomPanel.add(choice1);
        bottomPanel.add(choice2);
        bottomPanel.add(choice3);

        // setting background color
        Color bG = Color.decode("#ECECEC");

        desc.setBackground(bG);
        ques.setBackground(bG);


        // adding a picture via Jlabel to top panel

        imagePanel = new JPanel();
        imgLabel = new JLabel();
        imgLabel.setPreferredSize(new Dimension(500,300));
        imagePanel.setBackground(bG);


        BufferedImage img = null;

        if (!house.getimgPath().equals("-")) {
            try {
                img = ImageIO.read(new File(house.getimgPath()));
            } catch (IOException e) {
                e.getMessage();
            }

            Image dimg = img.getScaledInstance(500, 300,
                    Image.SCALE_SMOOTH);

            ImageIcon hse = new ImageIcon(dimg);

            imgLabel.setIcon(hse);
            imagePanel.add(imgLabel);

        } else{
            imagePanel.setVisible(false);
        }

        // Adding desc, ques, image & bottom panels into main panel
        // Adding layoutManagerConstraints

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        mainPanel.add(descPanel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.weighty = 7;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(imagePanel,gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(quesPanel,gbc);



        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 200;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 100;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(bottomPanel,gbc);
        mainPanel.setBackground(bG);


        // Adding mainPanel into mainFrame, then display mainFrame into GUI
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);

    }

    public void EventRuntime() {


        node = house.entryPoint();

        Font pFont = new Font("Serif", Font.BOLD, 20);
        prompt1.setFont(pFont);
        prompt2.setFont(pFont);
        prompt3.setFont(pFont);


        Color b1 = Color.decode("#4E4E50");
        Color b2 = Color.decode("#6B6E70");
        Color b3 = Color.decode("#ADADAD");
        Color font = Color.white;

        choice1.setBackground(b1);
        choice2.setBackground(b2);
        choice3.setBackground(b3);

        prompt1.setBackground(b1);
        prompt2.setBackground(b2);
        prompt3.setBackground(b3);


        prompt1.setForeground(font);
        prompt2.setForeground(font);
        prompt3.setForeground(font);



        choice1.setActionCommand("A");
        choice2.setActionCommand("B");
        choice3.setActionCommand("C");

        choice1.addActionListener(new ButtonClickListener(this));
        choice2.addActionListener(new ButtonClickListener(this));
        choice3.addActionListener(new ButtonClickListener(this));

        update();
    }

    public void update() {

        ArrayList<String> choices = house.getChoices();

        desc.setText(house.getDesc());
        ques.setText(house.getQues());

        prompt1.setText(choices.get(0));
        prompt2.setText(choices.get(1));


        // when 3 choices display 3 buttons, or else 2
        if (choices.size() == 3) {
            prompt3.setText(choices.get(2));
            choice3.setVisible(true);
        } else if (choices.size() == 2){
            choice3.setVisible(false);
        }

        // when no questions, display only one "continue" button
        // when question equals to "End", display one "Restart Button"

        if (house.getQues().equals("-") ){
            choice3.setVisible(false);
            choice2.setVisible(false);
            prompt1.setText("CONTINUE");
        } else if (house.getQues().equals("END")){
            choice3.setVisible(false);
            choice2.setVisible(false);
            prompt1.setText("RESTART");

        } else {
            choice2.setVisible(true);
        }


        // extracting file path from csv for image
        BufferedImage img = null;

        if (!house.getimgPath().equals("-")) {

            try {
                img = ImageIO.read(new File(house.getimgPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert img != null;
            Image dimg = img.getScaledInstance(500, 300,
                    Image.SCALE_SMOOTH);
            ImageIcon hse = new ImageIcon(dimg);

            imgLabel.setIcon(hse);
            imagePanel.add(imgLabel);

        } else {
            imagePanel.setVisible(false);
        }

        // if no file path available, dont display imagePanel

        if(house.getimgPath().equals("-")){
            imagePanel.setVisible(false);
        } else {
            imagePanel.setVisible(true);
        }
    }

    private class ButtonClickListener implements ActionListener {
        GUILayout gui;

        ButtonClickListener(GUILayout gui){
            this.gui = gui;
        }

        public void actionPerformed(ActionEvent e){

            String command = e.getActionCommand();

            try {
                if (command == "A") {
                    house.setChoices("A");
                } else if (command == "B") {
                    house.setChoices("B");
                } else if (command == "C") {
                    house.setChoices("C");
                }
                gui.update();
            }
            catch (InvalidChoiceException iE) {
                iE.getMessage();
            }

        }
    }

}
