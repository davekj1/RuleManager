package com.rulemanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rulemanager.entities.App;

@Repository
public interface AppRepo extends JpaRepository<App, Integer> {
	public App findByTitle (String title);
}
