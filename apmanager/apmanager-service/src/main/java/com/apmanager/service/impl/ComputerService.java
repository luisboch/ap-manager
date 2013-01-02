/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.service.impl;

import com.apmanager.domain.dao.impl.ComputerDAO;
import com.apmanager.domain.entity.Computer;
import com.apmanager.service.BasicService;
import com.apmanager.service.exceptions.ValidationException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class ComputerService extends BasicService<Computer, ComputerDAO> {

    private static final Logger log = LoggerFactory.getLogger(ComputerService.class);

    public ComputerService() {
        this.dao = new ComputerDAO(emanager);
    }

    @Override
    public void validate(Computer c) throws ValidationException {
        ValidationException ex = new ValidationException(Computer.class);

        if (c.getIpv4() == null && c.getIpv6() == null) {
            ex.addError("Ip inválido", "ipv4", "computer.invalid.ip");
        }

        if (c.getName() == null || c.getName().equals("")) {
            ex.addError("Nome do computador inválido", "name", "computer.invalid.name");
        }

        if (!ex.isEmpty()) {
            throw ex;
        }
    }

    public Computer createComputerParameter() throws Exception {
        Computer computer = new Computer();

        try {
            InetAddress ipv4 = InetAddress.getLocalHost();
            InetAddress ipv6 = Inet6Address.getLocalHost();

            computer.setIpv4(ipv4.getHostAddress());
            computer.setName(ipv4.getHostName());
            computer.setIpv6(ipv6.getHostAddress());

            save(computer);
            log.info("New computer created [ {} ]", computer.toString());
        } catch (UnknownHostException ex) {
            log.error(ex.getMessage(), ex);
        }

        return computer;
    }
}
