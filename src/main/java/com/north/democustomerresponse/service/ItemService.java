package com.north.democustomerresponse.service;

import com.north.democustomerresponse.dto.ItemDto;
import com.north.democustomerresponse.model.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    @AuthorizeReturnObject
    public ItemDto getItem() {
        log.info("Getting item");
        Item item = new Item();
        item.setId(1L);
        item.setName("Sample Item");
        item.setDescription("This is a sample item description");
        item.setPrice(new BigDecimal("29.99"));
        return new ItemDto(item);
    }
}
