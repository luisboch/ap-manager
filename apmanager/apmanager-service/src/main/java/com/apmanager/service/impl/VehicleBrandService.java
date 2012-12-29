package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.VehicleBrandDAO;
import com.apmanager.domain.entity.VehicleBrand;
import com.apmanager.service.BasicService;
import com.apmanager.service.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class VehicleBrandService extends BasicService<VehicleBrand, VehicleBrandDAO> {

    private static final Logger log = LoggerFactory.getLogger(VehicleBrandService.class);

    public VehicleBrandService() {
        this.dao = new VehicleBrandDAO(emanager);
    }

    @Override
    public void validate(VehicleBrand object) throws ValidationException {
        ValidationException e = new ValidationException(VehicleBrand.class);
        
        if(object.getName() ==  null || object.getName().equals("")){
            e.addError("Nome inválido", "name", "invalid.name");
        }
        
        if(!e.isEmpty()){
            throw e;
        }
    }
    
    
}
