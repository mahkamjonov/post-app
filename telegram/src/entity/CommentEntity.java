package entity;

public class CommentEntity {

    private int commentId;
    private int userId;
    private int postId;
    private String name;
    private String comment;

    public CommentEntity() {
    }

    public CommentEntity(int commentId, int userId, int postId, String name, String comment) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return commentId;
    }

    public void setId(int id) {
        this.commentId = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
