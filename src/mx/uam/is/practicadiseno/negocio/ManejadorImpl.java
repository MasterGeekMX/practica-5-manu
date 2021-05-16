package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;

public class ManejadorImpl implements Manejador {

	// La referencia a el Mapeador de Datos
	private MapeadorDatos mapeadorDatos;
	
	//La lista de observadores a manejar (ventanas)
	private ArrayList<Observador> observadores = new ArrayList<Observador>();

	/**
	 * Constructor que inicializa con algunos datos
	 *
	 */
	public ManejadorImpl(MapeadorDatos mapeadorDatos) {
		this.mapeadorDatos = mapeadorDatos;
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
		return mapeadorDatos.dameDatos();
	}

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agrega(String dato) {
		boolean resultado = mapeadorDatos.agrega(dato);
		notifica();
		return resultado;
	}

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	public boolean borra(String dato) {
		boolean resultado = mapeadorDatos.borra(dato);
		notifica();
		return resultado;
	}

	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza() {
		System.exit(0);
	}
	
	/**
	 * Agrega un observador a la lista de observadores
	 * 
	 * @param o el Observador a agregar
	 * @return true si hubo éxtito, false si hubo un problema
	 */
	public boolean agregaObservador(Observador o) {
			return observadores.add(o);
	}
	
	/**
	 * Quitar un observador de la lista de observadores
	 * 
	 * @param o el Observador a quitar
	 * @return true si hubo éxito, false si hubo un problema
	 */
	public boolean quitaObservador(Observador o) {
			boolean resultado = observadores.remove(o);
			if (observadores.isEmpty()) {
				finaliza();
			}
			return resultado;
	}
	
	/**
	 * Avisa a los observadores para que actualizen su información resprecto al sujeto.
	 */
	private void notifica() {
		for (Observador o : observadores) {
			o.actualiza();
		}
	}
}
