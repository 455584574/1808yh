package com.yh.fxmall.controller;

import com.yh.fxmall.entity.WxbGood;
import com.yh.fxmall.service.IGoodsService;
import com.yh.fxmall.service.impl.GoodsServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {


    final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

    private IGoodsService goodsService = classPathXmlApplicationContext.getBean(GoodsServiceImpl.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        pageStr = pageStr==null? "1":pageStr;
        List<WxbGood> goodList = goodsService.selectGoodsByPage(Integer.parseInt(pageStr));
        req.setAttribute("goodList",goodList);
        req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (ServletFileUpload.isMultipartContent(req)){
//            ServletFileUpload upload = new ServletFileUpload();
//            upload.setFileSizeMax(5*1024*1024);
//            WxbGood wxbGood = new WxbGood();
//            try {
//                FileItemIterator itr = upload.getItemIterator(req);
//                while (itr.hasNext()){
//                    FileItemStream item = itr.next();
//                    if (item.isFormField()){
//                        String value = Streams.asString(item.openStream(), "UTF-8");
//                        switch (item.getFieldName()){
//                            case "good_name":
//                                wxbGood.setGoodName(value);
//                                break;
//                            case "type_id":
//                                wxbGood.setTypeId(value);
//                                break;
//                            case "order_no":
//                                wxbGood.setOrderNo(Integer.parseInt(value));
//                                break;
//                            case "sell_num":
//                                wxbGood.setSellNum(Integer.parseInt(value));
//                                break;
//                            case "promote_desc":
//                                wxbGood.setPromoteDesc(value);
//                                break;
//                            case "copy_desc":
//                                wxbGood.setCopyDesc(value);
//                                break;
//                            case "forward_link":
//                                wxbGood.setForwardLink(value);
//                                break;
//                        }
//                    }
//                    IGoodsService service = new GoodsServiceImpl();
//                    service.insertGoods(wxbGood);
//                }
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            }

  //      }

    }
}
