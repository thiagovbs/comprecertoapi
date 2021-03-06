package br.com.comprecerto.api.security.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		if (request.getHeader("Origin") == null 
				|| request.getHeader("Origin").equals("https://localhost:4200")
				|| request.getHeader("Origin").equals("http://localhost:8100")
				|| request.getHeader("Origin").equals("http://localhost:8080")
		        || request.getHeader("Origin").equals("http://api.sheap.com.br")
		        || request.getHeader("Origin").equals("http://app.sheap.com.br")
		        || request.getHeader("Origin").equals("https://sheapweb.herokuapp.com")
		        || request.getHeader("Origin").equals("https://sheap.herokuapp.com")
		        || request.getHeader("Origin").equals("http://localhost:5000")
		        || request.getHeader("Origin").contains("http://167.86.118.44:8080")
		        || request.getHeader("Origin").contains("http://167.86.118.44:4200")
		        || request.getHeader("Origin").contains("http://167.86.118.44:8085")
		        || request.getHeader("Origin").equals("http://localhost:4200")) {
			
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

			response.setHeader("Access-Control-Allow-Credentials", "true");

			if ("OPTIONS".equals(request.getMethod())) {
				response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
				response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
				response.setHeader("Access-Control-Max-Age", "3600");

				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				chain.doFilter(req, resp);
			}
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
