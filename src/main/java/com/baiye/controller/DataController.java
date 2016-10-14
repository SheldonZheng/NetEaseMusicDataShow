package com.baiye.controller;

import com.baiye.DAO.MusicDAO;
import com.baiye.entity.Music;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Baiye on 2016/10/14.
 */

@Controller
public class DataController {

    MusicDAO musicDAO = new MusicDAO();

    @RequestMapping("/showData")
    @ResponseBody
    public List<Music> data(@RequestParam(name = "count") Integer count, @RequestParam(name = "start") Integer start, HttpServletRequest req, HttpServletResponse res)
    {
        List<Music> musicList = musicDAO.getDataByCountAndStart(start,count);
        res.setHeader("Access-Control-Allow-Origin","*");
        return musicList;
    }




}
