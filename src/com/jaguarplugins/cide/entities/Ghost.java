package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.maps.Map;

public class Ghost extends Entity {

	private Pacman target;
	
	public Ghost(Map map, Pacman target, double x, double y, double width, double height) {
		super(map, x, y, width, height);
		this.target = target;
	}

	@Override
	public void tick() {
		
		if (target.intersectsGhost(this)) {
			System.out.println("YOU LOSE");
		}
		
		

	}

}
