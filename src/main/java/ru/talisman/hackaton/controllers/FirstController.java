package ru.talisman.hackaton.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.talisman.hackaton.GetWeather;
import ru.talisman.hackaton.dao.BookDAO;
import ru.talisman.hackaton.dao.PersonDAO;
import ru.talisman.hackaton.models.Book;
import ru.talisman.hackaton.models.Person;

import java.sql.SQLException;


@Controller
public class FirstController {
    GetWeather gw = new GetWeather();
    @Autowired
    public BookDAO bookDAO;
    @Autowired
    public PersonDAO personDAO;

    @GetMapping("/")
    public String start(Model model) {
        try {
            JSONObject weather = gw.getWeather("Orenburg", "00e95f8471360abf5346f0a5645a1a41");
            // температура в городе
            double temp = weather.getJSONObject("main").getDouble("temp");
            model.addAttribute("temp", temp);
            return "index_new";
        } catch (Exception e) {
            System.out.println("Error!");
        }
        return null;
    }

    @GetMapping("/login")
    public String login() {
        return "vhod";
    }

    @GetMapping("/reg")
    public String registration() {
        return "registration";
    }

    @GetMapping("/book")
    public String book() {
        return "bron";
    }
    @GetMapping("/lk")
    public String profile(){
        return "lk";
    }

    @GetMapping("/houses")
    public String houses() {
        return "houses";
    }

    @GetMapping("/besedki")
    public String besedki() {
        return "besedki";
    }

    @GetMapping("/banya")
    public String banya() {
        return "banya";
    }

    @PostMapping()
    public String add(@ModelAttribute("book") Book book) throws SQLException {
        bookDAO.save(book);
        return "redirect:/";
    }
    @PostMapping("/reg")
    public String reg(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/";
    }


}
