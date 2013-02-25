import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ArtistPanel{
	
	public JPanel makeArtistPane(JFrame frame){
		//Creates itself and container
		JPanel artistPane = new JPanel(new BorderLayout());
		//
		final JComponent[] comps = new JComponent[]{
				new JLabel("Name: "),new JLabel ("Genre: "),new JLabel ("Misc: "),
				new JTextField("name"),	new JTextField("genre"), new JTextField("misc")
		};
		JPanel leftPane = new JPanel(new GridLayout(3,1));
		JPanel rightPane = new JPanel(new GridLayout(3,1));
		//Add ingredients to the soup
		for(JComponent component : comps){
			if(component.getClass() == JLabel.class){
				leftPane.add(component);
			} else {
				rightPane.add(component);
			}
		}	
		JPanel okPane = new JPanel(new FlowLayout());
		JButton ok = new JButton("OK");
		ok.addActionListener(new InputListener(frame, comps, "artist"));
		okPane.add(ok);
		artistPane.add(leftPane, BorderLayout.WEST);
		artistPane.add(rightPane, BorderLayout.CENTER);
		artistPane.add(okPane, BorderLayout.SOUTH);
		return artistPane;
	}
	
	public JPanel editArtistPane(JFrame frame, String targetArtist){
		//Creates itself and container
		JPanel artistPane = new JPanel(new BorderLayout());
		//setSize(new Dimension(300,200));
		Artist artist = IO.getInstance().getFestival().findArtist(targetArtist);
		final JComponent[] comps = new JComponent[]{
				new JLabel("Name: "),new JLabel ("Genre: "),new JLabel ("Misc: "),
				new JTextField(artist.getName()),	new JTextField(artist.getGenre()), new JTextField(artist.getMisc())
		};
		JPanel leftPane = new JPanel(new GridLayout(3,1));
		JPanel rightPane = new JPanel(new GridLayout(3,1));

		//Add ingredients to the soup
		for(JComponent component : comps){
			if(component.getClass() == JLabel.class){
				leftPane.add(component);
			} else {
				rightPane.add(component);
			}
		}	
		JPanel okPane = new JPanel(new FlowLayout());
		JButton ok = new JButton("OK");
		ok.addActionListener(new EditListener(frame, comps, artist));
		okPane.add(ok);
		artistPane.add(leftPane, BorderLayout.WEST);
		artistPane.add(rightPane, BorderLayout.CENTER);
		artistPane.add(okPane, BorderLayout.SOUTH);
		return artistPane;
	}
}
