package pkg.view;

import pkg.game.OverworldHandler;
import pkg.models.GameObject;
import pkg.models.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Zack (RealTutsGML)
 */
public class KeyInput extends KeyAdapter { //Keeps track of user keystrokes

    OverworldHandler overworldHandler;

    public KeyInput(OverworldHandler overworldHandler) {
        this.overworldHandler = overworldHandler;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject : overworldHandler.getObjects()) {

            if (tempObject instanceof Player) { //movement controls mapped to keys for Player object
                if (key == KeyEvent.VK_W) overworldHandler.setUp(true);
                if (key == KeyEvent.VK_S) overworldHandler.setDown(true);
                if (key == KeyEvent.VK_D) overworldHandler.setRight(true);
                if (key == KeyEvent.VK_A) overworldHandler.setLeft(true);
            }
        }


    }

    public void keyReleased(KeyEvent e) { //key release events immediately stop movement when keys released, for fast, responsive movement
        int key = e.getKeyCode();

        for (GameObject tempObject : overworldHandler.getObjects()) {

            if (tempObject instanceof Player) {
                if (key == KeyEvent.VK_W) overworldHandler.setUp(false);
                if (key == KeyEvent.VK_S) overworldHandler.setDown(false);
                if (key == KeyEvent.VK_D) overworldHandler.setRight(false);
                if (key == KeyEvent.VK_A) overworldHandler.setLeft(false);
            }
        }
    }

}

