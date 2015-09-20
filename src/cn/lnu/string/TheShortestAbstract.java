package cn.lnu.string;

import java.util.HashSet;

class Abstract {
 String abs;
 int len;
 Abstract() {}
 Abstract(String abs, int len) {
  this.abs = abs;
  this.len = len;
 }
}

public class TheShortestAbstract {

 public static void main(String[] args) {
  String[] keywords = { "微软", "计算机", "亚洲"};
  String[] text = { "微软", "亚洲", "研究院", "成立", "于", "1998", "年", "，", "我们",
    "的", "使命", "是", "使", "未来", "的", "计算机", "能够", "看", "、", "听",
    "、", "学", "，", "能", "用", "自然语言", "与", "人类", "进行", "交流", "。",
    "在", "此", "基础", "上", "，", "微软", "亚洲", "研究院", "还", "将", "促进",
    "计算机", "在", "亚太", "地区", "的", "普及", "，", "改善", "亚太", "用户", "的",
    "计算", "体验", "。" };
 
  Abstract re = getShortestAbstract(text, keywords);
  System.out.println("最短摘要是：" + re.abs + "\n长度为：" + re.len);
 }

 private static Abstract getShortestAbstract(String[] text, String[] keywords) {
  int begin = 0;
  int end = 0;
  Abstract re = new Abstract();
  StringBuffer sb = new StringBuffer();

  while (begin <= end && end <= text.length - 1) {
   //begin++ 如不包含了，end会继续++
   while (end <= text.length - 1 && !isContain(text, keywords, begin, end))
    end++;
   if (end <= text.length - 1 && isContain(text, keywords, begin, end)) {
    for (int i = begin; i <= end; i++)
     sb.append(text[i] + "+");
    Abstract temp = new Abstract(sb.toString(), end - begin + 1);
    if (re.abs == null || temp.len < re.len)
     re = temp;
    sb.delete(0, sb.length());
   }
   begin++;
  }
  return re;
 }

 private static boolean isContain(String[] text, String[] keywords,
   int begin, int end) {
  HashSet<String> hs = new HashSet<String>();
  for (int i = begin; i <= end; i++) {
   hs.add(text[i]);
  }
  for (int i = 0; i < keywords.length; i++) {
   if (!hs.contains(keywords[i]))
    return false;
  }
  return true;
 }

}
