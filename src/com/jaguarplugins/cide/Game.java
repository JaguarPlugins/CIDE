package com.jaguarplugins.cide;

import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.template.GameTemplate;

import javafx.scene.canvas.GraphicsContext;

public class Game extends GameTemplate{

	private Map map;
	
	public Game(GraphicsContext g, int fps) {
		super(g, fps);
		map = new Map();
	}

	@Override
	protected void tick() {
		
	}

	@Override
	protected void render() {
		
		map.render(g);
		
	}

	

}
