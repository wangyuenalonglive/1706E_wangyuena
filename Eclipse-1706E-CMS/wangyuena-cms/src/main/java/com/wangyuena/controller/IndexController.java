package com.wangyuena.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wangyuena.entity.Article;
import com.wangyuena.entity.Cat;
import com.wangyuena.entity.Channel;
import com.wangyuena.entity.Link;
import com.wangyuena.entity.Special;
import com.wangyuena.service.ArticleService;
import com.wangyuena.service.CatService;
import com.wangyuena.service.ChannelService;
import com.wangyuena.service.LinkService;
import com.wangyuena.service.SpecialService;
import com.wangyuena.web.PageUtils;

/**
 * @author WYN
 * @time 2019年10月17日
 */
@Controller
public class IndexController {
	@Autowired
	ChannelService chnlService;
	
	@Autowired
	CatService catService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	LinkService linkService;
	
	@Autowired
	SpecialService specialService;

	/**
	 * 
	 * @param request
	 * @param chnId  栏目id
	 * @param catId  分类id
	 * @param page  文章的页码
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping({"index","/"})
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="0") Integer chnId,
			@RequestParam(defaultValue="0")  Integer catId,
			@RequestParam(defaultValue="1")  Integer page
			) throws InterruptedException {

		//获取友情连接
		List<Link> linklist =linkService.linklist();
		request.setAttribute("linklist", linklist);
		
		Thread t1 = new Thread() {
			public void run() {
				List<Channel> channels = chnlService.getAllChnls();
				request.setAttribute("chnls", channels);
			}; 
		};
		
		
			// 获取所有的频道
		
		Thread t2;
		if(chnId!=0) {
			//获取该栏目下的所有分类
			t2=new Thread() {
				public void run() {
					List<Cat> catygories = catService.getListByChnlId(chnId); 
					request.setAttribute("catygories", catygories);
					
					//获取该栏目下的文章
					PageInfo<Article>  articleList = articleService.list(chnId,catId,page);
					request.setAttribute("articles", articleList);
					PageUtils.page(request, "/index?chnId="+chnId+"&catId=" + catId, 10, articleList.getList(),
							(long)articleList.getTotal(), articleList.getPageNum());
					//request.setAttribute("pageStr", pageStr);
				}
			};
			
			
		}else {
			// 首页热门
			// 获取热门文章
			t2=new Thread() {
				public void run() {
					PageInfo<Article>  articleList = articleService.hostList(page);
					request.setAttribute("articles", articleList);
					PageUtils.page(request, "/index", 10, articleList.getList(),
							(long)articleList.getTotal(), articleList.getPageNum());
				}
			};
			
		}
		
		Thread t3=new Thread() {
			public void run() {
				System.out.println(" ##################################################线程已经开始####################################");
				//获取最新文章
				List<Article>  lastList = articleService.last(5);
				request.setAttribute("lastList", lastList);
				System.out.println(" ##################################################线程即将结束####################################");
			}
		};
		List<Special> specials= new ArrayList<Special>();
		// 获取专题文章
		List<Special> list = specialService.list();
		for (Special special : list) {
			Special newSpecial = specialService.findById(special.getId());
			specials.add(newSpecial);
		}
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println(" 主线程即将结束");
		
		
		request.setAttribute("chnId", chnId);
		request.setAttribute("catId", catId);
		request.setAttribute("specials", specials);
		
		return "index";
	}

}
