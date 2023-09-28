package com.aircraftdemo1.aircraftdemo1.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftResponseDTO {

    private Long id;
    private String name;
    private String manufacturer;
    private String servicePeriod;
    private String countryOfOrigin;
    private String promoPageURL;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private Long categoryId;
    private Date creationDate; // Oluşturma tarihini ekledik
    private String createdBy; // Oluşturan kullanıcıyı ekledik
    private Date lastModifiedDate; // Son güncelleme tarihini ekledik
    private String lastModifiedBy; // Son güncelleyen kullanıcıyı ekledik
}
