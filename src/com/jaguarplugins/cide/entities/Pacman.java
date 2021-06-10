package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.gfx.Animation;
import com.jaguarplugins.cide.maps.Map;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Pacman extends Entity implements EventHandler<KeyEvent> {

	private double xOffset, yOffset, speed = 3;
	private Image[] imgs = {
			new Image("com/jaguarplugins/cide/res/open.png"),
			new Image("com/jaguarplugins/cide/res/closed.png")
	};
	private Animation animation;
	
	
	public Pacman(Map map, double x, double y, double width, double height) {
		super(map, x, y, width, height, null);
		animation = new Animation(200, imgs);
	}

	@Override
	public void tick() {
		
		animation.tick();
		move(xOffset * speed, yOffset * speed);
		
	}
	
	@Override
	public void render(GraphicsContext g) {
//		TODO Rotate pacman when you move!!
//		drawRotatedImage(g, sprite, 90, x, y, width, height);
		
		g.drawImage(animation.getCurrentFrame(), x, y, width, height);
		
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