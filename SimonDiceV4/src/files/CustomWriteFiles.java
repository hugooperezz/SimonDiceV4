package files;

import java.io.FileWriter;
import java.io.IOException;

// Clase para escribir archivos personalizados
public class CustomWriteFiles extends FileWriter implements ICustomWriteFile {

	/**
	 * constructora
	 * 
	 * @param file
	 * @throws IOException
	 */
	public CustomWriteFiles(String file) throws IOException {
		super(file);

	}

	/**
	 * metodo que cierra el fichero
	 */
	public void CloseWriteFile() throws IOException {
		this.close();

	}

	/**
	 * metodo que escribe en el fichero
	 */
	public void WritePlayers(String chain) throws IOException {
		this.write(chain);

	}

}
