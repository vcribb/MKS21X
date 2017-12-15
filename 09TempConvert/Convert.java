import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Convert extends JFrame implements ActionListener{
    private Container pane;
    private JButton a,b;
    private JTextField t;
   
    public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		//System.out.println(s);
		if(s.equals("fahrenheit to celsius")){
			t.setText(String.valueOf(FtoC(Double.parseDouble(t.getText()))));
		}
		else if(s.equals("celsius to fahrenheit")){
			t.setText(String.valueOf(CtoF(Double.parseDouble(t.getText()))));
		}
    }

    public Convert(){
		this.setTitle("Temperature conversion");
		this.setSize(600,400);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane = this.getContentPane();
		pane.setLayout(new FlowLayout());

		a = new JButton("fahrenheit to celsius");
		b = new JButton("celsius to fahrenheit");
		t = new JTextField(5);

		a.addActionListener(this);
		b.addActionListener(this);
		t.addActionListener(this);
	
		pane.add(t);
		pane.add(a);
		pane.add(b);
    }

	public static double CtoF(double t){
		return (1.8 * t + 32);
	}
	
	public static double FtoC(double t){
		return (t - 32)/1.8;
	}

    public static void main(String[] args){
		Convert g = new Convert();
		g.setVisible(true);
    }
}