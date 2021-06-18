package com.jaguarplugins.cide.ai;

import java.util.ArrayList;

import com.jaguarplugins.cide.entities.Entity;
import com.jaguarplugins.cide.util.Direction;

public class Random implements AI {

	@Override
	public Direction pick(ArrayList<Direction> directions, Entity seeker, Entity target) {
		return directions.get((int) (Math.random() * (directions.size())));
	}

}
