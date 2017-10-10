package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WJ on 2017/10/11
 * Description：实现controller接口的处理器
 */
public class ItemsController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        //调用service查找数据库，查询商品列表，这个里面使用静态数据模拟
        List<Items> itemsList = new ArrayList<Items>();
        //向list中填充静态数据
        Items item1 = new Items();
        item1.setName("联想笔记本");
        item1.setPrice(6000f);
        item1.setDetail("ThinkPad T430联想笔记本电脑");
        Items item2 = new Items();
        item2.setName("苹果手机");
        item2.setPrice(5000f);
        item2.setDetail("iphone6苹果手机");
        itemsList.add(item1);
        itemsList.add(item2);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute,在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);

        //指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        return modelAndView;
    }
}
