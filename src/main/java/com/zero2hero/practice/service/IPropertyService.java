package com.zero2hero.practice.service;

import com.zero2hero.practice.dto.PropertyDTO;

import java.util.List;

public interface IPropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
    public PropertyDTO updatePartialProperty(PropertyDTO propertyDTO,Long propertyId);

    public PropertyDTO deleteProperty(Long propertyId);

}
