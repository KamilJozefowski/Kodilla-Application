package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards() {

        trelloClient.getUrlTrelloBoard();
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoard();

        trelloBoards.stream()
                .filter(Objects::nonNull)
                .filter(t -> t.getName().matches("(.*)Kodilla(.*)"))
                .forEach(System.out::println);
    }
}