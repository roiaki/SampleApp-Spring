package com.example.demo.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Tweet;
import com.example.demo.repository.TweetRepository;


@Controller
public class TweetController {

    private final TweetRepository repository;

    // @Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    // springがオブジェクトを管理、注入してくれる
    public TweetController(TweetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showList(@ModelAttribute Tweet tweet, Model model) {
	model.addAttribute("tweets",
		repository.findAll(Sort.by(Sort.Direction.DESC, "id")));
	return "index";
    }

    @PostMapping("/add")
    public String addTweet(@Validated @ModelAttribute Tweet tweet, BindingResult result, Model model) {
	model.addAttribute("tweet", repository.findAll());
	if(result.hasErrors()) {
	    return "index";
	}
	repository.save(tweet);

	return "redirect:/";
    }
}

