package com.north.democustomerresponse.service;

import com.north.democustomerresponse.annotation.WithMockTestUser;
import com.north.democustomerresponse.dto.ItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ItemServiceTest {
    @Autowired
    private ItemService itemService;
    private ItemDto expectedItem;

    @BeforeEach
    void setUp() {
        expectedItem = new ItemDto();
        expectedItem.setId(1L);
        expectedItem.setName("Sample Item");
        expectedItem.setDescription("This is a sample item description");
        expectedItem.setPrice(new BigDecimal("29.99"));
    }

    @Test
    @WithMockTestUser(canSeeSensitive = true)
    void getItemWithCanSensitiveData_ShouldReturnItemWithSensitiveData() {
        ItemDto result = itemService.getItem();

        assertNotNull(result);
        assertEquals(expectedItem.getId(), result.getId());
        assertEquals(expectedItem.getName(), result.getName());
        assertEquals(expectedItem.getDescription(), result.getDescription());
        assertEquals(expectedItem.getPrice(), result.getPrice());
    }

    @Test
    @WithMockTestUser(canSeeSensitive = false)
    void getItemWithCanNotSensitiveData_ShouldReturnItemWithNonSensitiveData() {
        ItemDto result = itemService.getItem();
        assertNotNull(result);
        assertEquals(expectedItem.getId(), result.getId());
        assertEquals(expectedItem.getName(), result.getName());
        assertEquals("You can't see me.", result.getDescription());
        assertEquals("XX.XX", result.getPrice());
    }
}