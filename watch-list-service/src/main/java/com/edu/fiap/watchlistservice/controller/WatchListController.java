package com.edu.fiap.watchlistservice.controller;

import com.edu.fiap.watchlistservice.model.request.WatchItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("watchlist")
public class WatchListController {

    @PostMapping()
    public ResponseEntity createItem(@RequestBody WatchItemRequest watchItem) {

        return null;
    }

    @PutMapping("{idUser}")
    public ResponseEntity updateAvaliation(@PathVariable Integer idUser,
                                           @RequestBody WatchItemRequest watchItem) {

        return null;
    }

    @PutMapping("watched/{idUser}")
    public ResponseEntity markItemAsWatched(@PathVariable Integer idUser,
                                           @RequestBody WatchItemRequest watchItem) {

        //TODO: Contabilizar ranking, CRIAR TABELA
        return null;
    }

    @GetMapping("{idUser}")
    public  ResponseEntity getUserWatchlist(@PathVariable Integer idUser) {

        return null;
    }

    @GetMapping("watched/{idUser}")
    public ResponseEntity getWatchedList(@PathVariable Integer idUser) {

        return null;
    }
}
