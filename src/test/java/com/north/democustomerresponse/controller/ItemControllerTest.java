package com.north.democustomerresponse.controller;

import com.north.democustomerresponse.annotation.WithMockTestUser;
import com.north.democustomerresponse.dto.ItemDto;
import com.north.democustomerresponse.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@AutoConfigureMockMvc(addFilters = true)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ItemService itemService;

    private ItemDto testItem;

    @BeforeEach
    void setUp() {
        testItem = new ItemDto();
        testItem.setId(1L);
        testItem.setName("Sample Item");
        testItem.setDescription("This is a sample item description");
        testItem.setPrice(new BigDecimal("29.99"));
    }

    @Test
    @WithMockTestUser(username = "Admin", canSeeSensitive = true)
    void getItem_WithSensitiveDataAccess_ShouldReturnCompleteItem() throws Exception {
        when(itemService.getItem()).thenReturn(testItem);
        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("This is a sample item description"))
                .andExpect(jsonPath("$.name").value("Sample Item"));
    }
}