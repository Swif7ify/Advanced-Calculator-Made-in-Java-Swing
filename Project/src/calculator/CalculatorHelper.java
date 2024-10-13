package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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
	private RoundedButton format;
	private RoundedButton DEL_button;
	private RoundedButton equals_button;
	private RoundedButton AC_button;
	
	boolean isActive = false;
	boolean isFormatted = false;
	
	private ArrayList<Double> numbers;
	private ArrayList<String> operators;
	
	public CalculatorHelper(RoundedButton format, RoundJTextField calc, RoundJTextField numwrapper, RoundJTextField holder,
			RoundJTextField zValue, RoundJTextField yValue, RoundJTextField xValue, JLabel imageHolder, JLabel variableHolder,RoundedButton lognumx_button, RoundedButton logsubtwoX_button, RoundedButton set_button, RoundedButton cuberoot_button, RoundedButton numroot_button, RoundJTextField equationHolder, RoundedButton DEL_button, RoundedButton equals_button, RoundedButton AC_button) {
		
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
		this.format = format;
		this.DEL_button = DEL_button;
		this.equals_button = equals_button;
		this.AC_button = AC_button;
		
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
	
	public void setIn(String operator) {
		holder.setText(operator);
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
		numwrapper.setBounds(13, 41, 691, 72);
        numbers.clear();
        operators.clear();
        equationHolder.setText("Equation: --");
    }
	
	public void setEquals() {
		setXYZInactive();
	}

	public void setEquationNull() {
		equationHolder.setText("Equation: --");
	}
	
	public void setXYZInactive() {
		zValue.setBounds(0, 0, 0, 0);
		yValue.setBounds(0, 0, 0, 0);
		xValue.setBounds(0, 0, 0, 0);
		imageHolder.setBounds(0, 0, 0, 0);
		variableHolder.setBounds(0, 0, 0, 0);
		equationHolder.setBounds(0, 0, 0, 0);
		numwrapper.setBounds(13, 41, 691, 72);
		xValue.setFont(new Font("Malgun Gothic", Font.BOLD, 38)); 
		variableHolder.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		setEquationNull();
	}
	
	public void setXYActive() {
		setImageHolder("/Picture/xy-black.png");
		yValue.setBounds(523, 45, 178, 25);
		xValue.setBounds(523, 63, 161, 41);
		xValue.requestFocusInWindow();
		setFocusActive();
		imageHolder.setBounds(10, 33, 66, 72);
		xValue.setHorizontalAlignment(SwingConstants.TRAILING);
	}
	
	public void setXYZActive() {
		setImageHolder("/Picture/xyz-black.png");
		zValue.setBounds(517, 31, 189, 25);
		yValue.setBounds(514, 56, 178, 27);
		xValue.setBounds(514, 77, 161, 41);
		xValue.requestFocusInWindow();
		setFocusActive();
		imageHolder.setBounds(10, 33, 66, 72);
		xValue.setHorizontalAlignment(SwingConstants.TRAILING);
	}
	
	public void setFocusActive() {
		xValue.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        if (xValue.getText().equals("0")) {
		            xValue.setText("");
		        }
		    }
		});
		yValue.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        if (yValue.getText().equals("0")) {
		        	yValue.setText(""); 
		        }
		    }
		});
		zValue.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        if (zValue.getText().equals("0")) {
		        	zValue.setText(""); // Clear the text
		        }
		    }
		});
		bindArrowKey(zValue, "UP", yValue);
        bindArrowKey(yValue, "UP", xValue);
        bindArrowKey(xValue, "UP", zValue); 

        bindArrowKey(zValue, "DOWN", xValue);
        bindArrowKey(yValue, "DOWN", zValue);
        bindArrowKey(xValue, "DOWN", yValue); 
	}
	
	public void setKeyToObject(JPanel panel) {
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
        panel.getActionMap().put("delete", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
            	AC_button.doClick();
            }
        });
        
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");
        panel.getActionMap().put("backspace", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
            	DEL_button.doClick();
            }
        });

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        panel.getActionMap().put("enter", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                equals_button.doClick();
            }
        });
	}
	
	public void bindArrowKey(RoundJTextField field, String direction, RoundJTextField targetField) {
	    int condition = JComponent.WHEN_FOCUSED;
	    InputMap inputMap = field.getInputMap(condition);
	    ActionMap actionMap = field.getActionMap();
	    
	    KeyStroke keyStroke;
	    if ("DOWN".equals(direction)) {
	        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
	    } else {
	        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
	    }

	    inputMap.put(keyStroke, direction);
	    actionMap.put(direction, new AbstractAction() {
	        private static final long serialVersionUID = 1L;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            targetField.requestFocusInWindow();
	        }
	    });
	}
	
	public void setImageHolder(String text) {
		Image Holder = loadImage(text);
		imageHolder.setIcon(new ImageIcon(Holder));
		setEquationNull();
	}
	
	public void setSummationActive() {
		numwrapper.setBounds(13, 41, 691, 72);
		setImageHolder("/Picture/summation_hold.png");
		imageHolder.setBounds(14, 42, 66, 72);
		equationHolder.setBounds(134, 101, 133, 41);
		equationHolder.setBackground(new Color(213, 178, 224));
	}
	
	public void setNotationActive() {
		setImageHolder("/Picture/notation_hold.png");
		imageHolder.setBounds(14, 42, 66, 72);
		equationHolder.setBounds(134, 101, 133, 41);
		equationHolder.setBackground(new Color(213, 178, 224));
	}
	
	public void setDSummationActive() {
		setDsumDnotActive();
		setImageHolder("/Picture/Dsummation_hold.png");
		imageHolder.setBounds(15, 34, 144, 84);	
	}
	
	public void setDNotationActive() {
		setDsumDnotActive();
		setImageHolder("/Picture/Dnotation_hold.png");
		imageHolder.setBounds(15, 34, 144, 84);	
	}
	
	public void setChange() {
		if(isActive) {
			logsubtwoX_button.setBounds(444, 510, 147, 54);
			cuberoot_button.setBounds(548, 320, 94, 54);
			lognumx_button.setBounds(0, 0, 0, 0);
			numroot_button.setBounds(0, 0, 0, 0);
			set_button.setForeground(new Color(255, 255, 255));
			set_button.setBackground(new Color(133, 110, 167));
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
		setXYZInactive();
		xValue.setHorizontalAlignment(SwingConstants.LEADING);
		xValue.setBounds(80, 10, 200, 50);
		variableHolder.setBounds(20, 12, 60, 50);
		variableHolder.setText("n =");
	}
	
	public void setNumRootActive() {
		setXYZInactive();
		xValue.setHorizontalAlignment(SwingConstants.LEADING);
		xValue.setBounds(80, 6, 200, 50);
		variableHolder.setBounds(20, 5, 60, 50);
		variableHolder.setText("x =");
		setImageHolder("/Picture/numroot.png");
		imageHolder.setBounds(10, 33, 66, 72);
	}
	
	public void setDsumDnotActive() {
		xValue.setFont(new Font("Malgun Gothic", Font.BOLD, 25)); 
		xValue.setHorizontalAlignment(SwingConstants.LEADING);
		xValue.setBounds(333, 101, 200, 41);
		variableHolder.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		variableHolder.setBounds(273, 103, 60, 39);
		variableHolder.setText("N =");
		equationHolder.setBounds(134, 101, 133, 41);
		equationHolder.setBackground(new Color(213, 178, 224));
	}
	
	public void setFormat() {
		NumberFormat formatter = new DecimalFormat("#,###");
		try {
			if(isFormatted) {
				format.setBackground(new Color(255, 255, 255));
				String number = numwrapper.getText();
				Number num = formatter.parse(number);
				numwrapper.setText(String.valueOf(num));
				isFormatted = false;
			} else {
				format.setBackground(new Color(0, 0, 255));
				double number = Double.parseDouble(numwrapper.getText());
				numwrapper.setText(formatter.format(number));
				isFormatted = true;
			}
		} catch(Exception e) {
			return;
		}
	}
	
	public void setSENone() {
		String get = holder.getText();
		if(get.equals("Syntax Error") || get.equals("Math Error")) holder.setText("");
	}
	
	public Image loadImage(String path) {
		try {
	        InputStream imageStream = getClass().getResourceAsStream(path);
	        if (imageStream != null) {
	            return ImageIO.read(imageStream);
	        } else {
	            return null;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}