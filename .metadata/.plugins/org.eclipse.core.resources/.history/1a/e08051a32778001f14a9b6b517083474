package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class BSIT2A extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	  Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSIT2A frame = new BSIT2A();
					frame.setTitle("Advance Calculator");
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

	String firstValue, secondValue, thirdValue, fourthValue, operator, A, B, C, D;;
    double firstDoubleValue, secondDoubleValue, thirdDoubleValue, fourthDoubleValue, Answer, result, ANS;
    int decimalCount = 0, zeroCount = 0, valueIndex = 1;
    int start, end, constant, sum, jstart, jend, equation;
    int a = 1, b = 1;
    boolean reset = false, isMinus = false;
    private ArrayList<Integer> numbers = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public BSIT2A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 17, 775, 704);
		panel.setBackground(new Color(28, 28, 28));
		contentPane.add(panel);
		panel.setLayout(null);
		
		RoundedPanel panel_1 = new RoundedPanel(100);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(28, 36, 718, 136);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		RoundJTextField calc = new RoundJTextField(10);
//		calc.setSize(135, 33);
//		calc.setLocation(10, 10);
		panel_1.add(calc);
		calc.setColumns(10);
		
		RoundJTextField numwrapper = new RoundJTextField(500);
		numwrapper.setHorizontalAlignment(SwingConstants.TRAILING);
		numwrapper.setEditable(false);
		numwrapper.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		numwrapper.setBackground(new Color(255, 255, 255));
		numwrapper.setBounds(10, 33, 698, 72);
		numwrapper.setText("0");
		panel_1.add(numwrapper);
		numwrapper.setColumns(10);
		
		RoundJTextField holder = new RoundJTextField(10);
		holder.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		holder.setHorizontalAlignment(SwingConstants.LEFT);
		holder.setBackground(new Color(255, 255, 255));
		holder.setEditable(false);
		holder.setBounds(37, 2, 210, 41);
		panel_1.add(holder);
		holder.setColumns(10);
		
		RoundedButton DEL_button = new RoundedButton("DEL", 50);
		DEL_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		DEL_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentEq = calc.getText();
				String currentText = numwrapper.getText();
				if (currentText.equals("0") || currentEq.equals("0")) {
					return;
				} else if(currentText.length() == 2 || currentEq.length() == 2) {
					numwrapper.setText("0");
					calc.setText("0");
				} else if (currentText.length() > 1) {
					numwrapper.setText(currentText.substring(0, currentText.length() - 1));
				} else if (currentEq.length() > 1) {
					calc.setText(currentEq.substring(0, currentEq.length() - 1));
				} else {
					numwrapper.setText("0");
					calc.setText("0");
				}
				
				if (!numbers.isEmpty()) {
		            numbers.remove(numbers.size() - 1);
		        }
				
				if(valueIndex == 1) {
					valueIndex = 1;
				} else {
					valueIndex--;
				}
				if (zeroCount == 0) {
					zeroCount = 0;
				} else {
					zeroCount --;
				}
				
				if (zeroCount == 0) {
					holder.setText("");
				} else {
					return;
				}
				
				reset = false;
				isMinus = false;
			}
		});
		
		
		DEL_button.setForeground(new Color(0, 0, 0));
		DEL_button.setBackground(new Color(212, 212, 210));
		DEL_button.setBounds(28, 192, 94, 54);
		panel.add(DEL_button);
		
		RoundedButton AC_button = new RoundedButton("AC", 50);
		AC_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		AC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText("0");
				calc.setText("0");
				holder.setText("");
				firstValue = null;
				secondValue = null;
				thirdValue = null;
				fourthValue = null;
				firstDoubleValue = 0;
				secondDoubleValue = 0;
				thirdDoubleValue = 0;
				fourthDoubleValue = 0;
				Answer = 0;
				decimalCount = 0;
				zeroCount = 0;
				valueIndex = 0;
			    A = null;
			    B = null;
			    C = null;
			    D = null;
			    reset = false;
			    isMinus = false;
			    numbers.clear();
			}
		});
		AC_button.setForeground(new Color(0, 0, 0));
		AC_button.setBackground(new Color(212, 212, 210));
		AC_button.setBounds(132, 192, 94, 54);
		panel.add(AC_button);
		
		RoundedButton plus_minusbutton = new RoundedButton("+/-", 50);
		plus_minusbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		plus_minusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (zeroCount != 0) {
					 firstDoubleValue = Double.parseDouble(calc.getText());
					 String currentText = calc.getText();
					 if (isMinus) {
						 currentText = currentText.substring(1);
						 calc.setText(currentText);
						 numwrapper.setText(currentText);
						 isMinus = false;
					 } else {
						 calc.setText("-" + currentText);
						 numwrapper.setText(calc.getText());
						 holder.setText("+/-" + firstDoubleValue);
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
		plus_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		plus_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "+");
				operator = plus_button.getText();
	            decimalCount = 0;
				numbers.add(Integer.parseInt(calc.getText()));
				calc.setText("");
			}
		});
		plus_button.setForeground(new Color(255, 255, 255));
		plus_button.setBackground(new Color(254, 143, 0));
		plus_button.setBounds(340, 192, 94, 54);
		panel.add(plus_button);
		
		RoundedButton FLR_button = new RoundedButton("FLR", 50);
		FLR_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		FLR_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double flooredValue = Math.floor(currentValue);
		            
		            calc.setText(String.valueOf(flooredValue));
		            numwrapper.setText(calc.getText());
		        } catch (NumberFormatException ex) {
		            numwrapper.setText("0");
		            calc.setText("0");
		        }
			}
		});
		FLR_button.setForeground(new Color(0, 0, 0));
		FLR_button.setBackground(new Color(212, 212, 210));
		FLR_button.setBounds(444, 192, 94, 54);
		panel.add(FLR_button);
		
		RoundedButton CEIL_button = new RoundedButton("CEIL", 50);
		CEIL_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		CEIL_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double ceiledValue = Math.ceil(currentValue);
		            
		            calc.setText(String.valueOf(ceiledValue));
		            numwrapper.setText(calc.getText());
		        } catch (NumberFormatException ex) {
		            numwrapper.setText("0");
		            calc.setText("0");
		        }
			}
		});
		CEIL_button.setForeground(new Color(0, 0, 0));
		CEIL_button.setBackground(new Color(212, 212, 210));
		CEIL_button.setBounds(548, 192, 94, 54);
		panel.add(CEIL_button);
		
		RoundedButton INT_button = new RoundedButton("INT", 50);
		INT_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		INT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            int intValue = (int) currentValue;

		            calc.setText(String.valueOf(intValue));
		            numwrapper.setText(calc.getText());
		        } catch (NumberFormatException ex) {
		            numwrapper.setText("0");
		            calc.setText("0");
		        }
			}
		});
		INT_button.setForeground(new Color(0, 0, 0));
		INT_button.setBackground(new Color(212, 212, 210));
		INT_button.setBounds(652, 192, 94, 54);
		panel.add(INT_button);
		
		RoundedButton seven_button = new RoundedButton("7", 50);
		seven_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		seven_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + seven_button.getText()) : calc.getText() + seven_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + seven_button.getText()) : numwrapper.getText() + seven_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + seven_button.getText()) : calc.getText() + seven_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + seven_button.getText()) : numwrapper.getText() + seven_button.getText());
					zeroCount++;
				}
			}
		});
		seven_button.setForeground(new Color(255, 255, 255));
		seven_button.setBackground(new Color(80, 80, 80));
		seven_button.setBounds(28, 256, 94, 54);
		panel.add(seven_button);
		
		RoundedButton eight_button = new RoundedButton("8", 50);
		eight_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		eight_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + eight_button.getText()) : calc.getText() + eight_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + eight_button.getText()) : numwrapper.getText() + eight_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + eight_button.getText()) : calc.getText() + eight_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + eight_button.getText()) : numwrapper.getText() + eight_button.getText());
					zeroCount++;
				}
			}
		});
		eight_button.setForeground(new Color(255, 255, 255));
		eight_button.setBackground(new Color(80, 80, 80));
		eight_button.setBounds(132, 256, 94, 54);
		panel.add(eight_button);
		
		RoundedButton nine_button = new RoundedButton("9", 50);
		nine_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		nine_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + nine_button.getText()) : calc.getText() + nine_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + nine_button.getText()) : numwrapper.getText() + nine_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + nine_button.getText()) : calc.getText() + nine_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + nine_button.getText()) : numwrapper.getText() + nine_button.getText());
			        zeroCount++;
				}
			}
		});
		nine_button.setForeground(new Color(255, 255, 255));
		nine_button.setBackground(new Color(80, 80, 80));
		nine_button.setBounds(236, 256, 94, 54);
		panel.add(nine_button);
		
		RoundedButton minus_button = new RoundedButton("-", 50);
		minus_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		minus_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            numwrapper.setText(numwrapper.getText() + "-");
				operator = minus_button.getText();
	            decimalCount = 0;
				numbers.add(Integer.parseInt(calc.getText()));
				calc.setText("");
			}
			
		});
		minus_button.setForeground(new Color(255, 255, 255));
		minus_button.setBackground(new Color(254, 143, 0));
		minus_button.setBounds(340, 256, 94, 54);
		panel.add(minus_button);
		
		RoundedButton integerdivision_button = new RoundedButton("//", 50);
		integerdivision_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		integerdivision_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
		            firstValue = calc.getText();
		        } else {
		            secondValue = calc.getText();
		        }

		        calc.setText("");
		        numwrapper.setText(numwrapper.getText() + "//");
		        operator = integerdivision_button.getText();
		        decimalCount = 0;
		    }
		});
		integerdivision_button.setForeground(new Color(0, 0, 0));
		integerdivision_button.setBackground(new Color(212, 212, 210));
		integerdivision_button.setBounds(444, 256, 94, 54);
		panel.add(integerdivision_button);
		
		RoundedButton modulus = new RoundedButton("%", 50);
		modulus.setFont(new Font("Tahoma", Font.BOLD, 15));
		modulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
					firstValue = calc.getText();
				} else {                
					secondValue = calc.getText();    
				}      
				
				calc.setText("");
				numwrapper.setText(numwrapper.getText() + "%");
				operator = modulus.getText();
				decimalCount = 0;
			}
		});
		modulus.setForeground(new Color(0, 0, 0));
		modulus.setBackground(new Color(212, 212, 210));
		modulus.setBounds(548, 256, 94, 54);
		panel.add(modulus);
		
		RoundedButton factorial_button = new RoundedButton("N!", 50);
		factorial_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		factorial_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = calc.getText();
	            } else {
	                secondValue = calc.getText();                
	            }
				calc.setText("");
				numwrapper.setText(numwrapper.getText() + "!");
	            operator = factorial_button.getText();
	            decimalCount = 0;
			}
		});
		factorial_button.setForeground(new Color(0, 0, 0));
		factorial_button.setBackground(new Color(212, 212, 210));
		factorial_button.setBounds(652, 256, 94, 54);
		panel.add(factorial_button);
		
		RoundedButton four_button = new RoundedButton("4", 50);
		four_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		four_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + four_button.getText()) : calc.getText() + four_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + four_button.getText()) : numwrapper.getText() + four_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + four_button.getText()) : calc.getText() + four_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + four_button.getText()) : numwrapper.getText() + four_button.getText());
			        zeroCount++;
				}
			}
		});
		four_button.setForeground(new Color(255, 255, 255));
		four_button.setBackground(new Color(80, 80, 80));
		four_button.setBounds(28, 320, 94, 54);
		panel.add(four_button);
		
		RoundedButton five_button = new RoundedButton("5", 50);
		five_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		five_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + five_button.getText()) : calc.getText() + five_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + five_button.getText()) : numwrapper.getText() + five_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + five_button.getText()) : calc.getText() + five_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + five_button.getText()) : numwrapper.getText() + five_button.getText());
			        zeroCount++;
				}
			}
		});
		five_button.setForeground(new Color(255, 255, 255));
		five_button.setBackground(new Color(80, 80, 80));
		five_button.setBounds(132, 320, 94, 54);
		panel.add(five_button);
		
		RoundedButton six_button = new RoundedButton("6", 50);
		six_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		six_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + six_button.getText()) : calc.getText() + six_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + six_button.getText()) : numwrapper.getText() + six_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + six_button.getText()) : calc.getText() + six_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + six_button.getText()) : numwrapper.getText() + six_button.getText());
			        zeroCount++;
				}
			}
		});
		six_button.setForeground(new Color(255, 255, 255));
		six_button.setBackground(new Color(80, 80, 80));
		six_button.setBounds(236, 320, 94, 54);
		panel.add(six_button);
		
		RoundedButton multiplication_button = new RoundedButton("*", 50);
		multiplication_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		multiplication_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 numwrapper.setText(numwrapper.getText() + "*");
				 operator = multiplication_button.getText();
				 decimalCount = 0;
				 numbers.add(Integer.parseInt(calc.getText()));
				 calc.setText("");
			}
		});
		multiplication_button.setForeground(new Color(255, 255, 255));
		multiplication_button.setBackground(new Color(254, 143, 0));
		multiplication_button.setBounds(340, 320, 94, 54);
		panel.add(multiplication_button);
		
		RoundedButton squareroot_button = new RoundedButton("√", 50);
		squareroot_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		squareroot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double squreRootValue = Math.sqrt(currentValue);
		            
		            calc.setText(String.valueOf(squreRootValue));
		        } catch (NumberFormatException ex) {
		        	calc.setText("0");
		            numwrapper.setText("0");
		        }
				numwrapper.setText(calc.getText());
			}
		});
		squareroot_button.setForeground(new Color(0, 0, 0));
		squareroot_button.setBackground(new Color(212, 212, 210));
		squareroot_button.setBounds(444, 320, 94, 54);
		panel.add(squareroot_button);
		
		RoundedButton cuberoot_button = new RoundedButton("", 50);
		cuberoot_button.setIcon(new ImageIcon(getClass().getResource("/Picture/cuberoot.png")));
		cuberoot_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cuberoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            double currentValue = Double.parseDouble(calc.getText().trim());
		            double cubeRootValue = Math.cbrt(currentValue);
		            
		            calc.setText(String.valueOf(cubeRootValue));
		        } catch (NumberFormatException ex) {
		            calc.setText("0");
		            numwrapper.setText("0");
		        }
				numwrapper.setText(calc.getText());
			}
		});
		cuberoot_button.setForeground(new Color(0, 0, 0));
		cuberoot_button.setBackground(new Color(212, 212, 210));
		cuberoot_button.setBounds(548, 320, 94, 54);
		panel.add(cuberoot_button);
