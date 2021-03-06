




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;



public class InputListener implements ActionListener{
	private JFrame frame;
	private JComponent[] comps;
	private String target;
	/**
	 * Constructor for the InputListerener to 
	 * @param frame : To be closed at the end of execution.
	 * @param comps : Components to read out.
	 */
	public InputListener(JFrame frame, JComponent[] comps, String target){
		this.frame = frame;
		this.comps = comps;
		this.target = target;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object[] inputDetails = new Object[16];
		int counter = 0;
		for(int i = 0; i < comps.length; i++){
			if(comps[i].getClass() == JTextField.class){
				JTextField compTemp = (JTextField) comps[i];
				inputDetails[counter] = compTemp.getText();
				counter++;
			} 
			if(comps[i].getClass() == JCheckBox.class){
				JCheckBox compTemp = (JCheckBox) comps[i];
				inputDetails[counter] = compTemp.isSelected();
				counter++;
			}
			if(comps[i].getClass() == JList.class){
				JList<String> compTemp = (JList<String>) comps[i];
				inputDetails[counter] = compTemp.getSelectedValue();
				break;
			}
		}
		switch(target){
			case "artist": 
				String nameA = (String) inputDetails[0];
				String genreA = (String) inputDetails[1];
				String miscA = (String) inputDetails[2];
				IO.getInstance().getFestival().addArtist(new Artist(nameA,genreA,miscA));
				break;
			case "stage": 
				String nameS = (String) inputDetails[0];
				int maxVisitorsS = Integer.parseInt((String) inputDetails[1]);
				boolean isMainStageS = (boolean) inputDetails[2];
				IO.getInstance().getFestival().addStage(new Stage(nameS, maxVisitorsS, isMainStageS));
				break;
			case "performance": 
				String nameP = (String) inputDetails[0];
				float startTimeP = Float.parseFloat((String) inputDetails[1]);
				float endTimeP = Float.parseFloat((String) inputDetails[2]);
				int popularityP = Integer.parseInt((String) inputDetails[3]);
				Stage stageP = IO.getInstance().getFestival().findStage((String) inputDetails[4]);
				IO.getInstance().getFestival().addPerformance(new Performance(nameP, startTimeP,endTimeP,popularityP,stageP));
				JList<String> artistsList = (JList<String>) comps[12];
				DefaultListModel<String> artistsModel = (DefaultListModel<String>) artistsList.getModel();
				Object[] artistsArray = artistsModel.toArray();
				for(Object s : artistsArray){
					IO.getInstance().getFestival().findPerformance(nameP).addArtists(IO.getInstance().getFestival().findArtist((String) s));
				}
				break;
		}
		
		frame.dispose();
	}
}