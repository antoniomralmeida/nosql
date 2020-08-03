package cassandraApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class CASSANDRA {

	public static void main(String[] args) {
		Cluster cluster;
		Session session;
		Builder b = Cluster.builder().addContactPoint("127.0.0.1");
		b.withPort(9042);
		cluster = b.build();
		session = cluster.connect();

		Sensordata sd = new Sensordata("localhost", "time3", new Date(), 5020.0);

		StringBuilder sb = new StringBuilder("INSERT INTO ").append("bigdata.sensordata")
				.append("(host, metric , time, value) ").append("VALUES ('").append(sd.getHost()).append("', '")
				.append(sd.getMetric()).append("',").append(sd.getTime().getTime()).append(",").append(sd.getValue())
				.append(");");
		String query = sb.toString();
		System.out.println(query);
		session.execute(query);

		StringBuilder sb1 = new StringBuilder("SELECT * FROM ").append("bigdata.sensordata");
		String query1 = sb1.toString();
		ResultSet rs = session.execute(query1);
		List<Sensordata> sensordatas = new ArrayList<Sensordata>();
		rs.forEach(r -> {			
			sensordatas.add(new Sensordata(r.getString("host"), r.getString("metric"), r.getTimestamp("time"), r.getDouble("value")));
		});
		
		sensordatas.forEach(d -> {System.out.println(d);});
	}

}
