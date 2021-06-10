package com.jaguarplugins.cide;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Canvas canvas = new Canvas(1200, 800);
		GraphicsContext g = canvas.getGraphicsContext2D();
		Game game = new Game(g, 60);
		Scene scene = new Scene(new Group(canvas));
		
		primaryStage.setTitle("Alex Gray's CIDE Artefact: Pacman");
		primaryStage.setScene(scene);
		primaryStage.setWidth(1200 + 6);
		primaryStage.setHeight(800 + 29);
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(e -> {
			game.interrupt();
		});
		
		scene.setOnKeyPressed(game.getPlayer());
		game.start();
		
		primaryStage.show();
		
	}

}
