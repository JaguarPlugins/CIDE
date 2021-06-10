package com.jaguarplugins.cide;

import java.util.ArrayList;

import com.jaguarplugins.cide.entities.Pacman;
import com.jaguarplugins.cide.entities.Pellet;
import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.template.GameTemplate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game extends GameTemplate{

	private Map map;
	private Pacman player;
	private ArrayList<Pellet> pellets;
	
	public Game(GraphicsContext g, int fps) {
		super(g, fps);
		map = new Map(1120, 720);
		player = new Pacman(map, 1, 1, 78, 78);
		pellets = map.generatePellets();
	}

	@Override
	protected void tick() {
		
		player.tick();

//		Pacman eating pellets
		for (Pellet p : pellets) {
			if (player.intersectsPellet(p)) {
				pellets.remove(p);
				break;
			}
		}
		
	}

	@Override
	protected void render() {
		
		g.clearRect(0, 0, map.getWidth(), map.getHeight());
		
		g.setFill(Color.BLACK);
		g.fillRect(0, 0, map.getWidth(), map.getHeight());
		
		map.render(g);
		for (Pellet p : pellets) {
			p.render(g);
		}
		player.render(g);
		
	}

	public Pacman getPlayer() {
		return player;
	}
	
}
