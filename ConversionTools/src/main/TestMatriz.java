package main;
/**
 * La clase TestMatriz fue creada solamente con el propósito de validar las operaciones 
 * necesariar para calcular los coeficientes de la matriz de divisas a partir de un vector
 * conocido. 
 * 
 * Si bien este método no es el más eficiente ni el más preciso, si ofrece una buena
 * aproximación para resolver el problema de optimización planteado inicialmente. 
 * 
 * 
 * Partes de este código de prueba se utilizaron en las clases que componen el proyecto
 * del conversor.
 * 
 * @author Carlos Enrique Sosa Sánchez
 */
public class TestMatriz {
	public static void main(String[] args) {
		int cantidadDivisas = Divisa.values().length;
		double[][] matrizTipoDeCambio = new double[cantidadDivisas][cantidadDivisas];
		double[] valoresAPI = { 1, 16.72, 18.790, 21.860, 0.120, 0.013 };

		// Agregamos los tipos de cambio de la API a la primera columna de la matriz.
		for (int i = 0; i < cantidadDivisas; i++) {
			// Agregamos los tipos de cambio de la API a la primera columna de la matriz.
			matrizTipoDeCambio[i][0] = valoresAPI[i];
			// calculamos el inverso y lo colocamos en la primera fila
			matrizTipoDeCambio[0][i] = 1.0 / valoresAPI[i];
		}
		// calculamos los coeficientes del resto de la matriz
		for (int i = 1; i < cantidadDivisas; i++) {
			for (int j = 1; j < cantidadDivisas; j++) {
				if (i == j) {
					matrizTipoDeCambio[i][j] = 1.0;
				} else {
					matrizTipoDeCambio[i][j] = matrizTipoDeCambio[0][j] * matrizTipoDeCambio[i][0];
				}
			}
		}
		for (int i = 0; i < cantidadDivisas; i++) {
			for (int j = 0; j < cantidadDivisas; j++) {
				System.out.print(matrizTipoDeCambio[i][j] + ",  ");
			}
			System.out.println("\n");
		}
	}
}
