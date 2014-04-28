package foundation.messageFormat;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: gaozhan
 * Date: 1/16/14
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageFormatTest {

    public static  String batchInsertUserBillDetail(Map map) {
        List list = (List) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ignore INTO user_bill_detail VALUES");
        MessageFormat messageFormat = new MessageFormat("(#'{'list[{0}].date},#'{'list[{0}].uid},#'{'list[{0}].module},#'{'list[{0}].item},#'{'list[{0}].cost})");
        for(int i = 0 ;i<list.size();i++) {
            sb.append(messageFormat.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("1");
        list.add("1");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("list", list);
        System.out.println(batchInsertUserBillDetail(map));

    }


}
