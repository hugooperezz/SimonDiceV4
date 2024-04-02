package Main;

public class persona {
	private int puntuacion;
	private String name;

	public persona(String _nombre, int _puntos) {
		this.name = _nombre;
		this.puntuacion = _puntos;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String _nombre) {
		this.name = _nombre;
	}

	/**
	 * Metodo que nos perdimete ponerle una puntuacion al jugador 0(1)
	 * 
	 * @param _puntos numero al que quieres igualar
	 */

	public void setPuntuacion(int _puntos) {
		this.puntuacion = _puntos;
	}

	/**
	 * Metodo que nos permite saber la puntuacion del jugador 0(1)
	 * 
	 * @return
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
}
