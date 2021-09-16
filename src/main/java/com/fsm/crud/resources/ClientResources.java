package com.fsm.crud.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fsm.crud.dto.ClientDTO;
import com.fsm.crud.services.ClientServices;

@RestController
@RequestMapping(value = "clients")
public class ClientResources {
	@Autowired
	ClientServices services;
		@GetMapping
		public ResponseEntity<Page<ClientDTO>> findAll(
				@RequestParam(value = "page", defaultValue = "0") Integer page,
				@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
				@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
				@RequestParam(value = "direction", defaultValue = "DESC") String direction
			
				){
			PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
			Page<ClientDTO> clients = services.findAll(pageRequest);
			return ResponseEntity.ok().body(clients);

		}
		@GetMapping(value = "/{id}")
		public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
			ClientDTO client = services.findById(id);			
			return ResponseEntity.ok().body(client);
			
		}
		
		@PostMapping
		public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO newClient){
			ClientDTO client = services.insert(newClient);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
					buildAndExpand(client.getId()).toUri();
			return ResponseEntity.created(uri).body(client);
			
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<ClientDTO> update (@PathVariable Long id, @RequestBody ClientDTO updateClient ){
			ClientDTO client = services.update(id,updateClient);
			return ResponseEntity.ok().body(client);
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete (@PathVariable Long id){
			services.delete(id);
			return ResponseEntity.noContent().build();			
		}

}
