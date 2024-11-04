package service;

import entity.*;
import repo.DataBase;
import temp.Temp;

import java.util.ArrayList;

public class MainServiceImpl implements MainService {

    private DataBase dataBase = Temp.dataBase;

    @Override
    public boolean login(String phone, String password) {
        UserEntity user = dataBase.getUserByPhoneNumber(phone);

        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }
        Temp.userPhone = phone;
        Temp.currentUserId = user.getId();
        return true;
    }

    @Override
    public boolean register(UserEntity user) {
        UserEntity entity = dataBase.getUserByPhoneNumber(user.getPhoneNumber());

        if (entity != null) {
            return false;
        }
        user.setId(Temp.userId++);
        dataBase.setUserToList(user);
        Temp.userPhone = user.getPhoneNumber();
        Temp.currentUserId = user.getId();
        return true;
    }


    @Override
    public boolean createPost(PostEntity entity) {
        if (entity.getTitle().isEmpty() || entity.getPost().isEmpty()) {
            return false;
        }

        dataBase.setPostToList(entity);

        return true;
    }

    @Override
    public ArrayList<PostEntity> getPostListByUserId() {
        return dataBase.getPostListByUSerId();
    }

    @Override
    public void addUser() {
        dataBase.addUsers();
    }

    public ArrayList<PostEntity> getAllPosts() {
        return dataBase.getAllPosts();
    }

    public ArrayList<UserEntity> getAllUsers() {
        return dataBase.getAllUsers();
    }

    public boolean like(int id) {
        UserEntity user = dataBase.getUserByPhoneNumber(Temp.userPhone);

        ArrayList<LikeEntity> allLikes = getAllLikes();
        for (LikeEntity like: allLikes){
            if ( id == like.getPostId() && like.getUserId() == Temp.currentUserId ){
                dataBase.deleteLike(like.getUserId());
                return false;
            }
        }

        LikeEntity entity = new LikeEntity(id, Temp.likeId++, user.getId(), user.getFullName());

        dataBase.setLike(entity);
        return true;

    }

    public ArrayList<LikeEntity> getAllLikes() {
        return dataBase.getAllLikes();
    }

    public ArrayList<ViewEntity> getAllViews() {
        return dataBase.getAllViews();
    }

    public void setView(ViewEntity entity){
        dataBase.setView(entity);
    }

    public ArrayList<CommentEntity> getComments() {
        return dataBase.getComments();
    }

    public boolean setComment( int postId, String comment ){
        UserEntity user = dataBase.getUserByPhoneNumber(Temp.userPhone);

        if (comment.isEmpty()){
            return false;
        }

        CommentEntity entity = new CommentEntity(Temp.commentId++, user.getId(), postId, user.getFullName(), comment);

        dataBase.setComments(entity);
        return true;
    }

}
