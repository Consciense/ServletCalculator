package org.example.servletcalculator.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/calculate")
public class UnresolvedSymbolsFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String equation = req.getParameter("equation");
        Pattern pattern = Pattern.compile("[^0-9-/()*+]");
        Matcher matcher = pattern.matcher(equation);
        if (matcher.find()) {
            res.getWriter().write("Unresolved symbol!");
        } else {
            chain.doFilter(req, res);
        }
    }
}
