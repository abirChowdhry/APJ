package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;

@Controller

@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping({"calculator"})
    public String register() {
        return "Home";
    }


        @RequestMapping({"/result"})
            public String calculation(@ModelAttribute("num1") float num1, @ModelAttribute("op") String op, @ModelAttribute("num2") float num2, Model model) throws SQLException {

            model.getAttribute(String.valueOf(num1));
            model.getAttribute(op);
            model.getAttribute(String.valueOf(num2));
            float result = 0;
            if (op.equals("add")) {
                result = num1 + num2;
            } else if (op.equals("sub")) {
                result = num1 - num2;
            } else if (op.equals("multiply")) {
                result = num1 * num2;
            } else if (op.equals("divide")) {
                result = num1 / num2;
            }
            String operation = num1 + " " + op + " "+num2;

            Connection connection = this.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into calculations(operations, result) values (?, ?)");
            statement.setString(1, operation);
            statement.setString(2, String.valueOf(result));
            statement.execute();
            return "result";
        }
}

