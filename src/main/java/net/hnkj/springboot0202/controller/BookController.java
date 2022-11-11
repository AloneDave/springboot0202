package net.hnkj.springboot0202.controller;

import net.hnkj.springboot0202.model.Book;
import net.hnkj.springboot0202.service.IBookService;
import net.hnkj.springboot0202.utils.JsonData;
import net.hnkj.springboot0202.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    /**
     * 层级调用
     * Mapper层直接访问数据库
     * Service调用Mapper层
     * Controller层调用Service层
     */

    @Autowired
    private IBookService bookService;

    @RequestMapping("/load")
    public JsonData load(Book book){
        JsonData jsonData = new JsonData();

        //查询书本
        Book b = bookService.selectByPrimaryKey(book.getBookId());
        jsonData.setCode(0);
        jsonData.setMessage("查询成功");
        jsonData.setRow(b);

       return jsonData;
    }

    /**
     * 查询全部书本
     * @param book
     * @return
     */
    @RequestMapping("/list")
    public JsonData list(Book book, PageBean pageBean){
        //实例化JsonData
        JsonData jsonData = new JsonData();

        //查询所有书本
        List<Book> books = bookService.listBook(book, pageBean);

        jsonData.setCode(0);
        jsonData.setMessage("查询成功");
        jsonData.setRows(books);
        jsonData.setTotal(pageBean.getTotal());

        return jsonData;
    }

    /**
     * 书本的新增和修改接口
     * @param book
     * @return
     */
    @RequestMapping("/updataAndInsert")
    public JsonData updataAndInsert(Book book){
        JsonData jsonData = new JsonData();

        if(null==book.getBookId()){//如果前端没有传入书本id 就是书本新增
            int i = bookService.insertSelective(book);
            if(i==1){ //如果i==1,新增成功
                jsonData.setCode(1);
                jsonData.setMessage("书本新增成功");
            }else{
                jsonData.setCode(0);
                jsonData.setMessage("书本新增失败");
            }
        }else{//前端传过来的参数中包含bookId 就是书本修改
            int i = bookService.updateByPrimaryKeySelective(book);
            if(i==1){
                jsonData.setCode(1);
                jsonData.setMessage("书本修改成功");
            }else {
                jsonData.setCode(0);
                jsonData.setMessage("书本修改失败");
            }
        }

        return jsonData;
    }

    /**
     * 书本删除接口
     * @param book
     * @return
     */
    @RequestMapping("/del")
    public JsonData del(Book book){
        JsonData jsonData = new JsonData();

        int i = bookService.deleteByPrimaryKey(book.getBookId());
        if(i==1){
            jsonData.setCode(1);
            jsonData.setMessage("书本删除成功");
        }else{
            jsonData.setCode(0);
            jsonData.setMessage("书本修改失败");
        }

        return jsonData;
    }
}
