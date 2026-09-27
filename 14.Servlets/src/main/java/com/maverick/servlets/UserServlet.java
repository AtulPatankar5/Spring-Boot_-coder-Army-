package com.maverick.servlets;

import com.maverick.model.User;
import com.maverick.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (id == null) {
            List<User> list = userService.getAllUsers();
            resp.setStatus(200);
            resp.getWriter().write(userToJSONList(list));
            return;
        }
        User userResponse = userService.getUserById(id);

        if (userResponse == null) {
            resp.setStatus(400);
        }

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(userToJson(userResponse));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        if (id == null || email == null || mobile == null || name == null) {
            resp.setStatus(400);
            resp.getWriter().write("Any value is null");
        }

        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);
        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.getWriter().write("User added successfully");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private String userToJson(User userResponse) {
        return "{\n" +
                "    \"id\": " + userResponse.getId() + ",\n" +
                "    \"name\": \"" + userResponse.getName() + "\",\n" +
                "    \"email\": \"" + userResponse.getEmail() + "\"\n" +
                "    \"mobile\": \"" + userResponse.getMobile() + "\"\n" +
                "}";
    }

    private String userToJSONList(List<User> userlist) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < userlist.size(); i++) {
            sb.append(userToJson(userlist.get(i)));
            if (i < userlist.size() - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
