package org.subhashis.jpaexample.dao;

import org.springframework.stereotype.Repository;
import org.subhashis.jpaexample.model.Device;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeviceDaoImpl implements DeviceDao {

    private List<Device> deviceList = new ArrayList<>();

    public List<Device> getDeviceList() {
        return this.deviceList;
    }

    @Override
    public Optional<List<Device>> findAll() {
        return Optional.of(deviceList);
    }

    @Override
    public Optional<Device> findBySerial(String serial) {
        return deviceList.stream().filter(d -> d.getSerial().equals(serial)).findFirst();
    }

    @Override
    public void save(Device dev) {
        if(deviceList.stream().anyMatch(d -> d.getSerial().equals(dev.getSerial()))) {
            throw new IllegalArgumentException("Device with serial number " + dev.getSerial() + " already exists");
        }
        deviceList.stream()
                .filter(d -> d.getSerial().equals(dev.getSerial()))
                .findAny()
                .ifPresentOrElse(d -> {
                    throw new IllegalArgumentException("Device with serial number " + dev.getSerial() + " already exists");
                }, () -> deviceList.add(dev));
    }

    @Override
    public Device update(Device dev) {
        return deviceList.stream()
                .filter(d -> d.getSerial().equals(dev.getSerial())).findFirst()
                .map(devToUpdate -> {
                    devToUpdate.setModel(dev.getModel());
                    devToUpdate.setGateway(dev.getGateway());
                    devToUpdate.setProvisionDate(dev.getProvisionDate());
                    devToUpdate.setServiceEngineerList(dev.getServiceEngineerList());
                    return devToUpdate;
                }).get();
    }

    @Override
    public void deleteBySerial(String serial) {
        // TODO
        return;
    }
}
