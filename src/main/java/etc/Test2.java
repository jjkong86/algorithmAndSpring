package etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		List<Map<String, Object>> datas = new ArrayList<>();
		Map<String, Object> berith = new HashMap<>();
		Map<String, Object> eth = new HashMap<>();
//		berith.put("Berith", "Berith");
//		datas.add(berith);
		eth.put("Ethereum", "Ethereum");
		datas.add(eth);
		
        List<Map<String, Object>> findList = new ArrayList<>();
        findList = datas.stream().filter(map -> map.containsValue("Berith") || map.containsValue("Ethereum")).collect(Collectors.toList());

        System.out.println("berith : " + findList.stream().filter(map -> map.containsValue("Berith")).count());
        System.out.println("eth : " + findList.stream().filter(map -> map.containsValue("Ethereum")).count());
        
        if(findList.stream().filter(map -> map.containsValue("Berith")).count() == 0 && findList.stream().filter(map -> map.containsValue("Ethereum")).count() != 0) {
            System.out.println("들어옴");
            Map<String,Object> ethMap = (findList.stream().filter(map -> map.containsValue("Ethereum")).collect(Collectors.toList())).get(0);
            System.out.println(ethMap.values());
        } else {
        	System.out.println("안들어옴");
        }
		
	}

}
