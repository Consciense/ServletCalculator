package org.example.servletcalculator.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletcalculator.EquationValidation;

import java.io.IOException;

@WebFilter("/calculate")
public class EquationValidationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String equation = req.getParameter("equation");
        if(EquationValidation.validateEquation(equation)){
            chain.doFilter(req, res);
        }
        res.getWriter().write(EquationValidation.getErrorMsg());
    }
}
