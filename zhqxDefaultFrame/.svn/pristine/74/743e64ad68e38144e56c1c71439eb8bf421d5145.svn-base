package cn.com.oking.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Document
{
  private Dispatch doc = null;
  private Dispatch documents;
  private String newFileName = "";
  private ActiveXComponent word;

  public Document()
    throws Exception
  {
    try
    {
      this.word = new ActiveXComponent("Word.Application");
      this.documents = this.word.getProperty("Documents").toDispatch();
    }
    catch (UnsatisfiedLinkError e) {
      throw new Exception("初始化类库出错，请检查是否使用安装程序在本机器进行了安装。\n如果简单地从其它机器拷贝安装目录到本机器可能导致该错误。");
    }
    catch (Exception e)
    {
      throw new Exception("初始化类库出错，请检查是否注册了组件 Word.Application。 注册命令为 'regsvr32 文件名'。\n" + e.getMessage());
    }
  }

  static final int wdFormatPDF = 17;// PDF 格式  
  
  public void wordToPDF(String sfileName,String toFileName){    
      
      System.out.println("启动Word...");      
      long start = System.currentTimeMillis();      
      try {      
          open(sfileName);
          System.out.println("打开文档..." + sfileName);  
          System.out.println("转换文档到PDF..." + toFileName);      
          File tofile = new File(toFileName);      
          if (tofile.exists()) {      
              tofile.delete();      
          }      
          Dispatch.call(doc,      
                        "SaveAs",      
                        toFileName, // FileName      
                        wdFormatPDF);      
          long end = System.currentTimeMillis();      
          System.out.println("转换完成..用时：" + (end - start) + "ms.");  
            
              
      } catch (Exception e) {      
          System.out.println("========Error:文档转换失败：" + e.getMessage());      
      } 
  }  
  private void close(Dispatch doc, boolean saveOnExit)
  {
    if (doc != null) {
      Dispatch.call(doc, "Close", new Variant(saveOnExit));
      this.word.invoke("Quit", new Variant[0]);
    }
  }

  public void close(boolean saveOnExit)
    throws Exception
  {
    try
    {
      if (this.newFileName.length() > 0) {
        if (saveOnExit) {
          saveAs(this.newFileName);
          close(this.doc, false);
        }
      }
      else
        close(this.doc, saveOnExit);
    }
    catch (Exception e)
    {
      close(this.doc, false);
      throw e;
    }
  }

  private boolean find(Dispatch selection, String toFindText)
  {
    Dispatch find = ActiveXComponent.call(selection, "Find").toDispatch();

    Dispatch.put(find, "Text", toFindText);

    Dispatch.put(find, "Forward", "True");

    Dispatch.put(find, "Format", "True");

    Dispatch.put(find, "MatchCase", "True");

    Dispatch.put(find, "MatchWholeWord", "False");

    return Dispatch.call(find, "Execute").getBoolean();
  }

  public boolean find(String toFindText)
  {
    return find(getSelection(), toFindText);
  }

  private Dispatch getBookmark(String bookmarkName)
    throws Exception
  {
    try
    {
      Dispatch bookmark = Dispatch.call(this.doc, "Bookmarks", bookmarkName).toDispatch();

      return Dispatch.get(bookmark, "Range").toDispatch();
    }
    catch (ComFailException e) {
      throw new Exception("找不到所指定的书签：" + bookmarkName);
    }
    catch (Exception e) {
      throw e;
    }
  }

  private Dispatch getSelection()
  {
    return this.word.getProperty("Selection").toDispatch();
  }

  public void insert(List dataList, String styleName)
    throws TableStyleWarning
  {
    Dispatch range = Dispatch.get(getSelection(), "Range").toDispatch();
    insertTable(range, dataList, styleName);
    moveDown(1);
  }

  public void insert(List dataList)
    throws Exception
  {
    insert(dataList, null);
  }

  public void insert(File imageFile)
    throws Exception
  {
    if (imageFile.exists()) {
      replaceImage(getSelection(), imageFile.getAbsolutePath());
    }
    else
      throw new Exception("请输入完整的文件名(包括路径)");
  }

  public void insert(String newText, String styleName)
    throws StyleWarning
  {
    moveRight(getSelection(), 1);
    replace(getSelection(), newText);

    setStyle(styleName);
  }

  public void insert(String newText)
    throws Exception
  {
    insert(newText, null);
  }

  public void insertAtBookmark(String bookmarkName, List dataList, String styleName)
    throws Exception, TableStyleWarning
  {
    Dispatch bookmarkRange = getBookmark(bookmarkName);

    insertTable(bookmarkRange, dataList, styleName);

    insertBookmark(bookmarkRange, bookmarkName);
  }

  public void insertAtBookmark(String bookmarkName, List dataList)
    throws Exception
  {
    insertAtBookmark(bookmarkName, dataList, null);
  }

  public void insertAtBookmark(String bookmarkName, File imageFile)
    throws Exception
  {
    if (imageFile.exists())
    {
      Dispatch bookmarkRange = getBookmark(bookmarkName);

      replaceImage(bookmarkRange, imageFile.getAbsolutePath());

      insertBookmark(bookmarkRange, bookmarkName);
    }
    else {
      throw new Exception("请输入完整的文件名(包括路径)");
    }
  }

  public void insertAtBookmark(String bookmarkName, String newText, String styleName)
    throws Exception, StyleWarning
  {
    Dispatch bookmarkRange = getBookmark(bookmarkName);

    replace(bookmarkRange, newText);

    insertBookmark(bookmarkRange, bookmarkName);

    if (styleName != null)
      try {
        Dispatch.put(bookmarkRange, "style", styleName);
      }
      catch (ComFailException e) {
        throw new StyleWarning(styleName);
      }
  }

  public void insertAtBookmark(String bookmarkName, String newText)
    throws Exception
  {
    insertAtBookmark(bookmarkName, newText, null);
  }

  private void insertBookmark(Dispatch selection, String bookmarkName)
  {
    Dispatch Bookmarks = Dispatch.get(this.doc, "Bookmarks").toDispatch();
    Dispatch.call(Bookmarks, "Add", bookmarkName, selection);
  }

  private void insertTable(Dispatch range, List dataList, String styleName)
    throws TableStyleWarning
  {
    if (dataList.size() < 1) {
      System.out.println("Empty table!");
      return;
    }

    int rowLength = dataList.size();

    String[] titleData = (String[])dataList.get(0);

    int colLength = titleData.length;

    Dispatch tables = Dispatch.get(this.doc, "Tables").toDispatch();

    Dispatch table = Dispatch.call(tables, "Add", range, new Variant(rowLength), new Variant(colLength)).toDispatch();

    for (int i = 0; i < dataList.size(); i++)
    {
      String[] datas = (String[])dataList.get(i);

      for (int j = 0; j < datas.length; j++)
      {
        Dispatch cell = Dispatch.call(table, "Cell", Integer.toString(i + 1), Integer.toString(j + 1)).toDispatch();

        Dispatch.call(cell, "Select");

        if ((styleName == null) && (i == 0))
        {
          Dispatch shading = Dispatch.get(cell, "Shading").toDispatch();
          Dispatch.put(shading, "BackgroundPatternColorIndex", "15");

          Dispatch font = Dispatch.get(getSelection(), "Font").toDispatch();
          Dispatch.put(font, "Color", "0,0,0,0");
          Dispatch.put(font, "Bold", "1");
        }

        Dispatch.put(getSelection(), "Text", datas[j]);
      }
    }

    if (styleName != null)
      try {
        Dispatch.put(table, "style", styleName);
      }
      catch (ComFailException e) {
        throw new TableStyleWarning(styleName);
      }
  }

  public void insertln()
  {
    Dispatch range = Dispatch.get(getSelection(), "Range").toDispatch();
    Dispatch.call(range, "InsertParagraphAfter");
    moveDown(1);
  }

  public void insertln(String newText)
    throws Exception
  {
    insert(newText);
    insertln();
  }

  public void mergeCell(int tbIndex, int fromRow, int fromCol, int toRow, int toCol, String text)
    throws Exception
  {
    Dispatch tables = Dispatch.get(this.doc, "Tables").toDispatch();
    Dispatch table;
    try
    {
      table = Dispatch.call(tables, "Item", new Variant(tbIndex)).toDispatch();
    }
    catch (Exception e)
    {
      throw new Exception("找不到指定的表格:" + tbIndex);
    }

    Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
    int rowsCount = Dispatch.get(rows, "Count").getInt();

    if ((fromRow < 1) || (fromRow > rowsCount)) {
      fromRow = 1;
    }

    if ((toRow < 1) || (toRow > rowsCount)) {
      toRow = rowsCount;
    }

    Dispatch Columns = Dispatch.get(table, "Columns").toDispatch();
    int Columnscount = Dispatch.get(Columns, "Count").toInt();

    if ((fromCol < 1) || (fromCol > Columnscount)) {
      fromCol = 1;
    }

    if ((toCol < 1) || (toCol > Columnscount)) {
      toCol = Columnscount;
    }

    Dispatch fromCell = Dispatch.call(table, "Cell", Integer.toString(fromRow), Integer.toString(fromCol)).toDispatch();

    Dispatch toCell = Dispatch.call(table, "Cell", Integer.toString(toRow), Integer.toString(toCol)).toDispatch();

    Dispatch.call(fromCell, "Merge", toCell);
    if (text != null)
    {
      if (toRow < fromRow) {
        fromRow = toRow;
      }
      if (toCol < fromCol) {
        fromCol = toCol;
      }
      Dispatch cell = Dispatch.call(table, "Cell", Integer.toString(fromRow), Integer.toString(fromCol)).toDispatch();

      Dispatch.call(cell, "Select");

      Dispatch.put(getSelection(), "Text", text);
    }
  }

  public void mergeCell(int tbIndex, int fromRow, int fromCol, int toRow, int toCol)
    throws Exception
  {
    mergeCell(tbIndex, fromRow, fromCol, toRow, toCol, null);
  }

  private void moveDown(Dispatch selection, int count)
  {
    for (int i = 0; i < count; i++)
      Dispatch.call(selection, "MoveDown");
  }

  private void moveDown(int count)
  {
    moveDown(getSelection(), count);
  }

  private void moveLeft(Dispatch selection, int count)
  {
    for (int i = 0; i < count; i++)
      Dispatch.call(selection, "MoveLeft");
  }

  private void moveLeft(int count)
  {
    moveLeft(getSelection(), count);
  }

  private void moveRight(Dispatch selection, int count)
  {
    for (int i = 0; i < count; i++)
      Dispatch.call(selection, "MoveRight");
  }

  private void moveStart(Dispatch selection)
  {
    Dispatch.call(selection, "HomeKey", new Variant(6));
  }

  private void moveUp(Dispatch selection, int count)
  {
    for (int i = 0; i < count; i++)
      Dispatch.call(selection, "MoveUp");
  }

  private void moveUp(int count)
  {
    moveUp(getSelection(), count);
  }

  public void newDoc(String template, String fileName)
    throws Exception
  {
    File file = new File(template);
    if (file.exists()) {
      this.doc = Dispatch.call(this.documents, "Add", template).toDispatch();
      this.newFileName = fileName;
    }
    else {
      throw new Exception("创建新文档出错。指定的模板“" + template + "”不存在。");
    }
  }

  public void newDoc(String fileName)
    throws Exception
  {
    this.doc = Dispatch.call(this.documents, "Add").toDispatch();
    this.newFileName = fileName;
  }

  public void open(String fileName)
    throws Exception
  {
    File file = new File(fileName);
    if (file.exists()) {
      this.doc = Dispatch.call(this.documents, "Open", fileName).toDispatch();
    }
    else
      throw new Exception("提供的文件不存在：" + fileName);
  }

  public List readTable(int tbIndex, int fromRow)
    throws Exception
  {
    ArrayList tableData = new ArrayList();
    if (fromRow < 1) {
      fromRow = 1;
    }
    if (tbIndex < 1) {
      tbIndex = 1;
    }

    Dispatch tables = Dispatch.get(this.doc, "Tables").toDispatch();
    int tablesCount = Dispatch.get(tables, "Count").getInt();
    if (tablesCount < tbIndex) {
      throw new Exception("指定的表格不存在。打开的文档中没有表格。");
    }
    if (tablesCount < tbIndex) {
      throw new Exception("指定的表格不存在。打开的文档中只有" + tablesCount + "张表。");
    }

    Dispatch table = Dispatch.call(tables, "Item", new Variant(tbIndex)).toDispatch();

    Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
    int rowsCount = Dispatch.get(rows, "Count").getInt();

    Dispatch Columns = Dispatch.get(table, "Columns").toDispatch();
    int Columnscount = Dispatch.get(Columns, "Count").toInt();
    for (int i = fromRow; i < rowsCount + 1; i++) {
      ArrayList rowData = new ArrayList();
      for (int j = 1; j < Columnscount + 1; j++) {
        Dispatch cell = Dispatch.call(table, "Cell", i + "", j + "").toDispatch();

        Dispatch Range = Dispatch.get(cell, "Range").toDispatch();
        String text = Dispatch.get(Range, "Text").toString();
        rowData.add(text.substring(0, text.length() - 1));
      }
      tableData.add(rowData);
    }
    return tableData;
  }

  private void replace(Dispatch selection, String newText)
  {
    Dispatch.put(selection, "Text", newText);
  }

  public boolean replace(String toFindText, String newText)
  {
    boolean leaf = false;
    if (find(toFindText))
    {
      replace(getSelection(), newText);
      leaf = true;
    }
    return leaf;
  }

  private void replaceAll(Dispatch selection, String oldText, String newText)
  {
    moveStart(selection);
    while (find(selection, oldText)) {
      replace(selection, newText);
      Dispatch.call(selection, "MoveRight");
    }
  }

  public void replaceAll(String oldText, String newText)
  {
    replaceAll(getSelection(), oldText, newText);
  }

  private void replaceImage(Dispatch selection, String imagePath)
  {
    Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath);
  }

  private void replaceTable(Dispatch selection, int tbIndex, int fromRow, int fromCol, List dataList, String styleName)
    throws Exception, StyleWarning
  {
    if (dataList.size() < 1) {
      System.out.println("Empty table!");
      return;
    }

    Dispatch tables = Dispatch.get(this.doc, "Tables").toDispatch();
    Dispatch table;
    try {
      table = Dispatch.call(tables, "Item", new Variant(tbIndex)).toDispatch();
    }
    catch (Exception e)
    {
      throw new Exception("找不到指定的表格:" + tbIndex);
    }

    Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
    int rowsCount = Dispatch.get(rows, "Count").getInt();

    if (fromRow == -1) {
      fromRow = rowsCount;
    }

    Dispatch Columns = Dispatch.get(table, "Columns").toDispatch();
    int Columnscount = Dispatch.get(Columns, "Count").toInt();

    if ((fromCol < 1) || (fromCol > Columnscount)) {
      fromCol = 1;
    }
    boolean hasStyleError = false;

    for (int i = 0; i < dataList.size(); i++)
    {
      String[] datas = (String[])dataList.get(i);

      if (Dispatch.get(rows, "Count").getInt() < fromRow + i + 1) {
        Dispatch.call(rows, "Add");
      }

      for (int j = 0; j < datas.length; j++)
      {
        if (fromCol + j - 1 < Columnscount) {
          try {
            Dispatch cell = Dispatch.call(table, "Cell", Integer.toString(fromRow + i), Integer.toString(fromCol + j)).toDispatch();

            Dispatch.call(cell, "Select");

            if (styleName == null) {
              Dispatch font = Dispatch.get(selection, "Font").toDispatch();
              Dispatch.put(font, "Bold", "0");
              Dispatch.put(font, "Italic", "0");
            }
            else {
              Dispatch range = Dispatch.get(selection, "Range").toDispatch();
              try
              {
                Dispatch.put(range, "style", styleName);
              }
              catch (ComFailException e) {
                hasStyleError = true;
              }
            }

            Dispatch.put(selection, "Text", datas[j]);
          }
          catch (ComFailException e) {
            System.out.println("找不到指定的单元(" + (fromRow + i) + "," + (fromCol + j) + ")");
          }
        }
      }
    }

    if (hasStyleError)
      throw new StyleWarning(styleName);
  }

  public void replaceTable(int tbIndex, int fromRow, int fromCol, List dataList, String styleName)
    throws Exception, StyleWarning
  {
    replaceTable(getSelection(), tbIndex, fromRow, fromCol, dataList, styleName);
  }

  public void replaceTable(int tbIndex, int fromRow, List dataList, String styleName)
    throws Exception, StyleWarning
  {
    replaceTable(tbIndex, fromRow, 1, dataList, styleName);
  }

  public void replaceTable(int tbIndex, int fromRow, int fromCol, List dataList)
    throws Exception
  {
    replaceTable(tbIndex, fromRow, fromCol, dataList, null);
  }

  public void replaceTable(int tbIndex, int fromRow, List dataList)
    throws Exception
  {
    replaceTable(tbIndex, fromRow, 1, dataList);
  }

  public void saveAs(String outputFile)
    throws Exception
  {
    try
    {
      Dispatch.call(this.doc, "SaveAs", outputFile);
    }
    catch (ComFailException e) {
      throw new Exception("该文件[" + outputFile + "]已经存在，且已经被其它应用程序打开，无法保存。");
    }
  }

  public void setStyle(String styleName)
    throws StyleWarning
  {
    if (styleName != null) {
      Dispatch range = Dispatch.get(getSelection(), "Range").toDispatch();
      try {
        Dispatch.put(range, "style", styleName);
      }
      catch (ComFailException e) {
        throw new StyleWarning(styleName);
      }
    }
  }
 
}