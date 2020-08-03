package org.subhashis.jpaexample.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Device {
    @Id
    private String serial;

    private String model;

    @OneToOne
    private String gateway;

    private Date provisionDate;

    @ManyToMany
    @JoinTable(name="device_engineer", joinColumns=@JoinColumn(name="device_id"), inverseJoinColumns=@JoinColumn(name="service_engg_id"))
    private List<Engineer> serviceEngineerList;
}
