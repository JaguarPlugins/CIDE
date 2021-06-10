package com.jaguarplugins.cide.entities;

import com.jaguarplugins.cide.maps.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public abstract class Entity {

	protected Map map;
	protected double x, y, width, height;
	protected Image sprite;
	
	public Entity(Map map, double x, double y, double width, double height, Image sprite) {
		
		this.map = map;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
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
			if (!(x + xOffset < 0 || x + width + xOffset > map.getWidth() || y + yOffset < 0 || y + height + yOffset > map.getHeight())) {	
				x += xOffset;
				y += yOffset;
				return true;
			}
		}
		return false;
	}
	
	private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

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
        
    	g.save(); // saves the current state on stack, including the current transform
        rotate(g, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        g.restore(); // back to original state (before rotation)
        g.drawImage(image, tlpx, tlpy, width, height);
        
    }

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
}
