import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class App
{
    App() {
        JFrame frame = new JFrame("แอปโง่ๆ");
        JButton btn = new JButton("Click");
        JTextField text = new JTextField();
        text.setFont(new Font(null ,Font.PLAIN ,15));
        text.setForeground(Color.BLACK);
        text.setBounds(140,50 ,220,30);
        btn.setBounds(170 ,100 ,100 ,40);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                text.setText("Action Successfully");
            }
        });


        frame.add(btn); frame.add(text);
        frame.setSize(500 ,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        new App();
    }
}