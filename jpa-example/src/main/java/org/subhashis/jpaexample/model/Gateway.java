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
}
