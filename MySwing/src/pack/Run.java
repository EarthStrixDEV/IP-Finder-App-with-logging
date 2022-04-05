package pack;
import javax.swing.*;
/* 
    > นาย วราพล จิตสุข
    > 6430300862 
*/
public class Run {
    public static void main(String[] args) throws Exception {
        /* RUN APP */
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MyApp();
            }
        });
    }
}
