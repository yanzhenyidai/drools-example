package com.yanzhenyidai.drools.controller;

import com.yanzhenyidai.drools.domain.Element;
import com.yanzhenyidai.drools.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 16:00
 */
@RestController
@RequestMapping(value = "/element")
public class ElementController {

    @Autowired
    private ElementService elementService;

    @RequestMapping(value = "/findAll")
    public List<Element> findAll() {
        return elementService.findAll();
    }

    @RequestMapping(value = "/save")
    public Element save(@RequestBody Element element) {
        return elementService.save(element);
    }

    @RequestMapping(value = "/remove")
    public void remove(Long id) {
        elementService.deleteById(id);
    }
}
