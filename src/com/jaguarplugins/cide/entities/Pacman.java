package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.gfx.Animation;
import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.cide.util.Direction;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Pacman extends Entity implements EventHandler<KeyEvent> {

	private double speed = 4;
	private Direction dir = Direction.DOWN, newDir;
	private Image[] imgs = {
			new Image("com/jaguarplugins/cide/res/open.png"),
			new Image("com/jaguarplugins/cide/res/closed.png")
	};
	private Animation animation;
	
	
	public Pacman(Map map, double x, double y, double width, double height) {
		super(map, x, y, width, height);
		animation = new Animation(200, imgs);
	}

	@Override
	public void tick() {
		
		animation.tick();
		
		if (newDir != null) { 
			if (move(newDir.amplify(speed))) {
				dir = newDir;
				newDir = null;
			}
		}

		move(dir.amplify(speed));
		
	}
	
	@Override
	public void render(GraphicsContext g) {
//		TODO Rotate pacman when you move!!
//		drawRotatedImage(g, animation.getCurrentFrame(), 10, x, y, width, height);
		
		g.drawImage(animation.getCurrentFrame(), x, y, width, height);
		
	}

	@Override
	public void handle(KeyEvent e) {
		
		if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
			newDir = Direction.DOWN;
		}
		
		if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
			newDir = Direction.UP;
		}
		
		if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
			newDir = Direction.LEFT;
		}
		
		if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D)) {
			newDir = Direction.RIGHT;
		}
		
	}
	
}