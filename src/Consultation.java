import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consultation extends Patient{  //Extends super class Patient
    private LocalDateTime dateAndTime;
    private double totalCost;    //instances for patient class
    private String notes;
    private String docLicenceNo;

    public Consultation(){

    }
//constructor
    public Consultation(String name, String surname, LocalDate dateOfBirth, String mobileNo, String patientId, LocalDateTime dateAndTime, String docLicenceNo , double totalCost, String notes){
        super(name, surname, dateOfBirth, mobileNo, patientId);
        this.dateAndTime = dateAndTime;
        this.docLicenceNo = docLicenceNo;
        this.totalCost = totalCost;
        this.notes = notes;
    }

    /**
     Returns date and time
     parameters- None
     Return- date and time
     */
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    /**
     Returns total
     parameters- None
     Return- patient ID
     */
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     Returns notes
     parameters- None
     Return- notes
     */
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     Returns licence no
     parameters- None
     Return- licence no
     */
    public String getDocLicenceNo() {
        return docLicenceNo;
    }

    public void setDocLicenceNo(String docLicenceNo) {
        this.docLicenceNo = docLicenceNo;
    }
}
