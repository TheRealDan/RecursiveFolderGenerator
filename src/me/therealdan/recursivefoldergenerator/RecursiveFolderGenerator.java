package me.therealdan.recursivefoldergenerator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RecursiveFolderGenerator extends JFrame implements ActionListener {

    private JTextField minimumLength, maximumLength, totalFolders;

    public RecursiveFolderGenerator() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //
        }

        // VARIABLES
        int width = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Font font = new Font("Source Code Pro", Font.PLAIN, 15);

        // SETUP
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recursive Folder Generator");
        setMinimumSize(new Dimension(width, 300));
        setResizable(false);
        setLocationRelativeTo(null);

        // COMPONENTS
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        JLabel label1 = new JLabel("Minimum folder name length");
        label1.setFont(font);
        label1.setBounds(15, 15, screenSize.width, 25);
        panel.add(label1);
        minimumLength = new JTextField("");
        minimumLength.setFont(font);
        minimumLength.setBounds(15, 40, width - 50, 25);
        panel.add(minimumLength);

        JLabel label2 = new JLabel("Maximum folder name length");
        label2.setFont(font);
        label2.setBounds(15, 65, screenSize.width, 25);
        panel.add(label2);
        maximumLength = new JTextField("");
        maximumLength.setFont(font);
        maximumLength.setBounds(15, 90, width - 50, 25);
        panel.add(maximumLength);

        JLabel label3 = new JLabel("Total folders to generate");
        label3.setFont(font);
        label3.setBounds(15, 115, screenSize.width, 25);
        panel.add(label3);
        totalFolders = new JTextField("");
        totalFolders.setFont(font);
        totalFolders.setBounds(15, 145, width - 50, 25);
        panel.add(totalFolders);

        JButton generateButton = new JButton("Generate");
        generateButton.setFont(font);
        generateButton.setBounds(15, 220, 180, 25);
        generateButton.addActionListener(this);
        panel.add(generateButton);

        add(panel);
        setVisible(true);
    }

    private void run(int minimumLength, int maximumLength, int totalFolders) {
        String path = "";
        while (totalFolders > 0) {
            totalFolders--;
            path += new Name(minimumLength, maximumLength).get() + "/";
            new File(path).mkdir();
        }

        StringBuilder stringBuilder = new StringBuilder(path);
        int i = 0;
        while ((i = stringBuilder.indexOf("/", i + 120)) != -1) {
            stringBuilder.replace(i, i + 1, "\n");
        }

        JOptionPane.showMessageDialog(this, stringBuilder.toString(), "Done.", 1, null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JButton)) return;

        int minimumLength;
        try {
            minimumLength = Integer.parseInt(this.minimumLength.getText());
        } catch (Exception e) {
            minimumLength = 4;
        }

        int maximumLength;
        try {
            maximumLength = Integer.parseInt(this.maximumLength.getText());
        } catch (Exception e) {
            maximumLength = 8;
        }

        int totalFolders;
        try {
            totalFolders = Integer.parseInt(this.totalFolders.getText());
        } catch (Exception e) {
            totalFolders = 1;
        }

        run(minimumLength, maximumLength, totalFolders);
    }

    public static void main(String[] args) {
        new RecursiveFolderGenerator();
    }
}