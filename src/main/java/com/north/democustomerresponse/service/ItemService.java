package com.north.democustomerresponse.service;

import com.north.democustomerresponse.annotation.FeatureToggle;
import com.north.democustomerresponse.dto.ItemDto;
import com.north.democustomerresponse.model.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class ItemService {

    // inject proxy of itself
    private final ItemService self;

    public ItemService(@Lazy ItemService itemService) {
        this.self = itemService;
    }

    @AuthorizeReturnObject
    public ItemDto getItem() {
        log.info("Getting item");
        Item item = new Item();
        item.setId(1L);
        item.setName("Sample Item");
        item.setDescription("This is a sample item description");
        item.setPrice(new BigDecimal("29.99"));
        self.updateItem(item);
        return new ItemDto(item);
    }

    @FeatureToggle(value = "new.checkout", failClosed = false)
    public void updateItem(Item item) {
        log.info("Updating item");
        item.setName("Sample Item Updated");
    }
}
