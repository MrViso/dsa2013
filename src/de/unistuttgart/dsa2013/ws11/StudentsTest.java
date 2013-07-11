package de.unistuttgart.dsa2013.ws11;

import de.unistuttgart.dsa2013.ws11.answers.Student;

public class StudentsTest {
	
	public static void main(String[] args) {
		String[] studentNames = new String[] {
				"Ariane",
				"Bert",
				"Christina",
				"Dietrich",
				"Emilie",
				"Ferdinand",
				"Gloria",
				"Hubert",
				"Ingrid",
				"Jan"
		};
		
		Table table = new Table(studentNames.length);
		
		for (String name : studentNames) {
			Student student = new Student(name, table);
			student.startWork();
		}
	}
}
