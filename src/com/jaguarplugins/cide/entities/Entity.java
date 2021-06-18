package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.maps.Map;
import com.jaguarplugins.cide.util.Direction;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Entity {

	protected Map map;
	protected double x, y, width, height;
	protected Image sprite = null;
	
	public Entity(Map map, double x, double y, double width, double height) {
		
		this.map = map;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void tick();
	
	public void render(GraphicsContext g) {
		
		if (sprite != null) {
			g.drawImage(sprite, x, y, width, height);
		} else {
			g.setFill(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
	}
	
	public boolean move(double xOffset, double yOffset) {
		if (!map.intersects(x + xOffset, y + yOffset, width, height)) {
			x += xOffset;
			y += yOffset;
			return true;
		}
		return false;
	}
	
	public boolean move(Direction direction) {
		if (direction == null) {
			return false;
		}
		if (!map.intersects(x + direction.getxOffset(), y + direction.getyOffset(), width, height)) {
			x += direction.getxOffset();
			y += direction.getyOffset();
			return true;
		}
		return false;
	}
	
//	private void rotate(GraphicsContext gc, double angle, double px, double py) {
//        Rotate r = new Rotate(angle, px, py);
//        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
//    }

    /**
     * Draws an image on a graphics context.
     *
     * The image is drawn at (tlpx, tlpy) rotated by angle pivoted around the point:
     *   (tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2)
     *
     * @param g the graphics context the image is to be drawn on.
     * @param angle the angle of rotation.
     * @param tlpx the top left x co-ordinate where the image will be plotted (in canvas co-ordinates).
     * @param tlpy the top left y co-ordinate where the image will be plotted (in canvas co-ordinates).
     */
	
    protected void drawRotatedImage(GraphicsContext g, Image image, double angle, double tlpx, double tlpy, double width, double height) {
        
    	Platform.runLater(() -> {
    		
    		g.save(); // saves the current state on stack, including the current transform
//    		rotate(g, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
//    		g.drawImage(image, tlpx, tlpy, width, height);
    		g.rotate(angle);
    		g.drawImage(image, tlpx, tlpy, width, height);
    		g.restore(); // back to original state (before rotation)
    	
    	});
        
    }

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public boolean intersects(Entity e) {
		return new Rectangle(x, y, width, height).intersects(e.getX(), e.getY(), e.getWidth(), e.getHeight());
	}
	
}
