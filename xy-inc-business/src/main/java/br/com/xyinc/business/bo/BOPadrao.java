package br.com.xyinc.business.bo;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe padrao de Business Object para a camada de negocio.
 * 
 */
public abstract class BOPadrao implements Serializable {

	private static final long serialVersionUID = -8409344944267220687L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	public Logger getLogger() {
		return logger;
	}
	
}
