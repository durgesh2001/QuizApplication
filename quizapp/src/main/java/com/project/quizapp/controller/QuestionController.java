package com.project.quizapp.controller;

import com.project.quizapp.model.Question;
import com.project.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
     public ResponseEntity<List<Question>> allQuestions(){
         return questionService.getAllQuestions();
     }

     @GetMapping("category/{category}")
     public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
     }

     @PostMapping("add")
     public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
     }

     @DeleteMapping("delete")
     public ResponseEntity<String> deleteQuestion(@RequestParam Integer id){
        return questionService.deleteQuestion(id);
     }
}
