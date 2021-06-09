package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.maps.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class Entity {

	protected Map map;
	protected double x, y, width, height;
	protected Image sprite;
	
	public Entity(Map map, double x, double y, double width, double height, Image sprite) {
		
		this.map = map;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
	}
	
	public abstract void tick();
	
	public void render(GraphicsContext g) {
		
		if (sprite != null) {
			g.drawImage(sprite, x, y, width, height);
		} else {
			g.setFill(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
	}
	
	public void move(double xOffset, double yOffset) {
		if (!map.intersects(x + xOffset, y + yOffset, width, height)) {
			x += xOffset;
			y += yOffset;
		}
	}
	
}
