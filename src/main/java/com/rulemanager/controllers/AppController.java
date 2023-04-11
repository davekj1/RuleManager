package com.rulemanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rulemanager.dtos.AppDTO;
import com.rulemanager.entities.App;
import com.rulemanager.services.AppServices;

@RestController
public class AppController {
	@Autowired
	AppServices appService;
	
	/*
	 * /apps
	 *  /apps/{id}
	*/
	@GetMapping(value="/apps")
	public List<AppDTO> getAllApps(@RequestParam  Optional<Boolean> active){
		return appService.getAllApps(active);
	}
	@GetMapping(value="/apps/{id}")
	public AppDTO getById(@PathVariable int id) {
		return appService.getById(id);
	}
	
	@PutMapping(value="/apps/{id}")
	public void updateTitle(@PathVariable int id,@RequestBody AppDTO appDTO) {
		appService.updateApp(id, appDTO);
	}
	@Validated
	@PostMapping(value="/apps")
	public void saveApp(@RequestBody AppDTO appDTO) {
	
		appService.addApp(appDTO);
	}
	@DeleteMapping(value="/apps/{id}")
	public void deleteApp(@PathVariable int id) {
		appService.deleteAppById(id);
	}
}
