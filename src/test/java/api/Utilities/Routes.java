package api.Utilities;

public class Routes {
	
	public static String baseURl = "https://petstore.swagger.io/v2";
	
	public static String post_baseURl = baseURl + "/pet";
	public static String get_baseURl = baseURl + "/pet/{getPetId}";
	public static String get_baseURlWithStatus = baseURl + "/pet/{myParam}";
	public static String put_baseURl = baseURl + "/pet";
	public static String delete_baseURl = baseURl + "/pet/{getPetId}";

}
