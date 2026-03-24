package com.backend.quizzer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.backend.quizzer.dto.Evaluate;
import com.backend.quizzer.dto.Evaluation;
import com.backend.quizzer.dto.Question;
import com.backend.quizzer.service.ChatService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
// @RequestMapping("chat")
// @CrossOrigin(origins = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.OPTIONS
})
public class Controller {

    private final ChatService chatService;

    Controller(ChatService chatService) {
        this.chatService = chatService;
    }

    // @GetMapping("/")
    // public void redirect(HttpServletResponse response) throws IOException {
    // response.sendRedirect("https://quizzer-hj71raqa8-jay-varshneys-projects-44d2e328.vercel.app");
    // }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<html><body><script>window.location.href='https://quizzer-hj71raqa8-jay-varshneys-projects-44d2e328.vercel.app';</script><p>Redirecting...</p></body></html>";
    }

    @GetMapping("/chat/normal")
    public String callnormalai(@RequestParam("q") String q) {
        return chatService.chat(q);
    }

    @GetMapping("/chat/genQue")
    public Question generaQuestion(@RequestParam("n") int num, @RequestParam("q") String q) {
        return chatService.genQue(num, q);
    }

    @PostMapping("/chat/evaluate")
    public Evaluation evaluateTheAnswers(@RequestBody Evaluate eval) {
        return chatService.evaluate(eval);
    }

}
