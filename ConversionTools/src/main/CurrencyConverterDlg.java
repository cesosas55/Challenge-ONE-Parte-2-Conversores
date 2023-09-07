package main;

/** La clase CurrencyConverterDlg se utiliza para crear la ventana del conversor de divisas.
 *  Esta engloba la configuración de los elementos que componen la interfaz de usuario y
 *  algunas funciones que le dan la funcionalidad deseada.
 *  
 *  Los atributos de la clase constituyen los elementos, como botones, cajas de texto, 
 *  listas desplegables y etiquetas.
 *  
 *  Se inlcuye también la formación de algunos arreglos para generar las listas y agregarles
 *  los íconos correspondientes a las banderas de cada país.
 * 
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class CurrencyConverterDlg extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField_monto = new JTextField();
	private Color fondoBlanco = new Color(255, 255, 255);
	private String montoInicial = "0";
	private double multiplicador;
	// Definicion de los elementos del marco
	// Etiquetas
	private JLabel lbl_importe = new JLabel("Importe");
	private JLabel lbl_entrada = new JLabel("De:");
	private JLabel lbl_salida = new JLabel("a:");
	JLabel lbl_infoEntrada = new JLabel(" ");
	JLabel lbl_resultado = new JLabel(" ");
	JLabel lbl_tipoDeCambio = new JLabel(" ");
	JLabel lbl_tipoDeCambio_INV = new JLabel(" ");
	// Listas desplegables
	private JComboBox comboBox_divisaIn;
	private JComboBox comboBox_divisaOut;

	private ImageIcon iconoInvertir = createImageIcon("/loading.png");
	private ImageIcon iconoVentana = createImageIcon("/exchange.png");

	private String divisas[] = new String[Divisa.values().length];
	private ImageIcon[] iconosComboBox = new ImageIcon[Divisa.values().length];
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
	public CurrencyConverterDlg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(fondoBlanco);
		setLocationRelativeTo(null);
		setTitle("Conversor de Divisas - Challenge ONE Parte 2");
		setIconImage(iconoVentana.getImage());// Icono de la ventana
		setPreferredSize(new Dimension(550,300));
		setSize(550,300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(fondoBlanco);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		/**
		 * Creación de los vectores de etiquetas e íconos para las listas desplegables A
		 * partir de la información alamacenada en el enum, se crean estos vectores.
		 */
		Integer[] intArray = new Integer[Divisa.values().length];
		for (Divisa div : Divisa.values()) {
			intArray[i] = new Integer(i);
			divisas[i] = div.label;
			iconosComboBox[i] = createImageIcon("/" + div.label.substring(0, 3) + ".png");
			if (iconosComboBox[i] != null) {
				iconosComboBox[i].setDescription(divisas[i]);
			}
			i++;
		}

		/**
		 * Obtiene los datos de la API y los almacena en una matriz. Desde esta se
		 * determina el valor del multiplicador para el tipo de cambio de las
		 * conversiones
		 */
		manejador.crearCacheMxn(Divisa.MXN.toString());

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		// setup: lbl_resultado
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_resultado, 350, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_infoEntrada, 350, SpringLayout.WEST, lbl_importe);
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
		textField_monto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textField_monto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_monto.setHorizontalAlignment(SwingConstants.CENTER);
		textField_monto.setText(montoInicial);
		contentPane.add(textField_monto);
		textField_monto.setColumns(10);
		// setup: comboBox_divisaIn
		comboBox_divisaIn = new JComboBox(intArray);
		comboBox_divisaIn.setRenderer(new ComboBoxRenderer(iconosComboBox, divisas));
		comboBox_divisaIn.setMaximumRowCount(6);
		comboBox_divisaIn.setBackground(new Color(255, 255, 255));
		comboBox_divisaIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_divisaIn.setSelectedIndex(0);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_divisaIn, 25, SpringLayout.NORTH, lbl_entrada);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_divisaIn, 25, SpringLayout.EAST, textField_monto);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_divisaIn, 175, SpringLayout.EAST, textField_monto);
		contentPane.add(comboBox_divisaIn);
		// setup: comboBox_divisaOut
		comboBox_divisaOut = new JComboBox(intArray);
		comboBox_divisaOut.setRenderer(new ComboBoxRenderer(iconosComboBox, divisas));
		comboBox_divisaOut.setBackground(new Color(255, 255, 255));
		comboBox_divisaOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_divisaOut.setSelectedIndex(1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_divisaOut, 25, SpringLayout.NORTH, lbl_salida);
		contentPane.add(comboBox_divisaOut);
		// setup: btn_invertir
		JButton btn_invertir = new JButton("");
		/**
		 * Agregamos la funcionalidad al botón de inversión de las divisas. Esto nos
		 * permite invertir el resultado de la operación. por ejemplo, pasar de USD->MXN
		 * a MXN->USD.
		 */
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
		lbl_infoEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_infoEntrada, 25, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_infoEntrada);
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
		/**
		 * Al presionar el botón, se determinan los índices de las divisas seleccionadas
		 * según su posición y se obtiene el valor del multiplicador consultando en la
		 * matriz. Finalmente se actualizan las etiquetas correspondientes al resultado
		 * y la información complementaria.
		 */
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
					JOptionPane.showMessageDialog(f, "Las divisas son iguales", "Atención",
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

	/**
	 * Cambia la visibilidad del JFrame creado.
	 */
	public void initDialog() {
		setVisible(true);
	}

	/**
	 * Primero valida el valor de la caja de texto y posteriormente efectúa el
	 * cálculo y muestra el resultado en las etiquetas correspondientes.
	 * 
	 * @param monto           - Valor proveniente de la caja de texto
	 * @param indiceDivisaIn  - índice de la divisa base en la lista desplegable
	 * @param indiceDivisaOut - índice de la divisa solicitada en la lista
	 *                        desplegable
	 */
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
		multiplicador = manejador.getTipoCambio(indiceDivisaIn, indiceDivisaOut);
		lbl_infoEntrada.setText(cantidad + " " + nombreDivisaIn + " =");
		lbl_resultado.setText(numero.format(multiplicador * cantidad) + " " + nombreDivisaOut);
		lbl_tipoDeCambio.setText("1 " + codigoIn + " = " + numero.format(multiplicador) + " " + codigoOut);
		lbl_tipoDeCambio_INV.setText("1 " + codigoOut + " = " + numero.format(1 / multiplicador) + " " + codigoIn);
	}

	/**
	 * Regresa un ImageIcon, o null si la ruta no es válida
	 * 
	 * @param ruta - Ubicación del archivo relativa a la clase
	 * @return
	 */
	private static ImageIcon createImageIcon(String ruta) {
		java.net.URL imgURL = CurrencyConverterDlg.class.getResource(ruta);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + ruta);
			return null;
		}

	}
}