//		ATTENTION
		RoundedButton summation_button = new RoundedButton("", 50);	
		summation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/summation.png")));
		summation_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		summation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ?("" + "∑") : numwrapper.getText() + "∑");
				zeroCount++;
				operator = "∑";
				decimalCount = 0;
				valueIndex = 1;
			}
		});
		summation_button.setForeground(new Color(0, 0, 0));
		summation_button.setBackground(new Color(212, 212, 210));
		summation_button.setBounds(652, 320, 94, 54);
		panel.add(summation_button);
		
		RoundedButton one_button = new RoundedButton("1", 50);
		one_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		one_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + one_button.getText()) : calc.getText() + one_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + one_button.getText()) : numwrapper.getText() + one_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + one_button.getText()) : calc.getText() + one_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + one_button.getText()) : numwrapper.getText() + one_button.getText());
			        zeroCount++;
				}
			}
		});
		one_button.setForeground(new Color(255, 255, 255));
		one_button.setBackground(new Color(80, 80, 80));
		one_button.setBounds(28, 384, 94, 54);
		panel.add(one_button);
		
		RoundedButton two_button = new RoundedButton("2", 50);
		two_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		two_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + two_button.getText()) : calc.getText() + two_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + two_button.getText()) : numwrapper.getText() + two_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + two_button.getText()) : calc.getText() + two_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + two_button.getText()) : numwrapper.getText() + two_button.getText());
			        zeroCount++;
				}
			}
		});
		two_button.setForeground(new Color(255, 255, 255));
		two_button.setBackground(new Color(80, 80, 80));
		two_button.setBounds(132, 384, 94, 54);
		panel.add(two_button);
		
		RoundedButton three_button = new RoundedButton("3", 50);
		three_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		three_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					calc.setText(zeroCount == 0 ? ("" + three_button.getText()) : calc.getText() + three_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + three_button.getText()) : numwrapper.getText() + three_button.getText());
			        zeroCount++;
					
				} else {
					calc.setText(zeroCount == 0 ? ("" + three_button.getText()) : calc.getText() + three_button.getText());
					numwrapper.setText(zeroCount == 0 ? ("" + three_button.getText()) : numwrapper.getText() + three_button.getText());
			        zeroCount++;
				}
			}
		});
		three_button.setForeground(new Color(255, 255, 255));
		three_button.setBackground(new Color(80, 80, 80));
		three_button.setBounds(236, 384, 94, 54);
		panel.add(three_button);
		
		RoundedButton division_button = new RoundedButton("÷", 50);
		division_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		division_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "÷");
				operator = division_button.getText();
				decimalCount = 0;
				numbers.add(Integer.parseInt(calc.getText()));
				calc.setText("");
			}
		});
		division_button.setForeground(new Color(255, 255, 255));
		division_button.setBackground(new Color(254, 143, 0));
		division_button.setBounds(340, 384, 94, 54);
		panel.add(division_button);
