package com.yanzhenyidai.drools.service;

import com.yanzhenyidai.drools.domain.Element;

import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:39
 */
public interface ElementService {

    public List<Element> findAll();

    public Element save(Element element);

    public void deleteById(Long id);
}
