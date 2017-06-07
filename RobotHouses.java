import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class RobotHouses {
	public static void main(String[] args) {
		Robot.setWindowColor(Color.black);
		Robot lilduck =new Robot(0,500); 
		lilduck.setSpeed(10);
		lilduck.turn(90);
		lilduck.penDown();
		lilduck.setPenColor(Color.PINK);
		lilduck.move(100);
		lilduck.turn(-90);
		
		for (int i = 0; i < 10; i++) {
		int duck = new Random().nextInt(400+100) ;	
		lilduck.setRandomPenColor();	
		lilduck.move(duck);
		if(duck<300){
			lilduck.turn(90);
			lilduck.turn(-90);
			
	
		} else {
			
		}
			
		
		lilduck.turn(90);
		lilduck.move(100);
		lilduck.turn(90);
		lilduck.move(duck);
		lilduck.setPenColor(Color.GREEN);
		lilduck.turn(-90);
		lilduck.move(100);
		
		lilduck.turn(-90);
			
		}
		
	
		
		
		
		
	}
}
