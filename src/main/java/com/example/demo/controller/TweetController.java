package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.TweetRepository;


@Controller
public class TweetController {

    private final TweetRepository repository;

    //@Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    public TweetController(TweetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showList(Model model) {
	return "index";
    }
}

