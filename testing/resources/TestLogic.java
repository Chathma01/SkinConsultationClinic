import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestLogic {
    WestminsterSkinConsultationManager manager;

    @BeforeEach
    void setUp() {
        manager = new WestminsterSkinConsultationManager();
    }

    @Test
    @DisplayName("Checking if the file exist or not")
    public void checkFileExist(){

        File file = new File("doctorListSave.ser");
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Checking if the file is readable or not")
    public void checkFileisReadable(){

        File file = new File("doctorListSave.ser");
        assertTrue(file.canRead());
    }

    @Test
    @DisplayName("Checking if the file is writeable or not")
    public void checkFileisWriteable(){

        File file = new File("doctorListSave.ser");
        assertTrue(file.canWrite());
    }

    @Test
    @DisplayName("Checking if a doctor is removed successfully")
    void removingDoctor() {

        System.out.println("Checking if 007 numbered medical licensed doctor is sucessfully removed or not");
        manager.removeDoctorExtended("007");

        for (Doctor docter: manager.doctors) {
            if (docter.getLicenceNo() == "007") {
                System.out.println("Test Failed");
                assertTrue(false);
                break;
            }
        }
        System.out.println("Test Passed! Doctor removed successfully!");
        assertTrue(true);
    }


}