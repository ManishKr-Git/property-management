package com.zero2hero.practice.service.impl;

import com.zero2hero.practice.convertor.PropertyConverter;
import com.zero2hero.practice.dto.PropertyDTO;
import com.zero2hero.practice.entity.PropertyEntity;
import com.zero2hero.practice.repository.PropertyRepository;
import com.zero2hero.practice.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements IPropertyService {

    @Autowired
    private PropertyRepository  propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        PropertyDTO dto = propertyConverter.convertEntityToDTO(propertyEntity);
        return dto;
    }
    @Override
    public List<PropertyDTO> getAllProperties(){
        List<PropertyEntity> propertyEntityList = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for(PropertyEntity pe: propertyEntityList){
            propertyDTOList.add(propertyConverter.convertEntityToDTO(pe));
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity>propertyEntity = propertyRepository.findById(propertyId);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(pe);
            return propertyConverter.convertEntityToDTO(pe);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePartialProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity>propertyEntity = propertyRepository.findById(propertyId);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(pe);
            return propertyConverter.convertEntityToDTO(pe);
        }
        return null;
    }

    @Override
    public PropertyDTO deleteProperty(Long propertyId) {
        Optional<PropertyEntity>propertyEntity = propertyRepository.findById(propertyId);
        if(propertyEntity.isPresent()){
            propertyRepository.deleteById(propertyId);
            return propertyConverter.convertEntityToDTO(propertyEntity.get());
        }
        return null;
    }
}