//		ATTENTION
		RoundedButton XpowerY_button = new RoundedButton("", 50);
		XpowerY_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerY_button.setIcon(new ImageIcon(getClass().getResource("/Picture/X.png")));
		XpowerY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = calc.getText();
	                
	            } else {                
	                secondValue = calc.getText();                
	            }
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ? ("" + "^") : numwrapper.getText() + "^");
				zeroCount ++;
	            operator = "x^y";
	            decimalCount = 0;
			}
		});
		XpowerY_button.setForeground(new Color(0, 0, 0));
		XpowerY_button.setBackground(new Color(212, 212, 210));
		XpowerY_button.setBounds(444, 384, 94, 54);
		panel.add(XpowerY_button);
//		ATTENTION
		RoundedButton XpowerYpowerofZ_button = new RoundedButton("", 50);
		XpowerYpowerofZ_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerYpowerofZ_button.setIcon(new ImageIcon(getClass().getResource("/Picture/xyz.png")));
		XpowerYpowerofZ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = calc.getText();
	                
	            } else if(secondValue == null) {                
	                secondValue = calc.getText(); 
	                
	            } else if(thirdValue == null) {
	            	thirdValue = calc.getText();
	            }

				calc.setText("");
				numwrapper.setText(zeroCount == 0 ? ("" + "^") : numwrapper.getText() + "^");
				zeroCount ++;
	            operator = "x^y^z";
	            decimalCount = 0;
			}
		});
		XpowerYpowerofZ_button.setForeground(new Color(0, 0, 0));
		XpowerYpowerofZ_button.setBackground(new Color(212, 212, 210));
		XpowerYpowerofZ_button.setBounds(548, 384, 94, 54);
		panel.add(XpowerYpowerofZ_button);
