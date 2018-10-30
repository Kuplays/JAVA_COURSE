package ru.sibguti.Phonebook;

import java.lang.reflect.*;

class Test {
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		book.setNewIndividual("Garry Mason", "8-952-904", "7323242211");
		book.setNewIndividual("Jil Valentine", "7-988-345", "2221244272");
		book.setNewIndividual("Harold Cumar", "1-400-345", "67657821111");
		book.setNewLegal("Donald Trump", "1-496-9092-12", "11111111111");
		book.setNewLegal("Дядя Толик", "8-800-555-3535", "98723121111");

		book.display(0);
		Object[] objs = new Object[2];
		objs[0] = (Object)(new Individual("sadsd", "asdasd", "asdasdas"));
		Class cl = ((Individual) objs[0]).getClass();
		Field[] field = cl.getFields();
		System.out.println("\n\nCLASS NAME: " + cl.getName() + "\n\n");
		for (int i = 0; i < field.length; i++)
			System.out.println(field[i]);
	}
}
