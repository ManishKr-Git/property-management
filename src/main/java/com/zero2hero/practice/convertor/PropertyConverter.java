package com.zero2hero.practice.convertor;

import com.zero2hero.practice.dto.PropertyDTO;
import com.zero2hero.practice.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setDescription(propertyDTO.getDescription());

        return propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setDescription(propertyEntity.getDescription());

        return propertyDTO;
    }
}
