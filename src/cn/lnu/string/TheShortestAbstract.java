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
  String[] keywords = { "΢��", "�����", "����"};
  String[] text = { "΢��", "����", "�о�Ժ", "����", "��", "1998", "��", "��", "����",
    "��", "ʹ��", "��", "ʹ", "δ��", "��", "�����", "�ܹ�", "��", "��", "��",
    "��", "ѧ", "��", "��", "��", "��Ȼ����", "��", "����", "����", "����", "��",
    "��", "��", "����", "��", "��", "΢��", "����", "�о�Ժ", "��", "��", "�ٽ�",
    "�����", "��", "��̫", "����", "��", "�ռ�", "��", "����", "��̫", "�û�", "��",
    "����", "����", "��" };
 
  Abstract re = getShortestAbstract(text, keywords);
  System.out.println("���ժҪ�ǣ�" + re.abs + "\n����Ϊ��" + re.len);
 }

 private static Abstract getShortestAbstract(String[] text, String[] keywords) {
  int begin = 0;
  int end = 0;
  Abstract re = new Abstract();
  StringBuffer sb = new StringBuffer();

  while (begin <= end && end <= text.length - 1) {
   //begin++ �粻�����ˣ�end�����++
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
