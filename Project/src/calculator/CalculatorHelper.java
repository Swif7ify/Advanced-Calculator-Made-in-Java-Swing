package calculator;

import java.util.ArrayList;

import javax.swing.JLabel;

public class CalculatorHelper {
	
	private RoundJTextField calc;
	private RoundJTextField numwrapper;
	private RoundJTextField holder;
	private RoundJTextField zValue;
	private RoundJTextField yValue;
	private RoundJTextField xValue;
	private JLabel xy_holder;
	private JLabel xyz_holder;
	
	private ArrayList<Double> numbers;
	private ArrayList<String> operators;
	
	public CalculatorHelper(RoundJTextField calc, RoundJTextField numwrapper, RoundJTextField holder,
			RoundJTextField zValue, RoundJTextField yValue, RoundJTextField xValue, JLabel xy_holder, JLabel xyz_holder ) {
		
		this.calc = calc;
		this.numwrapper = numwrapper;
		this.holder = holder;
		this.zValue = zValue;
		this.yValue = yValue;
		this.xValue = xValue;
		this.xy_holder = xy_holder;
		this.xyz_holder = xyz_holder;
		
		numbers = new ArrayList<>();
		operators = new ArrayList<>();
	}
	
	public void setZero() {
		calc.setText("");
		holder.setText("");
		numwrapper.setText("0");
	}
	
	public void setReset() {
		calc.setText("");
		holder.setText("");
		numwrapper.setText("");
	}
	
	public void setMathError() {
		calc.setText("");
		holder.setText("Math Error");
		numwrapper.setText("0");
	}
	
	public void setSyntaxError() {
		calc.setText("");
		holder.setText("Syntax Error");
		numwrapper.setText("0");
	}
	
	public void setXYZ() {
		zValue.setText("0");
        yValue.setText("0");
        xValue.setText("0");
	}
	
	public void resetAll() {
		setZero();
		setXYZ();
        numbers.clear();
        operators.clear();
    }
	
	public void setXYZInactive() {
		zValue.setBounds(0, 0, 0, 0);
		yValue.setBounds(0, 0, 0, 0);
		xValue.setBounds(0, 0, 0, 0);
		xyz_holder.setBounds(0, 0, 0, 0);
		xy_holder.setBounds(0, 0, 0, 0);
	}
	
	public void setXYActive() {
		yValue.setBounds(515, 36, 178, 25);
		xValue.setBounds(515, 54, 161, 41);
		xy_holder.setBounds(15, 37, 66, 60);
	}
	
	public void setXYZActive() {
		zValue.setBounds(500, 21, 189, 25);
		yValue.setBounds(497, 46, 178, 27);
		xValue.setBounds(497, 67, 161, 41);
		xyz_holder.setBounds(15, 37, 66, 60);
	}
}