//		ATTENTION
		RoundedButton productnotation_button = new RoundedButton("", 50);
		productnotation_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		productnotation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/prodnot.png")));
		productnotation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ? ("" + "Π") : numwrapper.getText() + "Π");
				zeroCount++;
				operator = "Π";
				decimalCount = 0;
				valueIndex = 1;
			}
		});
		productnotation_button.setForeground(new Color(0, 0, 0));
		productnotation_button.setBackground(new Color(212, 212, 210));
		productnotation_button.setBounds(652, 384, 94, 54);
		panel.add(productnotation_button);
		
		RoundedButton zero_button = new RoundedButton("0", 50);
		zero_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		zero_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reset) {
					numwrapper.setText("");
					calc.setText("");
					reset = false;
					if(zeroCount !=0) {
						  calc.setText(calc.getText() + zero_button.getText());
						  numwrapper.setText(numwrapper.getText() + "0");
					}
					
				} else {
					if(zeroCount !=0) {
						  calc.setText(calc.getText() + zero_button.getText());
						  numwrapper.setText(numwrapper.getText() + "0");
					}
				}
			}
		});
		zero_button.setForeground(new Color(0, 0, 0));
		zero_button.setBackground(new Color(212, 212, 210));
		zero_button.setBounds(28, 448, 94, 54);
		panel.add(zero_button);
		
		RoundedButton period_button = new RoundedButton(".", 50);
		period_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		period_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 decimalCount++;
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
		equals_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		equals_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(operator) {
				case "∑":
					firstValue = A;
					secondValue = B;
					thirdValue = C;
					firstDoubleValue = Integer.parseInt(firstValue);
					secondDoubleValue = Integer.parseInt(secondValue);
					thirdDoubleValue = Integer.parseInt(thirdValue);
					
					int summation = (int) Functions.summation(firstDoubleValue, secondDoubleValue, thirdDoubleValue);
					calc.setText("" + summation);
	            	numwrapper.setText(calc.getText());
	            	ANS = summation;
					break;
	            	
				case "∑∑":
					firstValue = A;
					secondValue = B;
					thirdValue = C;
					fourthValue = D;
					firstDoubleValue = Double.parseDouble(firstValue);
					secondDoubleValue = Double.parseDouble(secondValue);
					thirdDoubleValue = Double.parseDouble(thirdValue);
					fourthDoubleValue = Double.parseDouble(fourthValue);
					
					int doubleSummation = (int) Functions.doubleSummation(firstDoubleValue, secondDoubleValue, thirdDoubleValue, fourthDoubleValue);
					calc.setText("" + doubleSummation);
	            	numwrapper.setText(calc.getText());
	            	ANS = doubleSummation;
					break;
	            	
				case "Π":
					firstValue = A;
					secondValue = B;
					thirdValue = C;
					firstDoubleValue = Double.parseDouble(firstValue);
					secondDoubleValue = Double.parseDouble(secondValue);
					thirdDoubleValue = Double.parseDouble(thirdValue);
					
					int prodnot = (int) Functions.prodnot(firstDoubleValue, secondDoubleValue, thirdDoubleValue);
	            	calc.setText("" + prodnot);
	            	numwrapper.setText(calc.getText());
	            	ANS = prodnot;
	            	break;
	            	
				case "ΠΠ":
					firstValue = A;
					secondValue = B;
					thirdValue = C;
					fourthValue = D;
					firstDoubleValue = Double.parseDouble(firstValue);
					secondDoubleValue = Double.parseDouble(secondValue);
					thirdDoubleValue = Double.parseDouble(thirdValue);
					fourthDoubleValue = Double.parseDouble(fourthValue);
					
					int doubleProdNot = (int) Functions.doubleProdNot(firstDoubleValue, secondDoubleValue, thirdDoubleValue, fourthDoubleValue);
					
					calc.setText("" + doubleProdNot);
	            	numwrapper.setText(calc.getText());
	            	ANS = doubleProdNot;
					break;
	            
				case "N!":
					firstDoubleValue = Double.parseDouble(firstValue);
					int factorial = Functions.factorial(firstDoubleValue);
					calc.setText("" + factorial);
					numwrapper.setText(calc.getText());
					ANS = factorial;
					break;
					
				case "a! + b!":
					firstDoubleValue = Double.parseDouble(firstValue);
					secondDoubleValue = Double.parseDouble(secondValue);
					int sumFactorial = Functions.sumFactorial(firstDoubleValue, secondDoubleValue);
					calc.setText("" + sumFactorial);
					numwrapper.setText(calc.getText());
					ANS = sumFactorial;
					break;
					
				case "a! / b!":
					firstDoubleValue = Integer.parseInt(firstValue);
					secondDoubleValue = Integer.parseInt(secondValue);
					int divideFactorial = Functions.divideFactorial(firstDoubleValue, secondDoubleValue);
					calc.setText("" + divideFactorial);
					numwrapper.setText(calc.getText());
					ANS = divideFactorial;
					break;
					
				case "log(2)(":
					firstValue = calc.getText();
					firstDoubleValue = Double.parseDouble(firstValue);
					Answer = Math.log(firstDoubleValue) / Math.log(2);
					calc.setText("" + Answer);
					numwrapper.setText(calc.getText());
					ANS = Answer;
					break;
					
				case "log(":
					firstValue = calc.getText();
					firstDoubleValue = Double.parseDouble(firstValue);
					Answer = Math.log(firstDoubleValue);
					calc.setText("" + Answer);
					numwrapper.setText(calc.getText());
					ANS = Answer;
					break;
				case "x^y^z":
					firstDoubleValue = Double.parseDouble(firstValue);
					secondDoubleValue = Double.parseDouble(secondValue);
					thirdDoubleValue = Double.parseDouble(thirdValue);
					holder.setText(numwrapper.getText());
					result =  Math.pow(thirdDoubleValue, secondDoubleValue);
					Answer =  Math.pow(firstDoubleValue, result);
					calc.setText("" + Answer);
					numwrapper.setText(calc.getText());
					ANS = Answer;
					break;
					
				default:
					if (!calc.getText().isEmpty()) {
						numbers.add((int) Double.parseDouble(calc.getText()));
					}
					Answer = Functions.calculateResult(numbers, operator);
					
					calc.setText("" + Answer);   
					numwrapper.setText(calc.getText());
					ANS = Answer;
				}
				
				reset = true;
				firstValue = null;
				decimalCount = 0;
			}
		});
		equals_button.setForeground(new Color(255, 255, 255));
		equals_button.setBackground(new Color(254, 143, 0));
		equals_button.setBounds(236, 448, 198, 54);
		panel.add(equals_button);
