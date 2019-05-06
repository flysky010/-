
/**
 * @author jianlei_shen
 * 查找两个字符串的最长公共子序列
 * 2019-05-05
 */
public class FindMaxSubStringUtil {
	
	public static String findMaxSubstring(String str1, String str2) {
		if(str1.length() == 0 || str2.length() == 0) {
			return "";
		}
		String result = str1.length() <= str2.length() ? str1 : str2;
		if(result.equals(str1)) {//str1较短
			result = findMaxSub(result, str2);
		}else {
			result = findMaxSub(result, str1);
		}
		return result;
	}
	
	private static String findMaxSub(String result, String destStr) {
		int beginIndex = 0;
		for(int step = 0; step < result.length(); step++) {
			int j = 0;
			for(int i = step; i >= 0; i--) {
				String subTemp = result.substring(beginIndex + step - i, result.length() - step + j);
				if(isExistSubstring(subTemp, destStr)) {
					return subTemp;
				}
				j++;
			}
		}
		return "";
	}
	
	//给定子字符串，判断其在另一个字符串中是否存在
	private static boolean isExistSubstring(String subStr, String destStr) {
		if(!destStr.contains(subStr)) {
			return false;
		}
		int begIndex = -1;
		int endIndex = destStr.length();
		for(int i = 0; i < destStr.length(); i++) {
			String subTemp = destStr.substring(i, destStr.length());
			if(!subTemp.contains(subStr)) {
				begIndex = i - 1;
				break;
			}
		}
		for(int j = destStr.length(); j > 0; j--) {
			String subTemp = destStr.substring(0, j);
			if(!subTemp.contains(subStr)) {
				endIndex = j;
				break;
			}
		}
		String sub = destStr.substring(begIndex, endIndex + 1);
		System.out.println("sub:"+sub+"  substr:"+subStr);
		if(sub.equals(subStr)) {
			return true; 
		}else {
			return false;
		}
	}
}
