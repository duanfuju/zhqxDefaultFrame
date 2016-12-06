package cn.com.oking.util;

public class StyleWarning extends Exception
{
  public StyleWarning(String styleName)
  {
    super("找不到指定的样式：[" + styleName + "]。必须先在模板中定义该样式，然后再使用。");
  }
}