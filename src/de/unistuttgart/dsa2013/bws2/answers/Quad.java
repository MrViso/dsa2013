package de.unistuttgart.dsa2013.bws2.answers;

import java.util.ArrayList;
import java.util.List;

import de.unistuttgart.dsa2013.bws2.QuadNodeA;
import de.unistuttgart.dsa2013.bws2.QuadNodeB;
import de.unistuttgart.dsa2013.bws2.Town;

public class Quad implements QuadNodeB {

	private double x;
	private double y;
	private double width;
	private double height;
	private int maxTownCount;
	private Quad[] children = null;
	private List<Town> towns = new ArrayList<Town>();

	public Quad(double x, double y, double width, double height,
			int maxTownCount) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxTownCount = maxTownCount;
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public boolean contains(double x, double y) {
		if (this.x == x && this.y == y){
			return true;
		}
		return false;
	}

	@Override
	public void add(Town town) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Town> getTowns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<QuadNodeB> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren() {
		// TODO Auto-generated method stub
		return false;
	}

}
