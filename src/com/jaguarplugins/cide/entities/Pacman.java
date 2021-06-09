package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.maps.Map;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Pacman extends Entity implements EventHandler<KeyEvent> {

	private double xOffset, yOffset, speed = 3;
	
	public Pacman(Map map, double x, double y, double width, double height, Image sprite) {
		super(map, x, y, width, height, sprite);
	}

	@Override
	public void tick() {
		move(xOffset * speed, yOffset * speed);
		
	}

	@Override
	public void handle(KeyEvent e) {
		
		if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
			xOffset = 0;
			yOffset = 1;
		}
		
		if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
			xOffset = 0;
			yOffset = -1;
		}
		
		if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
			xOffset = -1;
			yOffset = 0;
		}
		
		if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D)) {
			xOffset = 1;
			yOffset = 0;
		}
		
	}
	
}