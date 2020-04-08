/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 798794
 */
public class ShoppingListServlet extends HttpServlet {

    private HttpSession session = null;
    private ArrayList<String> items;
    
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
        
        session = request.getSession();
        String parameterValue = request.getParameter("action");
        
        if(parameterValue != null && parameterValue.equals("logout")) {
            session.removeAttribute("username");
            session.removeAttribute("items");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        
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
                
        String parameterValue = request.getParameter("action");
        session = request.getSession();
        
        if(parameterValue.equals("register")) {
            String username = request.getParameter("username");

            session.setAttribute("username", username);
            session.removeAttribute("items");
            items = new ArrayList<>();
                
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if(parameterValue.equals("add")) {
            String inputItem = request.getParameter("inputItem");
            
            if(inputItem == null || inputItem.equals("")) {
                request.setAttribute("message", "Please fill in the field");
            } else {
                items.add(inputItem);
                session.setAttribute("items", items);
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
        } else if(parameterValue.equals("delete")) {
            String clickedRadioButton = request.getParameter("radioButton");
            
            if(clickedRadioButton == null || clickedRadioButton.equals("")) {
                request.setAttribute("message", "select one of the items to delete.");
            } else {
                
                for(int i = 0;  i < items.size(); i++) {
                    
                    String oneItem = items.get(i);

                    if(clickedRadioButton.equals(oneItem)) {
                        items.remove(i);
                    }
                }
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
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
