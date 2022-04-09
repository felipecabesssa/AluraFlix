package com.aluraflix.apibackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluraflix.apibackend.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{
	
	Video findById(long id);

}
