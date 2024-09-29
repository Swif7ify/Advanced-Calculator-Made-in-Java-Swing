package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BSIT2A extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundJTextField calc;
	private RoundJTextField numwrapper;
	private RoundJTextField holder;
	private RoundJTextField zValue;
	private RoundJTextField yValue;
	private RoundJTextField xValue;
	private RoundJTextField equationHolder;
	private CalculatorHelper helper;
	private JLabel imageHolder;
	private JLabel variableHolder;
	private RoundedButton lognumx_button;
	private RoundedButton logsubtwoX_button;
	private RoundedButton set_button;
	private RoundedButton cuberoot_button;
	private RoundedButton numroot_button;
	
	/**
	  Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSIT2A frame = new BSIT2A();
					frame.setTitle("Calculator But Its Not A Normal Calculator It Is A Calculator That Can Literally Solve Human Crisis");
					Image image = ImageIO.read(new File(getClass().getResource("/Picture/teamba.png").toURI()));
					Image scaledImage = image.getScaledInstance(256, 256, Image.SCALE_SMOOTH);
					frame.setIconImage(scaledImage);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String firstValue, secondValue, thirdValue, fourthValue, operator, equation = "xy", A, B, C, D;
    double firstDoubleValue, secondDoubleValue, thirdDoubleValue, fourthDoubleValue, Answer, result, ANS;
    int zeroCount = 0, valueIndex = 1;
    int a = 1, b = 1;
    Integer nValue = null;
    boolean reset = false, isMinus = false, allowed = false, isVisible = false;
    private ArrayList<Double> numbers = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private Set<String> supportedAdvancedEquation = new HashSet<>(Set.of("∑", "∑∑", "Π", "ΠΠ"));
    private Set<String> supportedBasicEquation = new HashSet<>(Set.of("+", "-", "*", "÷"));
    
	/**
	 * Create the frame.
	 */
	public BSIT2A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 762);
		contentPane = new JPanel();
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 785, 725);
		panel.setBackground(new Color(28, 28, 28));
		contentPane.add(panel);
		panel.setLayout(null);
		
		RoundedPanel panel_1 = new RoundedPanel(100);
		panel_1.setBounds(28, 20, 718, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		equationHolder = new RoundJTextField(10);
		equationHolder.setHorizontalAlignment(SwingConstants.CENTER);
		equationHolder.setEditable(false);
		equationHolder.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		equationHolder.setText("Equation: " + equation);
		
		panel_1.add(equationHolder);
		
		zValue = new RoundJTextField(10);
		zValue.setHorizontalAlignment(SwingConstants.TRAILING);
		zValue.setFont(new Font("Malgun Gothic", Font.PLAIN, 26)); 
		zValue.setText("0");
		panel_1.add(zValue);
		
		yValue = new RoundJTextField(10);  
		yValue.setHorizontalAlignment(SwingConstants.TRAILING);
		yValue.setFont(new Font("Malgun Gothic", Font.PLAIN, 28)); 
		yValue.setText("0");
		panel_1.add(yValue);
		
		xValue = new RoundJTextField(10);
		xValue.setHorizontalAlignment(SwingConstants.TRAILING);
		xValue.setFont(new Font("Malgun Gothic", Font.BOLD, 38)); 
		xValue.setText("0"); 
		panel_1.add(xValue);
		
		variableHolder = new JLabel("");
		variableHolder.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		variableHolder.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(variableHolder);
		
		imageHolder = new JLabel("");
		panel_1.add(imageHolder);
		imageHolder.setHorizontalAlignment(SwingConstants.CENTER);
		
		calc = new RoundJTextField(10);
		panel_1.add(calc);

		numwrapper = new RoundJTextField(500);
		numwrapper.setHorizontalAlignment(SwingConstants.TRAILING);
		numwrapper.setEditable(false);
		numwrapper.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 35));
		numwrapper.setBackground(new Color(255, 255, 255));
		numwrapper.setBounds(13, 41, 691, 72);
		numwrapper.setText("0");
		panel_1.add(numwrapper);
		
		holder = new RoundJTextField(10);
		holder.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		holder.setHorizontalAlignment(SwingConstants.LEFT);
		holder.setBackground(new Color(255, 255, 255));
		holder.setEditable(false);
		holder.setBounds(37, 2, 210, 41);
		panel_1.add(holder);
		
		RoundedButton DEL_button = new RoundedButton("DEL", 50);
		DEL_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String currentEq = calc.getText();
					String currentText = numwrapper.getText();
					String xVal = xValue.getText();
					String yVal = yValue.getText();
					String zVal = zValue.getText();
					String[] values = {zVal, yVal, xVal};
					RoundJTextField[] textFields = {zValue, yValue, xValue};
					int length = values.length;
					
					if(isVisible) {
						for (int i = 0; i < length; i++) {
						    if (!values[i].isEmpty() && !values[i].equals("0")) {
						        textFields[i].setText(values[i].substring(0, values[i].length() - 1));
						        return;
						    } else {
						        textFields[i].setText("0");
						    }
						}
					} else {
						valueIndex = (valueIndex == 1) ? 1 : valueIndex - 1;
						zeroCount = (zeroCount == 0) ? 0 : zeroCount - 1;
						
						if (currentText.equals("0") || currentEq.equals("0")) {
							return;
						} 
						
						if (currentText.length() > 1 || currentEq.length() > 1) {
							numwrapper.setText(currentText.substring(0, currentText.length() - 1));
							calc.setText(currentEq.substring(0, currentEq.length() - 1));
						} 
						if(zeroCount == 0) {
							helper.setZero();
						} 
					}
					reset = false;
					isMinus = false;
				} catch (Exception error) {
					return;
				}
			}
		});
		DEL_button.setForeground(new Color(0, 0, 0));
		DEL_button.setBackground(new Color(212, 212, 210));
		DEL_button.setBounds(28, 192, 94, 54);
		panel.add(DEL_button);
		
		RoundedButton AC_button = new RoundedButton("AC", 50);
		AC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zeroCount = 0; Answer = 0;
				firstValue = null; secondValue = null;
		        thirdValue = null; fourthValue = null;
		        firstDoubleValue = 0; secondDoubleValue = 0;
		        thirdDoubleValue = 0; fourthDoubleValue = 0;
		        valueIndex = 0;
		        A = null; B = null; 
		        C = null; D = null;
		        reset = false; isMinus = false;
		        allowed = false;
		        isVisible = false;
				helper.resetAll();
			}
		});
		AC_button.setForeground(new Color(0, 0, 0));
		AC_button.setBackground(new Color(212, 212, 210));
		AC_button.setBounds(132, 192, 94, 54);
		panel.add(AC_button);
		
		RoundedButton plus_minusbutton = new RoundedButton("+/-", 50);
		plus_minusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (zeroCount != 0) {
					 String currentText = calc.getText();
					 if (isMinus) {
						 currentText = currentText.substring(1);
						 calc.setText(currentText);
						 numwrapper.setText(currentText);
						 isMinus = false;
					 } else {
						 calc.setText("-" + currentText);
						 numwrapper.setText(calc.getText());
						 holder.setText("+/-" + currentText);
						 isMinus = true;
					 }
				 }
			}
		});
		plus_minusbutton.setForeground(new Color(0, 0, 0));
		plus_minusbutton.setBackground(new Color(212, 212, 210));
		plus_minusbutton.setBounds(236, 192, 94, 54);
		panel.add(plus_minusbutton);
		
		RoundedButton plus_button = new RoundedButton("+", 50);
		plus_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (zeroCount == 0) return;
					reset = false;
					numwrapper.setText(numwrapper.getText() + "+");
					holder.setText(holder.getText() + numwrapper.getText());
					numwrapper.setText("");
					
					operator = plus_button.getText();
					numbers.add(Double.parseDouble(calc.getText()));
					operators.add(plus_button.getText());
					calc.setText("");
				} catch (Exception error) {
					String currentText = numwrapper.getText();
					numwrapper.setText(currentText.substring(0, currentText.length() - 1));
					return;
				}
			}
		});
		plus_button.setForeground(new Color(255, 255, 255));
		plus_button.setBackground(new Color(254, 143, 0));
		plus_button.setBounds(340, 192, 94, 54);
		panel.add(plus_button);
		
		RoundedButton FLR_button = new RoundedButton("FLR", 50);
		FLR_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double flooredValue = Math.floor(currentValue);
		            
		            String formattedAnswer = Functions.formatString(flooredValue);
		            calc.setText("" + formattedAnswer);
		            numwrapper.setText(calc.getText());
		        } catch (Exception error) {
		            helper.setMathError();
		            return;
		        }
			}
		});
		FLR_button.setForeground(new Color(0, 0, 0));
		FLR_button.setBackground(new Color(212, 212, 210));
		FLR_button.setBounds(444, 192, 94, 54);
		panel.add(FLR_button);
		
		RoundedButton CEIL_button = new RoundedButton("CEIL", 50);
		CEIL_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double ceiledValue = Math.ceil(currentValue);
		            
		            String formattedAnswer = Functions.formatString(ceiledValue);
		            calc.setText("" + formattedAnswer);
		            numwrapper.setText(calc.getText());
		        } catch (Exception error) {
		        	helper.setMathError();
		            return;
		        }
			}
		});
		CEIL_button.setForeground(new Color(0, 0, 0));
		CEIL_button.setBackground(new Color(212, 212, 210));
		CEIL_button.setBounds(548, 192, 94, 54);
		panel.add(CEIL_button);
		
		RoundedButton INT_button = new RoundedButton("INT", 50);
		INT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            int intValue = (int) currentValue;

		            calc.setText(String.valueOf(intValue));
		            numwrapper.setText(calc.getText());
		        } catch (Exception error) {
		        	helper.setMathError();
		        	reset = true;
		        }
			}
		});
		INT_button.setForeground(new Color(0, 0, 0));
		INT_button.setBackground(new Color(212, 212, 210));
		INT_button.setBounds(652, 192, 94, 54);
		panel.add(INT_button);
		
		RoundedButton seven_button = new RoundedButton("7", 50);
		seven_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					helper.setReset();
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + seven_button.getText()) : calc.getText() + seven_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + seven_button.getText()) : numwrapper.getText() + seven_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + seven_button.getText()) : calc.getText() + seven_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + seven_button.getText()) : numwrapper.getText() + seven_button.getText());
					zeroCount++;
				}
				allowed = true;
			}
		});
		seven_button.setForeground(new Color(255, 255, 255));
		seven_button.setBackground(new Color(80, 80, 80));
		seven_button.setBounds(28, 256, 94, 54);
		panel.add(seven_button);
		
		RoundedButton eight_button = new RoundedButton("8", 50);
		eight_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = eight_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		eight_button.setForeground(new Color(255, 255, 255));
		eight_button.setBackground(new Color(80, 80, 80));
		eight_button.setBounds(132, 256, 94, 54);
		panel.add(eight_button);
		
		RoundedButton nine_button = new RoundedButton("9", 50);
		nine_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = nine_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		nine_button.setForeground(new Color(255, 255, 255));
		nine_button.setBackground(new Color(80, 80, 80));
		nine_button.setBounds(236, 256, 94, 54);
		panel.add(nine_button);
		
		RoundedButton minus_button = new RoundedButton("-", 50);
		minus_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (zeroCount == 0) {
						return;
					} else {
						reset = false;
						numwrapper.setText(numwrapper.getText() + "-");
						holder.setText(holder.getText() + numwrapper.getText());
						numwrapper.setText("");
						operator = minus_button.getText();
						numbers.add(Double.parseDouble(calc.getText()));
						operators.add(minus_button.getText());
						calc.setText("");
					}
				} catch (Exception error) {
					String currentText = numwrapper.getText();
					numwrapper.setText(currentText.substring(0, currentText.length() - 1));
					return;
				}
			}
		});
		minus_button.setForeground(new Color(255, 255, 255));
		minus_button.setBackground(new Color(254, 143, 0));
		minus_button.setBounds(340, 256, 94, 54);
		panel.add(minus_button);
		
		RoundedButton integerdivision_button = new RoundedButton("//", 50);
		integerdivision_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(allowed) {
						if (firstValue == null) {
				            firstValue = calc.getText();
						} else {
							secondValue = calc.getText();
				        }
						calc.setText("");
				        numwrapper.setText(numwrapper.getText() + "//");
				        operator = integerdivision_button.getText();
				        allowed = false;
					} else {
						return;
					}
				} catch (Exception error) {
					firstValue = null;
					secondValue = null;
					reset = true;
					helper.setSyntaxError();
				}
		    }
		});
		integerdivision_button.setForeground(new Color(0, 0, 0));
		integerdivision_button.setBackground(new Color(212, 212, 210));
		integerdivision_button.setBounds(444, 256, 94, 54);
		panel.add(integerdivision_button);
		
		RoundedButton modulus = new RoundedButton("%", 50);
		modulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(allowed) {
						if (firstValue == null) {
							firstValue = calc.getText();
						} else {                
							secondValue = calc.getText();    
						}      
						
						calc.setText("");
						numwrapper.setText(numwrapper.getText() + "%");
						operator = modulus.getText();
						allowed = false;
					} else {
						return;
					}
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
		modulus.setForeground(new Color(0, 0, 0));
		modulus.setBackground(new Color(212, 212, 210));
		modulus.setBounds(548, 256, 94, 54);
		panel.add(modulus);
		
		RoundedButton factorial_button = new RoundedButton("N!", 50);
		factorial_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(allowed) {
						if (firstValue == null) {
			                firstValue = calc.getText();
			            }
						calc.setText("");
						numwrapper.setText(numwrapper.getText() + "!");
			            operator = factorial_button.getText();
			            allowed = false;
					} else {
						return;
					}
				} catch (Exception error) {
					firstValue = null;
					reset = true;
					helper.setSyntaxError();
				}
			}
		});
		factorial_button.setForeground(new Color(0, 0, 0));
		factorial_button.setBackground(new Color(212, 212, 210));
		factorial_button.setBounds(652, 256, 94, 54);
		panel.add(factorial_button);
		
		RoundedButton four_button = new RoundedButton("4", 50);
		four_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = four_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		four_button.setForeground(new Color(255, 255, 255));
		four_button.setBackground(new Color(80, 80, 80));
		four_button.setBounds(28, 320, 94, 54);
		panel.add(four_button);
		
		RoundedButton five_button = new RoundedButton("5", 50);
		five_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = five_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		five_button.setForeground(new Color(255, 255, 255));
		five_button.setBackground(new Color(80, 80, 80));
		five_button.setBounds(132, 320, 94, 54);
		panel.add(five_button);
		
		RoundedButton six_button = new RoundedButton("6", 50);
		six_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = six_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		six_button.setForeground(new Color(255, 255, 255));
		six_button.setBackground(new Color(80, 80, 80));
		six_button.setBounds(236, 320, 94, 54);
		panel.add(six_button);
		
		RoundedButton multiplication_button = new RoundedButton("*", 50);
		multiplication_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(zeroCount == 0) {
						return;
					} else {
						reset = false;
						numwrapper.setText(numwrapper.getText() + "+");
						holder.setText(holder.getText() + numwrapper.getText());
						numwrapper.setText("");
						operator = multiplication_button.getText();
						numbers.add(Double.parseDouble(calc.getText()));
						operators.add(multiplication_button.getText());
						calc.setText("");
					}
				} catch (Exception error) {
					String currentText = numwrapper.getText();
					numwrapper.setText(currentText.substring(0, currentText.length() - 1));
					return;
				}
			}
		});
		multiplication_button.setForeground(new Color(255, 255, 255));
		multiplication_button.setBackground(new Color(254, 143, 0));
		multiplication_button.setBounds(340, 320, 94, 54);
		panel.add(multiplication_button);
		
		RoundedButton squareroot_button = new RoundedButton("√", 50);
		squareroot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            if(currentValue < 0) {
		            	throw new IllegalArgumentException("Input must be a non-negative integer.");
		            }
		            
		            double squreRootValue = Math.sqrt(currentValue);
		            String formattedAnswer = Functions.formatString(squreRootValue);
		            
		            calc.setText(String.valueOf(formattedAnswer));
		        } catch (Exception error) {
		        	helper.setSyntaxError();
		        	return;
		        }
				numwrapper.setText(calc.getText());
			}
		});
		squareroot_button.setForeground(new Color(0, 0, 0));
		squareroot_button.setBackground(new Color(212, 212, 210));
		squareroot_button.setBounds(444, 320, 94, 54);
		panel.add(squareroot_button);
		
		cuberoot_button = new RoundedButton("", 50);
		cuberoot_button.setIcon(new ImageIcon(getClass().getResource("/Picture/cuberoot.png")));
		cuberoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double cubeRootValue = Math.cbrt(currentValue);
		            
		            String formattedAnswer = Functions.formatString(cubeRootValue);
		            calc.setText(String.valueOf(formattedAnswer));
		        } catch (Exception error) {
		        	reset = true;
		        	helper.setSyntaxError();
		        }
				numwrapper.setText(calc.getText());
			}
		});
		cuberoot_button.setForeground(new Color(0, 0, 0));
		cuberoot_button.setBackground(new Color(212, 212, 210));
		cuberoot_button.setBounds(548, 320, 94, 54);
		panel.add(cuberoot_button);
		
		numroot_button = new RoundedButton("", 50);
		numroot_button.setIcon(new ImageIcon(getClass().getResource("/Picture/numroot.png")));
		numroot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					helper.setNumRootActive();
					operator = "numroot";
		        } catch (Exception error) {
		        	helper.setSyntaxError();
		        }
			}
		});
		numroot_button.setForeground(new Color(0, 0, 0));
		numroot_button.setBounds(0, 0, 0, 0);
		numroot_button.setBackground(new Color(212, 212, 210));
		panel.add(numroot_button);
		
		RoundedButton summation_button = new RoundedButton("", 50);	
		summation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/summation.png")));
		summation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isVisible) {
						helper.setXYZInactive();
						isVisible = false;
					} else {
						helper.setXYZInactive();
						helper.setSummationActive();
						isVisible = true;
					}
					calc.setText("");
					operator = "∑";
					valueIndex = 1;
				} catch (Exception error) {
					reset = true;
		        	helper.setSyntaxError();
				}
			}
		});
		summation_button.setForeground(new Color(0, 0, 0));
		summation_button.setBackground(new Color(212, 212, 210));
		summation_button.setBounds(652, 320, 94, 54);
		panel.add(summation_button);
		
		RoundedButton one_button = new RoundedButton("1", 50);
		one_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = one_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		one_button.setForeground(new Color(255, 255, 255));
		one_button.setBackground(new Color(80, 80, 80));
		one_button.setBounds(28, 384, 94, 54);
		panel.add(one_button);
		
		RoundedButton two_button = new RoundedButton("2", 50);
		two_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = two_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		two_button.setForeground(new Color(255, 255, 255));
		two_button.setBackground(new Color(80, 80, 80));
		two_button.setBounds(132, 384, 94, 54);
		panel.add(two_button);
		
		RoundedButton three_button = new RoundedButton("3", 50);
		three_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttonText = three_button.getText();
				String calcText = zeroCount == 0 ? buttonText : calc.getText() + buttonText;
				String numwrapperText = zeroCount == 0 ? buttonText : numwrapper.getText() + buttonText;
				if (reset) {
				    helper.setReset();
				    reset = false;
				}
				calc.setText(calcText);
				numwrapper.setText(numwrapperText);
				zeroCount++;
				allowed = true;
			}
		});
		three_button.setForeground(new Color(255, 255, 255));
		three_button.setBackground(new Color(80, 80, 80));
		three_button.setBounds(236, 384, 94, 54);
		panel.add(three_button);
		
		RoundedButton division_button = new RoundedButton("÷", 50);
		division_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(zeroCount == 0) {
						return;
					} else {
						reset = false;
						numwrapper.setText(numwrapper.getText() + "+");
						holder.setText(holder.getText() + numwrapper.getText());
						numwrapper.setText("");
						operator = division_button.getText();
						numbers.add(Double.parseDouble(calc.getText()));
						operators.add(division_button.getText());
						calc.setText("");
					}
				} catch (Exception error) {
					String currentText = numwrapper.getText();
					numwrapper.setText(currentText.substring(0, currentText.length() - 1));
					return;
				}
			}
		});
		division_button.setForeground(new Color(255, 255, 255));
		division_button.setBackground(new Color(254, 143, 0));
		division_button.setBounds(340, 384, 94, 54);
		panel.add(division_button);
		
		RoundedButton XpowerY_button = new RoundedButton("", 50);
		XpowerY_button.setIcon(new ImageIcon(getClass().getResource("/Picture/X.png")));
		XpowerY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isVisible) {
						helper.setXYZInactive();
						numwrapper.setBounds(13, 41, 691, 72);
						isVisible = false;
					} else {
						helper.setXYZInactive();
						helper.setXYActive();
						numwrapper.setBounds(0, 0, 0, 0);
						isVisible = true;
					}
					
					zeroCount ++;
					operator = "x^y";
				} catch (Exception error) {
					System.out.println(error);
					helper.setSyntaxError();
					return;
				}
			}
		});
		XpowerY_button.setForeground(new Color(0, 0, 0));
		XpowerY_button.setBackground(new Color(212, 212, 210));
		XpowerY_button.setBounds(444, 384, 94, 54);
		panel.add(XpowerY_button);
		
		RoundedButton XpowerYpowerofZ_button = new RoundedButton("", 50);
		XpowerYpowerofZ_button.setIcon(new ImageIcon(getClass().getResource("/Picture/xyz.png")));
		XpowerYpowerofZ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isVisible) {
						helper.setXYZInactive();
						numwrapper.setBounds(13, 41, 691, 72);
						isVisible = false;
					} else {
						helper.setXYZInactive();
						helper.setXYZActive();
						numwrapper.setBounds(0, 0, 0, 0);
						isVisible = true;
					}
					
					zeroCount ++;
					operator = "x^y^z";
				} catch (Exception error) {
					helper.setSyntaxError();
					return;
				}
			}
		});
		XpowerYpowerofZ_button.setForeground(new Color(0, 0, 0));
		XpowerYpowerofZ_button.setBackground(new Color(212, 212, 210));
		XpowerYpowerofZ_button.setBounds(548, 384, 94, 54);
		panel.add(XpowerYpowerofZ_button);
		
		RoundedButton productnotation_button = new RoundedButton("", 50);
		productnotation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/prodnot.png")));
		productnotation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isVisible) {
						helper.setXYZInactive();
						isVisible = false;
					} else {
						helper.setXYZInactive();
						helper.setNotationActive();
						isVisible = true;
					}
					calc.setText("");
					operator = "Π";
					valueIndex = 1;
				} catch (Exception error) {
					reset = true;
		        	helper.setSyntaxError();
				}
			}
		});
		productnotation_button.setForeground(new Color(0, 0, 0));
		productnotation_button.setBackground(new Color(212, 212, 210));
		productnotation_button.setBounds(652, 384, 94, 54);
		panel.add(productnotation_button);
		
		RoundedButton zero_button = new RoundedButton("0", 50);
		zero_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (zeroCount != 0) {
				    if (reset) {
				        helper.setReset();
				        reset = false;
				    }
				    calc.setText(calc.getText() + zero_button.getText());
				    numwrapper.setText(numwrapper.getText() + "0");
				}
			}
		});
		zero_button.setForeground(new Color(0, 0, 0));
		zero_button.setBackground(new Color(212, 212, 210));
		zero_button.setBounds(28, 448, 94, 54);
		panel.add(zero_button);
		
		RoundedButton period_button = new RoundedButton(".", 50);
		period_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 zeroCount++;
				 calc.setText(calc.getText() + period_button.getText());     
				 numwrapper.setText(numwrapper.getText() + ".");
			}
		});
		period_button.setForeground(new Color(0, 0, 0));
		period_button.setBackground(new Color(212, 212, 210));
		period_button.setBounds(132, 448, 94, 54);
		panel.add(period_button);
		
		RoundedButton equals_button = new RoundedButton("=", 50);
		equals_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String currentText = calc.getText();
					
					if(operator == "∑" || operator == "Π") {
						firstValue = A; secondValue = B;
						thirdValue = C;
					} else if(operator == "∑∑" || operator == "ΠΠ") {
						nValue = Integer.parseInt(xValue.getText());
						firstValue = A; secondValue = B;
						thirdValue = C; fourthValue = D;
					} else if (operator == "log(2)(" || operator == "log(") {
						firstValue = calc.getText();
					} else if (operator == "log(n)x(") {
						firstValue = xValue.getText();
						secondValue = calc.getText();
					}
					
					if (firstValue != null) {
				        firstDoubleValue = Double.parseDouble(firstValue);
				    }
				    if (secondValue != null) {
				        secondDoubleValue = Double.parseDouble(secondValue);
				    }
				    if (thirdValue != null) {
				        thirdDoubleValue = Double.parseDouble(thirdValue);
				    }
				    if (fourthValue != null) {
				        fourthDoubleValue = Double.parseDouble(fourthValue);
				    }
					
					switch(operator) {
						case "∑":
							Answer = (int) Functions.summation(firstDoubleValue, secondDoubleValue, thirdDoubleValue);
							break;
			            	
						case "∑∑":
							Answer = (int) Functions.doubleSummation(nValue, equation, firstDoubleValue, secondDoubleValue, thirdDoubleValue, fourthDoubleValue);
							break;
			            	
						case "Π":
							Answer = (int) Functions.prodnot(firstDoubleValue, secondDoubleValue, thirdDoubleValue);
			            	break;
			            	
						case "ΠΠ":
			            	Answer = (int) Functions.doubleProdNot(nValue, equation, firstDoubleValue, secondDoubleValue, thirdDoubleValue, fourthDoubleValue);
							break;
			            
						case "N!":
							firstDoubleValue = Double.parseDouble(firstValue);
							int factorial = Functions.factorial(firstDoubleValue);
							Answer = factorial;
							break;
							
						case "a! + b!":
							Answer = Functions.sumFactorial(firstDoubleValue, secondDoubleValue);
							break;
							
						case "a! / b!":
							Answer = Functions.divideFactorial(firstDoubleValue, secondDoubleValue);
							break;
							
						case "log(2)(":
							Answer = Math.log(firstDoubleValue) / Math.log(2);
							break;
							
						case "log(":
							Answer = Math.log(firstDoubleValue);
							break;
							
						case "log(n)x(":
							Answer = Math.log(secondDoubleValue) / Math.log(firstDoubleValue);
							break;
							
						case "x^y^z":
							firstDoubleValue = Double.parseDouble(xValue.getText());
							secondDoubleValue = Double.parseDouble(yValue.getText());
							thirdDoubleValue = Double.parseDouble(zValue.getText());
							holder.setText(numwrapper.getText());
							result =  Math.pow(thirdDoubleValue, secondDoubleValue);
							Answer =  Math.pow(firstDoubleValue, result);
							break;
						default:
							if(supportedBasicEquation.contains(operator)) {
								if (!calc.getText().isEmpty()) {
									numbers.add((Double) Double.parseDouble(calc.getText()));
								}
								Answer = Functions.calculateResult(numbers, operators);
							} else {
								if(operator == "x^y") {
									firstValue = xValue.getText();
									secondValue = yValue.getText();
								} else if (operator == "numroot") {
									firstValue = xValue.getText();
									secondValue = currentText;
								} else {
									secondValue = currentText;
								}
								firstDoubleValue = Double.parseDouble(firstValue);
								secondDoubleValue = Double.parseDouble(secondValue);
								Answer = Functions.basicCalculation(operator, firstDoubleValue, secondDoubleValue);
							}
					}
					String formattedAnswer = Functions.formatString(Answer);
					helper.setEquals();
					holder.setText(numwrapper.getText());
					
					ANS = Answer;
					
					calc.setText("" + formattedAnswer);  
					
					numwrapper.setText(calc.getText());
					
					isVisible = false;
					reset = true;
					firstValue = null;
					operators.clear();
					numbers.clear();
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
		equals_button.setForeground(new Color(255, 255, 255));
		equals_button.setBackground(new Color(254, 143, 0));
		equals_button.setBounds(236, 448, 198, 54);
		panel.add(equals_button);
		
		RoundedButton doublesummation_button = new RoundedButton("", 50);
		doublesummation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/doublesum.png")));
		doublesummation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isVisible) {
						helper.setXYZInactive();
						isVisible = false;
					} else {
						helper.setXYZInactive();
						helper.setDSummationActive();
						isVisible = true;
					}
					
					calc.setText("");
					operator = "∑∑";
					valueIndex = 1;
				} catch (Exception error) {
					reset = true;
		        	helper.setSyntaxError();
				}
			}
		});
		doublesummation_button.setForeground(new Color(0, 0, 0));
		doublesummation_button.setBackground(new Color(212, 212, 210));
		doublesummation_button.setBounds(444, 448, 147, 54);
		panel.add(doublesummation_button);

		RoundedButton doubleproductnotation_button = new RoundedButton("", 50);
		doubleproductnotation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/doubleprodnot.png")));
		doubleproductnotation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isVisible) {
						helper.setXYZInactive();
						isVisible = false;
					} else {
						helper.setXYZInactive();
						helper.setDNotationActive();
						isVisible = true;
					}
					calc.setText("");
					operator = "ΠΠ";
					valueIndex = 1;
				} catch (Exception error) {
					reset = true;
					helper.setSyntaxError();
				}
			}
		});
		doubleproductnotation_button.setForeground(new Color(0, 0, 0));
		doubleproductnotation_button.setBackground(new Color(212, 212, 210));
		doubleproductnotation_button.setBounds(601, 448, 145, 54);
		panel.add(doubleproductnotation_button);
		
		set_button = new RoundedButton("SET", 50);
		set_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helper.setChange();
			}
		});
		set_button.setForeground(new Color(255, 255, 255));
		set_button.setBackground(new Color(80, 80, 80));
		set_button.setBounds(28, 510, 406, 54);
		panel.add(set_button);
		
		logsubtwoX_button = new RoundedButton("", 50);
		logsubtwoX_button.setIcon(new ImageIcon(getClass().getResource("/Picture/log2x.png")));
		logsubtwoX_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					numwrapper.setText(zeroCount == 0 ?("" + "log(2)(") : numwrapper.getText() + "log(2)(");
					zeroCount++;
					operator = "log(2)(";
					valueIndex = 1;
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
		
		logsubtwoX_button.setForeground(new Color(255, 255, 255));
		logsubtwoX_button.setBackground(new Color(80, 80, 80));
		logsubtwoX_button.setBounds(444, 512, 147, 54);
		panel.add(logsubtwoX_button);
		
		lognumx_button = new RoundedButton("", 50);
		lognumx_button.setIcon(new ImageIcon(getClass().getResource("/Picture/lognumx.png")));
		lognumx_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					helper.setLogNumXActive();
					numwrapper.setText(zeroCount == 0 ?("" + "log(n)X(") : numwrapper.getText() + "log(n)X(");
					zeroCount++;
					operator = "log(n)x(";
					valueIndex = 1;
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
		lognumx_button.setForeground(new Color(255, 255, 255));
		lognumx_button.setBounds(0, 0, 0, 0);
		lognumx_button.setBackground(new Color(80, 80, 80));
		panel.add(lognumx_button);
		
		RoundedButton logX_button = new RoundedButton("", 50);
		logX_button.setIcon(new ImageIcon(getClass().getResource("/Picture/logx.png")));
		logX_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					numwrapper.setText(zeroCount == 0 ?("" + "log(") : numwrapper.getText() + "log(");
					zeroCount++;
					operator = "log(";
					valueIndex = 1;
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
		logX_button.setForeground(new Color(255, 255, 255));
		logX_button.setBackground(new Color(80, 80, 80));
		logX_button.setBounds(601, 512, 145, 54);
		panel.add(logX_button);

		RoundedButton A_button = new RoundedButton("A", 50);
		A_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valueIndex == 1) {
					A = calc.getText();
		        } else if (valueIndex == 2) {
		        	B = calc.getText();
		        } else if (valueIndex == 3) {
		            C = calc.getText();
		        } else if (valueIndex == 4) {
		        	D = calc.getText();
		        }
				calc.setText("");
		        valueIndex++;
		        numwrapper.setText(zeroCount == 0 ? ("" + A_button.getText()) : numwrapper.getText() + A_button.getText());
		        zeroCount++;
			}
		});
		A_button.setForeground(new Color(255, 255, 255));
		A_button.setBackground(new Color(80, 80, 80));
		A_button.setBounds(28, 574, 94, 54);
		panel.add(A_button);

		RoundedButton B_button = new RoundedButton("B", 50);
		B_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valueIndex == 1) {
					A = calc.getText();
		        } else if (valueIndex == 2) {
		        	B = calc.getText();
		        } else if (valueIndex == 3) {
		            C = calc.getText();
		        } else if (valueIndex == 4) {
		        	D = calc.getText();
		        }
				
				calc.setText("");
		        valueIndex++;
		        numwrapper.setText(zeroCount == 0 ? ("" + B_button.getText()) : numwrapper.getText() + B_button.getText());
		        zeroCount++;
			}
		});
		B_button.setForeground(new Color(255, 255, 255));
		B_button.setBackground(new Color(80, 80, 80));
		B_button.setBounds(132, 574, 94, 54);
		panel.add(B_button);
		
		RoundedButton C_button = new RoundedButton("C", 50);
		C_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valueIndex == 1) {
					A = calc.getText();
		        } else if (valueIndex == 2) {
		        	B = calc.getText();
		        } else if (valueIndex == 3) {
		            C = calc.getText();
		        } else if (valueIndex == 4) {
		        	D = calc.getText();
		        }
							
				calc.setText("");
				valueIndex++;
				numwrapper.setText(zeroCount == 0 ? ("" + C_button.getText()) : numwrapper.getText() + C_button.getText());
				zeroCount++;
			}
		});
		C_button.setForeground(new Color(255, 255, 255));
		C_button.setBackground(new Color(80, 80, 80));
		C_button.setBounds(236, 574, 94, 54);
		panel.add(C_button);
		
		RoundedButton D_button = new RoundedButton("D", 50);
		D_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valueIndex == 1) {
					A = calc.getText();
		        } else if (valueIndex == 2) {
		        	B = calc.getText();
		        } else if (valueIndex == 3) {
		            C = calc.getText();
		        } else if (valueIndex == 4) {
		        	D = calc.getText();
		        }
							
				calc.setText("");
				valueIndex++;
				numwrapper.setText(zeroCount == 0 ? ("" + D_button.getText()) : numwrapper.getText() + D_button.getText());
				zeroCount++;
			}
		});
		D_button.setForeground(new Color(255, 255, 255));
		D_button.setBackground(new Color(80, 80, 80));
		D_button.setBounds(340, 574, 94, 54);
		panel.add(D_button);
		
		RoundedButton aFACTplusbFACT_button = new RoundedButton("a! + b!", 50);
		aFACTplusbFACT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (firstValue == null) {
		                firstValue = calc.getText();
		                
		            } else {                
		                secondValue = calc.getText();                
		            }
					calc.setText("");
					numwrapper.setText(zeroCount == 0 ?("" + "!") : numwrapper.getText() + "!");
					zeroCount++;
					operator = "a! + b!";
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
			
		aFACTplusbFACT_button.setForeground(new Color(255, 255, 255));
		aFACTplusbFACT_button.setBackground(new Color(80, 80, 80));
		aFACTplusbFACT_button.setBounds(444, 574, 147, 54);
		panel.add(aFACTplusbFACT_button);
