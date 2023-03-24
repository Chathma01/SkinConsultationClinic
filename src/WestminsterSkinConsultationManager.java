import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {

    public static ArrayList<Doctor> doctors = new ArrayList<>();  //Creating an arraylist to stores doctors' details
    public static ArrayList<Consultation> consultations = new ArrayList<Consultation>(); //Creating an arraylist to consultation details

    public WestminsterSkinConsultationManager() {

    }

    /**
     * Menu of the program. User input a menu option of their choice
     * Menu loops until the user enter Q/q to exit
     */

    public void displayMenu() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------Welcome to Westminster Skin Consultation Manager.----------------------------");
            System.out.println("    A : ADD NEW DOCTOR");
            System.out.println("    R : REMOVE DOCTOR");
            System.out.println("    S : SAVE DATA TO FILE");
            System.out.println("    P : PRINT THE LIST OF DOCTORS");
            System.out.println("    G : LAUNCH GRAPHICAL USER INTERFACE");
            System.out.println("    Q : QUIT THE PROGRAM");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Please Enter A Valid Menu Option: ");

            char userInput = input.next().toLowerCase().charAt(0);
            switch (userInput) {
                case 'a':                  //Calling methods according the user selection
                    this.addDoctor();
                    break;
                case 'r':
                    this.removeDoctor();
                    break;
                case 's':
                    this.writeToFile();
                    break;
                case 'p':
                    this.printDoctor();
                    break;
                case 'g':
                    new HomeGUI();
                    break;
                case 'q':
                    System.out.print("Exiting the program.............."); //Exiting the program
                    System.exit(0);
                default:
                    System.out.print("Invalid menu option!!! Please try again."); //When the user enters an invalid input
                    input.nextLine();
                    break;
            }
        }


    }


    @Override
    /**
     Take information of doctors, validates the input and add them to doctors array list.
     parameters- None
     Return- None
     */
    public void addDoctor() {
        Scanner input = new Scanner(System.in);
        String name, surname, mobile, licenceNo, specialization;
        LocalDate dob;
        int year, month, day;
        boolean condition = false;
        while (doctors.size() != 10) {  //max of doctor list
                while (true) {
                    System.out.print("Enter The Doctor's First Name: ");  //Takes and validate the first name
                    name = input.nextLine();
                    if (name.equals("") || name.equals(" ")) {
                        System.out.println("The First Name Field Cannot Be Empty");
                        continue;
                    }
                    break;
                }
                while (true) {
                    System.out.print("Enter The Doctor's Surname: ");
                    surname = input.nextLine();
                    if (surname.equals("") || surname.equals(" ")) {              //Takes and validate the surname
                        System.out.println("The Surname Field Cannot Be Empty");
                        continue;
                    }
                    break;
                }
                while (true) {
                    try {
                        System.out.print("Enter The Doctor's Year Of Birth: ");
                        year = input.nextInt();

                        System.out.print("Enter The Doctor's Month Of Birth: ");  //Takes and validate the year,month,day
                        month = input.nextInt();

                        System.out.print("Enter The Doctor's Day Of Birth: ");
                        day = input.nextInt();

                        dob = LocalDate.of(year, month, day);
                        input.nextLine();
                        break;
                    } catch (DateTimeException e) {
                        System.out.println("Invalid input");
                    } catch (InputMismatchException e) {     //exception handling
                        System.out.println("Invalid input");
                    }
                    input.nextLine();
                }
                while (true) {
                    System.out.print("Enter The Doctors Mobile Number: ");      //Takes and validate the mobile number
                    mobile = input.nextLine();
                    if (mobile.equals("") || mobile.equals(" ")) {
                        System.out.println("The Mobile Number Field Cannot Be Empty");
                        continue;
                    }
                    break;
                }
                while (true) {
                    System.out.print("Enter The Doctor's Medical License Number: ");        //Takes and validate the licence number
                    licenceNo = input.nextLine();
                    if (licenceNo.equals("") || licenceNo.equals(" ")) {
                        System.out.println("The Medical License Number Field Cannot Be Empty");
                        continue;
                    }
                    break;
                }
                while (true) {
                    System.out.print("Enter The Doctor's Specialization: ");  //Takes and validate the specialization
                    specialization = input.nextLine();
                    if (specialization.equals("") || specialization.equals(" ")) {
                        System.out.println("The Specialization Field Cannot Be Empty");
                        continue;
                    }
                    break;
                }
                Doctor doctor = new Doctor(name, surname, dob, mobile, licenceNo, specialization);  //creating a doctor object to pass data
                doctors.add(doctor); //add the doctor
                System.out.println("The record input is successful!");

                    System.out.print("Do you want to continue? \n Enter \'Y\' to continue or \'N\' to quit: ");
                    String userInput = input.nextLine();

                    if (userInput.equals("y")) {
                        addDoctor();
                    } else if (userInput.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Invalid input!! Please try again!");
                        continue;
                    }
                    input.nextLine();

        }
        if(doctors.size() == 10) {
            System.out.println("The doctor list is full");

        }

    }

    @Override
    /**
     Deletes the doctor record according to the licence number entered by the user, displays the details of the removed doctor
     parameters- None
     Return- None
     */
    public void removeDoctor() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the medical license number of the doctor to remove: ");
        String licenseNo = input.nextLine();

        boolean x = false;
        for (Doctor d : doctors) {
            if (d.getLicenceNo().equals(licenseNo)) { //finding the licence number
                System.out.println("Deletion successful");
                x = true;
                System.out.println(d.toString());
                System.out.println("The above record is successfully deleted");
                doctors.remove(d);
                break;
            }
        }
        if (x == false) {
            System.out.println("No match found!");
        }
        writeToFile(); //writing the latest doctor list to the file
    }

    public void removeDoctorExtended(String licenseNo) {

    }

    /**
     * print the list of doctors' details sorted according to their surnames
     * parameters- None
     * Return- None
     */
    @Override
    public void printDoctor() {

        ArrayList<Doctor> tempDoctors = (ArrayList) doctors.clone(); //creating a clone of the doctors list

        Collections.sort(tempDoctors, new Comparator<Doctor>() { //comparison
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareToIgnoreCase(d2.getSurname());
            }
        });
        for (int i = 0; i < tempDoctors.size(); i++) { //displaying the sorted doctor list
            System.out.println(tempDoctors.get(i).toString());
            //System.out.println("Name: " + tempDoctors.get(i).getName() + " " + tempDoctors.get(i).getSurname() +  "Mobile No: " + tempDoctors.get(i).getMobileNo() + "Date Of Birth: " + tempDoctors.get(i).getDateOfBirth() + "Licence No: " + tempDoctors.get(i).getLicenceNo() + "Specialisation: " + tempDoctors.get(i).getSpecialisation());
        }
    }

    @Override
    /**
     saves the doctor array list in to the file
     parameters- None
     Return- None
     */
    public void writeToFile() {

        try {
            FileOutputStream fos = new FileOutputStream("doctorListSave.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(doctors);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("The data is successfully saved to file!");

    }

    @Override
    /**
     read from the file and add data into the doctors arraylist
     parameters- None
     Return- None
     */
    public void readFromFile() {

        try {
            FileInputStream fis = new FileInputStream("doctorListSave.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            doctors = (ArrayList) ois.readObject(); //read object and store into arraylist

            System.out.println("Doctor details Data Has Been Loaded Successfully");
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();  //exception handling
            return;

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
            return;
        }

    }

    @Override
    /**
     saves the consultation details list in to the file
     parameters- None
     Return- None
     */
    public void saveConsultationData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("consultationData.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (Consultation c : consultations) {
                out.writeObject(c); // writing doctor object into output stream
            }
            out.close();
            fileOut.close();
            System.out.println("Consultation data Has Been Stored Successfully ");
        } catch (IOException e) {                          //exception handling
            System.out.println("Something Went Wrong !");
            e.printStackTrace();
        }
    }

    @Override
    public void loadConsultationsData() {
        try {
            FileInputStream fileIn = new FileInputStream("consultationData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
                /*for (Consultation c : consultations) {
                   // consultations.add(c);
                   // in.readObject();
                }*/
            consultations.add((Consultation) in.readObject());

            System.out.println("Consultation Data Has Been Loaded Successfully ");
                in.close();
                fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data Has Not Been Stored Yet");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}