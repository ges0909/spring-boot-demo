package de.schrader.spring.boot.demo.mapper;

import de.schrader.spring.boot.demo.dto.PersonDto;
import de.schrader.spring.boot.demo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "age", target = "alter")
    PersonDto toDto(Person person);

    @Mappings({
            @Mapping(source = "alter", target = "age"),
            @Mapping(target = "email", ignore = true)
    })
    Person toEntity(PersonDto personDto);
}
