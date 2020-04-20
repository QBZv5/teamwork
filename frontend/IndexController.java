package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class IndexController {
    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 欢迎页面,通过url访问，判断后端服务是否启动
     */
    List<String> data = new ArrayList<>();



    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<String> query() {
        return data;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add_item(@RequestParam(value = "item",required = true) String a){
        data.add(a);
        return "修改成功";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public void del_item(@RequestParam(value = "id", required = true) int id){
        data.remove(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update_item(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "cont", required = true) String cont){
        data.set(id, cont);
    }

}