//		ATTENTION
		RoundedButton aFACTdividebFACT_button = new RoundedButton("a! / b!", 50);
		aFACTdividebFACT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (firstValue == null) { 
		                firstValue = calc.getText();
		                
		            } else {                
		                secondValue = calc.getText();                
		            }
					calc.setText("");
					numwrapper.setText(zeroCount == 0 ?("" + "!") : numwrapper.getText() + "!");
					zeroCount++;
					operator = "a! / b!";
				} catch (Exception error) {
					holder.setText("Syntax Error");
					return;
				}
			}
		});
		aFACTdividebFACT_button.setForeground(new Color(255, 255, 255));
		aFACTdividebFACT_button.setBackground(new Color(80, 80, 80));
		aFACTdividebFACT_button.setBounds(601, 576, 145, 54);
		panel.add(aFACTdividebFACT_button);

		RoundedButton XY_button = new RoundedButton("xy", 50);
		XY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(supportedAdvancedEquation.contains(operator)) {
					equation = "xy";
					equationHolder.setText("Equation: " + equation);
				}
			}
		});
		XY_button.setForeground(new Color(255, 255, 255));
		XY_button.setBackground(new Color(80, 80, 80));
		XY_button.setBounds(28, 638, 94, 54);
		panel.add(XY_button);
		
		RoundedButton XplusY_button = new RoundedButton("x+y", 50);
		XplusY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(supportedAdvancedEquation.contains(operator)) {
					equation = "x+y";
					equationHolder.setText("Equation: " + equation);
				}
			}
		});
		XplusY_button.setForeground(new Color(255, 255, 255));
		XplusY_button.setBackground(new Color(80, 80, 80));
		XplusY_button.setBounds(132, 638, 94, 54);
		panel.add(XplusY_button);
		
		RoundedButton XpowerY = new RoundedButton("", 50);
		XpowerY.setIcon(new ImageIcon(getClass().getResource("/Picture/xy-white.png")));
		XpowerY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(supportedAdvancedEquation.contains(operator)) {
					equation = "x^y";
					equationHolder.setText("Equation: " + equation);
				}
			}
		});
		XpowerY.setForeground(new Color(255, 255, 255));
		XpowerY.setBackground(new Color(80, 80, 80));
		XpowerY.setBounds(236, 638, 94, 54);
		panel.add(XpowerY);
