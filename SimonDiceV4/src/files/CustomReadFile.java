package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Main.persona;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	Scanner sc;

	/**
	 * Constructora que inicializa el scanner y cargar el fichero
	 * 
	 * @param _file
	 * @throws FileNotFoundException
	 */
	public CustomReadFile(String file) throws FileNotFoundException {
		super(file);
		this.sc = new Scanner(this);
	}

	/**
	 * reescribe el metodo de la interfaz
	 */
	@Override
	public void CloseReadFile() throws IOException {
		this.close();

	}

	/**
	 * reescribe el metodo de la interfaz
	 */
	@Override
	public ArrayList<persona> jugadores() throws FileNotFoundException {
		ArrayList<persona> jugadores = new ArrayList<persona>();
		while (this.sc.hasNextLine()) {
			try {
				int puntos = this.sc.nextInt();
				String nombre = this.sc.next();
				persona jugador = new persona(nombre, puntos);
				jugadores.add(jugador);
				this.sc.nextLine();
			} catch (NoSuchElementException e) {
				System.err.println(e);
			}
		}
		return jugadores;
	}
}
