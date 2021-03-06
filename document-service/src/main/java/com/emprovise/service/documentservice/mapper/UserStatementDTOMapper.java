package com.emprovise.service.documentservice.mapper;

import com.emprovise.service.documentservice.dto.UserStatementDTO;
import com.emprovise.service.documentservice.dto.StatementDetailDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserStatementDTOMapper {

    @Mappings({
            @Mapping(target="period", source = "statement.dateTime",
                    dateFormat = "MMM-yyyy")})
    UserStatementDTO mapToUserStatementDTO(StatementDetailDTO statement);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="dateTime", source = "statementDTO.period",
                    dateFormat = "MMM-yyyy")})
    StatementDetailDTO mapToStatementDetailDTO(UserStatementDTO statementDTO);
}
