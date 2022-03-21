import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.nio.file.*;
import java.util.*;

public class MyApp {

    Path file = Paths.get("MySwing/src/Log_Data");
    String[] data_box = {"Name", "Address"};
    JFrame frame = new JFrame("IP Finder App");
    JButton btn = new JButton("Click");
    JButton btn2 = new JButton("Log Data");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenu menu2 = new JMenu("Windows");
    JMenuItem item = new JMenuItem("Open");
    JMenuItem item2 = new JMenuItem("Save");
    JMenuItem item3 = new JMenuItem("Exit");
    JMenuItem item_windows = new JMenuItem("About");
    JLabel label = new JLabel("IP Finder App");
    JLabel label2 = new JLabel("Ipv4");
    JLabel label3 = new JLabel("Ipv6");
    JTextField textOut = new JTextField();
    JTextField text = new JTextField();
    JComboBox box = new JComboBox(data_box);

    MyApp() {

        text.setFont(new Font("Prompt", Font.PLAIN, 15));
        text.setForeground(Color.BLACK);
        text.setBounds(130, 50, 220, 30);
        textOut.setBounds(100, 150, 300, 25);

        label.setFont(new Font("Prompt", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        label.setBounds(170, 10, 300, 40);

        label2.setFont(new Font("Prompt", Font.PLAIN, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(50, 140, 300, 40);

        btn.setBounds(170, 100, 100, 30);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String fromText = text.getText();
                    String ipv4 = java.net.Inet4Address.getByName(fromText).getHostAddress();
                    textOut.setText(ipv4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setBounds(170, 185, 100, 30);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter bf = Files.newBufferedWriter(file ,StandardCharsets.UTF_8 ,StandardOpenOption.APPEND);
                    Scanner scanner = new Scanner(file);
                    String fromText = text.getText();
                    String fromText2 = textOut.getText();
                    bf.write("My_Log\n");
                    bf.write("Name => " + fromText + "\n");
                    bf.write("Ipv4 => " + fromText2 + " ");
                    bf.write("\n");
                    bf.newLine();
                    bf.close();
                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        });

        frame.add(label2);
        frame.add(label3);
        frame.add(label);
        frame.add(textOut);
        frame.add(btn);
        frame.add(btn2);
        frame.add(text);
        frame.add(box);
        menu.add(item);
        menu.add(item2);
        menu.add(item3);
        menu2.add(item_windows);
        menuBar.add(menu);
        menuBar.add(menu2);
        frame.setJMenuBar(menuBar);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        /*RUN APP*/
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyApp();
            }
        });
    }
}