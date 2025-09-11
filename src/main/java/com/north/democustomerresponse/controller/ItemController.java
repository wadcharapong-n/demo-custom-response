package com.north.democustomerresponse.controller;

import com.north.democustomerresponse.dto.ItemDto;
import com.north.democustomerresponse.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<ItemDto> getItem() {
        log.info("Getting item");
        return ResponseEntity.ok(itemService.getItem());
    }

}
