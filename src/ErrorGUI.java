import javax.swing.*;

public class ErrorGUI{
    JFrame frame = new JFrame();
    public ErrorGUI(String errorText) {
        JLabel error = new JLabel(errorText);
        frame.setTitle("Error");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,150);
        frame.setVisible(true);
        ImageIcon logo = new ImageIcon("");
        frame.setIconImage(logo.getImage());    //change frame icon
        frame.add(error);
    }
}
