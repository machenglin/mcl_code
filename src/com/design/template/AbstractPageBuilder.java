package com.design.template;

/**
 * 模板设计模式：好用的一个设计模式
 * 模板方法模式用于定义构建某个对象的步骤与顺序，或者定义一个算法的骨架
 * Created by Mcl on 2017/11/14.
 */
public abstract class AbstractPageBuilder implements PageBuilder {
    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public String buildHtml() {
        //首先加入doctype,因为都是html页面,所以我们父类不需要推迟给子类实现,直接在父类实现
        stringBuffer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        //页面下面就是成对的一个HTML标签，我们也在父类加入,不需要给子类实现
        stringBuffer.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        //下面就应该是head标签里的内容了,这个我们父类做不了主了,推迟到子类实现,所以我们定义一个抽象方法,让子类必须实现
        appendHead(stringBuffer);
        //下面是body的内容了，我们父类依然无法做主，仍然推迟到子类实现
        appendBody(stringBuffer);
        //html标签的关闭
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }

    //第一个模板方法
    protected abstract void appendHead(StringBuffer stringBuffer);

    //第二个模板方法
    protected abstract void appendBody(StringBuffer stringBuffer);
}
