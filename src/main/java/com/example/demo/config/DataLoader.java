package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.TweetRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private final TweetRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//	var tweet01 = new Tweet();
//	tweet01.setContent("こんにちは");
//	repository.save(tweet01);
//
//	var tweet02 = new Tweet();
//	tweet01.setContent("こんにちは02");
//	repository.save(tweet02);


    }

}
