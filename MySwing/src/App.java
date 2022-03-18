import java.awt.*;
import java.awt.event.*;
import java.net.Inet6Address;
import java.util.*;
import javax.swing.*;

public class App
{
    App() {
        JFrame frame = new JFrame("IP Finder App");
        JButton btn = new JButton("Click");
        JLabel label = new JLabel("IP Finder App");
        JLabel label2 = new JLabel("Ipv4");
        JLabel label3 = new JLabel("Ipv6");
        JTextField textOut = new JTextField();
        JTextField textOut2 = new JTextField();
        JTextField text = new JTextField();

        text.setFont(new Font("Prompt" ,Font.PLAIN ,15));
        text.setForeground(Color.BLACK);
        text.setBounds(140,50 ,220,30);
        textOut.setBounds(100,150 ,300,25);
        textOut2.setBounds(100,190 ,300,25);

        label.setFont(new Font("Prompt" ,Font.PLAIN ,20));
        label.setForeground(Color.BLACK);
        label.setBounds(150 ,10 ,300 ,40);

        label2.setFont(new Font("Prompt" ,Font.PLAIN ,20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(50 ,138 ,300 ,40);

        label3.setFont(new Font("Prompt" ,Font.PLAIN ,20));
        label3.setForeground(Color.BLACK);
        label3.setBounds(50 ,180 ,300 ,40);

        btn.setBounds(170 ,100 ,100 ,30);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String fromText = text.getText();
                    String ip = java.net.InetAddress.getByName(fromText).getHostAddress();
                    String ip6 = java.net.Inet6Address.getByName(fromText).getHostAddress();
                    textOut.setText(ip);
                    textOut2.setText(ip6);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        frame.add(label2); frame.add(label3); frame.add(label); frame.add(textOut); frame.add(textOut2); frame.add(btn); frame.add(text);
        frame.setSize(500 ,500);
        frame.setLayout(null);
        frame.setVisible(true);


    }
    public static void main(String[] args) throws Exception
    {
        new App();
    }
}