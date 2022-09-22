package controllers;

import java.util.Set;

import dto.HospedeDTO;
import service.HospedeService;

public class HospedeController {

	private HospedeService hospedeService = new HospedeService();
	
	public Set<HospedeDTO> findAllHospedes() {
		Set<HospedeDTO> obj = hospedeService.findAll();
		return obj;
	}
	
}
