package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.cide.util.Direction;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pellet extends Entity {

	public Pellet(Map map, double x, double y) {
		super(map, x, y, 1, 1);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void render(GraphicsContext g) {
		
		g.setFill(Color.ANTIQUEWHITE);
		g.fillOval(x - 4, y - 4, 9, 9);
		
	}

	@Override
	public boolean move(double xOffset, double yOffset) {
//		Stops pellets from being able to move
		return false;
	}
	
	@Override
	public boolean move(Direction direction) {
//		Stops pellets from being able to move
		return false;
	}
	
}
