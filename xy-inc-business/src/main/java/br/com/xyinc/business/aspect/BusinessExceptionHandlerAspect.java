package br.com.xyinc.business.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import br.com.xyinc.commons.exception.ArgumentsException;
import br.com.xyinc.commons.exception.BusinessException;
import br.com.xyinc.commons.exception.InternalErrorException;
import br.com.xyinc.commons.exception.XyException;
import br.com.xyinc.commons.response.GenericResponse;
import br.com.xyinc.commons.response.MessageResponse;
import br.com.xyinc.commons.response.Status;
import br.com.xyinc.commons.utils.MessageUtils;

/**
 * BusinessExceptionHandlerAspect
 * Responsavel por realizar a captura das excecoes do modulo
 *
 */
@Aspect
@Component
public class BusinessExceptionHandlerAspect {

	private static final String ERROR_UNEXPECTED = "error.unexpected";
	private static final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandlerAspect.class);

	/**
	 *Recebe as requisicoes, controla excecoes e exibe um log com o erro.
	 */
	@Around("execution(* br.com.xyinc.business.bo.*BO.*(..))")
	public Object getAllExceptions(ProceedingJoinPoint joinPoint) {
		try {
			return joinPoint.proceed();
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			handleXyExceptions(new BusinessException(e.getMessage()), e.getMessage());
		} catch (XyException e){
			logger.error(e.getMessage(), e);
			handleXyExceptions(e, e.getMessage());
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
			throw new InternalErrorException(ERROR_UNEXPECTED);
		}
		throw new InternalErrorException(ERROR_UNEXPECTED);
	}

	/**
	 * Trabalha com as excecoes de XyException
	 * @param exception
	 * @param key
	 */
	private void handleXyExceptions(XyException exception, String key){
				
		GenericResponse<?> response = new GenericResponse<>();
		response.setStatus(Status.ERROR);
		if(exception.getClass().isAssignableFrom(BusinessException.class)){
			response.withError(new MessageResponse(key, MessageUtils.getMessage(key)));
			throw new BusinessException(response);
		}
		
		if(exception.getClass().isAssignableFrom(ArgumentsException.class)){
			if(exception.getGenericResponse().getErrors() != null){
				response.withErrors(exception.getGenericResponse().getErrors());
			}
			throw new ArgumentsException(response);
		}
		throw new InternalErrorException(response);
		
	}
}
