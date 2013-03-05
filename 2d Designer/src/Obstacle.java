
public class Obstacle {
String name = null;
int hoogte = 0;
int breedte = 0;
String hard = null;
int x = 0;
int y = 0;





public Obstacle(String name, int hoogte, int breedte, String hard, int x, int y)
{
	this.name = name;
	this.hoogte = hoogte;
	this.breedte= breedte;
	this.hard= hard;
	this.x = x;
	this.y = y;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getHoogte() {
	return hoogte;
}
public void setHoogte(int hoogte) {
	this.hoogte = hoogte;
}
public int getBreedte() {
	return breedte;
}
public void setBreedte(int breedte) {
	this.breedte = breedte;
}


public int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}


public int getY() {
	return y;
}


public void setY(int y) {
	this.y = y;
}


public String getHard() {
	return hard;
}


public void setHard(String hard) {
	this.hard = hard;
}


@Override
public String toString() {
	return "Object [name=" + name + ", hoogte=" + hoogte + ", breedte="
			+ breedte + ", hard=" + hard + "]";
}



	
}
