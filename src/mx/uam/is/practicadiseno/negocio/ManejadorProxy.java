package mx.uam.is.practicadiseno.negocio;

/**
 * @author Luis Manuel Arrieta Ávila (2153046374)
 *
 */
public class ManejadorProxy implements Manejador {
	
	//referencia al manejador real
	private Manejador manejador;

	/**
	 * Constructor que inicializa la referencia al manejador real
	 * 
	 * @param manejador la referencia al manejador
	 */
	public ManejadorProxy(Manejador manejador) {
		this.manejador = manejador;
	}

	@Override
	public String[] dameDatos() {
		System.out.println("Invocando dameDatos()");
		return manejador.dameDatos();
	}

	@Override
	public boolean agrega(String dato) {
		System.out.println("Invocando agrega(String dato) con \"" + dato + "\" como dato");
		return manejador.agrega(dato);
	}

	@Override
	public boolean borra(String dato) {
		System.out.println("Invocando borra(String dato) con \"" + dato + "\" como dato");
		return manejador.borra(dato);
	}

	@Override
	public void finaliza() {
		System.out.println("Invocando finaliza()");
		manejador.finaliza();
	}

	@Override
	public boolean agregaObservador(Observador o) {
		System.out.println("Invocando agregaObservador(Observador o) con " + o + " como observador");
		return manejador.agregaObservador(o);
	}

	@Override
	public boolean quitaObservador(Observador o) {
		System.out.println("Invocando quitaObservador(Observador o) con " + o + " como observador");
		return manejador.quitaObservador(o);
	}

}
