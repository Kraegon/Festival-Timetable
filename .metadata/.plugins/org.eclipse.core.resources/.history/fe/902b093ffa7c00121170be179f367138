import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class InputFrame extends JFrame{
	
	private static final long serialVersionUID = -1971482195672574230L;
	String source;
	JPanel artistPane;
	JPanel stagePane;
	JPanel performancePane;
	JPanel festivalPane;
	JPanel errorPane;
	
	public InputFrame(String source, Point sourcePoint){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setLocation(new Point(sourcePoint.x + 150, sourcePoint.y + 150));
		this.source = source;
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
		case "editArtist":
			setContentPane(makeSelector());
			setTitle("Edit artist");
			break;
		case "editStage":
			setContentPane(makeSelector());
			setTitle("Edit stage");
			break;
		case "editPerformance":
			setContentPane(makeSelector());
			setTitle("Edit performance");
			break;
		default:
			setContentPane(errorPane);
			setTitle("Error");
			break;
		}
		setVisible(true);
	}
	
	public JPanel makeArtistPane(){
		//Creates itself and container
		artistPane = new JPanel(new BorderLayout());
		setSize(new Dimension(300,200));
		final JComponent[] comps = new JComponent[]{
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
				rightPane.add(component);
			}
		}	
		JPanel okPane = new JPanel(new FlowLayout());
		JButton ok = new JButton("OK");
		ok.addActionListener(new InputListener(this, comps));
		okPane.add(ok);
		artistPane.add(leftPane, BorderLayout.WEST);
		artistPane.add(rightPane, BorderLayout.CENTER);
		artistPane.add(okPane, BorderLayout.SOUTH);
		setResizable(false);
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
	public JPanel makeSelector(){
		JPanel selectorPane = new JPanel(new BorderLayout());
		selectorPane.add(new JLabel(""));
		String[] names;
		switch(source){
		case "editArtist":
			names = new String[IO.getInstance().getFestival().getArtists().size()];
			for(int i = 0; i < names.length; i++){
				names[i] = IO.getInstance().getFestival().getArtists().get(i).getName();
			}
			break;
		case "editStage":
			names = new String[IO.getInstance().getFestival().getStages().size()];
			for(int i = 0; i < names.length; i++){
				names[i] = IO.getInstance().getFestival().getStages().get(i).getName();
			}
			break;
		case "editPerformance":
			names = new String[IO.getInstance().getFestival().getPerformances().size()];
			for(int i = 0; i < names.length; i++){
				names[i] = IO.getInstance().getFestival().getPerformances().get(i).getName();
			}
			break;
		default: names = new String[0];
		}
		final JList<String> list = new JList<String>(names);
		list.setSelectedIndex(0);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(list.getSelectedValue());			
			}
		});
		JPanel okPane = new JPanel(new FlowLayout());
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		okPane.add(ok);
		selectorPane.add(okPane, BorderLayout.SOUTH);
		selectorPane.add(new JScrollPane(list), BorderLayout.CENTER);
		setSize(new Dimension(200,500));
		setResizable(true);
		return selectorPane;
	}
	public void bePretty(){
		return;
	}
}
class InputListener implements ActionListener{
	private JFrame frame;
	private JComponent[] comps;
	/**
	 * Constructor for the InputListerener to 
	 * @param frame : To be closed at the end of execution.
	 * @param comps : Components to read out.
	 */
	public InputListener(JFrame frame, JComponent[] comps){
		this.frame = frame;
		this.comps = comps;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String[] artistDetails = new String[4];
		int counter = 0;
		for(int i = 0; i < comps.length; i++){
			if(comps[i].getClass() == JTextField.class){
				JTextField compTemp = (JTextField) comps[i];
				artistDetails[counter] = compTemp.getText();
				counter++;
			} 
		}
		IO.getInstance().getFestival().addArtist(new Artist(artistDetails[0], artistDetails[1], artistDetails[2]));
		frame.dispose();
	}
}
class EditListener implements ActionListener{
	private JFrame frame;
	private JComponent[] comps;
	/**
	 * Constructor for the InputListerener to 
	 * @param frame : To be closed at the end of execution.
	 * @param comps : Components to read out.
	 */
	public EditListener(JFrame frame, JComponent[] comps){
		this.frame = frame;
		this.comps = comps;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String[] artistDetails = new String[4];
		int counter = 0;
		for(int i = 0; i < comps.length; i++){
			if(comps[i].getClass() == JTextField.class){
				JTextField compTemp = (JTextField) comps[i];
				artistDetails[counter] = compTemp.getText();
				counter++;
			} 
		}
		//IO.getInstance().getFestival().findArtist(targetArtist).artistDetails[0], artistDetails[1], artistDetails[2]));
		frame.dispose();
	}
	
}