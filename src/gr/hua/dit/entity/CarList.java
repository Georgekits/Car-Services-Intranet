package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CarList")
@Component
public class CarList {

	List<ManagingSystem> carList;

	public List<ManagingSystem> getCarList() {
		return carList;
	}

	public void setCarList(List<ManagingSystem> carList) {
		this.carList = carList;
	}
	
}
