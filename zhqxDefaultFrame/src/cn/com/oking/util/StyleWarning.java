package cn.com.oking.util;

public class StyleWarning extends Exception
{
  public StyleWarning(String styleName)
  {
    super("�Ҳ���ָ������ʽ��[" + styleName + "]����������ģ���ж������ʽ��Ȼ����ʹ�á�");
  }
}