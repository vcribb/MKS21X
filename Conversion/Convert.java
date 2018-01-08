import javax.swing.*;
import java.awt.*;

public class Convert extends JFrame implements ActionListener{
    private Container pane;

    private JTextField t;
    private JCheckBox a;
    // private JButton b;

    public Convert(){
	this.setTitle("Temperature conversion");
	t = new JTextField(12);
	a = new JCheckBox("Celsius to Fahrenheit");
	//b = new JButton("Fahrenheit to Celsius");
	pane.add(t);
	pane.add(a);
	//pane.add(b);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	if(s.isSelected){
	    t.setText(CtoF((double)(t.getText())));
	}
	t.setText(FtoC((double)(t.getText())));
    }

    public static double CtoF(double t){
	return (1.8*t + 32);
    }
	
    public static double FtoC(double t){
	return (t - 32)/1.8;
    }
}
