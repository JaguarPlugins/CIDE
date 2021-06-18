package com.jaguarplugins.cide.entities;

import java.util.ArrayList;

import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.cide.util.Direction;

public class Ghost extends Entity {

	private Entity target;
	private double speed = 2;
	private Direction[] dirs = { Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT };
	private Direction cd = Direction.RIGHT; // Current direction
	private ArrayList<Direction> lastChoices;
	private int cooldown = 0;
	
	public Ghost(Map map, Entity target, double x, double y, double width, double height) {
		super(map, x, y, width, height);
		this.target = target;
	}

	@Override
	public void tick() {
		
		if (cooldown == 1) {
			lastChoices = calculateRoutes();
			cooldown--;
		} else if (cooldown <= 0) {
			if (!calculateRoutes().equals(lastChoices)) {
				cd = pick(calculateRoutes());
				cooldown = 30;
			}
		} else {
			cooldown--;
		}
		
		if (intersects(target)) {
			System.out.println("YOU LOSE");
		}
		
		move(cd.amplify(speed));

		
	}
	
	private ArrayList<Direction> calculateRoutes() {
		
		ArrayList<Direction> possible = new ArrayList<Direction>();
		
		for (Direction d : dirs) {
			if (!map.intersects(x + d.getxOffset(), y + d.getyOffset(), width, height)) {
				possible.add(d);
			}
		}
		
		return possible;
		
	}
	
	private Direction pick(ArrayList<Direction> directions) {
		Direction best = directions.get(0);
		for (Direction d : directions) {
			best = compareDirections(best, d);
			System.out.println("Best: " + best);
		}
		return best;
	}

	private Direction compareDirections(Direction a, Direction b) {
		if (distanceToTarget(x + a.getxOffset(), y + a.getyOffset()) < distanceToTarget(x + b.getxOffset(), y + b.getyOffset())) {
			System.out.println("A");
			return a;
		}
		System.out.println("B");
		return b;

	}
	
	private double distanceToTarget(double xPos, double yPos) {
		System.out.println("" + Math.sqrt(Math.pow(xPos - target.getX(), 2) + Math.pow(yPos - target.getY(), 2)));
		return Math.sqrt(Math.pow(xPos - target.getX(), 2) + Math.pow(yPos - target.getY(), 2));
	}
	
}
