package rest_hello_world;

public class Hello {
	private static int id = 1;
	private String text;

	public Hello(String text) {
		this.id = id;
		this.text = text;
		id += 1;
	}

	public int getId() {
		return this.id;
	}

	public String getText() {
		return this.text;
	}
}