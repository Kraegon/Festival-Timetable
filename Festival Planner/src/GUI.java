import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//TEST LESLEY
import javax.swing.filechooser.FileNameExtensionFilter;

	public class GUI extends JFrame
	{
		// Attributen
		private static final long serialVersionUID = 1L;
		JButton center;
	    JLabel statusLabel;
	    private String status = "This panel will show you useful messages";
	    IO io;
	    
	    public GUI()
	    {
	        super("FestivalPlanner");
	        makeFrame();
	        io = new IO();
	    }
	    
	    private void makeFrame()
	    {
	        /** Main Frame **/
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

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
	                    addArtist();
	                }
	            });
	        
	        JButton addPerformance = new JButton("Add Performance");
	        westPanel.add(addPerformance);
	        addPerformance.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                    addPerformance();
	                }
	            });
	        
	        JButton addStage = new JButton("Add Stage");
	        westPanel.add(addStage);
	        addStage.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                    addStage();
	                }
	            });
	          
	        /** CENTER **/
	        center = new JButton("CENTER");
	        contentPane.add(center, BorderLayout.CENTER);
	        center.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                { 
                	io.printFestival();
                    statusLabel.setText("This is where the agenda will be.");
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
	                }
	            });
	        fileMenu.add(newMenu);
	        
	        fileMenu.addSeparator();
	        
	        JMenuItem saveMenu = new JMenuItem("Save");
	        saveMenu.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                    io.saveFestival();
	                }
	            });
	        fileMenu.add(saveMenu);
	        
	        JMenuItem saveAsMenu = new JMenuItem("Save as...");
	        saveAsMenu.addActionListener(new ActionListener() 
	            {
	                public void actionPerformed(ActionEvent e) 
	                { 
	                	JFileChooser choose = new JFileChooser();
	                	//choose.setFileFilter(new FileNameExtensionFilter("fest"));  BROKEN
	                	choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	                	int choice = choose.showSaveDialog(getContentPane());
	                	if(choice == JFileChooser.APPROVE_OPTION) {
	                		io.setFilePath(choose.getSelectedFile().getName());
	                		io.saveFestival();
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
	                	//choose.setFileFilter(new FileNameExtensionFilter("fest"));  BROKEN
	                	choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	                	int choice = choose.showOpenDialog(getContentPane());
	                	if(choice == JFileChooser.APPROVE_OPTION) {
	                		io.setFilePath(choose.getSelectedFile().getName());
	                		io.openFestival();
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
	        statusLabel.setText("addArtist();");
	    }
	    
	    private void addPerformance() 
	    {
	    	statusLabel.setText("addPerformance();");
		}
	    
	    private void addStage()
	    {
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
