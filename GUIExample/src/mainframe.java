import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class mainframe extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//save the path/location of the sound to a URL
	URL soundQ = mainframe.class.getResource("sound/bongo0.wav");
	URL soundW = mainframe.class.getResource("sound/bongo1.wav");

	//function to play the sound that accepts the URL object
	 public void playSound(URL soundFile){
	      try 
	      {
	       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
	       Clip clip = AudioSystem.getClip();
	       clip.open(audioInputStream);
	       clip.start();
	      }
	      catch(Exception ex)
	      {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace( );
	      }
	    }
	 
	//constructor/initializer 
	mainframe(){ 
		
		//creating the main frame
		JFrame mframe = new JFrame("Simple GUI Program");
		mframe.setVisible(true);
		mframe.setSize(400,500);
		mframe.setLocationRelativeTo(null);
		mframe.setResizable(true);
		mframe.getContentPane().setBackground(Color.white);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setLayout(null);
		
		//creating the top panel that will contain the image
		JPanel panel_top = new JPanel();
		panel_top.setBounds(0, 0, 400,365);
		panel_top.setBackground(Color.LIGHT_GRAY);
		
		//A JLabel will be used to display the image by
		//setting the image as an icon for the JLabel
		JLabel image1 = new JLabel("");
		image1.setIcon(new ImageIcon(mainframe.class.getResource("/img/doggo1.png")));
		
		//adding an image listener to change the image if mouse is hovered over
		image1.addMouseListener(new MouseAdapter() {
		   
		    //setting the image1 Icon to doggo5 if mouse hovered over doggo1
		    public void mouseEntered(MouseEvent e) {
		    	image1.setIcon(new ImageIcon(mainframe.class.
		    			getResource("/img/doggo5.png")));
		    }
		    
		    //setting the image1 Icon back to doggo1 if mouse hover is over
		    public void mouseExited(MouseEvent e) {
		    	image1.setIcon(new ImageIcon(mainframe.class.
		    			getResource("/img/doggo1.png"))); 	
		    }
		    
		    //sample event when mouse is clicked
		    public void mouseClicked(MouseEvent e) {
		    	image1.setIcon(new ImageIcon(mainframe.class.
		    			getResource("/img/doge.png"))); 	
		    }
		    
		    
		});
		
		//adding image1 to top panel
		panel_top.add(image1);
		
		//creating the bottom panel that will contain a text (JLabel)
		JPanel panel_bottom = new JPanel();
		panel_bottom.setBounds(0, 365, 400,75);
		panel_bottom.setBackground(Color.DARK_GRAY);
		
		//creating label1 and setting text to Press Q or W
		JLabel label1 = new JLabel("Press Q or W ");
		label1.setForeground(Color. white);
		
		//adding label1 to bottom panel
		panel_bottom.add(label1);
		
		
		//creating the credits panel
		JPanel panel_credits = new JPanel();
		panel_credits.setBounds(0, 440, 400,25);
		panel_credits.setBackground(Color.black);
		
		//creating the label for the panel
		JLabel credits = new JLabel("Hover over me!");
		credits.setForeground(Color. white);
		
		//adding a mouselistener to the label
		credits.addMouseListener(new MouseAdapter() {
		    
			//if credits label is clicked, a sample message prompt will appear
		    public void mouseClicked(MouseEvent e) {
		    	JOptionPane.showMessageDialog(mframe,
            			"Message Example: Mouse clicked",
            			"Title",
            			JOptionPane.INFORMATION_MESSAGE);
		    }
		    
		   //if credits label is hovered, a sample warning prompt will appear
		    public void mouseEntered(MouseEvent e) {
		    	JOptionPane.showMessageDialog(mframe,
		    			"Warning Example: Mouse Entered!",
		    			"Warning dialog",
		    			JOptionPane.WARNING_MESSAGE);
		    }
		    
		   //if credits label hover is over, a sample error prompt will appear
		    public void mouseExited(MouseEvent e) {
		    	JOptionPane.showMessageDialog(mframe,
		    			"Error Example. Mouse Exited!",
		    			"Error dialog",
		    			JOptionPane.ERROR_MESSAGE);
		    }
		    
		    
		});
		
		//adding the credits label to the credits panel
		panel_credits.add(credits);

		
		//adding the keylistener for Q and W
		panel_bottom.setFocusable(true);
		panel_bottom.addKeyListener(new KeyAdapter() {
           
            public void keyPressed(KeyEvent e) {
                // Handle key presses within the panel
            	char ch = e.getKeyChar();
                if (ch=='q'){
                	System.out.println("Q pressed");
                	image1.setIcon(new ImageIcon(mainframe.class.getResource("/img/doggo2.png")));
                	playSound(soundQ);
                }
                else if (ch=='w'){
                	System.out.println("W pressed");
                	image1.setIcon(new ImageIcon(mainframe.class.getResource("/img/doggo3.png")));
                	playSound(soundW);
                }
              	
            }
            
            public void keyReleased(KeyEvent e) {
                // Handle key presses within the panel
            	char ch = e.getKeyChar();
                if (ch=='q'){
                	System.out.println("Q released");
                	image1.setIcon(new ImageIcon(mainframe.class.getResource("/img/doggo1.png")));
                	
                }
                else if (ch=='w'){
                	System.out.println("W released");
                	image1.setIcon(new ImageIcon(mainframe.class.getResource("/img/doggo1.png")));
                }
   	
            }
        });
		
		mframe.add(panel_top);
		mframe.add(panel_bottom);
		mframe.add(panel_credits);
		
		
		
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new mainframe();
			}
		});
		
		
	}

	
}
