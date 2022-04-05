import javax.swing.*;

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
