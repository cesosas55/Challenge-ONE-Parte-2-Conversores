package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CurrencyConverterDlg extends JFrame {

	private JPanel contentPane;
	private JTextField textField_monto = new JTextField();
	private Color fondoBlanco = new Color(255, 255, 255);
	private String montoInicial = "0";
	private double multiplicador;

	// Definicion de los elementos del marco
	private JLabel lbl_importe = new JLabel("Importe");
	private JLabel lbl_entrada = new JLabel("De:");
	private JLabel lbl_salida = new JLabel("a:");
	private JComboBox<String> comboBox_divisaIn;
	private JComboBox<String> comboBox_divisaOut;

	JLabel lbl_infoEntrada = new JLabel("00.00 DIVISA =");
	JLabel lbl_resultado = new JLabel("000.00 DIVISA");
	JLabel lbl_tipoDeCambio = new JLabel("Tipo de cambio");
	JLabel lbl_tipoDeCambio_INV = new JLabel("Tipo de cambio INV");

	private ImageIcon iconoInvertir = new ImageIcon(
			"C:\\Users\\Jarvis\\eclipse-workspace\\Challenges\\Challenge 2 - Converter\\ConversionTools\\src\\main\\icons\\loading.png");

	private static String divisas[] = new String[Divisa.values().length];
	private int i = 0;

	private AgenteMonetario manejador = new AgenteMonetario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverterDlg frame = new CurrencyConverterDlg();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrencyConverterDlg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(fondoBlanco);
		setLocationRelativeTo(null);
		setSize(550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(fondoBlanco);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Creaci�n del vector de divisas a partir del enum
		for (Divisa div : Divisa.values()) {
			divisas[i] = div.label;
			i++;
		}
		// obtiene los datos de covnersi�n de divisas;
		manejador.crearCacheMxn(Divisa.MXN.toString());
		

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		// setup: lbl_importe
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_importe, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_importe, 25, SpringLayout.WEST, contentPane);
		lbl_importe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbl_importe);
		// setup: lbl_entrada
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_entrada, 25, SpringLayout.NORTH, contentPane);
		lbl_entrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbl_entrada);
		// setup: lbl_salida
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_salida, 25, SpringLayout.NORTH, contentPane);
		lbl_salida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbl_salida);
		// setup: textField_monto
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_monto, 125, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_entrada, 25, SpringLayout.EAST, textField_monto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_monto, 25, SpringLayout.NORTH, lbl_importe);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_monto, 25, SpringLayout.WEST, contentPane);
		textField_monto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_monto.setHorizontalAlignment(SwingConstants.CENTER);
		textField_monto.setText(montoInicial);
		contentPane.add(textField_monto);
		textField_monto.setColumns(10);
		// setup: comboBox_divisaIn
		comboBox_divisaIn = new JComboBox<String>(divisas);
		comboBox_divisaIn.setBackground(new Color(255, 255, 255));
		comboBox_divisaIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_divisaIn.setSelectedIndex(0);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_divisaIn, 25, SpringLayout.NORTH, lbl_entrada);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_divisaIn, 25, SpringLayout.EAST, textField_monto);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_divisaIn, 175, SpringLayout.EAST, textField_monto);
		contentPane.add(comboBox_divisaIn);
		// setup: comboBox_divisaOut
		comboBox_divisaOut = new JComboBox<String>(divisas);
		comboBox_divisaOut.setBackground(new Color(255, 255, 255));
		comboBox_divisaOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_divisaOut.setSelectedIndex(1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_divisaOut, 25, SpringLayout.NORTH, lbl_salida);
		contentPane.add(comboBox_divisaOut);
		// setup: btn_invertir
		JButton btn_invertir = new JButton("");
		btn_invertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("Boton INVERTIR presionado");//Test de funcionamiento del
				// Boton
				boolean sonIguales = comboBox_divisaIn.getSelectedIndex() == comboBox_divisaOut.getSelectedIndex();
				if (!sonIguales) {
					int i = 0;
					i = comboBox_divisaIn.getSelectedIndex();
					comboBox_divisaIn.setSelectedIndex(comboBox_divisaOut.getSelectedIndex());
					comboBox_divisaOut.setSelectedIndex(i);
				}
			}
		});
		btn_invertir.setIcon(iconoInvertir);
		btn_invertir.setBackground(new Color(255, 255, 255));
		btn_invertir.setBorderPainted(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, btn_invertir, 15, SpringLayout.EAST, comboBox_divisaIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, btn_invertir, 35, SpringLayout.EAST, comboBox_divisaIn);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_divisaOut, 165, SpringLayout.EAST, btn_invertir);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_divisaOut, 15, SpringLayout.EAST, btn_invertir);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_salida, 15, SpringLayout.EAST, btn_invertir);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btn_invertir, 25, SpringLayout.NORTH, lbl_entrada);
		contentPane.add(btn_invertir);
		// setup: lbl_infoEntrada
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_infoEntrada, 100, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_infoEntrada, 175, SpringLayout.WEST, contentPane);
		lbl_infoEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_infoEntrada, 25, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_infoEntrada);
		// setup: lbl_resultado
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_resultado, 275, SpringLayout.WEST, contentPane);
		lbl_resultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_resultado, 25, SpringLayout.SOUTH, lbl_infoEntrada);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_resultado, 25, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_resultado);
		// setup: lbl_tipoDeCambio
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_tipoDeCambio, 25, SpringLayout.NORTH, lbl_resultado);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_tipoDeCambio, 25, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_tipoDeCambio, 225, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_tipoDeCambio);

		// setup: lbl_tipoDeCambio_INV
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_tipoDeCambio_INV, 6, SpringLayout.SOUTH, lbl_tipoDeCambio);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_tipoDeCambio_INV, 25, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_tipoDeCambio_INV, 225, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_tipoDeCambio_INV);
		// setup: btn_convertir
		JButton btn_convertir = new JButton("Convertir");
		btn_convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Boton CONVERTIR presionado"); //Test de funcionamiento
				// del Boton
				int i = comboBox_divisaIn.getSelectedIndex();
				int j = comboBox_divisaOut.getSelectedIndex();
				boolean mismaMoneda = i == j;
				if (mismaMoneda) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Las divisas son iguales", "Atenci�n",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// System.out.println("Moneda de entrada: " + Divisa.values()[i].toString());
					// System.out.println("Moneda de salida: " + Divisa.values()[j].toString());
					alterarEtiquetas(textField_monto.getText(), comboBox_divisaIn.getSelectedIndex(),
							comboBox_divisaOut.getSelectedIndex());
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btn_convertir, 0, SpringLayout.NORTH, lbl_infoEntrada);
		sl_contentPane.putConstraint(SpringLayout.WEST, btn_convertir, 50, SpringLayout.WEST, comboBox_divisaOut);
		sl_contentPane.putConstraint(SpringLayout.EAST, btn_convertir, 0, SpringLayout.EAST, comboBox_divisaOut);
		btn_convertir.setBackground(new Color(73, 153, 218));
		btn_convertir.setForeground(new Color(255, 255, 255));
		contentPane.add(btn_convertir);
		// Action listeners

	}

	public void initDialog() {
		setVisible(true);
	}

	private void alterarEtiquetas(String monto, int indiceDivisaIn, int indiceDivisaOut) {
		double cantidad = Double.valueOf(monto);
		DecimalFormat numero = new DecimalFormat("#.0000");

		String nombreDivisaIn = Divisa.values()[indiceDivisaIn].nombre;
		Divisa codigoIn = Divisa.values()[indiceDivisaIn];
		Divisa codigoOut = Divisa.values()[indiceDivisaOut];
		String nombreDivisaOut = Divisa.values()[indiceDivisaOut].nombre;

		if (cantidad == 1) {
			nombreDivisaIn = Divisa.values()[indiceDivisaIn].label.substring(6);
		}
		multiplicador = manejador.getTipoCambio(indiceDivisaIn,indiceDivisaOut);
		lbl_infoEntrada.setText(cantidad + " " + nombreDivisaIn + " =");
		lbl_resultado.setText(numero.format(multiplicador * cantidad) + " " + nombreDivisaOut);
		lbl_tipoDeCambio.setText("1 " + codigoIn + " = " + numero.format(multiplicador) + " " + codigoOut);
		lbl_tipoDeCambio_INV.setText("1 " + codigoOut + " = " + numero.format(1 / multiplicador) + " " + codigoIn);
	}
}
