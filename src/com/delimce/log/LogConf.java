package com.delimce.log;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class LogConf {
	
	public static void init() {

		// Obtiene archivo de propiedades de log4j
		String file = "."+System.getProperty("file.separator")+"log4j.properties";
                


		if((file != null) & (new File(file).exists())) {
			PropertyConfigurator.configure(file);
			//System.out.println("Archivo de propiedades de log4j encontrado " + file);
		}else{
			BasicConfigurator.configure();
			System.err.println("Archivo de propiedades de log4j NO encontado se utilizara configuracion basica " + file);
		}

	}

}
