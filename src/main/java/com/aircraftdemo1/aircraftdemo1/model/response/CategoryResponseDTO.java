package com.aircraftdemo1.aircraftdemo1.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {

    private Long id;
    private String categoryName;
    private String categoryDescription;
    private Date creationDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;

    // Getter and setter methods...
}
