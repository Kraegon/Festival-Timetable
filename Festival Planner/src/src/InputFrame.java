import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class InputFrame extends JFrame{
	
	
	String source;
	
	
public InputFrame(String source, Point sourcePoint){

		   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		   JPanel contentPane = new JPanel(new BorderLayout(10, 10));
	       contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	       setLocation(new Point(100, 100));
	       setSize(300, 400);
	       setContentPane(contentPane);
	       setLocation(new Point(100, 100));
	       setVisible(true);
	
		this.source = source;
		
		switch(source){
		case "Obstakel":
			//ArtistPanel aPanel = new ArtistPanel();
			Obstakel();
		}		}

public void Obstakel()
{
	final JComponent[] comps = new JComponent[]{
			new JLabel("Name: "),new JLabel ("Hoogte: "),new JLabel ("Breedte: "), new JLabel ("collidable: "),
			new JTextField("name"),	new JTextField("10"), new JTextField("10"), new JTextField("true")
	};
	JPanel leftPane = new JPanel(new GridLayout(3,1));
	JPanel rightPane = new JPanel(new GridLayout(3,1));
	for(JComponent component : comps){
		if(component.getClass() == JLabel.class){
			leftPane.add(component);
		} else {
			rightPane.add(component);
		}
	}
	
	JPanel okPane = new JPanel(new FlowLayout());
	JButton ok = new JButton("OK");
	okPane.add(ok);
	ok.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
			{	
				int aantalVelden = 4;
				JTextField name = (JTextField) comps[aantalVelden];
				File file = new File("Objecten/"+name.getText() + ".object");
				FileWriter Output = new FileWriter(file);
				PrintWriter out = new PrintWriter(Output);
				int counter = aantalVelden;
				
				 	for(JComponent component : comps){
				 		
					if(component.getClass() != JLabel.class){
						JTextField compTemp = (JTextField) comps[counter];
						out.println(compTemp.getText());
						counter++;
					} 
				}
				
				
			
				out.close();
				
				dispose();
				
			}
			catch(IOException b)
			{
				System.out.println("Je bent gefaald noob");
			}
			
			
		}
		
	});
	
	
	
	
	add(leftPane, BorderLayout.WEST);
	add(rightPane, BorderLayout.CENTER);
	add(okPane, BorderLayout.SOUTH);
	
	
	
}



}