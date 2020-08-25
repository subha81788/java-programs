package org.subhashis.jpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.subhashis.jpaexample.dao.DeviceDao;
import org.subhashis.jpaexample.dao.DeviceDaoImpl;
import org.subhashis.jpaexample.model.Device;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class JpaExampleApplication implements CommandLineRunner {

	@Autowired
	private DeviceDaoImpl deviceDaoImpl;

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var deviceList = deviceDaoImpl.getDeviceList();
		var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		deviceList.add(new Device("AAA123", "PowerStore", LocalDate.parse("12/06/2020", dateFormatter)));
		deviceList.add(new Device("AAA124", "Beta1", LocalDate.parse("11/05/2019", dateFormatter)));
		deviceList.add(new Device("AAA125", "Beta2", LocalDate.parse("25/08/2020", dateFormatter)));


	}
}
