import org.jointheleague.graphical.robot.Robot;

public class HelloWorld {
	public static void main(String[] args) { 
	Robot liljack=new Robot("vic"); 
	
	for (int i = 0; i < 12; i++) {
		liljack.penDown();
		liljack.setSpeed(10);
		liljack.move(100);
		liljack.turn(30);
	}
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
