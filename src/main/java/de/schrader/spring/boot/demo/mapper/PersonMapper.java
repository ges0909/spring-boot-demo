package de.schrader.spring.boot.demo.mapper;

import de.schrader.spring.boot.demo.dto.PersonDto;
import de.schrader.spring.boot.demo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "age", target = "alter")
    PersonDto toDto(Person person);

    @Mapping(source = "alter", target = "age")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", source = "")
    Person toEntity(PersonDto personDto);
}
