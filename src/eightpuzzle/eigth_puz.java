package eightpuzzle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eigth_puz extends JFrame  {
       
	private JPanel p=new JPanel();
	JButton buttons[]=new JButton[9];
	
	/*public static void main(String args[]){
		new eigth_puz();
	}*/
	public eigth_puz(Integer b[][]){
		super("Eight puzzle");
		print_puz(b);
		/*try{
			wait(200);
		}catch(InterruptedException e){
		}*/
	}
    
	public void print_puz(Integer b[][]){
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));
		setVisible(true);
		for(int i=0;i<9;i++){
			buttons[i]=new JButton();
			buttons[i].setVisible(true);
		//	buttons[i].addActionListener(this); 
			p.add(buttons[i]);
		}
		add(p);
		setLocation(150,150);
		
		/*try{
			wait(200);
		}catch(InterruptedException e){
		}*/
	}
	public void reprint(Integer b[][]){
		int n = 0;
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b.length;j++){
				String s = Integer.toString(b[i][j]);
				buttons[n].setText(s);
				n++;
			}		
		}
	}

/*	public void actionPerformed(ActionEvent event){
	     
		if(event.getSource()==buttons[0])
			buttons[0].setText("button:1");
		if(event.getSource()==buttons[1])
			buttons[1].setText("button:2");
		if(event.getSource()==buttons[2])
			buttons[2].setText("button:3");
		if(event.getSource()==buttons[3])
			buttons[3].setText("button:4");
		if(event.getSource()==buttons[4])
			buttons[4].setText("button:5");
		if(event.getSource()==buttons[5])
			buttons[5].setText("button:6");
		if(event.getSource()==buttons[6])
			buttons[6].setText("button:7");
		if(event.getSource()==buttons[7])
			buttons[7].setText("button:8");
		if(event.getSource()==buttons[8])
			buttons[8].setText("button:9");
		
		
	}*/
	
	
}

