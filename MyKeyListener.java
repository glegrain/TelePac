import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Listen to arrow keys to change room
 * 
 * @author Guillaume Legrain 
 * @version 2013-11-18
 */
public class MyKeyListener implements KeyListener
{
    
    private GameEngine engine;
    public MyKeyListener(final GameEngine pGameEngine)
    {
        super();
        engine = pGameEngine;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            engine.interpretCommand("go North");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            engine.interpretCommand("go South");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            engine.interpretCommand("go West");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            engine.interpretCommand("go East");
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