//		ATTENTION
		RoundedButton doublesummation_button = new RoundedButton("", 50);
		doublesummation_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		doublesummation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/doublesum.png")));
		doublesummation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ?("" + "∑∑") : numwrapper.getText() + "∑∑");
				zeroCount++;
				operator = "∑∑";
				decimalCount = 0;
				valueIndex = 1;
			}
		});
		doublesummation_button.setForeground(new Color(0, 0, 0));
		doublesummation_button.setBackground(new Color(212, 212, 210));
		doublesummation_button.setBounds(444, 448, 147, 54);
		panel.add(doublesummation_button);
//		ATTENTION
		RoundedButton doubleproductnotation_button = new RoundedButton("", 50);
		doubleproductnotation_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		doubleproductnotation_button.setIcon(new ImageIcon(getClass().getResource("/Picture/doubleprodnot.png")));
		doubleproductnotation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ?("" + "ΠΠ") : numwrapper.getText() + "ΠΠ");
				zeroCount++;
				operator = "ΠΠ";
				decimalCount = 0;
				valueIndex = 1;
			}
		});
		doubleproductnotation_button.setForeground(new Color(0, 0, 0));
		doubleproductnotation_button.setBackground(new Color(212, 212, 210));
		doubleproductnotation_button.setBounds(601, 448, 145, 54);
		panel.add(doubleproductnotation_button);
