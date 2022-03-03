package com.azure.LoggedInn.mappers;

import com.azure.LoggedInn.dto.HostDTO;
import com.azure.LoggedInn.models.Host;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface HostMapper {


    Host DTOtoHost(HostDTO hostDTO);

    HostDTO hostToDTO(Host host);

    @Mappings({@Mapping(target = "id", ignore = true),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "email", ignore = true)})
    void customMapHost(@MappingTarget Host targetHost, Host sourceHost);
}
