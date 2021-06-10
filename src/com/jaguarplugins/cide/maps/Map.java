package com.jaguarplugins.cide.maps;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map {

	private Rectangle[] shapes = {
			new Rectangle(81, 160, 800, 80),
			new Rectangle(199, 199, 801, 201),
			new Rectangle()
	};
	
	private double width, height;
	
	public Map(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public void render(GraphicsContext g) {
		for (Rectangle r : shapes) {
			drawRect(g, r);
		}
	}
	
	public boolean intersects(double x, double y, double width, double height) {
		for (Rectangle r : shapes) {
			if (r.intersects(x, y, width, height)) {
				return true;
			}
		}
		return false;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	private void drawRect(GraphicsContext g, Rectangle rect) {

		g.setLineWidth(5);
		g.setStroke(Color.WHITE);
		g.strokeRoundRect(rect.getX() - 1, rect.getY() - 1, rect.getWidth() + 2, rect.getHeight() + 2, 10, 10);
		
	}
	
}
