package com.gameflix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<div style='font-family: Arial; text-align: center; margin-top: 50px;'>"
             + "<h1 style='color: #e50914;'>Gameflix is Live!</h1>"
             + "<p>Your Spring Boot application is running successfully in Docker.</p>"
             + "<a href='/h2-console' style='color: #007bff;'>Access H2 Database Console</a>"
             + "</div>";
    }
}
