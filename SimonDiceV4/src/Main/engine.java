package Main;

import java.util.Random;

import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class engine {
	Scanner sc = new Scanner(System.in);

	/**
	 * Metodo de colores
	 */
	public enum tColores {
		Rojo, Dorado, Verde, Azul, Blanco, Marron, Naranja
	}

	/**
	 * enum tModo para usar el modo facil o dificil
	 */
	public enum tMode {
		FACIL, DIFICIL
	}

	static int MAX_COLORES_SEQ = 15;
	static int MAX_COLORES_FACIL = 4;
	static int MAX_COLORES_DIFICIL = 7;
	static int AYUDAS = 3;
	public int puntuacion;

	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * Metodo para asignar letras a Colores
	 * 
	 * @param _color
	 * @return
	 */
	public tColores charToColor(char _color) {
		tColores eleccion = null;
		char LetraColores = Character.toLowerCase(_color); // Para q no diferencie entre mayusculas y minusculas
		switch (LetraColores) {
		case 'r':
			eleccion = tColores.Rojo;
			break;
		case 'a':
			eleccion = tColores.Azul;
			break;
		case 'v':
			eleccion = tColores.Verde;
			break;
		case 'd':
			eleccion = tColores.Dorado;
			break;
		case 'b':
			eleccion = tColores.Blanco;
			break;
		case 'm':
			eleccion = tColores.Marron;
			break;
		case 'n':
			eleccion = tColores.Naranja;
			break;

		}
		return eleccion;

	}

	/**
	 * Metodo para relacionar los colores con numeros para el arrays
	 * 
	 * @param _numero
	 * @return
	 */
	public tColores intToColor(int _numero) {
		tColores numeros = null;
		switch (_numero) {
		case 1:
			numeros = tColores.Rojo;
			break;
		case 2:
			numeros = tColores.Azul;
			break;
		case 3:
			numeros = tColores.Verde;
			break;
		case 4:
			numeros = tColores.Dorado;
			break;
		case 5:
			numeros = tColores.Blanco;
			break;
		case 6:
			numeros = tColores.Marron;
			break;
		case 7:
			numeros = tColores.Naranja;
			break;
		}
		return numeros;
	}

	/**
	 * Metodo para gererar una secuencia ramdon (FACIL)
	 * 
	 * @param _numColores
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(1, _numColores);
			secuenciaColores[i] = intToColor(aleatorio);
		}
	}

	/**
	 * Metodo para comparar la secuencia y ver si a ganado o a perdido
	 * 
	 * @param _index
	 * @param _color
	 * @return
	 */
	boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;

	}

	/**
	 * Metodo para mostrar el array
	 * 
	 * @param _numero
	 */
	void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	/**
	 * Metodo para ejecutar un menu para jugar
	 */
	public void menu() {
		System.out.println("");
		System.out.println("1--Jugar Modo Facil.");
		System.out.println("2--Jugar Modo Dificil.");
		System.out.println("3--Mostrar el mejor Ranking.");
		System.out.println("4--Mostrar Ranking.");
		System.out.println("5--Salir.");

	}

	/**
	 * Metodo para usar ayudas
	 * 
	 * @param _index
	 * @return
	 */
	boolean usarAyuda(int _index) {
		if (AYUDAS > 0) {
			System.out.println("El color que deseas saber es: " + mostrarColor(secuenciaColores[_index]));
			System.out.println("Te quedan " + (AYUDAS - 1) + " ayudas restantes");
			AYUDAS--;
			return true;
		} else {
			System.out.println("Ya no te quedan más ayudas disponibles");
			return false;
		}
	}

	/**
	 * metodo que cambia el color de tColores a un string S
	 * 
	 * @param _color color que hay dentro del array tColores
	 * @return devuelve un string
	 */
	public String mostrarColor(tColores _color) {

		String colorString = null;

		switch (_color) {
		case Rojo:
			colorString = "Rojo";
			break;
		case Azul:
			colorString = "Azul";
			break;
		case Verde:
			colorString = "Verde";
			break;
		case Dorado:
			colorString = "Dorado";
			break;
		case Blanco:
			colorString = "Blanco";
			break;
		case Marron:
			colorString = "Marrón";
			break;
		case Naranja:
			colorString = "Naranja";
			break;
		}
		return colorString;
	}

	/**
	 * Metodo para que muestre el mensaje de biembenida al jugador
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {
		Record record = new Record();
		Scanner sc = new Scanner(System.in);

		// Mensaje de biemvenida
		System.out.println("Bienvenido a Simon Dice.");
		System.out.print("Introduce tu nombre de usuario:");

		// Solicita el nombre del jugador
		String nombre = sc.nextLine();
		System.out.println("");

		// Guarda el nombre
		persona jugador = new persona(nombre, 0);
		record.añadirJugador(jugador);
		record.cargarRanking();
		System.out.println("Hola " + nombre + " pulsa enter para mostrar menu.");
		sc.nextLine();

		int seleccion = 0;

		while (seleccion != 5) {
			menu();
			seleccion = sc.nextInt();
			switch (seleccion) {
			case 1:
				play(tMode.FACIL);
				jugador.setPuntuacion(puntuacion);
				break;
			case 2:
				play(tMode.DIFICIL);
				jugador.setPuntuacion(puntuacion);
				break;
			case 3:
				record.showBestPlayer();
				System.out.println();
				break;
			case 4:
				record.showRanking();
				System.out.println();
				break;
			case 5:
				System.out.println("¡Adios! vuelve pronto");
				record.escribirRanking();
			}
		}
	}

	/**
	 * Metodo donde se ejecuta todo el juego con la utilizacion de todos los metodos
	 * anteriormente creados
	 * 
	 * @param modo
	 */
	public void play(tMode _modo) {
		AYUDAS = 3;
		int numeroSecuencia = 0;

		// Elegir el modo de juego
		if (_modo == tMode.DIFICIL) {
			generarSecuencia(MAX_COLORES_DIFICIL);
			numeroSecuencia = MAX_COLORES_DIFICIL;
		} else {
			generarSecuencia(MAX_COLORES_FACIL);
			numeroSecuencia = MAX_COLORES_FACIL;
		}
		System.out.println("Preparado? pulsa enter para empezar.");

		sc.nextLine();
		boolean fallar = false; // Variable para parar el bucle una vez has fallado

		// Comienzo del juego
		int i = 0;
		while (i < MAX_COLORES_SEQ && fallar == false) {

			// Mostrar secuencia segun el modo que se elija
			mostrarSecuencia(numeroSecuencia + i);
			sc.nextLine();

			// Bucle para borrar la parte de arriba
			for (int j = 0; j < 20; j++) {
				System.out.println();
			}
			System.out.println("Ingresa la secuencia");
			System.out.println();

			// Introducir los colores y comprobar
			int j = 0;
			while (j < numeroSecuencia + i && fallar == false) {
				char letraColor = new Scanner(System.in).next().charAt(0);
				tColores Color_Elegido = charToColor(letraColor);

				if (letraColor != 'x' && letraColor != 'X') {
					if (comprobarColor(j, Color_Elegido)) {
						System.out.println("¡¡Color correcto!!");
						if (_modo == tMode.FACIL) {
							puntuacion = +2;
						} else {
							puntuacion = +4;
						}
					} else if (comprobarColor(j, Color_Elegido) == false) {
						System.out.println("¡Oh no! has perdido.");
						fallar = true;
					}
				} else {
					if (AYUDAS > 0) {
						usarAyuda(j);
						if (_modo == tMode.FACIL) {
							puntuacion = (puntuacion - 8);
						} else {
							puntuacion = (puntuacion - 16);
						}
					}
				}
				if (puntuacion < 0) {
					puntuacion = 0;
				}

				j++;
			}
			i++;
		}
		System.out.println("Tu puntuacion es de " + puntuacion + " puntos.");
	}

}