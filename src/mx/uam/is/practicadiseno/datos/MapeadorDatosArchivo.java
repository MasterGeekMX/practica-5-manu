package mx.uam.is.practicadiseno.datos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Luis Manuel Arrieta Ávila (2153046374)
 *
 */
public class MapeadorDatosArchivo implements MapeadorDatos {

	/**
	 * Constructor
	 */
	public MapeadorDatosArchivo(){
		//no es necesario de momento
	}

	@Override
	public boolean agrega(String dato){
		try {
			BufferedWriter archivo = new BufferedWriter(new FileWriter("datos.txt", true));
			archivo.write(dato);
			archivo.newLine();
			archivo.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borra(String dato) {
		boolean resultado = false;
		ArrayList<String> datos = new ArrayList<String>();
		//copiamos los datos del archivo a una lista, excluyendo el que queremos borrar
		try {
			BufferedReader archivoLec = new BufferedReader(new FileReader("datos.txt"));
			String datoActual;
			while ((datoActual = archivoLec.readLine()) != null) {
				if(!datoActual.equals(dato)) {
					datos.add(datoActual);
				}
				else {
					resultado = true;
				}
			}
			archivoLec.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//escribimos en el archivo los datos que están en la lista
		try {
			BufferedWriter archivoEsc = new BufferedWriter(new FileWriter("datos.txt"));
			for (String datoActual : datos) {
				archivoEsc.write(datoActual);
				archivoEsc.newLine();
			}
			archivoEsc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public String[] dameDatos() {
		ArrayList<String> datos = new ArrayList<String>();
		try {
			BufferedReader archivo = new BufferedReader(new FileReader("datos.txt"));
			String dato;
			while ((dato = archivo.readLine()) != null) {
				datos.add(dato);
			}
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arregloDatos = new String[datos.size()];
		datos.toArray(arregloDatos);
		return arregloDatos;
	}

	@Override
	public boolean contiene(String dato) {
		boolean resultado = false;
		try {
			BufferedReader archivo = new BufferedReader(new FileReader("datos.txt"));
			String datoActual;
			while ((datoActual = archivo.readLine()) != null) {
				if(datoActual.equals(dato)) {
					resultado = true;
				}
			}
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
