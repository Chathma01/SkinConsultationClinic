import java.time.LocalDate;

public class Patient extends Person{ //eextends super class person
    private String patientId;

    public Patient(){

    }
//Constructor
    public Patient(String name, String surname, LocalDate dateOfBirth, String mobileNo, String patientId){
        super(name, surname, dateOfBirth, mobileNo);
        this.patientId = patientId;
    }
    /**
     Returns Patient ID
     parameters- None
     Return- patient ID
     */
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
