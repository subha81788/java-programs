package org.subhashis.jpaexample.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Gateway {

    @Id
    private String serial;

    private String model;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "gateway")
    private List<Device> deviceList;

    public Gateway() {}

    public Gateway(String serial, String model, List<Device> deviceList) {
        this.serial = serial;
        this.model = model;
        this.deviceList = deviceList;
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

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gateway{");
        sb.append("serial='").append(serial).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", deviceList=").append(deviceList);
        sb.append('}');
        return sb.toString();
    }
}
