package Linker;

public class Link {
	private String linkDate;
	private String linkActualLink;
	private String linkAuthorName;

	public Link(String date, String link, String name) {
		this.linkDate = date;
		this.linkActualLink = link;
		this.linkAuthorName = name;
	}

	public String getDate() {return this.linkDate;}
	public String getLink() {return this.linkActualLink;}
	public String getName() {return this.linkAuthorName;}

	public void setDate(String newDate) {this.linkDate = newDate;}
	public void setLink(String newLink) {this.linkActualLink = newLink;}
	public void setName(String newName) {this.linkAuthorName = newName;}
}