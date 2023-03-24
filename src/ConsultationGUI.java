import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultationGUI {

    WestminsterSkinConsultationManager WestminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

    JTable docTable = new JTable();
    JFrame frame = new JFrame();
    JLabel docList = new JLabel();

    JPanel docPanel = new JPanel();

    public ConsultationGUI() {

        //setting frame title
        frame.setTitle("Westminster Skin Consultation Clinic");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        //setting image icon
        ImageIcon logo = new ImageIcon("Logo.jpg");
        frame.setIconImage(logo.getImage());

        docList.setText("List of Consultations");
        docList.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        docList.setVerticalAlignment(JLabel.CENTER);
        docList.setHorizontalAlignment(JLabel.CENTER);
        docList.setBounds(300, 30, 550, 50);


        String[] column = new String[]{"Full Name", "DoB", "Mobile No", "Patient ID", "Consultation Date/Time", "Medical Licence No.", "Cost", "Notes"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        tableModel.setColumnIdentifiers(column);

        docTable.setModel(tableModel);
        docTable.setBounds(100, 100, 1000, 400);

        JScrollPane docPane = new JScrollPane(docTable);
        docPane.setBounds(50, 100, 1200, 400);

        for (Consultation c : WestminsterSkinConsultationManager.consultations) {
            tableModel.addRow(new Object[]{c.getName() + " " + c.getSurname(), c.getDateOfBirth(), c.getMobileNo(), c.getPatientId(), c.getDateAndTime(),c.getDocLicenceNo(), c.getTotalCost(), c.getNotes()});
        }

        docPanel.setBackground(Color.white);
        docPanel.setBounds(0, 20, 1300, 600);
        docPanel.setLayout(null);
        docPanel.add(docList);
        docPanel.add(docPane);

        //docPanel.setH

        frame.setSize(1500, 900);        //Set x-dimension and y-dimension
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of the application
        frame.setVisible(true);         //Make the frame visible
        frame.setLayout(null);
        frame.setResizable(false);      //Make frame cannot be resized by the user
        frame.getContentPane().setBackground(Color.decode("#C8AD7E"));
        frame.add(docPanel);

    }
}
