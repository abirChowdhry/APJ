package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>Hello Java<h1>");
    }

    @RequestMapping("/greet")
    public String greet() {
        return "home";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Mir Md Kawsur");
        return "welcome";
    }

    @RequestMapping("/register-form")
    public String registrationForm() {
        return "registration";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Registration Page: " + request.getParameter("username"));
        return "registration";
    }

    @RequestMapping("/register/v2")
    public String registerTwo(@ModelAttribute("uname") String uname, @ModelAttribute("pass") String pass, Model model) {
        model.addAttribute("uname", uname);
        model.addAttribute("pass", pass);
//        return "welcome";
        return "/data/create";
    }

    @RequestMapping("/data")
    public void getData() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }

    @RequestMapping("/data/create")
    public String createData(@ModelAttribute("num1") String num1, @ModelAttribute("op") String op,  @ModelAttribute("num2") String num2, Model model) throws SQLException {
            model.getAttribute(num1);
            model.getAttribute(op);
            model.getAttribute(num2);

            int result = 0;
            if(op == "Addition"){result = Integer.parseInt(num1 + num2);}
            else if(op == "Subtraction"){int num3 = Integer.parseInt(num1);
                int num4 = Integer.parseInt(num2);
                result = num3 - num4;
            }
            else if(op == "Multiplication"){int num3 = Integer.parseInt(num1);
                int num4 = Integer.parseInt(num2);
                result = num3 * num4;
            }
            else if(op == "Division"){int num3 = Integer.parseInt(num1);
                int num4 = Integer.parseInt(num2);
                result = num3 / num4;}

            String result2 = String.valueOf(result);
            String operation = num1 + op + num2;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users (operation, result) values (?, ?)");
        statement.setString(1, operation);
        statement.setString(2, result2);
        statement.execute();

        return "welcome2";
    }

    @RequestMapping("/data/update")
    public void createUpdate() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update users set email = ?, password = ? where id = ?");
        statement.setString(1, "test3@aiub.edu");
        statement.setString(2, "111555");
        statement.setLong(3, 5);
        statement.executeUpdate();
    }
}
