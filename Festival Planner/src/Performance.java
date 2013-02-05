import java.io.Serializable;
import java.util.*;

/**
 * Data class. Holds a performance's artist(s), stage, times and expected popularity level. 
 * Data here should be used to draw within the table and borrows artist(s) and stage from it's Festival parent.
 * @author Julian G. West
 *
 */
public class Performance implements Serializable{

	private static final long serialVersionUID = -7222551310907198818L;
	private ArrayList<Artist> artists;
	private Stage stage;
	private float startTime;
	private float endTime;
	private int popularity;
	
	public Performance(float startTime, float endTime, int popularity, Stage stage) throws ArithmeticException {
		if(startTime > endTime)
			throw new ArithmeticException("Ending time must be greater than starting time");
		this.startTime = startTime;
		this.endTime = endTime;
		this.popularity = popularity;
		this.stage = stage;
		artists = new ArrayList<Artist>();
	}
	
	public ArrayList<Artist> getArtists() {
		return artists;
	}
	public void addArtists(Artist artist) {
		artists.add(artist);
	}
	
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public float[] getTime(){
		float[] time = new float[1];
		time[0] = startTime;
		time[1] = endTime;
		return time;
	}
	public void setTime(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	public String toString(){
		String str = "\n Performance of:";
		for(Artist a : artists){
			str += "\n \t " + a.getName();
		}
		str += "\n \t At " + startTime + " till " + endTime + "\n \t On stage " + stage.getName() + " with expected popularity " + popularity;
		return str;
	}
	
}
