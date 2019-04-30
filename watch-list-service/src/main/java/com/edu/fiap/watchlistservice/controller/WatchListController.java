package com.edu.fiap.watchlistservice.controller;

import com.edu.fiap.watchlistservice.facade.WatchListFacade;
import com.edu.fiap.watchlistservice.model.request.WatchListItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * WatchList Controller
 * @author agnaldo.almeida
 */
@RestController("watchlist")
public class WatchListController {

    /**
     * WatchList Facade
     */
    @Autowired
    private WatchListFacade watchListFacade;

    @PostMapping()
    public ResponseEntity createItem(@RequestBody WatchListItemRequest watchItem) {

        return null;
    }

    @PutMapping("{idUser}")
    public ResponseEntity updateAvaliation(@PathVariable Integer idUser,
                                           @RequestBody WatchListItemRequest watchItem) {

        return null;
    }

    @PutMapping("watched/{idUser}")
    public ResponseEntity markItemAsWatched(@PathVariable Integer idUser,
                                           @RequestBody WatchListItemRequest watchItem) {

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
