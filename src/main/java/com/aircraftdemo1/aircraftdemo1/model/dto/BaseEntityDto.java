package com.aircraftdemo1.aircraftdemo1.model.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Data
@MappedSuperclass
public abstract class BaseEntityDto implements Serializable {
    private Long id;
}
