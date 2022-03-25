import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.nio.file.*;
import java.net.*;

public class MyApp {
    Path file = Paths.get("MySwing/src/Log_Data");
    String[] data_box = {"UserAddress", "WebSite"};
    JFrame frame = new JFrame("IP Finder App");
    JButton btn = new JButton("Click");
    JButton btn2 = new JButton("Log Data");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Windows");
    JMenuItem item_windows = new JMenuItem("About");
    JLabel label = new JLabel("IP Finder App");
    JLabel label2 = new JLabel("IPv4:");
    JLabel label3 = new JLabel("UserAddress:");
    JTextField textOut = new JTextField();
    JTextField textOut2 = new JTextField();
    JTextField text = new JTextField();
    JComboBox box = new JComboBox(data_box);

    public MyApp() {

        text.setFont(new Font("Prompt", Font.PLAIN, 15));
        text.setForeground(Color.BLACK);
        text.setBounds(130, 50, 220, 30);
        textOut.setBounds(100, 150, 300, 25);
        textOut2.setBounds(100, 190, 300, 25);

        label.setFont(new Font("Prompt", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        label.setBounds(170, 10, 300, 40);

        label2.setFont(new Font("Prompt", Font.PLAIN, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(48, 142, 300, 40);

        label3.setFont(new Font("Prompt", Font.PLAIN, 15));
        label3.setForeground((Color.BLACK));
        label3.setBounds(3, 182, 300, 40);

        box.setBounds(380, 50, 80, 30);

        btn.setBounds(170, 100, 100, 30);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (box.getItemAt(0) == data_box[0]) {
                    try {
                        InetAddress[] addr = InetAddress.getAllByName(Inet6Address.getLocalHost().getHostName());
                        for(InetAddress a : addr) {
                            textOut2.setText(a.toString());
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (box.getItemAt(1) == data_box[1]) {
                    try {
                        String fromText = text.getText();
                        String ipv4 = Inet4Address.getByName(fromText).getHostAddress();
                        textOut.setText(ipv4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        textOut.setText(null);
                        textOut2.setText(null);
                    } catch (Exception t) {
                        t.printStackTrace();
                    }
                }
            }
        });

        btn2.setBounds(170, 230, 100, 30);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter buffer = Files.newBufferedWriter(file ,StandardCharsets.UTF_8 ,StandardOpenOption.APPEND);
                    String fromText = text.getText();
                    String fromText2 = textOut.getText();
                    String fromText3 = textOut2.getText();
                    buffer.write("My_Log\n");
                    buffer.write("Name => " + fromText + "\n");
                    buffer.write("Ipv4 => " + fromText2 + "\n");
                    buffer.write("UserAddress => " + fromText3 + " ");
                    buffer.write("\n");
                    buffer.newLine();
                    buffer.close();
                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        });

        item_windows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == item_windows) {
                    JOptionPane.showMessageDialog(null ,"Beta Version 1.0 | Developed by EarthStrix");
                }
            }
        });

        frame.add(label2);
        frame.add(label3);
        frame.add(label);
        frame.add(textOut);
        frame.add(textOut2);
        frame.add(btn);
        frame.add(btn2);
        frame.add(text);
        frame.add(box);
        menu.add(item_windows);
        menuBar.add(menu);
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
