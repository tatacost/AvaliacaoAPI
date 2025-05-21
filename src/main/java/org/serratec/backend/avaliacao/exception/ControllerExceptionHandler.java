package org.serratec.backend.avaliacao.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> erros = new ArrayList<>();
		for (FieldError er : ex.getBindingResult().getFieldErrors()) {
			erros.add(er.getField() + ": " + er.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(
				status.value(),"Existem campos inválidos ,confira o preenchimento ",
				LocalDateTime.now(),erros);
		
		return super.handleExceptionInternal(ex, erroResposta , headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<>();
		erros.add("Erro de leitura do corpo da requisição: " + ex.getMostSpecificCause().getMessage());

		ErroResposta erroResposta = new ErroResposta(status.value(),
				"Existem campos inválidos ,verifique se os dados estão corretos", LocalDateTime.now(), erros);

		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

}
