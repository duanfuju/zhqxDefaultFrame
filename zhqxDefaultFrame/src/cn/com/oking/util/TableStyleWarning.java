package cn.com.oking.util;

public class TableStyleWarning extends Exception
{
  public TableStyleWarning(String styleName)
  {
    super("�Ҳ���ָ���ı����ʽ��[" + styleName + "]����������ģ���ж������ʽ��Ȼ����ʹ�á�");
  }
}