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
            engine.interpretCommand(CommandWord.GO.toString() + " North");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            engine.interpretCommand(CommandWord.GO.toString() + " South");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            engine.interpretCommand(CommandWord.GO.toString() + " West");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            engine.interpretCommand(CommandWord.GO.toString() + " East");
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
