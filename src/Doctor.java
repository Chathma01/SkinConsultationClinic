import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Person implements Serializable {  //Implementing Serializable interface to make objects readable for streams
    private String licenceNo;
    private String specialisation; //Instance variables for Doctor

    public Doctor(){

    }
    //constructor
    public Doctor (String name, String surname, LocalDate dateOfBirth, String mobileNo, String licenceNo, String specialisation ){
        super(name, surname, dateOfBirth, mobileNo);
        this.licenceNo = licenceNo;
        this.specialisation = specialisation;
    }

    /**
     Returns Medical Licence Number
     parameters- None
     Return- Medical Licence Number
     */
    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    /**
     Returns Specialization
     parameters- None
     Return- Specialization
     */

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    /**
     return Doctor details
     Parameters- None
     Return- String containing doctor information
     */
    public String toString() {
        return super.toString() + " LicenceNo: " + licenceNo + "  Specialisation: " + specialisation;
    }
}
