package com.example.demo.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * ツイート一覧表示
     * @param tweet
     * @param model
     * @return　ツイート一覧画面
     */
    @GetMapping("/")
    public String showList(@ModelAttribute Tweet tweet, Model model) {
	model.addAttribute("tweets",
		repository.findAll(Sort.by(Sort.Direction.DESC, "id")));
	return "index";
    }

    /**
     * ツイート保存
     * @param tweet
     * @param result
     * @param model
     * @return　一覧画面へリダイレクト
     */
    @PostMapping("/add")
    public String addTweet(@Validated @ModelAttribute Tweet tweet, BindingResult result, Model model) {
	model.addAttribute("tweet", repository.findAll());
	if(result.hasErrors()) {
	    return "index";
	}
	repository.save(tweet);

	return "redirect:/";
    }

    /**
     * TWEET編集画面を表示
     * @param id ツイートID
     * @param model Model
     * @return ツイート編集画面
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
	model.addAttribute("tweet", repository.findById(id));
	return "edit";
    }

    /**
     * TWEET更新処理
     * @param model Model
     * @param tweet Tweet
     * @return ツイート一覧画面
     */
    @PostMapping("/update")
    public String update(@ModelAttribute Tweet tweet, Model model) {

	repository.save(tweet);

	model.addAttribute("tweets",
		repository.findAll(Sort.by(Sort.Direction.DESC, "id")));

	return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {

	repository.deleteById(id);

	return "redirect:/";
    }

}

