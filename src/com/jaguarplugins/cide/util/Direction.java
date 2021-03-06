package com.jaguarplugins.cide.util;

public class Direction {

	public static final Direction 
		UP = new Direction(0, -1),
		DOWN = new Direction(0, 1),
		LEFT = new Direction(-1, 0),
		RIGHT = new Direction(1, 0);

	private double xOffset, yOffset;
	
	public Direction(double xOffset, double yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public Direction amplify(double multiplier) {
		return new Direction(xOffset * multiplier, yOffset * multiplier);
	}
	
	public Direction complementary() {
		return new Direction(-xOffset, -yOffset);
	}
	
	public double getxOffset() {
		return xOffset;
	}

	public double getyOffset() {
		return yOffset;
	}
	
	@Override
	public String toString() {
		if (xOffset == 0 && yOffset < 0) {
			return "UP";
		} else if (xOffset == 0 && yOffset > 0) {
			return "DOWN";
		} else if (xOffset > 0 && yOffset == 0) {
			return "RIGHT";
		} else if (xOffset < 0 && yOffset == 0) {
			return "LEFT";
		} else {
			return "UNKNOWN DIRECTION";
		}
	}
	
}
