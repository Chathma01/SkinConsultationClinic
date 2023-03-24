import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable { //Implementing Serializable interface to make objects readable for streams
    private String name;
    private String surname;   //instance variables of person class
    private LocalDate dateOfBirth;
    private String mobileNo;

    public Person(String name, String surname, LocalDate dateOfBirth, String mobileNo){  //person constructor
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
    }

    public Person(){

    }

    /**
     Returns first name
     parameters- None
     Return- first name
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     Returns surname
     parameters- None
     Return- surname
     */

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     Returns mobile number
     parameters- None
     Return- mobile number
     */

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     Returns date of birth
     parameters- None
     Return- date of birth
     */

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //public voice getDate
    /**
     a string method with person details
     parameters- None
     Return - String
     */

    public String toString() {
        return "Name: " + name + " " + surname + "  Date of Birth: " + dateOfBirth + "  Mobile No: " + mobileNo;
    }
}
