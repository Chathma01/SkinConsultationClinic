public class Main {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager wsm = new WestminsterSkinConsultationManager();

        wsm.readFromFile();
        wsm.loadConsultationsData();
        wsm.displayMenu();


    }
}
