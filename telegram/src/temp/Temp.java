package temp;

import controller.MainController;
import repo.DataBase;
import service.MainService;
import service.MainServiceImpl;

import java.util.Scanner;

public class Temp {

    public static int userId = 1;
    public static int postId = 1;
    public static int likeId = 1;
    public static int viewId = 1;
    public static int commentId = 1;

    public static Scanner scannerNum = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);

    public static DataBase dataBase = new DataBase();
    public static MainServiceImpl mainService = new MainServiceImpl();
    public static MainController mainController = new MainController();

    public static String userPhone;
    public static int currentUserId;

}
