package com.jaguarplugins.cide;

import java.util.ArrayList;

import com.jaguarplugins.cide.ai.Heatseeker;
import com.jaguarplugins.cide.ai.Random;
import com.jaguarplugins.cide.entities.Ghost;
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
	private Ghost ghost1, ghost2, ghost3;
	
	public Game(GraphicsContext g, int fps) {
		super(g, fps);
		map = new Map(1120, 720);
		player = new Pacman(map, 1, 1, 78, 78);
		ghost1 = new Ghost(map, player, 321, 1, 78, 78, new Heatseeker());
		ghost2 = new Ghost(map, player, 1041, 641, 78, 78, new Heatseeker());
		ghost3 = new Ghost(map, ghost1, 481, 1, 78, 78, new Random());
		pellets = map.generatePellets();
	}

	@Override
	protected void tick() {
		
		player.tick();
		ghost1.tick();
		ghost2.tick();
		ghost3.tick();
		
//		Pacman eating pellets
		for (Pellet p : pellets) {
			if (player.intersects(p)) {
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
		ghost1.render(g);
		ghost2.render(g);
		ghost3.render(g);
		
	}

	public Pacman getPlayer() {
		return player;
	}
	
}
