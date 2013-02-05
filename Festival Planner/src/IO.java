import java.io.*;
/**
 * Handles file IO for festivals and holds the GUI. Will pass festival objects to GUI.
 * @author Julian G. West
 *
 */
public class IO {
	private Festival festival;	
	private String filePath;	
	
	File festiFile;	
	
	public IO(){
		
	}
	
	public IO(String filePath){
		this.filePath = filePath;
		festiFile = new File(filePath);
	}
	
	public Festival getFestival() {
		return festival;
	}
	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public File getFestiFile() {
		return festiFile;
	}
	public void setFestiFile(File festiFile) {
		this.festiFile = festiFile;
	}
	
	public void openFestival(){
		ObjectInputStream objIn;
		try{
			objIn = new ObjectInputStream(new FileInputStream(filePath));
			setFestival((Festival) objIn.readObject());
			objIn.close();
		} catch(IOException e){
			System.out.println("Failed to open");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
	}
	
	public void saveFestival(){
		ObjectOutputStream objOut;
		try{
			if(festiFile.exists()){
				objOut = new ObjectOutputStream(new FileOutputStream(filePath));
				objOut.writeObject(festival);
				objOut.close();
			} else {
				festiFile.createNewFile();
				objOut = new ObjectOutputStream(new FileOutputStream(filePath));
				objOut.writeObject(festival);
				objOut.close();
			}
		} catch(IOException e){
			System.out.println("Failed to save");
			e.printStackTrace();
		}
	}
	
	public void printFestival(){
		System.out.print(festival.toString());
	}
}
