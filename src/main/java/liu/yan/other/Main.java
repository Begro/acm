package liu.yan.other;

import com.google.gson.Gson;

/**
 * @author liu yan
 * @description
 * @date 2019/1/4
 */
public class Main {
	public static void main(String[] args) {
		User u = new Gson().fromJson("{}", User.class);
		System.out.println(String.format("x=[%s] s=[%s]", u.name, u.age));
	}
}
