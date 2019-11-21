package liu.yan.asm;

import java.util.List;

/**
 * @author liuyan
 * @date 15:54 2019/8/7
 * @description
 */
public class TTT {

	/**
	 * body : [{"keyName":"test","clientIP":"192.179.121.121:2323","version":"java-0.0.1","language":"java"},{"keyName":"test","clientIP":"192.179.122.121:2323","version":"java-0.0.1","language":"java"}]
	 * message : 成功
	 * status : 0000
	 */



	private String message;
	private String status;
	private List<BodyBean> body;


	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BodyBean> getBody() {
		return body;
	}

	public void setBody(List<BodyBean> body) {
		this.body = body;
	}

	public static class BodyBean {
		/**
		 * keyName : test
		 * clientIP : 192.179.121.121:2323
		 * version : java-0.0.1
		 * language : java
		 */

		private String keyName;
		private String clientIP;
		private String version;
		private String language;

		public String getKeyName() {
			return keyName;
		}

		public void setKeyName(String keyName) {
			this.keyName = keyName;
		}

		public String getClientIP() {
			return clientIP;
		}

		public void setClientIP(String clientIP) {
			this.clientIP = clientIP;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}
	}
}
