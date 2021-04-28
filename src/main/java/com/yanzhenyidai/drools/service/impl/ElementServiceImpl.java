package com.yanzhenyidai.drools.service.impl;

import com.yanzhenyidai.drools.domain.Element;
import com.yanzhenyidai.drools.repository.ElementRepository;
import com.yanzhenyidai.drools.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:40
 */
@Service
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public List<Element> findAll() {
        return elementRepository.findAll();
    }

    @Override
    public Element save(Element element) {
        return elementRepository.save(element);
    }

    @Override
    public void deleteById(Long id) {
        elementRepository.deleteById(id);
    }
}
