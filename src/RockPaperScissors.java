import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RockPaperScissors extends JPanel implements ActionListener{
    //2. create an object of the Random class
	Random liljack= new Random();
	
    JFrame window = new JFrame("Rock Paper Scissors");
    JButton rockButton = new JButton();
    JButton paperButton = new JButton();
    JButton scissorsButton = new JButton();
    
    JLabel instructionLabel = new JLabel();
    
    BufferedImage rockImage;
    BufferedImage paperImage;
    BufferedImage scissorsImage;
    
    Dimension buttonDim = new Dimension(300, 200);
    
    public void run(){
        URL url;
        try {
            //1. On the internet, find a picture of a rock, some paper, and scissors. Replace the 
            //   strings below with the URL to your image
            rockImage = ImageIO.read(new URL("https://s-media-cache-ak0.pinimg.com/736x/d3/dc/28/d3dc28c87576e99b5b03aaea9de9fa09.jpg"));  
            paperImage = ImageIO.read(new URL("http://www.lyanpackaging.co.uk/media/catalog/category/CARDBOARD_BOXES_4.jpg")); 
            scissorsImage = ImageIO.read(new URL("https://ae01.alicdn.com/kf/HTB1xn3xKFXXXXbgXVXXq6xXFXXX4/Very-font-b-Cool-b-font-Handmade-Hunting-Karambit-font-b-Knife-b-font-CS-GO.jpg")); 
        } catch (MalformedURLException ex) {
            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rockButton.setIcon(new ImageIcon(rockImage));
        paperButton.setIcon(new ImageIcon(paperImage));
        scissorsButton.setIcon(new ImageIcon(scissorsImage));
        
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        
        rockButton.setPreferredSize(buttonDim);
        paperButton.setPreferredSize(buttonDim);
        scissorsButton.setPreferredSize(buttonDim);
        
        instructionLabel.setText("Choose Your Weapon!");
        
        add(instructionLabel);
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selection = 0;
        
        
        //3. fix the next line so that the opponent's selection is random
        int opponentSelection = liljack.nextInt();
        
        if(e.getSource() == paperButton){
            selection = 1;
        }else if(e.getSource() == scissorsButton){
            selection = 2;
        }
        JOptionPane.showMessageDialog(null, "You chose: " + convertSelection(selection) + ".\n"
                    + "The computer chose: " + convertSelection(opponentSelection) + ".\n");
        
        if(selection == opponentSelection){
            JOptionPane.showMessageDialog(null, "No Winner.  Play again.");
        }else if((selection == 0 && opponentSelection == 2) || 
                 (selection == 1 && opponentSelection == 0) ||
                 (selection == 2 && opponentSelection == 1)){
            JOptionPane.showMessageDialog(null, "You Win!");
        }else{
            JOptionPane.showMessageDialog(null, "You Lose!");
        }
    }
    
    private String convertSelection(int s){
        switch(s){
            case 0: return "ROCK";
            case 1: return "PAPER";
            case 2: return "SCISSORS";
            default: return "";
        }
    }
    
        
    public static void main(String[] args) {
        new RockPaperScissors().run();
    }   
}