//		ATTENTION
		RoundedButton set_button = new RoundedButton("SET", 50);
		set_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		set_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "SET");
			}
		});
		set_button.setForeground(new Color(255, 255, 255));
		set_button.setBackground(new Color(80, 80, 80));
		set_button.setBounds(28, 510, 406, 54);
		panel.add(set_button);
//		ATTENTION
		RoundedButton logsubtwoX_button = new RoundedButton("", 50);
		logsubtwoX_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logsubtwoX_button.setIcon(new ImageIcon(getClass().getResource("/Picture/log2x.png")));
		logsubtwoX_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ?("" + "log(2)(") : numwrapper.getText() + "log(2)(");
				zeroCount++;
				operator = "log(2)(";
				decimalCount = 0;
				valueIndex = 1;
			}
		});
		logsubtwoX_button.setForeground(new Color(255, 255, 255));
		logsubtwoX_button.setBackground(new Color(80, 80, 80));
		logsubtwoX_button.setBounds(444, 510, 147, 54);
		panel.add(logsubtwoX_button);
//		ATTENTION
		RoundedButton logX_button = new RoundedButton("", 50);
		logX_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logX_button.setIcon(new ImageIcon(getClass().getResource("/Picture/logx.png")));
		logX_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ?("" + "log(") : numwrapper.getText() + "log(");
				zeroCount++;
				operator = "log(";
				decimalCount = 0;
				valueIndex = 1;
			}
		});
		logX_button.setForeground(new Color(255, 255, 255));
		logX_button.setBackground(new Color(80, 80, 80));
		logX_button.setBounds(601, 512, 145, 54);
		panel.add(logX_button);

		RoundedButton A_button = new RoundedButton("A", 50);
		A_button.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		B_button.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		C_button.setFont(new Font("Tahoma", Font.BOLD, 15));
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
//		ATTENTION
		RoundedButton D_button = new RoundedButton("D", 50);
		D_button.setFont(new Font("Tahoma", Font.BOLD, 15));
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
//		ATTENTION
		RoundedButton aFACTplusbFACT_button = new RoundedButton("a! + b!", 50);
		aFACTplusbFACT_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		aFACTplusbFACT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = calc.getText();
	                
	            } else {                
	                secondValue = calc.getText();                
	            }
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ?("" + "!") : numwrapper.getText() + "!");
				zeroCount++;
				operator = "a! + b!";
			}
		});
		aFACTplusbFACT_button.setForeground(new Color(255, 255, 255));
		aFACTplusbFACT_button.setBackground(new Color(80, 80, 80));
		aFACTplusbFACT_button.setBounds(444, 574, 147, 54);
		panel.add(aFACTplusbFACT_button);
