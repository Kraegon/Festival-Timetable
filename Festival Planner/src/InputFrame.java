import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.*;
import java.awt.*;


public class InputFrame extends JFrame{

	JPanel artistPane;
	JPanel stagePane;
	JPanel performancePane;
	JPanel errorPane;
	
	public InputFrame(String source, Point sourcePoint){
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setLocation(new Point(sourcePoint.x + 150, sourcePoint.y + 150));
		errorPane = new JPanel(null);
		errorPane.add(new JLabel("Uh oh."));
		
		switch(source){
		case "artist":
			setContentPane(makeArtistPane());
			break;
		case "stage":
			setContentPane(makeStagePane());
			break;
		case "performance":
			setContentPane(makePerformancePane());
			break;
		default:
			setContentPane(errorPane);
		}
		setSize(300,300);
		setVisible(true);
	}
	
	public JPanel makeArtistPane(){
		artistPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		artistPane.add(new JLabel("Is artist!"));
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
	

}
