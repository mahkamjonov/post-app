package entity;

public class ViewEntity {

    private int postId;
    private int viewId;

    public ViewEntity() {
    }

    public ViewEntity(int postId, int viewId) {
        this.postId = postId;
        this.viewId = viewId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }
}
