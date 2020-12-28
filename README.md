# 基于Apache poi封装，在上层做了模型转换的封装，让使用者更加简单方便

#### 介绍
基于Apache poi封装，在上层做了模型转换的封装，让使用者更加简单方便

#### 软件架构
依赖：
1. poi:4.1.2
2. poi-ooxml:4.1.2

#### 安装教程
```
<dependency>
    <groupId>com.sushengren</groupId>
    <artifactId>easyword</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### 使用说明

##### 简单使用
![word模板文件](https://images.gitee.com/uploads/images/2020/1228/110223_353ac411_2130627.png "屏幕截图.png")

```
public class TestEntity {

    @WordProperty(value = "文物名称")
    private String value1;

    @WordProperty("文物级别")
    private String value2;

    @WordProperty("总登记号")
    private String value3;

    @WordProperty("分类号")
    private String value4;

    @WordProperty("档案编号")
    private String value5;

    @WordProperty("年")
    private String value6;

    @WordProperty("月")
    private String value7;

    @WordProperty("日")
    private String value8;

    @WordProperty("制档人")
    private String value9;

    @WordProperty(value = "图片", handle = PictureFillTypeHandle.class)
    private InputStream img;
    
    // 省略getting，setting
}
```
```
        TestEntity testEntity = new TestEntity();
        testEntity.setValue1("北宋“富”字大狮子绣球藤花纹绫");
        testEntity.setValue2("一级");
        testEntity.setValue3("T0001");
        testEntity.setValue4("F0001");
        testEntity.setValue5("DA00001");
        testEntity.setValue6("2020");
        testEntity.setValue7("12");
        testEntity.setValue8("24");
        testEntity.setValue9("杰克");
        testEntity.setImg(new FileInputStream(new File("C:\\Users\\AD\\Pictures\\01.jpg")));


        File file = new File("C:\\Users\\AD\\Desktop\\CollectionFile.docx");
        FileOutputStream out = new FileOutputStream("C:\\Users\\AD\\Desktop\\CollectionFile1.docx");
        EasyWord.of(file).doWrite(testEntity).toOutputStream(out);
```

![文档输出](https://images.gitee.com/uploads/images/2020/1228/110502_27e979df_2130627.png "屏幕截图.png")