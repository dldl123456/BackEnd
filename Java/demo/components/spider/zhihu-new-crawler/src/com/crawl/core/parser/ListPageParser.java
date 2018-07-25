package com.crawl.core.parser;

import com.crawl.zhihu.entity.Page;

import java.util.List;

public interface ListPageParser extends Parser {
    @SuppressWarnings("rawtypes")
	List parseListPage(Page page);
}
