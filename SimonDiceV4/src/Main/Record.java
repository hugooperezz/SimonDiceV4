package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import files.CustomReadFile;
import files.CustomWriteFiles;

public class Record {
	final int MAX_JUGADORES = 10;
	private persona[] jugadores;
	private int cuenta;
	String ruta;

	public Record() {
		this.jugadores = new persona[MAX_JUGADORES];
		this.cuenta = 0;
	}

	/**
	 * Añade jugadores al array de jugadores
	 *
	 * @param jugador
	 */
	public void añadirJugador(persona jugador) {
		if (cuenta < MAX_JUGADORES) {
			this.jugadores[cuenta] = jugador;
			this.cuenta++;
		} else {
			System.out.println("No se pueden añadir más jugadores. Se ha alcanzado el límite.");
		}
	}

	/**
	 * Muestra el ranking de los 10 mejores jugadores
	 */
	public void showRanking() {
		ordenarJugadores();
		System.out.println("Ranking de los 10 mejores jugadores:");
		int limite = Math.min(cuenta, 10);
		for (int i = 0; i < limite; i++) {
			System.out.println((i + 1) + ". " + jugadores[i].getNombre() + ": " + jugadores[i].getPuntuacion());
		}
	}

	/**
	 * Muestra el jugador (o jugadores) con la puntuación más alta
	 */
	public void showBestPlayer() {
		ordenarJugadores();
		System.out.println("Mejor jugador:");
		int topJugador = jugadores[0].getPuntuacion(); // Variable que guarda al jugador de la posicion 0
		int i = 0;
		while (i < cuenta - 1) {
			if (jugadores[i].getPuntuacion() == topJugador) {
				System.out.println(jugadores[i].getNombre() + ": " + topJugador);
			} else {
				break; // Salir del bucle cuando ya no haya jugadores con la máxima puntuación
			}
			i++;
		}
	}

	/**
	 * Metodo que ordena el array mediante el metodo de la burbuja
	 */
	private void ordenarJugadores() {
		for (int i = 0; i < cuenta; i++) {
			for (int j = 0; j < (cuenta - i - 1); j++) {
				if (jugadores[j].getPuntuacion() < jugadores[j + 1].getPuntuacion()) {
					persona temp = jugadores[j + 1];
					jugadores[j + 1] = jugadores[j];
					jugadores[j] = temp;
				}
			}
		}
	}

	public void escribirRanking() throws IOException {
		CustomWriteFiles write = new CustomWriteFiles("./src/data/top.txt");
		String jugadores = "";
		for (int i = 0; i < this.cuenta; i++) {
			jugadores = jugadores + (this.jugadores[i].getPuntuacion() + " " + this.jugadores[i].getNombre() + "\n");
		}
		write.WritePlayers(jugadores);
		write.CloseWriteFile();
	}

	public void cargarRanking() throws IOException {
		CustomReadFile read = new CustomReadFile("./src/data/top.txt");
		ArrayList<persona> jugadores = read.jugadores();
		int i = 0;
		int size = jugadores.size();
		while (i < size && i < this.MAX_JUGADORES) {
			persona j = jugadores.get(i);
			añadirJugador(j);
			i++;
		}
		read.CloseReadFile();
	}

}
