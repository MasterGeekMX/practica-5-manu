package mx.uam.is.practicadiseno.negocio;

/**
 * @author Luis Manuel Arrieta Ávila (2153046374)
 *
 */
public interface Observador {

	/**
	 * Notificar al observador de un cambio de estado para avisar al sujeto
	 */
	public void actualiza();
	
}
