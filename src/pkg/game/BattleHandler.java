package pkg.game;

import pkg.models.GameObject;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BattleHandler {

    private Queue<GameObject> objects = new LinkedBlockingQueue<>();


    public Queue<GameObject> getObjects() { //GameObjects all stored together in ArrayList
        return objects;
    }

    public void setObjects(Queue<GameObject> objects) {
        this.objects = objects;
    }


    /**
     * Tick() method is called to update/animate the game. Each execution of tick represents a new frame in the game.
     * Thus, it is an essential method for all elements of our game that must be updated.
     */
    public void tick() {
        for (GameObject tempObject : objects) {

            tempObject.tick();
        }


    }

    /**
     * Render() is called to draw objects into our game.
     *
     * @param Graphics g
     */
    public void render(Graphics g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject tempObject) {
        objects.add(tempObject);
    }

    public void removeObject(GameObject tempObject) {
        objects.remove(tempObject);
    }
}


