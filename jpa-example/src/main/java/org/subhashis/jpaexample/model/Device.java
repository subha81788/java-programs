package org.subhashis.jpaexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Device {
    @Id
    private String serial;

    private String model;

    @OneToOne
    private Gateway gateway;

    private LocalDate provisionDate;

    @ManyToMany
    @JoinTable(name="device_engineer",
            joinColumns=@JoinColumn(name="device_id"),
            inverseJoinColumns=@JoinColumn(name="service_engg_id"))
    private List<Engineer> serviceEngineerList;

    public Device() {}

    public Device(String serial, String model) {
        this.serial = serial;
        this.model = model;
    }

    public Device(String serial, String model, LocalDate date) {
        this(serial, model);
        this.provisionDate = date;
    }

    public Device(String serial, String model, Gateway gw, LocalDate date) {
        this(serial, model, date);
        this.gateway = gw;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public LocalDate getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(LocalDate provisionDate) {
        this.provisionDate = provisionDate;
    }

    public List<Engineer> getServiceEngineerList() {
        return serviceEngineerList;
    }

    public void setServiceEngineerList(List<Engineer> serviceEngineerList) {
        this.serviceEngineerList = serviceEngineerList;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("Device{");
        sb.append("serial='").append(serial).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", gateway=").append(gateway);
        sb.append(", provisionDate=").append(provisionDate);
        sb.append(", serviceEngineerList=").append(serviceEngineerList);
        sb.append('}');
        return sb.toString();
    }
}
