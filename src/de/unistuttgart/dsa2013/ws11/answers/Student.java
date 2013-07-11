package de.unistuttgart.dsa2013.ws11.answers;

import de.unistuttgart.dsa2013.ws11.Table;

public class Student implements Runnable {
	private String name;
	private Table table;

	public Student(String name, Table table) {
		this.name = name;
		this.table = table;
	}

	@Override
	public void run() {
		while(true){
			try{
				Thread.sleep((long) 300 + (long) (Math.random()*1000));
				System.out.println(name + " erweitert die Lösung mit dem Bleistift.");
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public void startWork() {
		new Thread(this).start();
	}

}
