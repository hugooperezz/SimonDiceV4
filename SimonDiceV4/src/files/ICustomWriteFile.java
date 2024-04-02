package files;

import java.io.IOException;

// Interfaz para escribir archivos personalizados
public interface ICustomWriteFile {
	// Método para cerrar el archivo de escritura
	public void CloseWriteFile() throws IOException;

	// Método para escribir jugadores en un archivo
	public void WritePlayers(String chain) throws IOException;

}
