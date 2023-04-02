package com.example.demo.CourseAPI.Slack;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class SlackClient {
    public String sendMessage(String text) {


        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
