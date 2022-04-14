import org.json.JSONArray;
import org.json.JSONObject;

public class JSONDemo {
   public static void main(String[] args) { 
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("Name", "Robert");
      jsonObject.put("ID", 1);
      jsonObject.put("Fees", 1000.21);
      jsonObject.put("Active", true); 
      jsonObject.put("Other Details", JSONObject.NULL);

      JSONArray list = new JSONArray();
      list.put("foo");
      list.put(100);
      jsonObject.put("list",list);
      System.out.println(jsonObject);
   }
}