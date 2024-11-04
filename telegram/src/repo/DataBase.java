package repo;

import entity.*;
import temp.Temp;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<UserEntity> users = new ArrayList<>();

    private ArrayList<PostEntity> posts = new ArrayList<>();

    private ArrayList<LikeEntity> likes = new ArrayList<>();

    private ArrayList<ViewEntity> views = new ArrayList<>();

    private ArrayList<CommentEntity> comments = new ArrayList<>();

    public void setComments( CommentEntity entity) {
        comments.add(entity);
    }

    public ArrayList<CommentEntity> getComments() {
        return comments;
    }

    public boolean setUserToList(UserEntity entity ) {
        if ( entity != null && entity.getPhoneNumber() != null && entity.getId() != 0 ) {
            users.add(entity);
            return true;
        }
        return false;
    }

    public void setPostToList(PostEntity entity) {
        posts.add( entity );
    }

    public void setView( ViewEntity entity ){
        views.add(entity);
    }

    public UserEntity getUserByPhoneNumber( String number ){
        for ( UserEntity u: users ) {
            if ( u.getPhoneNumber().equals( number ) ) {
                return u;
            }
        }
        return null;
    }

    public UserEntity getUserById( int id ) {
        for ( UserEntity u: users ){
            if ( u.getId() == id ){
                return u;
            }
        }
        return null;
    }

    public ArrayList<PostEntity> getPostListByUSerId(  ){
        ArrayList<PostEntity> res = new ArrayList<>();
        for ( PostEntity entity: posts ){
            if ( entity.getUserId() == Temp.currentUserId ){
                res.add( entity );
            }
        }
        return res;
    }

    public ArrayList<PostEntity> getAllPosts() {
        return posts;
    }
    public ArrayList<UserEntity> getAllUsers(){
        return users;
    }

    public void setLike(LikeEntity entity) {
        likes.add( entity );
    }

    public ArrayList<LikeEntity> getAllLikes(){
        return likes;
    }

    public ArrayList<ViewEntity> getAllViews(){
        return views;
    }

    public void deleteLike(int id){
        for (LikeEntity like : likes){
            if (id == like.getUserId()){
                likes.remove(like);
                break;
            }
        }
    }



    public void addUsers() {
        UserEntity user1 = new UserEntity(Temp.userId++, "Ali Aliyev", "934445566", "5566", 20);
        UserEntity user2 = new UserEntity(Temp.userId++, "Vali Valiyev", "901112233", "2233", 25);
        setUserToList(user1);
        setUserToList(user2);
        addPost();
    }

    public void addPost(  ){
        PostEntity post1 = new PostEntity( Temp.postId++, 1, "Hello", "hello world" );
        PostEntity post2 = new PostEntity( Temp.postId++, 2, "Salom", "Salom dunyo men vali" );
        posts.add(post1);
        posts.add(post2);
    }


}
