package liu.yan.concurrent;

import java.util.Objects;

/**
 * @author liu yan
 * @description
 * @date 2018/7/12
 */
public class Node {
	private String ip;
	private int port;
	private boolean isAvailable;
	private int order;

	@Override
	public int hashCode() {

		return Objects.hash(ip, port);
	}

	public Node(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}
		Node target = (Node) obj;
		if (!target.ip.equals(ip)) {
			return false;
		}
		if (target.port != port) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return ip + ":" + port + "-" + order;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
