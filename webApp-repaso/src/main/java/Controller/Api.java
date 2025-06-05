/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import Service.UserService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "Api", urlPatterns = {"/Api"})
public class Api extends HttpServlet {

    UserService service = new UserService();
    Gson gson = new Gson();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        String ced = request.getParameter("cedula");
        try {
            if (ced != null) {
                User u = service.getUser(Integer.parseInt(ced));
                response.getWriter().print(gson.toJson(u));
            } else {
                List<User> list = service.getAll();
                response.getWriter().print(gson.toJson(list));
            }
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = gson.fromJson(request.getReader(), User.class);
        try {
            boolean ok = service.save(u);
            response.getWriter().print("{\"success\":" + ok + "}");
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = gson.fromJson(request.getReader(), User.class);
        try {
            boolean ok = service.update(u);
            response.getWriter().print("{\"success\":" + ok + "}");
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = gson.fromJson(request.getReader(), User.class);
        try {
            boolean ok = service.delete(u.getCedula());
            response.getWriter().print("{\"success\":" + ok + "}");
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
