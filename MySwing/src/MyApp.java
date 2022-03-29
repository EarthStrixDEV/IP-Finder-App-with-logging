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
    Path file = Paths.get("MySwing/src/Log_Data");
    String[] data_box = { "UserAddress", "WebSite" };
    JFrame frame = new JFrame("IP/Address Finder");
    JButton btn = new JButton("Submit");
    JButton btn2 = new JButton("Log Data");
    JButton btn3 = new JButton("Clear Log");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Windows");
    JMenu menu_2 = new JMenu("Help");
    JMenuItem item_windows = new JMenuItem("About");
    JMenuItem item_windows_3 = new JMenuItem("Log Data");
    JMenuItem item_windows_2 = new JMenuItem("Tutorial");
    JLabel label = new JLabel("IP/Address Finder");
    JLabel label2 = new JLabel("IPv4:");
    JLabel label3 = new JLabel("UserAddress:");
    JTextField textOut = new JTextField();
    JTextField textOut2 = new JTextField();
    JTextField text = new JTextField();
    JTextField text_log = new JTextField();
    JComboBox box = new JComboBox(data_box);

    public MyApp() {
        /* set properties component */
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

        label2.setFont(new Font("Prompt", Font.PLAIN, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(48, 142, 300, 40);

        label3.setFont(new Font("Prompt", Font.PLAIN, 15));
        label3.setForeground((Color.BLACK));
        label3.setBounds(3, 182, 300, 40);

        box.setBounds(380, 50, 120, 30);

        btn.setBounds(170, 100, 100, 30);
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
                } else {
                    System.out.printf(null);
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
                            String fromText3 = textOut2.getText();
                            buffer.write("UserAddress => " + fromText3 + "\n");
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
                JFrame show_text = new JFrame();
                show_text.setVisible(true);
                show_text.setSize(600, 500);
                
                try {
                    BufferedReader bfr = new BufferedReader(Files.newBufferedReader(file));
                    String read_text = "";
                    while ((read_text=bfr.readLine()) != null) {
                        
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
        });

        /* create message box */
        item_windows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Beta Version 1.0 | Developed by EarthStrix", "Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        item_windows_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame tutorial = new JFrame("Tutorial App");
                JTextArea show = new JTextArea();
                tutorial.setVisible(true);
                tutorial.setSize(800, 500);
                tutorial.add(show);

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
                show.setFont(new Font("Prompt", Font.PLAIN, 20));
            }
        });

        /* add all component on JFrame */
        frame.add(label2);
        frame.add(label3);
        frame.add(label);
        frame.add(textOut);
        frame.add(textOut2);
        frame.add(btn);
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

    public static void main(String[] args) throws Exception {
        /* RUN APP */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyApp();
            }
        });
    }
}
