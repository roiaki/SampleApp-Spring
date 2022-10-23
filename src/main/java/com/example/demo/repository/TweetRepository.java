package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tweet;


//import com.example.demo.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>{

}
