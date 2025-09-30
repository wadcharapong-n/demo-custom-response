package com.north.democustomerresponse.dto;

import com.north.democustomerresponse.annotation.SensitiveData;
import com.north.democustomerresponse.handle.CustomHandleAuthorizationDenied;
import com.north.democustomerresponse.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public ItemDto(Item item) {
        BeanUtils.copyProperties(item, this);
    }

    @SensitiveData
    public Object getPrice() {
        return price;
    }

    @SensitiveData
    public String getDescription() {
        return description;
    }
}
