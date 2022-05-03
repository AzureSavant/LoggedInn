package com.azure.LoggedInn.mappers;

import com.azure.LoggedInn.dto.ResourceDTO;
import com.azure.LoggedInn.models.Resource;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface ResourceMapper {

    Resource DTOtoResource(ResourceDTO resourceDTO);

    ResourceDTO resourceToDTO(Resource resource);

    @Mappings({@Mapping(target = "id", ignore = true)})
    void customMapResource(@MappingTarget Resource targetResource, Resource sourceResource);
}
