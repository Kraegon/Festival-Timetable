
import java.io.Serializable;
import java.util.*;

/**
 * Data class. Holds a performance's artist(s), stage, times and expected popularity level. 
 * Data here should be used to draw within the table and borrows artist(s) and stage from it's Festival parent.
 * @author Julian G. West
 *
 */
public class Performance implements Serializable, FestivalObject{

	private static final long serialVersionUID = -7222551310907198818L;
	private String name;
	private ArrayList<Artist> artists;
	private Stage stage;
	private float startTime;
	private float endTime;
	private int popularity;
	
	public Performance(String name, float startTime, float endTime, int popularity, Stage stage) throws ArithmeticException {
		if(startTime > endTime)
			throw new ArithmeticException("Ending time must be greater than starting time");
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.popularity = popularity;
		this.stage = stage;
		artists = new ArrayList<Artist>();
	}
	
	public float getStartTime() {
		return startTime;
	}

	public void setStartTime(float startTime) {
		this.startTime = startTime;
	}

	public float getEndTime() {
		return endTime;
	}

	public void setEndTime(float endTime) {
		this.endTime = endTime;
	}

	public ArrayList<Artist> getArtists() {
		return artists;
	}
	public void addArtists(Artist artist) {
		artists.add(artist);
	}
	public void clearArtists(){
		artists.clear();
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
	
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	public String toString(){
		String str = "Performance name:" + name + "\nIncluding:";
		for(Artist a : artists){
			str += "\n\t" + a.getName();
		}
		str += "\nAt " + startTime + " till " + endTime + "\nOn stage " + stage.getName() + " with expected popularity " + popularity + "\n -------";
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
