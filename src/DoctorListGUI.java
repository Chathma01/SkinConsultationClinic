import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class DoctorListGUI implements ActionListener {  //Implements ActionListener Interface to receive action events

    WestminsterSkinConsultationManager WestminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

    JTable docTable = new JTable();
    JFrame frame = new JFrame();
    JButton sortButton = new JButton();
    JLabel docList = new JLabel();
    JPanel docPanel = new JPanel();

    JButton availabilty, addPatient;
    JTextField yearValue;
    JComboBox dayValue, monthValue, minutesValue, hourValue;

    public static LocalDateTime dateTime;
    public static String docML;
    public static int checkHour;

    public DoctorListGUI() {

        frame.setTitle("Westminster Skin Consultation Clinic");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        ImageIcon logo = new ImageIcon("Logo.jpg");
        frame.setIconImage(logo.getImage());

        //customzing lables
        docList.setText("List of Doctors");
        docList.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        docList.setVerticalAlignment(JLabel.CENTER);
        docList.setHorizontalAlignment(JLabel.CENTER);
        docList.setBounds(50, 30, 550, 50);


        String[] column = new String[]{"Full Name", "DoB", "Mobile No", "Medical No.", "Specialization"}; //setting names for column headers
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);  //creating a table
        tableModel.setColumnIdentifiers(column);

        //customizing the table

        docTable.setModel(tableModel);
        docTable.setBounds(100, 100, 500, 400);

        JScrollPane docPane = new JScrollPane(docTable);
        docPane.setBounds(50, 100, 500, 400);

        //adding the values in the doctors array list into the table
        for (Doctor d : WestminsterSkinConsultationManager.doctors) {
            tableModel.addRow(new Object[]{d.getName() + " " + d.getSurname(), d.getDateOfBirth(), d.getMobileNo(), d.getLicenceNo(), d.getSpecialisation(),});
        }

        //customizing a button
        sortButton.setBounds(270, 640, 150, 50);
        sortButton.addActionListener(this);
        sortButton.setText("Sort");
        sortButton.setFocusable(false);
        sortButton.setFont(new Font("Arial", Font.BOLD, 15));
        sortButton.setForeground(Color.white);
        sortButton.setBackground(Color.black);
        sortButton.setBorder(BorderFactory.createEmptyBorder());

        docPanel.setBackground(Color.white);
        docPanel.setBounds(0, 20, 650, 600);
        docPanel.setLayout(null);
        docPanel.add(docList);
        docPanel.add(docPane);

        frame.setSize(1500, 900);        //Set x-dimension and y-dimension
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of the application
        frame.setVisible(true);         //Make the frame visible
        frame.setLayout(null);
        frame.setResizable(false);      //Make frame cannot be resized by the user
        frame.getContentPane().setBackground(Color.decode("#C8AD7E"));
        frame.add(docPanel);

        //values for JComoBoxes
        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] hours = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
        String[] minutes = {"0", "15", "30", "45"};

        //crating JComboBoxes
        dayValue = new JComboBox<>(days);
        monthValue = new JComboBox<>(months);
        hourValue = new JComboBox<>(hours);
        minutesValue = new JComboBox<>(minutes);

        //Creating lables, customizing them and adding them
        JLabel year = new JLabel("Year: ");
        year.setBounds(900, 100, 100, 30);
        year.setFont(new Font("Calibre", Font.BOLD, 20));
        frame.add(year);

        yearValue = new JTextField();
        yearValue.setPreferredSize(new Dimension(250, 40));
        yearValue.setBounds(1000, 100, 150, 40);
        yearValue.setBorder(BorderFactory.createLineBorder(Color.cyan));
        frame.add(yearValue);

        JLabel day = new JLabel("Day: ");
        day.setBounds(900, 150, 100, 30);
        day.setFont(new Font("Calibre", Font.BOLD, 20));
        frame.add(day);

        dayValue.setBounds(1000, 150, 150, 40);
        dayValue.setBackground(Color.white);
        dayValue.setBorder(BorderFactory.createLineBorder(Color.cyan));
        frame.add(dayValue);

        JLabel month = new JLabel("Month: ");
        month.setBounds(900, 200, 100, 30);
        month.setFont(new Font("Calibre", Font.BOLD, 20));
        frame.add(month);

        monthValue.setBounds(1000, 200, 150, 40);
        monthValue.setBackground(Color.white);
        monthValue.setBorder(BorderFactory.createLineBorder(Color.cyan));
        frame.add(monthValue);

        JLabel hour = new JLabel("Hour: ");
        hour.setBounds(900, 250, 100, 30);
        hour.setFont(new Font("Calibre", Font.BOLD, 20));
        frame.add(hour);

        hourValue.setBounds(1000, 250, 150, 40);
        hourValue.setBackground(Color.white);
        hourValue.setBorder(BorderFactory.createLineBorder(Color.cyan));
        frame.add(hourValue);

        JLabel mins = new JLabel("Minutes: ");
        mins.setBounds(900, 300, 100, 30);
        mins.setFont(new Font("Calibre", Font.BOLD, 20));
        frame.add(mins);

        minutesValue.setBounds(1000, 300, 150, 40);
        minutesValue.setBackground(Color.white);
        minutesValue.setBorder(BorderFactory.createLineBorder(Color.cyan));
        frame.add(minutesValue);

        //customising buttons
        availabilty = new JButton("Consult");
        availabilty.addActionListener(this);
        availabilty.setBounds(1000, 350, 150, 30);
        frame.add(availabilty);

        addPatient = new JButton("Add Patient");
        addPatient.addActionListener(this);
        addPatient.setBounds(1000, 400, 150, 30);
        frame.add(addPatient);
        frame.add(sortButton);



    }

    /**
     checking the availability of user selected doctors
     parameters- None
     Return- None
     */

    public void checkAvailability(){

        int checkDate, checkMonth, checkYear, checkMinute,selectedRow;

        checkDate = Integer.parseInt(dayValue.getSelectedItem().toString());
        checkMonth = Integer.parseInt(monthValue.getSelectedItem().toString());
        checkYear = Integer.parseInt(yearValue.getText());
        checkHour = Integer.parseInt(hourValue.getSelectedItem().toString());
        checkMinute = Integer.parseInt(minutesValue.getSelectedItem().toString());

        dateTime = LocalDateTime.of(LocalDate.of(checkYear,checkMonth,checkDate), LocalTime.of(checkHour,checkMinute));

        selectedRow = docTable.getSelectedRow();
        docML = docTable.getModel().getValueAt(selectedRow, 3).toString();

        int i;
        boolean foundDoctor = true;
        if (WestminsterSkinConsultationManager.consultations.size() > 0) {
            for ( i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {
                if (WestminsterSkinConsultationManager.consultations.get(i).getDocLicenceNo().equalsIgnoreCase(docML)) {
                    if (WestminsterSkinConsultationManager.consultations.get(i).getDateAndTime().equals(dateTime)) {
                        foundDoctor = true;
                    }
                    else {
                        foundDoctor = false;
                    }
                }
                else{
                    foundDoctor = false;
                }
            }
            if (foundDoctor) {
                while (foundDoctor) {
                    int random = (int)(Math.random() * WestminsterSkinConsultationManager.doctors.size());

                    for ( i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {
                        if(WestminsterSkinConsultationManager.doctors.get(random).getLicenceNo().equals(WestminsterSkinConsultationManager.consultations.get(i).getDocLicenceNo())){
                            if(WestminsterSkinConsultationManager.consultations.get(i).getDateAndTime().equals(dateTime)){
                                foundDoctor = true;
                            }
                            else {
                                foundDoctor = false;
                            }
                        }
                        else{
                            foundDoctor = false;
                        }
                    }

                    if (!foundDoctor) {
                        docML = WestminsterSkinConsultationManager.doctors.get(i).getLicenceNo();
                        String docName = WestminsterSkinConsultationManager.doctors.get(random).getName()+ " " + WestminsterSkinConsultationManager.doctors.get(random).getSurname();
                        JOptionPane.showMessageDialog(null, "The doctor you selected is not available. Doctor appointed: " + docName, "Consult", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }

            }
            else {
                JOptionPane.showMessageDialog(null, "Your appointment is confirmed", "Consult", JOptionPane.PLAIN_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Your appointment is confirmed(1)", "Consult", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == sortButton ){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(docTable.getModel());
            docTable.setRowSorter(sorter);

            ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(10);
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        if ( e.getSource() == availabilty){
            checkAvailability();
        }

        if ( e.getSource() == addPatient ) {
            new PatientGUI();
            frame.setVisible(false);
        }

    }

}
