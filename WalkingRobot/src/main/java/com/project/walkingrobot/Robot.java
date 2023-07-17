package com.project.walkingrobot;

public class Robot {
    private int x;
    private int y;
    private boolean penDown;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPenDown() {
        return penDown;
    }

    public void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private Direction direction;

    public Robot() {
        x = 0;
        y = 0;
        penDown = false;
        direction = Direction.NORTH;
    }

    public void move(int steps) {
        if (steps <= 0) {
            throw new IllegalArgumentException("Invalid number of steps: " + steps);
        }
        switch (direction) {
            case NORTH -> y += steps;
            case EAST -> x += steps;
            case SOUTH -> y -= steps;
            case WEST -> x -= steps;
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case NORTH -> direction = Direction.WEST;
            case EAST -> direction = Direction.NORTH;
            case SOUTH -> direction = Direction.EAST;
            case WEST -> direction = Direction.SOUTH;
        }
    }

    public void printPosition() {
        String penStatus = penDown ? "down" : "up";
        System.out.println("Position: " + x + ", " + y + " - Pen: " + penStatus + " - Facing: " + direction);
    }

}
