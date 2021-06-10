package com.jaguarplugins.cide.gfx;

import javafx.scene.image.Image;

public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private Image[] frames;
	
	public Animation (int speed, Image[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		lastTime = System.currentTimeMillis();
		timer = 0;
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
//				resets array
				index = 0;
			}
		}
					
	}
	
	public Image getCurrentFrame() {
		return frames[index];
	}
	
}
