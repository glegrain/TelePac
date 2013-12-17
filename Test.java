import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    private Scanner aSc;
    private GameEngine aEngine;

    public Test(final String pTestFilePath, final GameEngine pGameEngine)
    {
        System.out.println("Starting test ...");
        System.out.println("Opening :" + pTestFilePath);
        this.aEngine = pGameEngine;

        try {
            this.aSc = new Scanner( new File(pTestFilePath) );
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        while( this.aSc != null && aSc.hasNextLine() ) {
            String vCommandString = aSc.nextLine();
            System.out.println("Executing: " + vCommandString);
            this.aEngine.interpretCommand(vCommandString); //FIXME: only the first command is executed
            try {
                //thread to sleep for the specified number of milliseconds
                Thread.sleep(100);
            } catch ( java.lang.InterruptedException ie) {
                System.out.println(ie);
            }

        }
    }
}
