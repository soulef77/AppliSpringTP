package com.inetum.appliSpringWeb.converter;


import java.util.List;

import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.entity.Compte;

public class DtoConverter {

	
	
	public /*static*/ List<CompteDto> compteToCompteDto(List<Compte> entityList) {
		 return entityList.stream()
		         .map((entity)->compteToCompteDto(entity))
		         .toList();
	}
	
	
	 public /*static*/ CompteDto compteToCompteDto(Compte entity) {
		/* return new CompteDto(entity.getNumero(), entity.getLabel(), entity.getSolde());*/
		 
		 CompteDto compteDto = new CompteDto();
		 compteDto.setLabel(entity.getLabel());
		 compteDto.setNumero(entity.getNumero());
		 compteDto.setSolde(entity.getSolde());
		 // BeanUtils.copyProperties(entity, compteDto);
		  return compteDto;
	 }
	 
	 public /*static*/ Compte compteDtoToCompte(CompteDto dto) {
		 return new Compte(dto.getNumero(), dto.getLabel(), dto.getSolde());
	 }
}
