package com.server.maskara.domain.collectionBox.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseCollectionBoxPos {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
}
