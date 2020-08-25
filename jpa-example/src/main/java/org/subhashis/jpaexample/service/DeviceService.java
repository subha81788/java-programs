package org.subhashis.jpaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.subhashis.jpaexample.dao.DeviceDao;
import org.subhashis.jpaexample.exception.DeviceNotFoundException;
import org.subhashis.jpaexample.model.Device;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceDao deviceDaoImpl;

    public List<Device> getAllDevices() {
        return deviceDaoImpl
                .findAll()
                .orElseThrow(() -> { throw new DeviceNotFoundException("No device found"); });
    }

    public  Device getDevice(String serial) {
        return deviceDaoImpl.findBySerial(serial).get();
        //return deviceDaoImpl.findBySerial(serial)
        //        .orElseThrow(() -> { throw new DeviceNotFoundException(HttpStatus.NOT_FOUND, "No device found"); });
    }

    public void addDevice(Device dev) {
        deviceDaoImpl.save(dev);
    }

    public Device updateDevice(Device dev) {
        return deviceDaoImpl.update(dev);
    }

    public void removeDevice(String serial) {
        deviceDaoImpl.deleteBySerial(serial);
    }
}