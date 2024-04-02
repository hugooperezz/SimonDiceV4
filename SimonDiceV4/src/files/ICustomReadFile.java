package files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Main.persona;

//Interfaz para leer archivos personalizados
public interface ICustomReadFile {
	// Método para cerrar el archivo de lectura
	public void CloseReadFile() throws IOException;

	// Método para leer jugadores desde un archivo y devolverlos en una lista
	ArrayList<persona> jugadores() throws FileNotFoundException;

}
