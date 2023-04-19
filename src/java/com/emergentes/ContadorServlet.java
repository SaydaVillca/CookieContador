package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContadorServlet", urlPatterns = {"/ContadorServlet"})
public class ContadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        Cookie[] cukies = request.getCookies();
        
        if(cukies != null){
            for (Cookie c : cukies) {
                if(c.getName().equals("visitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
            contador += 1;
            Cookie c = new Cookie("visitas",contador + "");
            
            c.setMaxAge(60);
            response.addCookie(c);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("Visitante Nro: "+ contador);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        
        
    }
}
