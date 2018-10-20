import Phonebook.Phonebook;

class Test {
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		book.setNewAccount("Garry Mason", "8-952-904");
		book.setNewAccount("Jil Valentine", "7-988-345");
		book.setNewAccount("Harold Cumar", "1-400-345");
		
		book.removeAccountByID(2);
		book.displayAccountByID(3);

		book.display(1);
	}
}
