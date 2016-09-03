/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanLogin;
import Modelo.Usuario_sistema;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dajua
 */
@WebServlet(name = "login", urlPatterns = {"/iniciar_sesion"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            char[] separada = null;
            separada = password.toCharArray();
            
//            Usuario_sistema us = new Usuario_sistema();
//            String[] dato = us.consultar_x_usuario(usuario, separada);
//            out.println("<h2> Bienvenido: "+dato[0]+", "+dato[1]+"</h2>");
//            
//            for(int i = 0; i<separada.length; i++){
//                
//                out.println("[" + i + "] " + separada[i]);
//            }
            BeanLogin bl = new Usuario_sistema().consultar_x_usuario(usuario, separada);
            
            if(bl != null){
                response.getWriter().println("<h2> Bienvenido: "+bl.getUsuario()+", "+bl.getPassword()+"</h2>");           
            }else{
                response.getWriter().println("<h2>No se encontro coincidencias</h2>");
            }
            
            
            for(int i = 0; i<separada.length; i++){
                
                out.println("[" + i + "] " + separada[i]);
            }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
