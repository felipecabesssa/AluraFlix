package com.aluraflix.apibackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluraflix.apibackend.entities.Video;
import com.aluraflix.apibackend.repositories.VideoRepository;
import com.aluraflix.apibackend.resources.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping
public class VideoResource {
	
	@Autowired
	VideoRepository videoRepository;
	
	@GetMapping("/videos")
	public List<Video> listaTodosVideos(){
		return videoRepository.findAll();
	}
	
	@GetMapping("/videos/{id}")
	public Video listaUnicoVideo(@PathVariable(value="id") long id){
		Video obj = videoRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Video não encontrado! Id: " + id
					+ ", Tipo: " + Video.class.getName());
		}
		return obj;
	}
	
	@PostMapping("/videos")
	public Video salvaVideo(@RequestBody Video video) {
		return videoRepository.save(video);
	}
	
	@DeleteMapping("/videos/{id}")
	public void deletaVideo(@PathVariable(value="id") long id) {
		videoRepository.deleteById(id);
	}

	@PutMapping("/videos/{id}")
	public Video atualizaVideo(@PathVariable(value="id") long id, @RequestBody Video video) {
		return videoRepository.save(video);
	}

}
