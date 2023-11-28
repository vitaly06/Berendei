package ru.talisman.hackaton.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.talisman.hackaton.GetWeather;
import ru.talisman.hackaton.dao.BookDAO;
import ru.talisman.hackaton.dao.EventDAO;
import ru.talisman.hackaton.dao.PersonDAO;
import ru.talisman.hackaton.models.Book;
import ru.talisman.hackaton.models.Event;
import ru.talisman.hackaton.models.Person;

import java.sql.SQLException;
import java.util.List;


@Controller
public class FirstController {
    GetWeather gw = new GetWeather();
    @Autowired
    public BookDAO bookDAO;
    @Autowired
    public PersonDAO personDAO;
    @Autowired
    public EventDAO eventDAO;
    String isauth = "0";
    String[] personData;
    List<Book> books;

    @GetMapping("/")
    public String start(Model model) {
        System.out.println(isauth);
        model.addAttribute("isauth", isauth);
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

    @GetMapping("/razvl")
    public String razvl() {
        return "razvl";
    }

    @GetMapping("/beach")
    public String beach() {
        return "beach";
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

    @GetMapping("/contact")
    public String contact() {
        return "contact";
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
    @GetMapping("/besedki_book")
    public String book_besedki(){
        return "besedki_book";
    }
    @GetMapping("/banya_book")
    public String book_banya(){
        return "banya_book";
    }

    @GetMapping("/lk")
    public String profile(Model model) {
        System.out.println("name!!!");
        books = bookDAO.getData(personData[1]);
        for (Book book : books){
            System.out.println(book.getInfo());
        }
        model.addAttribute("books",  books);
        model.addAttribute("dao", bookDAO);
        model.addAttribute("name", personData[0]);
        return "lk";
    }


    @PostMapping("/reg")
    public String reg(@ModelAttribute("person") Person person, HttpServletRequest request) throws SQLException {
        String field = request.getParameter("regbtn");
        if("redirect".equals(field)){
            return "redirect:/login";
        }
        personDAO.save(person);
        personData = personDAO.getData(person);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String log(@ModelAttribute("person") Person person, HttpServletRequest request) throws SQLException {
        String field = request.getParameter("loginbtn");
        if("redirect".equals(field)){
            return "redirect:/reg";
        }
        isauth = personDAO.login(person);
        personData = personDAO.getData(person);
        return "redirect:/";
    }

    @PostMapping("/bron")
    public String bron_post(@ModelAttribute("book") Book book) throws SQLException {
        bookDAO.book(book);
        return "redirect:/lk";
    }

    @PostMapping("/event")
    public String event_db(@ModelAttribute("event") Event event) throws SQLException {
        eventDAO.event(event);
        return "redirect:/lk";
    }


}