//		ATTENTION
		RoundedButton Cx_button = new RoundedButton("Cx", 50);
		Cx_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "Cx");
			}
		});
		Cx_button.setForeground(new Color(255, 255, 255));
		Cx_button.setBackground(new Color(80, 80, 80));
		Cx_button.setBounds(340, 638, 94, 54);
		panel.add(Cx_button);
//		ATTENTION
		RoundedButton xplusC_button = new RoundedButton("x + C", 50);
		xplusC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x + C");
			} 
		});
		xplusC_button.setForeground(new Color(255, 255, 255));
		xplusC_button.setBackground(new Color(80, 80, 80));
		xplusC_button.setBounds(444, 638, 94, 54);
		panel.add(xplusC_button);
//		ATTENTION
		RoundedButton XpowerC = new RoundedButton("", 50);
		XpowerC.setIcon(new ImageIcon(getClass().getResource("/Picture/xc.png")));
		XpowerC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x^C");
			}
		});
		XpowerC.setForeground(new Color(255, 255, 255));
		XpowerC.setBackground(new Color(80, 80, 80));
		XpowerC.setBounds(548, 638, 94, 54);
		panel.add(XpowerC);
		
		RoundedButton answer_button = new RoundedButton("ANS", 50);
		answer_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setText(calc.getText() + ANS);
				numwrapper.setText(zeroCount == 0 ?("" + "ANS") : numwrapper.getText() + "ANS");
				zeroCount ++;
			}
		});
		answer_button.setForeground(new Color(255, 255, 255));
		answer_button.setBackground(new Color(80, 80, 80));
		answer_button.setBounds(652, 640, 94, 54);
		panel.add(answer_button);
		
		helper = new CalculatorHelper(calc, numwrapper, holder, zValue, yValue, xValue, imageHolder, variableHolder, lognumx_button, logsubtwoX_button, set_button, cuberoot_button, numroot_button, equationHolder);
	}
}
// ATTENTION FIX
// MISSING FUNCTION
// CLEASN THE DAMN CODE WHY THE FUCK YOU HAVE 1.4k+ LINES OF CODE WADAPAK
