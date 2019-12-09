package com.timlis.gmall.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.timlis.gmall.bean.PmsSearchParam;
import com.timlis.gmall.bean.PmsSkuInfo;
import com.timlis.gmall.bean.PmsSkuSearchInfo;
import com.timlis.gmall.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
public class SearchController {

    @Reference
    SearchService searchService;

    @RequestMapping("/list.html")
    public String list(PmsSearchParam pmsSearchParam, ModelMap modelMap) {

        List<PmsSkuSearchInfo> pmsSkuSearchInfos = searchService.list(pmsSearchParam);
        modelMap.put("skuLsInfoList", pmsSkuSearchInfos);

        return "list";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
