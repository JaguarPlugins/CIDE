package com.jaguarplugins.cide.entities;

import java.util.ArrayList;

import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.cide.util.Direction;

public class Ghost extends Entity {

	private Pacman target;
	private double speed = 1;
	private Direction[] dirs = { Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT };
	private Direction cd = Direction.RIGHT; // Current direction
	private ArrayList<Direction> lastChoices;
	private int cooldown = 0;
	
	public Ghost(Map map, Pacman target, double x, double y, double width, double height) {
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
				cd = pickRandom(calculateRoutes());
				System.out.println("Options: " + calculateRoutes().size() + "Chosen: " + cd);
				cooldown = 30;
			}
		} else {
			cooldown--;
		}
		
		if (target.intersectsGhost(this)) {
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
	
	private Direction pickRandom(ArrayList<Direction> directions) {
		return directions.get((int) (Math.random() * (directions.size())));
	}

}
