package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author zyy
 * @create 2022-05-27 15:41
 */
@Controller
@RequestMapping("/alpha")  //给类取一个访问的名
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    //模拟查询请求
    @RequestMapping("/data")
    @ResponseBody
    public String getData()
    {
        return alphaService.find();
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello()
    {
        return "hello, Spring Boot.";
    }

    @RequestMapping("/http")//方法的访问路径
    public void http(HttpServletRequest request, HttpServletResponse response) //没有返回类型——通过response对象可以直接向浏览器输出任何对象，就不依赖return了
    {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());//请求路径
        //请求行 是key-value结构
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements())
        {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+": "+value);

        }
        System.out.println(request.getParameter("code"));
        //response 返回响应数据
        response.setContentType("text/html;charset=utf-8");//utf-8支持中文
        try(PrintWriter writer = response.getWriter();
        ) {
            writer.write("<hl>牛客网</hl>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //GET请求
    // /student?current=1&limit=20
    @RequestMapping(path="/students", method= RequestMethod.GET) //指定访问路径，强制请求方式只能是GET
    @ResponseBody //响应
    //通过RequestParam对参数的注入做更详细的声明
    public String getStudents(
            @RequestParam(name="current", required=false,defaultValue = "1") int current,
            @RequestParam(name="limit", required=false,defaultValue = "10") int limit)//只要参数名和传过来的参数名一致就可以赋值
    {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path="/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id)
    {
        System.out.println(id);
        return "a student";
    }

    //POST请求  浏览器向服务器提交数据
    @RequestMapping(path="/student", method = RequestMethod.POST)
    @ResponseBody//响应还是简单处理
    public String saveStudent(String name, int age)
    {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    //响应HTML数据
    @RequestMapping(path="/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher()
    {
        ModelAndView mav = new ModelAndView();//实例化
        mav.addObject("name","ks");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");//放在resources的template下，但是template文件路径不用写  view是view.html,.html可以省略
        return mav;

    }

    @RequestMapping(path="/school", method = RequestMethod.GET)
    public String getSchool(Model model)
    {
        model.addAttribute("name","贾戈小学");
        model.addAttribute("age",100);
        return "/demo/view";//返回view的路径
    }
    //响应JSON数据（异步请求）
    //java对象  -->JSON字符串 --->JS对象  通过JSON字符串可以转换对象
    @RequestMapping(path="/emp", method = RequestMethod.GET)
    @ResponseBody //加上他，说明浏览器返回的不是html网页
    public Map<String, Object> getEmp()
    {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","张玉瑶");
        emp.put("age", 18);
        emp.put("salary", 30000);
        return emp;

    }//那个Disxx看到你那个ResponseBody注解并且返回类型是Map<String, Object>，然后会自动将map转成JSON字符串

    //一组员工的情况
    @RequestMapping(path="/emps", method = RequestMethod.GET)
    @ResponseBody //加上他，说明浏览器返回的不是html网页
    public List<Map<String, Object>> getEmps()
    {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","张玉瑶");
        emp.put("age", 18);
        emp.put("salary", 30000);
        list.add(emp);
        Map<String, Object> emp1 = new HashMap<>();
        emp1.put("name","曹北方");
        emp1.put("age", 30);
        emp1.put("salary", 30000);
        list.add(emp1);
        return list;
    }

















































}
