package com.jaguarplugins.cide.maps;

import java.util.ArrayList;

import com.jaguarplugins.cide.entities.Pellet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map {

	private Rectangle border = new Rectangle (1, 1, 1119, 719);
	private Rectangle[] shapes = {
			
			new Rectangle(80, 80, 400, 80), //Top left
			new Rectangle(80, 80, 80, 400),
			new Rectangle(80, 400, 400, 80),
			new Rectangle(400, 240, 80, 240),
			new Rectangle(240, 240, 240, 80),
			
			new Rectangle(560, 80, 600, 80), //Top right
			new Rectangle(560, 240, 80, 240),
			new Rectangle(560, 400, 320, 80),
			new Rectangle(720, 240, 240, 80),
			new Rectangle(960, 400, 80, 240),
			new Rectangle(1040, 240, 120, 80), // blob
			
			new Rectangle(80, 560, 480, 80), // Bottom left
			
			new Rectangle(640, 560, 240, 80), // bottom right
	
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
		drawRect(g, border);
	}
	
	public boolean intersects(double x, double y, double width, double height) {
		if ((x <= 0 || x + width >= this.width || y <= 0 || y + height >= this.height)) {
			return true;
		}
		for (Rectangle r : shapes) {
			if (r.intersects(x, y, width, height)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Pellet> generatePellets() {
		
		ArrayList<Pellet> pellets = new ArrayList<Pellet>();
		
		for (int x = 1; x <= 14 ; x++) {
			for (int y = 1; y <= 9; y++) {
				if (!intersects(x * 80 - 40, y * 80 - 40, 1, 1)) {
					pellets.add(new Pellet(this, x * 80 - 40, y * 80 - 40));
				}
			}
		}
		
		return pellets;
	
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
