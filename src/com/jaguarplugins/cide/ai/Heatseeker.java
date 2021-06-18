package com.jaguarplugins.cide.ai;

import java.util.ArrayList;

import com.jaguarplugins.cide.entities.Entity;
import com.jaguarplugins.cide.util.Direction;

public class Heatseeker implements AI {

	@Override
	public Direction pick(ArrayList<Direction> directions, Entity seeker, Entity target) {
		Direction best = directions.get(0);
		for (Direction d : directions) {
			best = compareDirections(best, d, seeker, target);
		}
		return best;
	}
	
	private Direction compareDirections(Direction a, Direction b, Entity seeker, Entity target) {
		if (distanceToTarget(seeker.getX() + a.getxOffset(), seeker.getY() + a.getyOffset(), target) < distanceToTarget(seeker.getX() + b.getxOffset(), seeker.getY() + b.getyOffset(), target)) {
			return a;
		}
		return b;
	}
	
	private double distanceToTarget(double xPos, double yPos, Entity target) {
		return Math.sqrt(Math.pow(xPos - target.getX(), 2) + Math.pow(yPos - target.getY(), 2));
	}

}
