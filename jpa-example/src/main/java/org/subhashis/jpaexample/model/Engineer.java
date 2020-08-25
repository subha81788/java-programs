package org.subhashis.jpaexample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_engineer")
public class Engineer {

    @Id
    @Column(name = "service_engg_id")
    private String empId;

    private String name;

    @ManyToMany
    private List<Device> provisionedDeviceList;

    public Engineer() {}

    public Engineer(String empId, String name, List<Device> provisionedDeviceList) {
        this.empId = empId;
        this.name = name;
        this.provisionedDeviceList = provisionedDeviceList;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getProvisionedDeviceList() {
        return provisionedDeviceList;
    }

    public void setProvisionedDeviceList(List<Device> provisionedDeviceList) {
        this.provisionedDeviceList = provisionedDeviceList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Engineer{");
        sb.append("empId='").append(empId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", provisionedDeviceList=").append(provisionedDeviceList);
        sb.append('}');
        return sb.toString();
    }
}