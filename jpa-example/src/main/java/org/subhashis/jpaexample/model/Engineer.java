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

}
