import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PatientGUI implements ActionListener { //Implements ActionListener Interface to receive action events

    DoctorListGUI DocGUI = new DoctorListGUI();
    WestminsterSkinConsultationManager WestminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

    JButton addPatient = new JButton();
    JButton findCost = new JButton();
    JFrame frame = new JFrame();
    double totalCost;

    //Creating JLable
    JLabel label = new JLabel("Westminster Skin Consultation Clinic");

    //Creating text fields to get patient details

    JTextField nameField = new JTextField();
    JLabel nameLabel = new JLabel("Name:");

    JTextField surnameField = new JTextField();
    JLabel surnameLabel = new JLabel("Surname:");

    JTextField yearOfBirthField = new JTextField();
    JLabel yearOfBirthLabel = new JLabel("Date of birth:       Year:");

    JTextField monthOfBirthField = new JTextField();
    JLabel monthOfBirthLabel = new JLabel("Month:");

    JTextField dayOfBirthField = new JTextField();
    JLabel dayOfBirthLabel = new JLabel("Day:");

    JTextField mobileNoField = new JTextField();
    JLabel mobileNoLabel = new JLabel("Mobile No.:");

    JTextField patientIDField = new JTextField();
    JLabel patientIDLabel = new JLabel("Patient ID:");

    JTextField consNotesField = new JTextField();
    JLabel consNotesLabel = new JLabel("Notes:");


    PatientGUI() {

        //cuztomizing

        frame.setTitle("WestMinster Skin Consultation Clinic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(640, 640);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#C8AD7E"));

        //image icon

        ImageIcon logo = new ImageIcon("Logo.jpg");
        frame.setIconImage(logo.getImage());

        // cuztomizing lables

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 10, 640, 320);

        //Positioning Button, Text fields and their labels

        nameField.setBounds(245, 75, 200, 25);
        nameLabel.setBounds(100, 75, 200, 25);

        surnameField.setBounds(245, 100, 200, 25);
        surnameLabel.setBounds(100, 100, 200, 25);

        yearOfBirthField.setBounds(245, 125, 50, 25);
        yearOfBirthLabel.setBounds(100, 125, 200, 25);
        monthOfBirthField.setBounds(345, 125, 50, 25);
        monthOfBirthLabel.setBounds(300, 125, 50, 25);
        dayOfBirthField.setBounds(445, 125, 50, 25);
        dayOfBirthLabel.setBounds(400, 125, 50, 25);

        mobileNoField.setBounds(245, 150, 200, 25);
        mobileNoLabel.setBounds(100, 150, 200, 25);

        patientIDField.setBounds(245, 175, 200, 25);
        patientIDLabel.setBounds(100, 175, 200, 25);

        consNotesField.setBounds(245, 300, 200, 75);
        consNotesLabel.setBounds(100, 300, 200, 75);

        addPatient.setBounds(145, 400, 150, 50);
        addPatient.addActionListener(this);
        addPatient.setText("Confirm");

        findCost.setBounds(345, 400, 150, 50);
        findCost.addActionListener(this);
        findCost.setText("Find cost");

        //Attaching all the elements to the visible frame

        frame.setTitle("Westminster Skin Consultation Clinic");
        frame.setSize(640, 640);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#C8AD7E"));
        frame.add(label);

        frame.add(nameField);
        frame.add(nameLabel);

        frame.add(surnameField);
        frame.add(surnameLabel);

        frame.add(yearOfBirthField);
        frame.add(yearOfBirthLabel);
        frame.add(monthOfBirthField);
        frame.add(monthOfBirthLabel);
        frame.add(dayOfBirthField);
        frame.add(dayOfBirthLabel);

        frame.add(mobileNoField);
        frame.add(mobileNoLabel);

        frame.add(patientIDField);
        frame.add(patientIDLabel);

        frame.add(consNotesField);
        frame.add(consNotesLabel);

        frame.add(addPatient);
        frame.add(findCost);
        //frame.add(button);
    }

    /**
     Calculates the cost of the user entered consultation hours
     parameters- None
     Return- None
     */
    public void calculatingCost() {

        String id = patientIDField.getText();

        if (id.equals("")) {                //If patientID is null
            new ErrorGUI("Please Enter Patient ID!");              //Sending an error frame
        }
        else {
            int consultHr = DocGUI.checkHour;
            int costPerHour = 0;

            if (consultHr == 1) {
                totalCost = 15;        //calculating the cost of consultation hours
            } else {
                totalCost = 15 + 25 * (consultHr - 1);
            }
        }
        //displays the cost
        JOptionPane.showMessageDialog(null, " Total Cost:  £" + totalCost, "Consultation Cost", JOptionPane.PLAIN_MESSAGE);

    }

    /**
     Getting patient details and adding them in to the consultation array list.
     parameters- None
     Return- None
     */
    public void setAddPatient() {

        //setting user entered values
        String name = nameField.getText();
        String lName = surnameField.getText();
        String dobDate = dayOfBirthField.getText();
        String dobMonth = monthOfBirthField.getText();
        String dobYear = yearOfBirthField.getText();
        String mobNo = mobileNoField.getText();
        String patientID = patientIDField.getText();
        String docML = DocGUI.docML;
        String note = consNotesField.getText();


        int inputDay = Integer.parseInt(dobDate);
        int inputMonth = Integer.parseInt(dobMonth);
        int inputYear = Integer.parseInt(dobYear);

        LocalDate dob = LocalDate.of(inputYear, inputMonth, inputDay);   //Creating LocalDate date of birth objects
        Consultation consultation = new Consultation(name, lName, dob, mobNo, patientID, DocGUI.dateTime, docML, totalCost, note);
        WestminsterSkinConsultationManager.consultations.add(consultation);
        WestminsterSkinConsultationManager.saveConsultationData();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findCost) {
            calculatingCost();

        }
        if(e.getSource() == addPatient){
            setAddPatient();
            new ConsultationGUI();
            frame.setVisible(false);
        }
    }
}






