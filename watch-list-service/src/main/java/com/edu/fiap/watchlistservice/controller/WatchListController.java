package com.edu.fiap.watchlistservice.controller;

import com.edu.fiap.watchlistservice.facade.WatchListFacade;
import com.edu.fiap.watchlistservice.model.request.WatchListItemRequest;
import com.edu.fiap.watchlistservice.model.response.WatchListItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * WatchList Controller
 * @author agnaldo.almeida
 */
@RestController
@RequestMapping(ControllerConstants.SERVICE_URL_PREFIX)
public class WatchListController {

    /**
     * WatchList Facade
     */
    @Autowired
    private WatchListFacade watchListFacade;

    /**
     * Creates item in watchlist
     * @param watchItem watchItem
     * @return ResponseEntity
     */
    @PostMapping()
    public ResponseEntity<Boolean> createItem(@Valid @NotNull @RequestBody WatchListItemRequest watchItem) {

        if (watchListFacade.addCatalogToWatchList(watchItem)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    /**
     * Updated user avaliation for an item
     * @param watchItem watchItem
     * @return ResponseEntity
     */
    @PutMapping(ControllerConstants.SERVICE_URL_AVALIATION)
    public ResponseEntity<Boolean> updateAvaliation(@RequestBody WatchListItemRequest watchItem) {
        if (watchListFacade.updateAvaliation(watchItem)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }


    /**
     * Mark catalog item as watched
     * @param watchItem watchItem
     * @return ResponseEntity
     */
    @PutMapping(ControllerConstants.SERVICE_URL_WATCHED)
    public ResponseEntity<Boolean> markItemAsWatched(@RequestBody WatchListItemRequest watchItem) {

        if (watchListFacade.markAsWatched(watchItem)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gets user watchlist
     * @param idUser id User
     * @return ResponseEntity
     */
    @GetMapping("{idUser}")
    @SuppressWarnings("Duplicates")
    public ResponseEntity<List<WatchListItemResponse>> getUserWatchlist(@PathVariable Integer idUser) {

        List<WatchListItemResponse> listItemResponseList = watchListFacade.getUserWatchList(idUser);
        if (listItemResponseList != null && listItemResponseList.size() > 0) {
            return new ResponseEntity(listItemResponseList, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Gets wathed movies of the user
     * @param idUser user id
     * @return ResponseEntity
     */
    @GetMapping(ControllerConstants.SERVICE_URL_WATCHED + "/{idUser}")
    @SuppressWarnings("Duplicates")
    public ResponseEntity<List<WatchListItemResponse>> getWatchedList(@PathVariable Integer idUser) {

        List<WatchListItemResponse> listItemResponseList = watchListFacade
                .getUserWatchedOrNonWatched(true, idUser);
        if (listItemResponseList != null && listItemResponseList.size() > 0) {
            return new ResponseEntity(listItemResponseList, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}
