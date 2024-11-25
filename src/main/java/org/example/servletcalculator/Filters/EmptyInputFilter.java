package org.example.servletcalculator.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/calculate")
public class EmptyInputFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String equation = req.getParameter("equation");
        if(equation == null || equation.isBlank()) {
            res.getWriter().write("You need to provide an equation, at least type 1+1 or something =)");
        } else {
            chain.doFilter(req, res);
        }
    }
}
