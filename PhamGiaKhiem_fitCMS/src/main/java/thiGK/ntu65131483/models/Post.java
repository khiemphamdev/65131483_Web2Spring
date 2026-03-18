package thiGK.ntu65131483.models;

public class Post {
	String id;
	String title;
	String Content;
	int categoryId;
	public Post(String id, String title, String content, int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.Content = content;
		this.categoryId = categoryId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}