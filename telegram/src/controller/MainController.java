package controller;

import entity.*;
import service.MainServiceImpl;
import temp.Temp;

import java.util.ArrayList;

public class MainController {

    private MainServiceImpl mainService = Temp.mainService;

    public void authMenu() {
        System.out.println("1. sign in");
        System.out.println("2. sign up");
        System.out.println("0. Exit");
        System.out.print(" Choose: ");
        int menu = Temp.scannerNum.nextInt();
        if (menu == 1) {
            login();
        } else if (menu == 2) {
            register();
        } else if (menu == 0){
            return;
        } else {
            System.out.println("Error");
        }
        authMenu();
    }

    public void mainMenu() {
        System.out.println("1. List");
        System.out.println("2. Create");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Lenta");
        System.out.println("0. Log out");
        System.out.print(" Choose: ");
        int menu = Temp.scannerNum.nextInt();

        switch (menu) {
            case 1: {
                myPostList();
                break;
            }
            case 2: {
                create();
                break;
            }
            case 3: {
                update();
                break;
            }
            case 4: {
                delete();
                break;
            }
            case 5: {
                allPosts();
                break;
            }
            case 0:{return;}
        }

        mainMenu();
    }

    public void create() {
        System.out.print("Post title: ");
        String title = Temp.scannerStr.nextLine();
        System.out.print("Post: ");
        String post = Temp.scannerStr.nextLine();
        PostEntity entity = new PostEntity(Temp.postId++, Temp.currentUserId, title, post);
        boolean res = mainService.createPost(entity);
        if (res) {
            System.out.println("Success");
        } else {
            System.out.println("Post error");
        }
    }

    public void update() {

    }

    private void delete() {

    }

    private void myPostList() {
        ArrayList<PostEntity> myList = mainService.getPostListByUserId();
        for (PostEntity entity : myList) {
            System.out.println("Id: " + entity.getPostId());
            System.out.println("Title: " + entity.getTitle());
            System.out.println("Post: " + entity.getPost());
            System.out.println("----------------------------------------");
        }
    }

    public void allPosts() {

        ArrayList<UserEntity> allUsersList = mainService.getAllUsers();
        ArrayList<PostEntity> allPostList = mainService.getAllPosts();
        ArrayList<LikeEntity> allLikeList = mainService.getAllLikes();
        ArrayList<ViewEntity> allViewsList = mainService.getAllViews();

        for ( PostEntity post: allPostList ){
            System.out.println("---------------------------------------");
            System.out.println( " ID:  " + post.getPostId() );
            System.out.println( " Title: " + post.getTitle() );
            System.out.println("---------------------------------------");
        }
        System.out.print(" Choose post id: "); int postId = Temp.scannerNum.nextInt();

        for (PostEntity postEntity : allPostList) {
            if ( postEntity.getPostId() == postId ) {
                ViewEntity viewEntity = new ViewEntity( postId, Temp.viewId++ );
                mainService.setView(viewEntity);
                for (UserEntity user: allUsersList  ) {
                    if ( postEntity.getUserId() == user.getId() ) {
                        System.out.println("Authors name: " + user.getFullName() );
                    }
                }
                System.out.println("Id: " + postEntity.getPostId());
                System.out.println("Title: " + postEntity.getTitle());
                System.out.println("Post: " + postEntity.getPost());
                int sanoq = 0;
                for (LikeEntity like: allLikeList  ) {
                    if ( postEntity.getPostId() == like.getPostId() ){
                        sanoq++;
                    }
                }
                int viewCount = 0;
                for (ViewEntity v: allViewsList){
                    if ( postEntity.getPostId() == v.getPostId() ){
                        viewCount++;
                    }
                }
                System.out.println(" Likes count: " + sanoq + " -- Views count: " + viewCount);
                System.out.println("----------------------------------------");
            }
        }
        postMenu(postId);
    }

    public void postMenu(int postId) {
        System.out.println("1. Like bosish: ");
        System.out.println("2. Kim like bosgan: ");
        System.out.println("3. Kamment yozish: ");
        System.out.println("4. Kamment ko'rish: ");
        System.out.println("0. Back: ");
        System.out.print("Choose: ");
        int postMenu = Temp.scannerNum.nextInt();
        switch (postMenu) {
            case 1: {
                mainService.like(postId);
                System.out.println("Success");
                break;
            }
            case 2: {
                ArrayList<LikeEntity> allLikes = mainService.getAllLikes();
                for (LikeEntity like: allLikes){
                    if ( postId == like.getPostId() ){
                        System.out.println("--------------------------");
                        System.out.println(" Name: " + like.getName());
                        System.out.println("--------------------------");
                    }
                }
                break;
            }
            case 3: {
                System.out.print("Kamment yozing: ");
                String comment = Temp.scannerStr.nextLine();
                boolean res = mainService.setComment(postId, comment);
                if (res){
                    System.out.println("Success!");
                }
                else {
                    System.out.println("Error!");
                }
                break;
            }
            case 4: {
                ArrayList<CommentEntity> allComments = mainService.getComments();
                for (CommentEntity comment : allComments){
                    if(postId == comment.getPostId()){
                        System.out.println("------------------------");
                        System.out.println(comment.getName());
                        System.out.println(comment.getComment());
                        System.out.println("------------------------");
                    }
                }
            }
        }
    }

    private void login() {
        System.out.print("Enter phone: ");
        String tel = Temp.scannerStr.nextLine();
        System.out.print("Enter password: ");
        String pass = Temp.scannerStr.nextLine();
        boolean res = mainService.login(tel, pass);

        if (!res) {
            System.out.println("Login error");
            authMenu();
        }
        mainMenu();
    }

    public void register() {
        UserEntity userEntity = new UserEntity();
        System.out.print("Enter full name: ");
        userEntity.setFullName(Temp.scannerStr.nextLine());
        System.out.print("Enter phone number: ");
        userEntity.setPhoneNumber(Temp.scannerStr.nextLine());
        System.out.print("Enter password: ");
        userEntity.setPassword(Temp.scannerStr.nextLine());
        System.out.print("Enter age: ");
        userEntity.setAge(Temp.scannerNum.nextInt());

        boolean res = mainService.register(userEntity);
        if (!res) {
            System.out.println("Register error");
            authMenu();
        }
        mainMenu();
    }


    public void addUSer() {
        mainService.addUser();
    }


}
