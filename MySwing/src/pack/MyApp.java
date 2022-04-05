package pack;
/* 
    > นาย วราพล จิตสุข
    > 6430300862 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.nio.file.*;
import java.net.*;

public class MyApp {
    /* create object component widget */
    Path file = Paths.get("MySwing/src/pack/Log_Data");
    String[] data_box = { "UserAddress", "WebSite Address" };
    JFrame frame = new JFrame("IP/Address Finder");
    JButton btn = new JButton("Submit");
    JButton btn2 = new JButton("Log Data");
    JButton btn3 = new JButton("Clear Log");
    JButton btn4 = new JButton("Delete All");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Windows");
    JMenu menu_2 = new JMenu("Help");
    JMenuItem item_windows = new JMenuItem("About");
    JMenuItem item_windows_3 = new JMenuItem("Log Data");
    JMenuItem item_windows_2 = new JMenuItem("Tutorial");
    JLabel label = new JLabel("IP/Address Finder");
    JLabel label2 = new JLabel("IP Address:");
    JLabel label3 = new JLabel("UserAddress:");
    JTextField textOut = new JTextField();
    JTextField textOut2 = new JTextField();
    JTextField text = new JTextField();
    JComboBox box = new JComboBox(data_box);

    public MyApp() {
        /* set attribute component */
        text.setFont(new Font("Prompt", Font.PLAIN, 15));
        text.setForeground(Color.BLACK);
        text.setBounds(130, 50, 220, 30);
        textOut.setFont(new Font("Prompt", Font.PLAIN, 15));
        textOut.setBounds(100, 150, 300, 30);
        textOut2.setFont(new Font("Prompt", Font.PLAIN, 15));
        textOut2.setBounds(100, 190, 300, 30);

        label.setFont(new Font("Prompt", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        label.setBounds(155, 10, 300, 40);

        label2.setFont(new Font("Prompt", Font.PLAIN, 15));
        label2.setForeground(Color.BLACK);
        label2.setBounds(20, 142, 300, 40);

        label3.setFont(new Font("Prompt", Font.PLAIN, 15));
        label3.setForeground((Color.BLACK));
        label3.setBounds(3, 182, 300, 40);

        box.setBounds(380, 50, 120, 30);

        btn.setBounds(170, 100, 100, 30);
        
        /* Button ActionListener */
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.getItemAt(0) == box.getSelectedItem()) {
                    try {
                        /* get User address from class InetAddress */
                        InetAddress[] addr = InetAddress.getAllByName(Inet6Address.getLocalHost().getHostName());
                        for (InetAddress a : addr) {
                            textOut2.setText(a.toString());
                        }
                        InetAddress ipv4_user = InetAddress.getLocalHost();
                        textOut.setText(ipv4_user.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (box.getItemAt(1) == box.getSelectedItem()) {
                    try {
                        /* get Ipv4 from class InetAddress */
                        String fromText = text.getText();
                        String ipv4 = Inet4Address.getByName(fromText).getHostAddress();
                        textOut.setText(ipv4);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btn2.setBounds(170, 230, 100, 30);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter buffer = Files.newBufferedWriter(file, StandardCharsets.UTF_8,
                            StandardOpenOption.APPEND);
                    if (box.getItemAt(0) == box.getSelectedItem()) {
                        try {
                            String fromText = textOut.getText();
                            String fromText3 = textOut2.getText();
                            buffer.newLine();
                            buffer.write("UserHostAddress => " + fromText3 + "\n");
                            buffer.write("UserIPAddress => " + fromText + "\n");
                            buffer.newLine();
                            buffer.close();
                            JOptionPane.showMessageDialog(null, "Write Logging Complete!");
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                    } else if (box.getItemAt(1) == box.getSelectedItem()) {
                        try {
                            String fromText = text.getText();
                            String fromText2 = textOut.getText();
                            buffer.newLine();
                            buffer.write("My_Log\n");
                            buffer.write("Name => " + fromText + "\n");
                            buffer.write("Ipv4 => " + fromText2 + "\n");
                            buffer.newLine();
                            buffer.close();
                            JOptionPane.showMessageDialog(null, "Write Logging Complete!");
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                    } else {
                        System.out.printf(null);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn3.setBounds(170, 270, 100, 30);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String info = "Warapon Jitsook 6430300862";
                    File getFile = new File("MySwing/src/pack/Log_Data");
                    FileWriter fw = new FileWriter(getFile, false);
                    PrintWriter pw = new PrintWriter(fw, false);
                    fw.write(info);
                    pw.flush();
                    pw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null ,"Delete log data Complete!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }  
            }
        });
        
        btn4.setBounds(420, 152, 90, 30);
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String blank = "";
                textOut.setText(blank);
                textOut2.setText(blank);
                text.setText(blank);    
            }
        });

        /* MenuItem ActionListener */
        item_windows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "BETA Version 1.0 | Developed by EarthStrix");
            }
        });

        item_windows_2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                JFrame tutorial = new JFrame("Tutorial App");
                JTextArea show = new JTextArea();
                tutorial.setVisible(true);
                tutorial.setSize(800, 500);
                tutorial.add(show);
                show.setBounds(0, 0, 800, 1000);

                String text_container = "How To Use IP/Address Finder\n"
                        + "\n"
                        + "1.Choose your function Website/UserAddress on Checkbox\n"
                        + "2.Enter name website\n"
                        + "3.Press click button for show result\n"
                        + "4.Press Log Data button for save your result on file's App\n"
                        + "5.If you select UserAddress ,You can submit button without enter name website\n"
                        + "\n"
                        + "Thank For Used my app :)\n";
                show.setText(text_container);
                show.setEditable(false);
                show.setFont(new Font("Prompt", Font.PLAIN, 20));
            }
        });

        item_windows_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame show_text = new JFrame("Log Data");
                JPanel panel = new JPanel();
                JTextArea text_log = new JTextArea();
                JScrollPane scroll = new JScrollPane(text_log);
                text_log.setFont(new Font("Prompt", Font.PLAIN, 18));
                text_log.setEditable(false);

                show_text.getContentPane().add(scroll);
                show_text.setLocationRelativeTo(null);

                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                panel.add(scroll);
                show_text.add(panel);
                show_text.setVisible(true);
                show_text.setSize(800, 750);

                try {
                    BufferedReader bfr = Files.newBufferedReader(file);
                    String read_text = "" ,read_line = "";
                    while ((read_text = bfr.readLine()) != null) {
                        read_line += read_text + "\n";
                    }
                    text_log.setText(read_line);
                    bfr.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        /* add all component to JFrame */
        frame.add(label2);
        frame.add(label3);
        frame.add(label);
        frame.add(textOut);
        frame.add(textOut2);
        frame.add(btn);
        frame.add(btn4);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(text);
        frame.add(box);
        menu.add(item_windows_3);
        menu.add(item_windows);
        menu_2.add(item_windows_2);
        menuBar.add(menu);
        menuBar.add(menu_2);
        frame.setJMenuBar(menuBar);
        frame.setSize(550, 450);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
