package org.subhashis.jpaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.subhashis.jpaexample.exception.DeviceNotFoundException;
import org.subhashis.jpaexample.model.Device;
import org.subhashis.jpaexample.service.DeviceService;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping(path="/devices", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping(path="/devices/{serial}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Device getDevice(@PathVariable("serial") String serial) {
        return deviceService.getDevice(serial);
    }

    @PostMapping(path="/devices",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        device.getSerial())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}