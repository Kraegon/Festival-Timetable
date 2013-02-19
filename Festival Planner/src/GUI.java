import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;

import javax.swing.filechooser.FileNameExtensionFilter;

	public class GUI extends JFrame
	{
		// Attributen
		private JFrame inputFrame;
		private static final long serialVersionUID = 1L;
		JButton center;
	    JLabel statusLabel;
	    private String status = "This panel will show you useful messages";
	    IO io;
	    
	    public GUI()
	    {
	        super("FestivalPlanner"); // Todo: Add festivalnaam aan schermnaam
	        makeFrame();
	        io = new IO();
	    }
	    
	    private void makeFrame()
	    {
	        /** Main Frame **/
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        setLocation(new Point(100, 100));

	        /** Maak menuBar **/
	        makeMenuBar();
	        
	        /** Componenten **/
	         
	        /** westPanel **/
	        JPanel westPanel = new JPanel();
	        westPanel.setLayout(new GridLayout(10, 1, 10, 10));
	        contentPane.add(westPanel, BorderLayout.WEST);
	        
	        /** WEST **/
	        JButton addArtist = new JButton("Add Artist");
	        westPanel.add(addArtist);
	        addArtist.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                	if(io.getFestival() == null){
	                		statusLabel.setText("No festival set.");
	                	} else {              	
	                		addArtist();
	                	}
	                    
	                }
	            });
	        
	        JButton addPerformance = new JButton("Add Performance");
	        westPanel.add(addPerformance);
	        addPerformance.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                	if(io.getFestival() == null){
	                		statusLabel.setText("No festival set.");
	                	} else {              	
	                		addPerformance();
	                	}
	                }
	            });
	        
	        JButton addStage = new JButton("Add Stage");
	        westPanel.add(addStage);
	        addStage.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                	if(io.getFestival() == null){
	                		statusLabel.setText("No festival set.");
	                	} else {              	
	                		addStage();
	                	}
	                }
	            });
	          
	        /** CENTER **/
	        center = new JButton("CENTER");
	        contentPane.add(center, BorderLayout.CENTER);
	        center.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                { 
                	if(io.getFestival() == null){
                		statusLabel.setText("No festival set.");
                	} else {              	
	                	io.printFestival();              	
	                    statusLabel.setText("This is where the agenda will be.");
                	}
                }
            });
	        
	        /** SOUTH **/
	        statusLabel = new JLabel(getStatus());
	        contentPane.add(statusLabel, BorderLayout.SOUTH);
	        
	        /** Componenten samenvoegen **/
	        setContentPane(contentPane);
	        setSize(800, 600);
	        setVisible(true);
	    }
	    
	    private void makeMenuBar()
	    {
	        /** JMenuBar **/
	        JMenuBar menuBar = new JMenuBar();
	        
	        /** JMenu **/
	        JMenu fileMenu = new JMenu("File");
	        JMenu simulatorMenu = new JMenu("Simulator");
	        JMenu infoMenu = new JMenu("Info");
	        menuBar.add(fileMenu);
	        menuBar.add(simulatorMenu);
	        menuBar.add(infoMenu);
	        
	        /** JMenuItem **/
	        JMenuItem newMenu = new JMenuItem("New");
	        newMenu.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                    io.setNewFestival("default.fest");
	                    setTitle("FestivalPlanner - " + io.getFilePath());
	                }
	            });
	        fileMenu.add(newMenu);
	        
	        fileMenu.addSeparator();
	        
	        JMenuItem saveMenu = new JMenuItem("Save");
	        saveMenu.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                	try{
	                		io.saveFestival();
	                		statusLabel.setText("Save success");
	                	} catch (IOException exc){
	                		statusLabel.setText("Saving failed");
	                	} catch (NullPointerException exc) {
	                		statusLabel.setText("No festival set");
	                	}
	                }
	            });
	        fileMenu.add(saveMenu);
	        
	        JMenuItem saveAsMenu = new JMenuItem("Save as...");
	        saveAsMenu.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                	JFileChooser choose = new JFileChooser();	                	
	                	choose.setFileFilter(new FileNameExtensionFilter("Festival data files | .fest", "fest"));
	                	choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	                	int choice = choose.showSaveDialog(getContentPane());
	                	if(choice == JFileChooser.APPROVE_OPTION){
	                		io.setFilePath(choose.getSelectedFile() + ".fest");
	                		try{
		                		io.saveFestival();
		                		statusLabel.setText("Save successful");
		                		setTitle("FestivalPlanner - " + io.getFestiFile().getName());
		                	} catch (IOException exc){
		                		statusLabel.setText("Saving failed");
		                	} catch (NullPointerException exc) {
		                		statusLabel.setText("No festival set");
		                	}
	                	}
	                }
	            });
	        fileMenu.add(saveAsMenu);
	        
	        fileMenu.addSeparator();
	        
	        JMenuItem openMenu = new JMenuItem("Open");
	        openMenu.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                {
	                	JFileChooser choose = new JFileChooser();
	                	choose.setFileFilter(new FileNameExtensionFilter("Festival data files | .fest", "fest"));
	                	choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	                	int choice = choose.showOpenDialog(getContentPane());
	                	if(choice == JFileChooser.APPROVE_OPTION) {
	                		io.setFilePath(choose.getSelectedFile().getName());
	                		io.setFestiFile(choose.getSelectedFile());
	                		try{
	                			io.openFestival();
	                			statusLabel.setText("Opening successful");
	                			setTitle("FestivalPlanner - " + io.getFestiFile().getName());
	                		} catch(IOException exc){
	                			statusLabel.setText("Opening failed");
	                			exc.printStackTrace();
	                		}
	                	}
	                }
	            });
	        fileMenu.add(openMenu);	           
	        
	        JMenuItem simulatorItem = new JMenuItem("Execute");
	        simulatorItem.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                    executeSimulator();
	                }
	            });
	        simulatorMenu.add(simulatorItem);
	        
	        JMenuItem aboutItem = new JMenuItem("Show info");
	        aboutItem.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                    showInfo();  
	                }
	            });
	        infoMenu.add(aboutItem);
	        
	        /** menuBar op frame zetten **/
	        setJMenuBar(menuBar);
	    }
	    
	    private void addArtist()
	    {
	    	inputFrame = new InputFrame("artist", getLocation());
	        statusLabel.setText("addArtist();");
	    }
	    
	    private void addPerformance() 
	    {
	    	inputFrame = new InputFrame("performance", getLocation());
	    	statusLabel.setText("addPerformance();");
		}
	    
	    private void addStage()
	    {
	    	inputFrame = new InputFrame("stage", getLocation());
	    	statusLabel.setText("addStage();");
	    }
	    
	    private void showInfo()
	    {
	        JOptionPane.showMessageDialog(null, "This program was created by projectgroup TIA6 from Avans Hogeschool in Breda.");
	    }
	    
	    private String getStatus()
	    {
	        return status;
	    }
	    
	    private void executeSimulator()
	    {
	    	statusLabel.setText("executeSimulator();");
	    }
	}
