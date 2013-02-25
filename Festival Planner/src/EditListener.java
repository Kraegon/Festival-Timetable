import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

class EditListener implements ActionListener{
	private JFrame frame;
	private JComponent[] comps;
	private FestivalObject toEdit;
	/**
	 * Constructor for the InputListerener to 
	 * @param frame : To be closed at the end of execution.
	 * @param comps : Components to read out.
	 */
	public EditListener(JFrame frame, JComponent[] comps, FestivalObject toEdit){
		this.frame = frame;
		this.comps = comps;
		this.toEdit = toEdit;
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
		if(toEdit.getClass() == Artist.class){
			Artist artist = (Artist) toEdit;
			artist.setName((String) inputDetails[0]);
			artist.setGenre((String) inputDetails[1]);
			artist.setMisc((String) inputDetails[2]);
		} else if (toEdit.getClass() == Stage.class){
			Stage stage = (Stage) toEdit;
			stage.setName((String) inputDetails[0]);
			stage.setVisitorsMax(Integer.parseInt((String) inputDetails[1]));
			stage.setIsMainStage((boolean) inputDetails[2]);
		} else if (toEdit.getClass() == Performance.class){
			Performance performance = (Performance) toEdit;
			performance.setName((String) inputDetails[0]);
			performance.setStartTime(Float.parseFloat((String) inputDetails[1]));
			performance.setEndTime(Float.parseFloat((String) inputDetails[2]));
			performance.setEndTime(Integer.parseInt((String) inputDetails[3]));
			performance.setStage(IO.getInstance().getFestival().findStage((String) inputDetails[4]));
			performance.clearArtists();
			JList<String> artistsList = (JList<String>) comps[12];
			DefaultListModel<String> artistsModel = (DefaultListModel<String>) artistsList.getModel();
			Object[] artistsArray = artistsModel.toArray();
			for(Object s : artistsArray){
				IO.getInstance().getFestival().findPerformance((String) inputDetails[0]).addArtists(IO.getInstance().getFestival().findArtist((String) s));
			}
		}
		frame.dispose();
	}
	
}