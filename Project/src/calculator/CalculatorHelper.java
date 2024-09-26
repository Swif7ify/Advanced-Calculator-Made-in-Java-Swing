package calculator;

import javax.swing.text.*;
import java.util.ArrayList;

import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CalculatorHelper {
	
	private RoundJTextField calc;
	private RoundJTextField numwrapper;
	private RoundJTextField holder;
	private RoundJTextField zValue;
	private RoundJTextField yValue;
	private RoundJTextField xValue;
	private JLabel imageHolder;
	
	public boolean updating = false;
	
	private ArrayList<Double> numbers;
	private ArrayList<String> operators;
	
	public CalculatorHelper(RoundJTextField calc, RoundJTextField numwrapper, RoundJTextField holder,
			RoundJTextField zValue, RoundJTextField yValue, RoundJTextField xValue, JLabel imageHolder) {
		
		this.calc = calc;
		this.numwrapper = numwrapper;
		this.holder = holder;
		this.zValue = zValue;
		this.yValue = yValue;
		this.xValue = xValue;
		this.imageHolder = imageHolder;
		
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
		setImageHolder("/Picture/DSummation_hold.png");
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setDNotationActive() {
		setImageHolder("/Picture/DNotation_hold.png");
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	
// GOOD WHILE IT LASTED
//	public void addFormatting(RoundJTextField numwrapper) {
//	    ((AbstractDocument) numwrapper.getDocument()).setDocumentFilter(new DocumentFilter() {
//	    	@Override
//	    	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
//	    	    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
//	    	    String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
//	    	    fb.replace(0, fb.getDocument().getLength(), newText, null);
//	    	    formatAndSetText(fb);
//	    	}
//
//	    	@Override
//	    	public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
//	    	    String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
//	    	    String newText = currentText.substring(0, offset) + string + currentText.substring(offset + length);
//	    	    fb.replace(0, fb.getDocument().getLength(), newText, null);
//	    	    formatAndSetText(fb);
//	    	}
//
//	    	private void formatAndSetText(FilterBypass fb) throws BadLocationException {
//	    	    String text = fb.getDocument().getText(0, fb.getDocument().getLength()).replaceAll(",", "");
//	    	    if (!text.isEmpty()) {
//	    	        try {
//	    	            NumberFormat formatter = NumberFormat.getInstance();
//	    	            Number number = formatter.parse(text);
//	    	            String formatted = formatter.format(number);
//	    	            fb.replace(0, fb.getDocument().getLength(), formatted, null);
//	    	        } catch (Exception e) {
//	    	            System.out.println(e);
//	    	        }
//	    	    }
//	    	}
//	    });
//	} 
	
}