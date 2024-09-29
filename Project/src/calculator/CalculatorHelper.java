package calculator;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CalculatorHelper {
	
	private RoundJTextField calc;
	private RoundJTextField numwrapper;
	private RoundJTextField holder;
	private RoundJTextField zValue;
	private RoundJTextField yValue;
	private RoundJTextField xValue;
	private RoundJTextField equationHolder;
	private JLabel imageHolder;
	private JLabel variableHolder;
	private RoundedButton lognumx_button;
	private RoundedButton logsubtwoX_button;
	private RoundedButton set_button;
	private RoundedButton cuberoot_button;
	private RoundedButton numroot_button;
	
	boolean isActive = false;
	
	private ArrayList<Double> numbers;
	private ArrayList<String> operators;
	
	public CalculatorHelper(RoundJTextField calc, RoundJTextField numwrapper, RoundJTextField holder,
			RoundJTextField zValue, RoundJTextField yValue, RoundJTextField xValue, JLabel imageHolder, JLabel variableHolder,RoundedButton lognumx_button, RoundedButton logsubtwoX_button, RoundedButton set_button, RoundedButton cuberoot_button, RoundedButton numroot_button, RoundJTextField equationHolder) {
		
		this.calc = calc;
		this.numwrapper = numwrapper;
		this.holder = holder;
		this.zValue = zValue;
		this.yValue = yValue;
		this.xValue = xValue;
		this.imageHolder = imageHolder;
		this.lognumx_button = lognumx_button;
		this.logsubtwoX_button = logsubtwoX_button;
		this.set_button = set_button;
		this.variableHolder = variableHolder;
		this.cuberoot_button = cuberoot_button;
		this.numroot_button = numroot_button;
		this.equationHolder = equationHolder;
		
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
		setXYZInactive();
		numwrapper.setBounds(10, 33, 698, 72);
        numbers.clear();
        operators.clear();
    }
	
	public void setEquals() {
		setXYZInactive();
		numwrapper.setBounds(10, 33, 698, 72);
	}
	
	public void setXYZInactive() {
		zValue.setBounds(0, 0, 0, 0);
		yValue.setBounds(0, 0, 0, 0);
		xValue.setBounds(0, 0, 0, 0);
		imageHolder.setBounds(0, 0, 0, 0);
		variableHolder.setBounds(0, 0, 0, 0);
		equationHolder.setBounds(0, 0, 0, 0);
	}
	
	public void setXYActive() {
		setImageHolder("/Picture/xy-black.png");
		yValue.setBounds(515, 36, 178, 25);
		xValue.setBounds(515, 54, 161, 41);
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setXYZActive() {
		setImageHolder("/Picture/xyz-black.png");
		zValue.setBounds(500, 21, 189, 25);
		yValue.setBounds(497, 46, 178, 27);
		xValue.setBounds(497, 67, 161, 41);
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setImageHolder(String text) {
		imageHolder.setIcon(new ImageIcon(getClass().getResource(text)));
	}
	
	public void setSummationActive() {
		setImageHolder("/Picture/summation_hold.png");
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setNotationActive() {
		setImageHolder("/Picture/notation_hold.png");
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setDSummationActive() {
		setDsumDnotActive();
		setImageHolder("/Picture/Dsummation_hold.png");
		imageHolder.setBounds(20, 42, 144, 84);
	}
	
	public void setDNotationActive() {
		setDsumDnotActive();
		setImageHolder("/Picture/Dnotation_hold.png");
		imageHolder.setBounds(20, 42, 144, 84);
	}
	
	public void setChange() {
		if(isActive) {
			logsubtwoX_button.setBounds(444, 510, 147, 54);
			cuberoot_button.setBounds(548, 320, 94, 54);
			lognumx_button.setBounds(0, 0, 0, 0);
			numroot_button.setBounds(0, 0, 0, 0);
			set_button.setForeground(new Color(255, 255, 255));
			set_button.setBackground(new Color(80, 80, 80));
			isActive = false;
		} else {
			lognumx_button.setBounds(444, 510, 147, 54);
			numroot_button.setBounds(548, 320, 94, 54);
			set_button.setForeground(new Color(255, 255, 255));
			set_button.setBackground(new Color(0, 128, 0));
			logsubtwoX_button.setBounds(0, 0, 0, 0);
			cuberoot_button.setBounds(0, 0, 0, 0);
			isActive = true;
		}
	}
	
	public void setLogNumXActive() {
		xValue.setHorizontalAlignment(SwingConstants.LEADING);
		xValue.setBounds(80, 10, 200, 50);
		variableHolder.setBounds(20, 12, 60, 50);
		variableHolder.setText("n =");
	}
	
	public void setNumRootActive() {
		xValue.setHorizontalAlignment(SwingConstants.LEADING);
		xValue.setBounds(80, 6, 200, 50);
		variableHolder.setBounds(20, 5, 60, 50);
		variableHolder.setText("x =");
		setImageHolder("/Picture/numroot.png");
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setDsumDnotActive() {
		xValue.setHorizontalAlignment(SwingConstants.LEADING);
		xValue.setBounds(223, 74, 200, 50);
		variableHolder.setBounds(163, 76, 60, 50);
		variableHolder.setText("N =");
		equationHolder.setBounds(258, 72, 173, 54);
		equationHolder.setBackground(new Color(255, 255, 255));
	}
}