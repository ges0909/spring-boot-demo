package de.schrader.spring.boot.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {

    private String name;
    private int alter;
}
