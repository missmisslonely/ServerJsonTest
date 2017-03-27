package servlet;

import bean.User;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONStringer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUserServlet extends HttpServlet {

	/**
	 * 覆盖Get方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		System.out.println("Get方法");

		//测试数据
		List<User> list = new ArrayList<User>();
		list.add(new User("U001","张三",123456));
		list.add(new User("U002","李四",654321));

		//生成JSON数据
		JSONStringer stringer = new JSONStringer();
		JSONObject object = new JSONObject();
		try {
			stringer.array();
			for(User u : list) {
				stringer.object().
						key("Id").value(u.id).
						key("name").value(u.name).
						key("passwords").value(u.passwords).
						endObject();
			}
			stringer.endArray();
			object.element("user", stringer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getOutputStream().write(object.toString().getBytes("UTF-8"));
		response.setContentType("text/json; charset=UTF-8");
	}

	/**
	 * 跳转到Get方法
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
