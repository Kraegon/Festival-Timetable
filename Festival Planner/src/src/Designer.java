import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Designer extends JFrame {
	private InputFrame inputFrame;
	ArrayList<Object> objects = new ArrayList<Object>();
	JPanel westPanel = new JPanel();
	JPanel objectHolder = new JPanel(new GridLayout(20, 2));
	JLabel asdf = new JLabel("test");
	
	public Designer()
	{
		super("2D Designer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setLocation(new Point(100, 100));
        setSize(800, 600);
        westPanel.setLayout(new BorderLayout(20, 20));
        westPanel.add(objectHolder, BorderLayout.CENTER);
        objectHolder.setBackground(Color.RED);
        refresh();
  
        
       
   
        
        contentPane.add(westPanel, BorderLayout.WEST);
        
        //west
    	
		
		
      
      //Dropdown list
      String[] DropdownStrings = { "Podiums", "Ingang", "Uitgang", "Catering", "Toiletten","Obstakel" };
      JComboBox dropList = new JComboBox(DropdownStrings);
      dropList.setSelectedIndex(0);
      westPanel.add(dropList, BorderLayout.NORTH);
      dropList.addActionListener(new ActionListener() 
      {
          public void actionPerformed(ActionEvent e) 
          { 
        	   JComboBox cb = (JComboBox)e.getSource();
               
        	  inputFrame = new InputFrame((String)cb.getSelectedItem(), getLocation());
      }});
      
      //
      

        //center
        JPanel center = new JPanel();
        center.setBackground(Color.GREEN);
        
        contentPane.add(center, BorderLayout.CENTER);
  
        makeMenuBar();
        
        setContentPane(contentPane);
        setLocation(new Point(100, 100));
        setVisible(true);
       
        
    }
 

		
		

		   
	 
	   private void makeMenuBar()
	    {
	        /** JMenuBar **/
	        JMenuBar menuBar = new JMenuBar();
	        
	        /** JMenu **/
	        JMenuItem clear = new JMenuItem("Clear");
	        JMenuItem open = new JMenuItem("Openen");
	        JMenuItem save = new JMenuItem("Opslaan");
	        JMenuItem refresh = new JMenuItem("Refresh");
	        menuBar.add(clear);
	        menuBar.add(open);
	        menuBar.add(save);
	        menuBar.add(refresh);
	        setJMenuBar(menuBar);
	        refresh.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 refresh();
					
				}
			});
	       
	    }
	   
	   public void refresh()
	   {
		   objects.clear();
		   objectHolder.removeAll();
		   // Directory path here
		   String path = "Objecten"; 
			String name = null;
			int hoogte = 0;
			int breedte = 0;
			String hard;
			int x = 0;
			int y = 0;
			
		   String files;
		   File folder = new File(path);
		   File[] listOfFiles = folder.listFiles(); 
		   int listSize = listOfFiles.length;
		   for (int i = 0; i < listSize; i++) 
		   {
		  
		    if (listOfFiles[i].isFile()) 
		    {
		    files = listOfFiles[i].getName();
		        if (files.endsWith(".object") || files.endsWith(".object"))
		        {
		        	try
					{
					
						//open
						FileInputStream stream = new FileInputStream("Objecten/"+listOfFiles[i].getName());
						
						//zet stream op
						DataInputStream in = new DataInputStream(stream);
						
						//buffer									//lees uit bestand
						BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
						
						//save buffer
						name =  buffer.readLine();
						hoogte =  Integer.parseInt(buffer.readLine());
						breedte =  Integer.parseInt(buffer.readLine());
						hard =  buffer.readLine();
						
						//add to array
						
						Object value = new Obstacle(name, hoogte, breedte, hard, x, y);
						
						
						 
						objectHolder.add(new JLabel(name), BorderLayout.CENTER);
						
					    objectHolder.revalidate();
						objectHolder.repaint();
						
						in.close();
						
					}
					catch(IOException e)
					{
						System.out.println("Fout");
					}
		         }
		      }
		   }
		  
			
	   }
	   
}
