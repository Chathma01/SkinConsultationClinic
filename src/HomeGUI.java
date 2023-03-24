import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeGUI implements ActionListener {  //Implements ActionListener Interface to receive action events
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton button = new JButton();

    HomeGUI() {

        frame.setTitle("WestMinster Skin Consultation Clinic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#C8AD7E"));

        ImageIcon logo = new ImageIcon("Logo.jpg");
        frame.setIconImage(logo.getImage());

        label.setText("Westminster Skin Consultation Clinic");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        label.setIconTextGap(30);
        frame.add(label);
        label.setIcon(logo);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(1000, 140, 150, 50);
        label.setHorizontalAlignment(JLabel.CENTER);

        button.addActionListener(this);
        button.setText("Continue");
        button.setForeground(Color.black);
        button.setFocusable(false);
        button.setBounds(325, 500, 150, 50);
        label.add(button);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            new DoctorListGUI();
            frame.setVisible(false);

        }
    }
}
