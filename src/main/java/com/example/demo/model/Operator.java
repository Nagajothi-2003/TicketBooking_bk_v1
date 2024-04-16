package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="operators")
public class Operator {
		@Id
		@GeneratedValue
	 	private int operatorId;
	    private String operatorName;
	    private String contactPhone;
	    
	    @OneToMany(mappedBy = "operator",cascade = CascadeType.ALL)
		private List<BusSchedule> busSchedules;

		public int getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(int operatorId) {
			this.operatorId = operatorId;
		}

		public String getOperatorName() {
			return operatorName;
		}

		public void setOperatorName(String operatorName) {
			this.operatorName = operatorName;
		}

		public String getContactPhone() {
			return contactPhone;
		}

		public void setContactPhone(String contactPhone) {
			this.contactPhone = contactPhone;
		}

		public List<BusSchedule> getBusSchedules() {
			return busSchedules;
		}

		public void setBusSchedules(List<BusSchedule> busSchedules) {
			this.busSchedules = busSchedules;
		}
	    
	  

}
