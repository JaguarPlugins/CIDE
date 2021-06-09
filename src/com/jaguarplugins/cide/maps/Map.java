package com.jaguarplugins.cide.maps;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Map {

	private Line line = new Line(200, 200, 800, 200);
	
	public void render(GraphicsContext g) {
		g.setFill(Color.BLACK);
		g.fillRect(line.getStartX() - 1, line.getStartY() - 1, line.getEndX() - line.getStartX() + 2, line.getEndY() - line.getStartY() + 2);
	}
	
	public boolean intersects(double x, double y, double width, double height) {
		return line.intersects(x, y, width, height);
	}
	
}
