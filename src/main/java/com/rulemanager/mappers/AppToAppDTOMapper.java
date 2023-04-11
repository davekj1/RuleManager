package com.rulemanager.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.rulemanager.dtos.AppDTO;
import com.rulemanager.entities.App;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AppToAppDTOMapper {
	AppToAppDTOMapper INSTANCE = Mappers.getMapper( AppToAppDTOMapper.class ); 
	 
   
   AppDTO appToAppDTO(App app);
   List<AppDTO> appsToAppDTOs(List<App> apps);
   App appDTOToApp(AppDTO appDTO);
}
 