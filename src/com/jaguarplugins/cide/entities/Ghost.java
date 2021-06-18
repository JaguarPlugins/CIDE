package com.jaguarplugins.cide.entities;

import java.util.ArrayList;

import com.jaguarplugins.cide.ai.AI;
import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.cide.util.Direction;

public class Ghost extends Entity {

	private Entity target;
	private double speed = 2;
	private Direction[] dirs = { Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT };
	private Direction cd = Direction.RIGHT; // Current direction
	private ArrayList<Direction> lastChoices;
	private int cooldown = 0;
	private AI ai;
	
	public Ghost(Map map, Entity target, double x, double y, double width, double height, AI ai) {
		super(map, x, y, width, height);
		this.target = target;
		this.ai = ai;
	}

	@Override
	public void tick() {
		
		if (cooldown == 1) {
			lastChoices = calculateRoutes();
			cooldown--;
		} else if (cooldown <= 0) {
			if (!calculateRoutes().equals(lastChoices)) {
				cd = ai.pick(calculateRoutes(), this, target);
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
	
}
