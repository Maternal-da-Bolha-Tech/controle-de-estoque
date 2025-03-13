package com.maternal.controle_estoques.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

/**
 * Uma classe de aconselhamento do controlador para lidar com exceções globalmente em todo o aplicativo.
 * Esta classe está anotada com {@code @RestControllerAdvice} para interceptar e lidar com exceções
 * levantado pelos controladores e fornece respostas apropriadas.
 */
@RestControllerAdvice
public class DataException {

	/**
	 * Lida com exceções do tipo {@code MethodArgumentNotValidException} que ocorrem quando
	 * um argumento de método falha na validação. Constrói uma resposta {@code ProblemDetail}
	 * apropriada com detalhes sobre o problema de validação.
	 *
	 * @param exception      a {@code MethodArgumentNotValidException} a ser tratada,
	 *                       contendo detalhes sobre os erros de validação
	 * @param servletRequest o {@code HttpServletRequest} atual, usado para construir o
	 *                       URI do tipo de detalhe do problema
	 * @return um {@code ResponseEntity} contendo um objeto {@code ProblemDetail} com
	 * informações sobre o erro de validação e um status HTTP {@code BAD_REQUEST}
	 */
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<ProblemDetail> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest servletRequest) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemDetail problemDetail = ProblemDetail.forStatus(status);
		problemDetail.setType(URI.create(servletRequest.getRequestURL().toString()));
		problemDetail.setTitle("Method argument not valid");
		problemDetail.setDetail(exception.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
		return ResponseEntity.status(status).body(problemDetail);
	}
}
