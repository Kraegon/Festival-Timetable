import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.*;

import java.awt.*;


public class InputFrame extends JFrame{

	private static final long serialVersionUID = -1971482195672574230L;
	JPanel artistPane;
	JPanel stagePane;
	JPanel performancePane;
	JPanel festivalPane;
	JPanel errorPane;
	IO io;
	
	public InputFrame(String source, Point sourcePoint, IO io){
		this.io = io;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setLocation(new Point(sourcePoint.x + 150, sourcePoint.y + 150));
		errorPane = new JPanel(null);
		errorPane.add(new JLabel("Uh oh."));
		
		switch(source){
		case "artist":
			setContentPane(makeArtistPane());
			setTitle("Add artist");
			break;
		case "stage":
			setContentPane(makeStagePane());
			setTitle("Add stage");
			break;
		case "performance":
			setContentPane(makePerformancePane());
			setTitle("Add performance");
			break;
		default:
			setContentPane(errorPane);
			setTitle("Error");
			break;
		}
		setResizable(false);
		setVisible(true);
	}
	
	public JPanel makeArtistPane(){
		//Creates itself and container
		artistPane = new JPanel(new BorderLayout());
		setPreferredSize(new Dimension(300,100));
		JComponent[] comps = new JComponent[]{
				new JLabel("Name: "),new JLabel ("Genre: "),new JLabel ("Misc: "),
				new JTextField("name"),	new JTextField("genre"), new JTextField("misc")
		};
		JPanel leftPane = new JPanel(new GridLayout(3,1));
		JPanel rightPane = new JPanel(new GridLayout(3,1));
		//Aesthetics
		bePretty();
		//Add ingredients to the soup
		for(JComponent component : comps){
			if(component.getClass() == JLabel.class){
				leftPane.add(component);
			} else {
				JTextField compTemp = (JTextField) component;
				rightPane.add(component);
			}
		}
		artistPane.add(leftPane, BorderLayout.WEST);
		artistPane.add(rightPane, BorderLayout.CENTER);
		//Finish
		return artistPane;
	}
	public JPanel makeStagePane(){
		stagePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		stagePane.add(new JLabel("Is stage!"));
		return stagePane;
	}
	public JPanel makePerformancePane(){
		performancePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		performancePane.add(new JLabel("Is performance!"));
		return performancePane;
	}	
	public JPanel makeInputPane(){
		performancePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		performancePane.add(new JLabel("Is input!"));
		return performancePane;
	}
	public JPanel makeErrorPane(){
		JPanel errorPane = new JPanel(new BorderLayout());
		errorPane.add(new JLabel("Something has gone horribly wrong."), BorderLayout.CENTER);
		return errorPane;
	}
	
	public void bePretty(){
		return;
	}
}
