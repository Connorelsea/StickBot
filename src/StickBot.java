import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.PublicKey;

public class StickBot
{
	public static void main(String[] args)
	{
		new StickBot().run();
	}
	
	public Robot robot;
	public boolean running;
	
	private int count;
	
	public StickBot()
	{
		try
		{
			robot = new Robot();
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}
		
		if (robot != null)
		{
			running = true;
		}
	}
	
	public void run()
	{
		click(new Point(990, 250));
		goHome();
		
		while (running)
		{
			doThis(x ->
			{
				work();
				goHome();
			}, 15);
			
			swole();
			goHome();
			intelligence();
			goHome();
			sleep();
			
			safetyCheck();
    	}
		
		cleanKeys();
	}
	
	public void safetyCheck()
	{
		count++;
		
		if (count > 1000)
		{
			running = false;
		}
	}
	
	public void stop() {
		cleanKeys();
		running = false;
	}
	
	public void goHome()
	{
		System.out.println("[Location] Going home");
		
		doThis(x -> click(new Point(990, 250)), 3);
		doThis(x -> click(new Point(970, 570)), 3);
		
		//Sleep
		doThis(x -> click(new Point(750, 420)), 3);
		
		// Leave sleep
		doThis(x -> click(new Point(975, 517)), 3);
		
		// Leave house
		doThis(x -> click(new Point(970, 520)), 3);
	}
	
	public void work()
	{
		System.out.println("[Location] Going to work");
		
		doThis(x -> click(new Point(970, 520)), 3);
		
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_SHIFT);
		doThis(x -> type(KeyEvent.VK_RIGHT), 27);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_SHIFT);
		doThis(x -> type(KeyEvent.VK_DOWN),  6);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		doThis(x -> type(KeyEvent.VK_DOWN),  1);
		robot.delay(300);
		doThis(x -> type(KeyEvent.VK_RIGHT), 4);
		
		doThis(x -> click(new Point(910, 500)), 5);
		doThis(x -> click(new Point(910, 570)), 3);
	}
	
	public void swole()
	{
		goToSchoolOfStick();
		
		System.out.println("[Location] Going to get swole");
		
		doThis(x ->
		{
			click(new Point(910, 390));
			robot.delay(1500);
		}, 12);
		
		click(new Point(913, 500));
	}
	
	public void intelligence()
	{
		goToSchoolOfStick();
		
		System.out.println("[Location] Going to learn");
		
		doThis(x ->
		{
			click(new Point(720, 435));
			robot.delay(1500);
		}, 12);
		
		click(new Point(913, 500));
	}
	
	public void goToSchoolOfStick()
	{
		System.out.println("[Location] Going to The School of Stick");
		
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_SHIFT);
		doThis(x -> type(KeyEvent.VK_RIGHT),  30);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_SHIFT);
		doThis(x -> type(KeyEvent.VK_DOWN), 13);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_SHIFT);
		doThis(x -> type(KeyEvent.VK_RIGHT), 14);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		doThis(x ->
		{
			type(KeyEvent.VK_DOWN);
			type(KeyEvent.VK_RIGHT);
			doThis(a -> type(KeyEvent.VK_UP), 3);
		}, 5);
	}
	
	public void sleep()
	{
//		click(new Point(750,420));
		click(new Point(1000,600));
	}
	public void doThis(ActionListener event, int times)
	{
		for (int i = 0; i < times; i++)
		{
			event.actionPerformed(null);
		}
	}
	
	public void click(Point p)
	{
		System.out.println("Clicking: (" + p.x + ", " + p.y + ")");
		robot.mouseMove(p.x, p.y);
		robot.delay(30);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(30);
	 	robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(30);
	}
	
	public void cleanKeys()
	{
		System.out.println("Cleaning keys");
		
		robot.keyPress  (KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		robot.keyPress  (KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		
		robot.keyPress  (KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress  (KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
		
		robot.keyPress  (KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
	 
	public void type(int key)
	{
		//System.out.println("Pressing " + KeyEvent.getKeyText(key));
		robot.delay(120);
		robot.keyPress(key);
		robot.delay(120);
		robot.keyRelease(key);
		//robot.delay(120);
	}
}