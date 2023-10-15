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
import ru.talisman.hackaton.models.Book;

import java.sql.SQLException;


@Controller
public class FirstController {
    GetWeather gw = new GetWeather();
    @Autowired
    public BookDAO bookDAO;



    @GetMapping("/")
    public String start(Model model){
        try {
            JSONObject weather = gw.getWeather("Orenburg", "00e95f8471360abf5346f0a5645a1a41");
            // температура в городе
            double temp = weather.getJSONObject("main").getDouble("temp");
            model.addAttribute("temp", temp);
            return "index";
        } catch (Exception e){
            System.out.println("Error!");
        }
        return null;
    }
    @PostMapping()
    public String add(@ModelAttribute("book") Book book) throws SQLException {
        bookDAO.save(book);
        return "redirect:/";
    }


}
