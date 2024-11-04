import controller.MainController;
import temp.Temp;

public class Main {
    public static void main(String[] args) {

        MainController mainController = Temp.mainController;

        mainController.addUSer();

        mainController.authMenu();

    }
}