package com.jrp.pma.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error/error-404";
			}
			else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error/error-500";
			}
			else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "error/error-403";
			}
		}
		return "error/error";
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
