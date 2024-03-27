package com.xaut.blog.blog.controller;

import com.xaut.blog.blog.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "hello Spring Boot";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response)
    //程序在启动时，就已经创建好了request、response对象，我们只需要在这里接收就好
    {
        //获取请求数据
        System.out.println(request.getMethod());//获取请求的方式
        System.out.println(request.getServletPath());//获取请求的路径
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));//相当于业务层面
        System.out.println(request.getParameter("name"));//相当于业务层面

        //向浏览器返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
        ) {
            writer.write("<h1>xx网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //处理Get请求
    //浏览器：/students?current=1&limit=20
    /*前面代码中写的比较简单，这里多了一个参数method，表明只有Get请求才能调用这个方法，
    而像前面没有写的话，那个方法无论是Get请求还是Post请求都能调用
    */
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    /*这里主要是为了演示如何处理Get请求，所以服务器响应还是按照之前最简单的方式
    返回一个字符串
    */
    @ResponseBody

    /*
    @RequestParam注解指明传递参数的默认值，required = false，表明可以不传参，默认值为1，limit
    类似(因为我们在第一次访问的时候可能就不传参）
     */
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1")int current,
            @RequestParam(name = "limit", required = false,defaultValue = "1") int limit){
        System.out.println(current);//为了验证是否取得了current的值
        System.out.println(limit);//为了验证是否取得了limit的值
        return "some students";
    }

    //获取Get请求方式二
    //需求：/student/123

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //服务器处理post请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){//只要形参和表单中的名字对应，就会自动获取
        System.out.println(name);
        System.out.println(age);
        return "success";
    }


    //服务器向浏览器响应HTML
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");//向Model里面添加值
        mav.addObject("age",50);
        mav.setViewName("/demo/view");//这里不用写templates文件夹，另外view.html可以直接写view,因为thymeleaf
        //默认都是以html为基础的模板引擎
        return mav;
    }











}
