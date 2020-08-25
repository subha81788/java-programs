package org.subhashis.jpaexample.dao;

import org.subhashis.jpaexample.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceDao {
    public Optional<List<Device>> findAll();
    public Optional<Device> findBySerial(String serial);
    public void save(Device dev);
    public Device update(Device dev);
    public void deleteBySerial(String serial);
}
