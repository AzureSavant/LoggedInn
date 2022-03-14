package com.azure.LoggedInn.mappers;

import com.azure.LoggedInn.dto.UserDTO;
import com.azure.LoggedInn.models.User;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface UserMapper {


    User DTOtoUser(UserDTO userDTO);

    UserDTO UserToDTO(User user);

    @Mappings({@Mapping(target = "id", ignore = true),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "email", ignore = true)})
    void customMapUser(@MappingTarget User targetUser, User sourceUser);
}
