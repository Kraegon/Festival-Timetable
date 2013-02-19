import java.io.Serializable;
import java.util.*;
/**
 * Data class. Holds all artists and stages and performances with a date. 
 * When a new performance is made, please select it's artist(s) and stage from here.
 * @author Julian G. West
 *
 */
public class Festival implements Serializable{

	private static final long serialVersionUID = 3988410474252007794L;
	private LinkedList<Stage> stages;
	private LinkedList<Artist> artists;
	private LinkedList<Performance> performances;
	private Date date;	

	public Festival(){
		stages = new LinkedList<Stage>();
		artists = new LinkedList<Artist>();
		performances = new LinkedList<Performance>();
	}
	
	public Festival(Date date){
		stages = new LinkedList<Stage>();
		artists = new LinkedList<Artist>();
		performances = new LinkedList<Performance>();
		this.date = date;
	}
	
	public void addStage(Stage stage){
		stages.add(stage);
	}
	public void addArtist(Artist artist){
		artists.add(artist);
	}
	public void addPerformance(Performance performance) throws IllegalArgumentException{
		if(stages.isEmpty())
			throw new IllegalArgumentException("No stages created");
		if(artists.isEmpty())
			throw new IllegalArgumentException("No artists created");
		performances.add(performance);
	}
	
	public LinkedList<Stage> getStages() {
		return stages;
	}
	public LinkedList<Artist> getArtists() {
		return artists;
	}
	public LinkedList<Performance> getPerformances() {
		return performances;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		String str = "";
		if(stages.isEmpty())
			str += "\n No stages made.";
		else
			for(Stage s : stages){
				str += s.toString();
			}
		if(artists.isEmpty())
			str += "\n No artists made.";
		else
			for(Artist a : artists){
				str += a.toString();
			}
		if(performances.isEmpty())
			str += "\n No performances made.";
		else
			for(Performance p : performances){
				str += p.toString();
			}
		
		return str;
	}
}
