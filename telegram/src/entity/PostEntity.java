package entity;

public class PostEntity {

    private int postId;
    private int userId;

    private String title;
    private String post;

    public PostEntity() {
    }

    public PostEntity(int postId, int userId, String title, String post) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.post = post;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
