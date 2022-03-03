package com.azure.LoggedInn.mappers;

import com.azure.LoggedInn.dto.TravelerDTO;
import com.azure.LoggedInn.models.Traveler;
import org.mapstruct.*;

@Mapper (nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface TravelerMapper {

    Traveler DTOtoTraveler(TravelerDTO travelerDTO);

    TravelerDTO travelerToDTO (Traveler traveler);

    @Mappings({@Mapping(target = "id", ignore = true),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "email", ignore = true)})
    void customMapTraveler(@MappingTarget Traveler targetTraveler, Traveler sourceTraveler);
}
