//Comentario añadido por José Rafael
package celciusConverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
//Otro comentario añadido aquí
public class CelsiusConverterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTemp;
	private JTextField textFieldFahr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CelsiusConverterGUI frame = new CelsiusConverterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CelsiusConverterGUI() {
		setTitle("Convertidor De Grados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 218, 132);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldTemp = new JTextField();
		textFieldTemp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Float.parseFloat(textFieldTemp.getText());
				} catch (NumberFormatException cambioColor) {
					textFieldTemp.setForeground(Color.RED);
					}
			}
			@Override
			public void focusGained(FocusEvent e) {
				textFieldTemp.setForeground(Color.BLACK);
			}
		});
		
		textFieldTemp.setBounds(10, 11, 86, 20);
		contentPane.add(textFieldTemp);
		textFieldTemp.setColumns(10);
		
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBackground(Color.CYAN);
		lblCelsius.setBounds(106, 14, 46, 14);
		contentPane.add(lblCelsius);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventConvert) {
				try {
					int tempFahr = (int)((Double.parseDouble(textFieldTemp.getText()))
				            * 1.8 + 32);
					textFieldFahr.setText(tempFahr + " ºF");
					textFieldTemp.setText(textFieldTemp.getText() + " ºC");
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Introduce un número");
				
				}
			}
		});
		btnConvertir.setBackground(Color.YELLOW);
		btnConvertir.setBounds(110, 70, 86, 23);
		contentPane.add(btnConvertir);
		
		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(106, 45, 99, 14);
		contentPane.add(lblFahrenheit);
		
		textFieldFahr = new JTextField();
		textFieldFahr.setBackground(Color.LIGHT_GRAY);
		textFieldFahr.setBounds(10, 42, 86, 20);
		contentPane.add(textFieldFahr);
		textFieldFahr.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eventLimpiar) {
				textFieldFahr.setText("");
				textFieldTemp.setText("");
				
			}
		});
		btnLimpiar.setBackground(Color.RED);
		btnLimpiar.setBounds(10, 70, 91, 23);
		contentPane.add(btnLimpiar);
	}
}
