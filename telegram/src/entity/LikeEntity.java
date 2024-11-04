package entity;

public class LikeEntity {

    private int postId;
    private int likeId;
    private int userId;

    private String name;

    public LikeEntity() {
    }

    public LikeEntity(int postId, int likeId, int userId, String name) {
        this.postId = postId;
        this.likeId = likeId;
        this.userId = userId;
        this.name = name;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
