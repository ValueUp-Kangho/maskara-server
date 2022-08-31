package com.server.maskara.domain.collectionBox.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseCollectionBox {
    private String name;
    private String address;
    private String imgUrl;
}
