package service;

import entity.PostEntity;
import entity.UserEntity;

import java.util.ArrayList;

public interface MainService {

    public boolean login( String phone, String password );

    public boolean register( UserEntity user );

    public void addUser(  );

    public boolean createPost(PostEntity entity);

    public ArrayList<PostEntity> getPostListByUserId();

}
