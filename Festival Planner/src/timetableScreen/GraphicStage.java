package timetableScreen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

import data.Stage;


public class GraphicStage implements VisibleObject
{
	LinkedList<GraphicPerformance> m_List;
	String m_Name;
	int m_Vpos; //vertical position
	
	Stage stage;

	public GraphicStage(String name)
	{
		m_Name = name;
		m_List = new LinkedList<>();
	}

	public GraphicStage(Stage stage){
		this.stage = stage;
		m_Name = stage.getName();
		m_List = new LinkedList<>();
	}
	
	public int getEstimatedWidth()
	{
		int retval = 0;
		int vsize = m_List.size();
		for (int i = 0; i < vsize; i ++)
		{
			retval += m_List.get(i).m_Length.getPixels();
		}
		
		return retval;
	}
	
	public void setVerticalPosition(int i)
	{
		m_Vpos = i;
	}
	
	public void addPerformance(GraphicPerformance p)
	{
		m_List.add(p);
	}
	public String getM_Name() {
		return m_Name;
	}
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	@Override
	public void draw(Graphics g)
	{
		int m_Y = 50 + 50 * m_Vpos;
		Graphics2D dst = (Graphics2D) g;
		//box
		dst.setColor(Color.BLUE);
		dst.fillRect(0, m_Y, 100, 50);
		dst.setColor(Color.BLACK);
		dst.drawRect(0, m_Y, 100, 50);
		//text
		dst.setColor(Color.WHITE);
		dst.drawChars(m_Name.toCharArray(), 0, m_Name.length(), 10, m_Y + 20);
		
	
		for (int i = 0; i < m_List.size(); i ++)
		{
			GraphicPerformance p = m_List.get(i);
			p.setForm(p.m_Time.getPixels()-(9*60)+100, m_Y);
			p.draw(g);
		}		
	}

	@Override
	public void update(JPanel s)
	{
		for (int i = 0; i < m_List.size(); i ++)
		{
			GraphicPerformance p = m_List.get(i);
			p.update(s);
		}		
	}
	
}