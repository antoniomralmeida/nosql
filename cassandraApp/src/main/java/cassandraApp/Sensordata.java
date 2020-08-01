package cassandraApp;

import java.util.Date;

public class Sensordata {
	String host;
	String metric;
	Date time;
	Double value;

	public Sensordata() {
	}

	public Sensordata(String host, String metric, Date time, Double value) {
		super();
		this.host = host;
		this.metric = metric;
		this.time = time;
		this.value = value;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Sensordata [host=" + host + ", metric=" + metric + ", time=" + time + ", value=" + value + "]";
	}

}
