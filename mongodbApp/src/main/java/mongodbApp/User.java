package mongodbApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class User {
	private int _id;
	private String login;
	private String name;
	private String pwd;

	public User(String json) throws JsonMappingException, JsonProcessingException {
		super();
		ObjectMapper obj = new ObjectMapper();
		User u = obj.readValue(json, User.class);
		_id = u.get_id();
		login = u.getLogin();
		name = u.getName();
		pwd = u.getPwd();

	}

	public User(int _id, String login, String name, String pwd) {
		super();
		this._id = _id;
		this.login = login;
		this.name = name;
		this.pwd = pwd;
	}

	public User() {
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		ObjectMapper obj = new ObjectMapper();
		try {
			return obj.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public DBObject toJson() {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", this.get_id());
		docBuilder.append("name", this.getName());
		docBuilder.append("login", this.getLogin());
		docBuilder.append("pwd", this.getPwd());
		return docBuilder.get();
	}

}
