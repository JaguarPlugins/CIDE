package com.jaguarplugins.cide.ai;

import java.util.ArrayList;

import com.jaguarplugins.cide.entities.Entity;
import com.jaguarplugins.cide.util.Direction;

public interface AI {
	
	public Direction pick(ArrayList<Direction> directions, Entity seeker, Entity target);
	
}
