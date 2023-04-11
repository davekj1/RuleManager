package com.rulemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulemanager.dtos.AppDTO;
import com.rulemanager.entities.App;
import com.rulemanager.mappers.AppToAppDTOMapper;
import com.rulemanager.repositories.AppRepo;
@Service
public class AppServices {
	@Autowired
	private AppRepo appRepository;
	
	private AppToAppDTOMapper mapper;
	public void addApp(AppDTO appDTO) {
		
		App app=mapper.INSTANCE.appDTOToApp(appDTO);
		appRepository.save(app);
	}
	public void deleteAppById(int id) {
		App app=appRepository.findById(id).get();
		app.setActive(false);
		appRepository.save(app);
	}
	public void updateApp(int id,AppDTO appDTO) {
		App originalApp=appRepository.findById(id).get();
		originalApp.setDescription(appDTO.getDescription());
		originalApp.setTitle(appDTO.getTitle());
		appRepository.save(originalApp);
	}

	public List<AppDTO> getAllApps(Optional<Boolean> active) {
		List<App> appList= appRepository.findAll();
		if(!active.isEmpty()  && active.get().booleanValue()) {
			appList.removeIf((e)->!e.isActive());
		}
		return mapper.INSTANCE.appsToAppDTOs(appList);
	}

	public AppDTO getById(int id) {
		App app=appRepository.findById(id).get();
	    return mapper.INSTANCE.appToAppDTO(app);
	}
	
}
