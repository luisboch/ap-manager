/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.VehicleDAO;
import com.apmanager.domain.entity.Vehicle;
import com.apmanager.domain.entity.VehicleBrand;
import com.apmanager.domain.entity.VehicleModel;
import com.apmanager.service.BasicService;
import com.apmanager.service.ServiceAction;
import com.apmanager.service.exceptions.ValidationException;
import java.util.List;

/**
 *
 * @author luis
 */
public class VehicleService extends BasicService<Vehicle, VehicleDAO> {

    public VehicleService() {
        this.dao = new VehicleDAO(emanager);
    }

    @Override
    public void validate(Vehicle object, ServiceAction action) throws ValidationException {

        ValidationException v = new ValidationException(Vehicle.class);

        if (object.getName() == null || object.getName().equals("")) {
            v.addError("Nome de Veículo Inválido", "name", "invalide.vehicle.name");
        }
        if (object.getBrand() == null) {
            v.addError("Marca de Veículo não selecionado", "name", "invalide.vehicle.brand");
        }

        for (VehicleModel m : object.getVehicleModels()) {

            if (m.getFuelType() == null) {
                v.addError("Há modelo sem combústivel selecionado", "model.fueltype", "invalid.vehicle.model.fueltype");
            }
            if (m.getPotency() == null) {
                v.addError("Há modelo sem potencia", "model.fueltype", "invalid.vehicle.model.fueltype");
            }

            if (m.getVehicle() == null) {
                m.setVehicle(object);
            }

            if (m.getYear() == null || m.getYear().equals("")) {
                v.addError("Há modelo sem Ano", "model.year", "invalid.vehicle.model.year");
            }
            if (!v.isEmpty()) {
                throw v;
            }
        }

        if (!v.isEmpty()) {
            throw v;
        }
    }

    public List<Vehicle> getVehiclesByBrand(VehicleBrand brand) {
        return dao.getVehiclesByBrand(brand);
    }
}