//		ATTENTION
		RoundedButton aFACTdividebFACT_button = new RoundedButton("a! / b!", 50);
		aFACTdividebFACT_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		aFACTdividebFACT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = calc.getText();
	                
	            } else {                
	                secondValue = calc.getText();                
	            }
				calc.setText("");
				numwrapper.setText(zeroCount == 0 ?("" + "!") : numwrapper.getText() + "!");
				zeroCount++;
				operator = "a! / b!";
			}
		});
		aFACTdividebFACT_button.setForeground(new Color(255, 255, 255));
		aFACTdividebFACT_button.setBackground(new Color(80, 80, 80));
		aFACTdividebFACT_button.setBounds(601, 576, 145, 54);
		panel.add(aFACTdividebFACT_button);
//		ATTENTION
		RoundedButton XY_button = new RoundedButton("xy", 50);
		XY_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		XY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "xy");
			}
		});
		XY_button.setForeground(new Color(255, 255, 255));
		XY_button.setBackground(new Color(80, 80, 80));
		XY_button.setBounds(28, 638, 94, 54);
		panel.add(XY_button);
//		ATTENTION
		RoundedButton XplusY_button = new RoundedButton("x+y", 50);
		XplusY_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XplusY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x+y");
			}
		});
		XplusY_button.setForeground(new Color(255, 255, 255));
		XplusY_button.setBackground(new Color(80, 80, 80));
		XplusY_button.setBounds(132, 638, 94, 54);
		panel.add(XplusY_button);
//		ATTENTION
		RoundedButton XpowerY = new RoundedButton("", 50);
		XpowerY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerY.setIcon(new ImageIcon(getClass().getResource("/Picture/xy-white.png")));
		XpowerY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x^y");
			}
		});
		XpowerY.setForeground(new Color(255, 255, 255));
		XpowerY.setBackground(new Color(80, 80, 80));
		XpowerY.setBounds(236, 638, 94, 54);
		panel.add(XpowerY);
//		ATTENTION
		RoundedButton Cx_button = new RoundedButton("Cx", 50);
		Cx_button.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		xplusC_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		XpowerC.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		answer_button.setFont(new Font("Tahoma", Font.BOLD, 15));
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
	}
}
