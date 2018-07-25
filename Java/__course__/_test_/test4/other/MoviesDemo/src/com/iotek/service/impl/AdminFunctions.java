package com.iotek.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.IAdminDao;
import com.iotek.dao.IMovieDao;
import com.iotek.dao.IReviewDao;
import com.iotek.dao.IShowHallDao;
import com.iotek.dao.IShowPlanDao;
import com.iotek.dao.ITheaterDao;
import com.iotek.dao.ITicketDao;
import com.iotek.dao.impl.AdminDao;
import com.iotek.dao.impl.MovieDao;
import com.iotek.dao.impl.ReviewDao;
import com.iotek.dao.impl.ShowHallDao;
import com.iotek.dao.impl.ShowPlanDao;
import com.iotek.dao.impl.TheaterDao;
import com.iotek.dao.impl.TicketDao;
import com.iotek.entity.Admin;
import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;
import com.iotek.service.IAdminFunctions;
import com.iotek.util.Util;
 public class AdminFunctions implements IAdminFunctions{
	/**
	 * 把列表分页（待修改//使用limit）
	 * @param ls
	 * @param n
	 * @return
	 */
	private <T> List<T> apartTwo(List<T> ls,int n){
		if(ls.isEmpty()){
			return null;
		}
		List<T> mid=new ArrayList<T>();
		if(n<=0){
			for(int i=0;i<10;i++){
				if((ls.size()-1)<i){
					break;
				}
				mid.add(ls.get(i));
			}
			return mid;
		}
		if(ls.size()<(n*10)){
			return apartTwo(ls,n-1);
		}
		else if(ls.size()<((n+1)*10)){
			for(int i=n*10;i<ls.size();i++){
				mid.add(ls.get(i));
			}
		}else{
			for(int i=n*10;i<(n+1)*10;i++){
				mid.add(ls.get(i));
			}
		}
		return mid;
	}

	@Override
	public Admin login() {
		IAdminDao iad=new AdminDao();
		String name=Util.getString("请输入用户名");
		while(!iad.nameIsOk(name)){
			name=Util.getString("没找到该用户，请重新输入用户名（输入0退出登录）");
			if(name.equals("0")){
				return null;
			}
		}
		String psw=Util.getString("请输入用户密码：");
		Admin ad=iad.login(name, psw);
		return ad;
	}
	
	@Override
	public void movieOptions() {
		Movie m=null;
		List<Movie> mls=null;
		while(true){
			int choose=Util.getInt("请输入选项：1.查看所有电影\t2.查看已经下架的电影\t3.搜索电影\t4.添加电影\t0.返回");
			switch(choose){
				case 1:
					mls=null;
					mls=selectMovies();
					if(mls==null){
						System.out.println("没有找到相关影片");
						break;
					}
					m=null;
					m=selectMovie(mls);
					if(m==null){
						break;
					}
					movieOptions(m);
					break;
				case 2:
					mls=null;
					mls=selectDeletedMovies();
					if(mls==null){
						System.out.println("暂时没有下架的电影");
						break;
					}
					m=null;
					m=selectMovie(mls);
					if(m==null){
						break;
					}
					String status=Util.getString("你要让这部电影重新上架吗？1.是2.不是");
					if(status.equals("1")){
						m.setStatus("0");
						if(new MovieDao().setMovie(m)){
							System.out.println("上架成功");
							return;
						}
						
					}else{
						break;
					}
					break;
				case 3:
					m=selectMovie();
					if(m==null){
						break;
					}
					movieOptions(m);
					break;
				case 4:
					if(addMovie()){
						
						break;
					}
					break;
				case 0:
					return;
					default:
						System.out.println("请输入正确选项！！！");
						break;
			}
		}
	}
	/**
	 * 不包括下架的电影
	 * @return
	 */
	@Override
	public List<Movie> selectMovies() {
		IMovieDao imd=new MovieDao();
		List<Movie> mls=imd.selecMovies();
		if(mls==null){
			return null;
		}
		if(mls.isEmpty()){
			return null;
		}
		return mls;
	}
	/**
	 * 某部电影的所有操作
	 * @param m
	 */
	@Override
	public void movieOptions(Movie m) {
		
		int choose=0;
		while(true){
			choose=Util.getInt("请输入选项：1.查看场次\t2.查看影评\t3.修改电影\t4.删除电影\t5.添加场次\t0.返回");
			switch(choose){
				case 0:
					return;
				case 1:
					List<ShowPlan> spls=null;
					spls=getShowPlans(m);
					if(spls==null){
						break;
					}
					 ShowPlan sp=getShowPlan(spls); 
					 if(sp==null){
						 break;
					 }
					 showplanOptions(sp);
					break;
				case 2:
					IReviewDao ird=new ReviewDao();
					List<Review> rls=ird.selectReview(m);
					if(rls==null||rls.isEmpty()){
						System.out.println("暂时还没有人填写该电影的影评");
						break;
					}
					int n2=0;
					int count2=0;
					while(true){
						count2=0;
						List<Review> rls2=apartTwo(rls,n2);
						for(Review r:rls2){
							System.out.println(count2+":"+m.getName()+
									",用户："+r.getUserName()+
									"评分："+r.getMark()+
									"\n评价："+r.getComments());
						}
						String str=Util.getString("请输入你要操作的选项:\nq.上一页\tw.返回\te.下一页)");
						if(str.equals("q")){
							if(n2==0){
								System.out.println("已经是首页啦^_^");
							}else{
								n2--;
								continue;
							}
						}else if(str.equals("w")){
							break;
						}else if(str.equals("e")){
							if(20*(n2+1)>rls.size()){
								System.out.println("已经到末尾了啦^_^");
							}else{
								n2++;
								continue;
							}
						}else if(str.equals("0")){
							return;
						}
					}
					break;
				case 3:
					if(updateMovie(m)){
						System.out.println("电影更新完成");
						return ;
						
					};
					break;
				case 4:
					if(deleteMovie(m)){
						System.out.println("更新完成");
						return;
					}
					break;
				case 5:
					addShowPlan(m);
					break;
				default:
					System.out.println("请输入正确选项！");
					break;
			}
		}
		
	}
	/**
	 * 从电影列表选择电影
	 * @param mls
	 * @return
	 */
	@Override
	public Movie selectMovie(List<Movie> mls) {
		int count=0;
		if(mls==null){
			return null;
		}
		if(mls.isEmpty()){
			System.out.println("没有相关电影");
			return null;
		}
		int n=0;
			while(true){
				count=0;
				List<Movie> mls2=apartTwo(mls,n);
				if(mls2==null){
					break;
				}
				for(Movie m:mls2){
					count++;
					System.out.println(count+":"+m.getName()+"\t导演："+m.getDirector()+"\t主演："+m.getStars()+"\t类型："+m.getType()+"\t评分："+m.getMark());
				}
				String str=Util.getString("请输入你要查看的电影序号:\nq.上一页\tw.返回\te.下一页");
				if(str.equals("q")){
					if(n==0){
						System.out.println("已经是首页啦^_^");
					}else{
						n--;
						continue;
					}
				}else if(str.equals("w")){
					break;
				}else if(str.equals("e")){
					if(20*(n+1)>mls.size()){
						System.out.println("已经到末尾了啦^_^");
					}else{
						n++;
						continue;
					}
				}else if(str.equals("0")){
					return null;
				}
				else{
					try{
						if(Integer.valueOf(str) instanceof Integer){
							int num=Integer.valueOf(str);
							if(num>0&&num<=mls2.size()){
								Movie movie=mls2.get(num-1);
								System.out.println(movie.toString());
								System.out.println("***********************************************************");
								return movie;
							}else{
								System.out.println("你输入的选项有误，请重新输入！！！");
							}
						}
					}catch(Exception e){
						System.out.println("你输入的选项有误，请输入正确的选项！！！");
					}
					
					
				}
				
			
			}		return null;	
		}
	
	@Override
	public boolean addMovie() {
		IMovieDao imd=new  MovieDao();
		String name=Util.getString("请输入你是想添加的电影名：0.放弃添加");
		while(true){
			if(name.equals("0")||(name==null)){
				return false;
			}else{
				if(imd.nameIsOK(name)){
					System.out.println("你是不是输错了呀，该电影已经有了呀，请重新再来一次：");
					name=Util.getString("请输入你是想添加的电影名：0.放弃添加");
					continue;
				};
				
			}
			break;
		}
		String director=Util.getString("请输入电影导演名：1.跳过");
		
		String star=Util.getString("请输入主演名：");
		
		String intro=Util.getString("请输入简介：");
		
		String type=Util.getString("请输入电影类型：");
		int min=Util.getInt("请输入电影时长：");
		String status="0";
		Date date=Util.getDate("请输入电影上映时间：");
		Movie m2=new Movie();
		m2.setDirector(director);
		m2.setIntro(intro);
		m2.setMark(10);
		m2.setStars(star);
		m2.setMins(min);
		m2.setName(name);
		m2.setOpenTime(date);
		m2.setType(type);
		m2.setStatus(status);
		if(imd.addMovie(m2)){
			System.out.println("添加成功");
			int choose2=Util.getInt("是否继续添加场次：1.添加2.算了");
			if(choose2==1){
				addShowPlan(m2);
			}
			return true;
		}else{
			System.out.println("添加失败");
		}
		
		return false;
	}
	
	@Override
	public boolean updateMovie(Movie m) {
		IMovieDao imd=new  MovieDao();
		String name=Util.getString("请输入你是想修改的电影名：0.放弃修改1.跳过修改电影名");
		while(true){
			if(name.equals("1")){
				name=m.getName();
			}else if(name.equals(m.getName())){
				
			}else if(name.equals("0")||(name==null)){
				return false;
			}else{
				if(imd.nameIsOK(name)){
					System.out.println("你是不是输错了呀，该电影已经有了呀，请重新再来一次：");
					continue;
				};
				
			}
			break;
		}
		String director=Util.getString("请输入电影导演名：1.跳过");
		if(director.equals("1")||director==null){
			director=m.getDirector();
		}
		String star=Util.getString("请输入主演名：(人名之间以逗号（，）隔开)1.跳过");
		if(star.equals("1")||star==null){
			star=m.getStars();
		}
		String intro=Util.getString("请输入简介：1.跳过");
		if(intro.equals("1")||intro==null){
			intro=m.getIntro();
		}String type=Util.getString("请输入电影类型：1.跳过");
		if(type.equals("1")||type==null){
			type=m.getType();
		}
		int min=Util.getInt("请输入电影时长：1.跳过");
		if(min==1){
			min=m.getMins();
			
		}
		String status=Util.getString("输入电影1.上架2.下架：0.不修改");
		if(status.equals("2")){
			status="-1";
		}else if(status.equals("1")){
			status="1";
		}else{
			status=m.getStatus();
			
		}
		Date date=Util.getDate("请输入电影上映时间：");
		Movie m2=new Movie();
		m2.setId(m.getId());
		m2.setDirector(director);
		m2.setIntro(intro);
		m2.setMark(m.getMark());
		m2.setStars(star);
		m2.setMins(min);
		m2.setName(name);
		m2.setOpenTime(date);
		m2.setType(type);
		m2.setStatus(status);
		if(imd.updateMovie(m)){
			m=m2;
			return true;
		}else{
			System.out.println("修改失败");
		}
		
		return false;
	}
	
	@Override
	public boolean deleteMovie(Movie m) {
		IMovieDao imd=new MovieDao();
		int choose=Util.getInt("你是要删除电影还是下架电影1.删除2.下架0.返回");
		if(choose==2){
			String status="-1";
			Movie m2=new Movie();
			m2.setId(m.getId());
			m2.setDirector(m.getDirector());
			m2.setIntro(m.getIntro());
			m2.setMark(m.getMark());
			m2.setStars(m.getStars());
			m2.setMins(m.getMins());
			m2.setName(m.getName());
			m2.setOpenTime(m.getOpenTime());
			m2.setType(m.getType());
			m2.setStatus(status);
			if(setMovieStatus(m)){
				m=m2;
				return true;
			}
			return false;
		}
		else if(choose==1) {
			if(imd.movieIsDelete(m)){
				if(imd.deleteMovie(m)){
					System.out.println("已删除");
					return true;
				}else{
					System.out.println("系统忙，请稍后重试");
				}
				
			}else{
				System.out.println("该电影无法被删除，已经有演出了，请先删除演出再来删除电影！");
			}
			
		}else{
			return false;
		}
		return false;
	}
	
	@Override
	public List<Movie> selectAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Movie selectMovie() {
		IMovieDao imd=new MovieDao();
		List<Movie> mls=imd.selecMovies();
		if(mls==null){
			return null;
		}
		List<Movie> mls2=null;
		int choose=Util.getInt("请输入选项：1.电影名 2.电影上映时间4.电影导演4.电影类型 0.返回上一步");
		switch(choose){
		case 1:
			mls2=null;
			String name=Util.getString("请输入电影名：");
			mls2=imd.selectMovies(name);
			break;
		case 2:
			mls2=new ArrayList<>();
			Date date=Util.getDate("请输入你要查看电影的上映时间：");
			for(Movie m:mls){
				if(m.getOpenTime().after(date)){
					mls2.add(m);
				}
			}
			
			break;
		case 3:
			mls2=new ArrayList<>();
			String director=Util.getString("请输入你要查看电影的导演：");
			for(Movie m:mls){
				if(m.getDirector().contains(director)){
					mls2.add(m);
				}
			}
			
			break;
		case 4:
			mls2=new ArrayList<>();
			String type=Util.getString("请输入你要查看电影的类型：");
			for(Movie m:mls){
				if(m.getDirector().contains(type)){
					mls2.add(m);
				}
			}
			break;
		case 0:
			return null;
			default:		
				return null;
		}
		Movie m= selectMovie(mls2);
		if(m==null){
			return null;
		}
		return m;
	}
	
	@Override
	public boolean setMovieStatus(Movie m) {
		int choose=Util.getInt("确认修改吗：1.确认2.返回");
		if(choose==1){
			IMovieDao imd=new MovieDao();
			if(imd.setMovie(m)){
				System.out.println("修改成功");
				return true;
			}
		}
		return false;
	}

	@Override
	public void ticketOptions() {
		
	}
	
	@Override
	public List<Ticket> selectTickets() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void theaterOptions() {
		ITheaterDao itd=new TheaterDao();
		List<Theater> tls=null;
		Theater theater=null;
		while(true){
			int choose=Util.getInt("请输入选项：1.查看所有电影院\t2.查看已经关闭的电影院\t3.搜索电影院\t4.添加电影院\t0.返回");
			switch(choose){
				case 1:
					tls=null;
					tls=itd.selectTheaters();
					if(tls==null){
						System.out.println("没有找到相关影院");
						break;
					}
					theater=null;
					theater=getTheater(tls);
					if(theater==null){
						System.out.println("暂时没有关闭的电影院");
						break;
					}
					theaterOptions(theater);
					break;
				case 2:
					tls=null;
					tls=selectClosedTheater();
					if(tls==null){
						break;
					}
					theater=null;
					theater=getTheater(tls);
					if(theater==null){
						break;
					}
					String status=Util.getString("你要让这家电影院重开营业吗？1.是2.不是");
					if(status.equals("1")){
						theater.setStatus("1");
						itd.setTheater(theater);
					}else{
						break;
					}
				case 3:
					String name=Util.getString("输入电影院名：");
					tls=itd.selectTheaters(name);
					if(tls==null){
						System.out.println("没有该电影院，你是不是输入错了呀");
						break;
					}
					theater=getTheater(tls);
					if(theater==null){
						break;
					}
					theaterOptions(theater);
					break;
				case 4:
					addTheater();
					break;
				case 0:
					return;
					default:
						System.out.println("请输入正确选项！！！");
						break;
			}
		}
	}
	
	@Override
	public List<Theater> selectTheaters() {
		ITheaterDao itd=new TheaterDao();
		List<Theater> tls=itd.selectTheaters();
		if(tls==null){
			return null;
		}
		return tls;
	}
	
	@Override
	public List<Theater> selectClosedTheater() {
		ITheaterDao itd=new TheaterDao();
		List<Theater> tls=itd.selectClosedTheaters();
		if(tls==null){
			return null;
		}
		return tls;
	}
	
	@Override
	public Theater getTheater(List<Theater> tls) {
		int count=0;
		if(tls==null){
			return null;
		}
		if(tls.isEmpty()){
			System.out.println("没有电影院");
			return null;
		}
		int n=0;
			while(true){
				count=0;
				List<Theater> tls2=apartTwo(tls,n);
				if(tls2==null){
					break;
				}
				for(Theater t:tls2){
					count++;
					System.out.println(count+":"+t.getName()+",地址："+t.getAdress());
				}
				String str=Util.getString("请输入你要查看的电影院序号:\nq.上一页\tw.返回\te.下一页");
				if(str.equals("q")){
					if(n==0){
						System.out.println("已经是首页啦^_^");
					}else{
						n--;
						continue;
					}
				}else if(str.equals("w")){
					break;
				}else if(str.equals("e")){
					if(20*(n+1)>tls.size()){
						System.out.println("已经到末尾了啦^_^");
					}else{
						n++;
						continue;
					}
				}else if(str.equals("0")){
					return null;
				}
				else{
					try{
						if(Integer.valueOf(str) instanceof Integer){
							int num=Integer.valueOf(str);
							if(num>0&&num<=tls2.size()){
								Theater t=tls2.get(num-1);
								System.out.println("***********************************************************");
								return t;
							}else{
								System.out.println("你输入的选项有误，请重新输入！！！");
							}
						}
					}catch(Exception e){
						System.out.println("你输入的选项有误，请输入正确的选项！！！");
					}
					
					
				}
			}	
			return null;	
	}
	
	@Override
	public void theaterOptions(Theater t) {
		int choose=0;
		while(true){
			choose=Util.getInt("请输入选项：1.查看影厅\t2.修改电影院信息\t3.删除电影院\t4.添加影厅\t0.返回");
			switch(choose){
				case 0:
					return;
				case 1:
					List<ShowHall> shls=null;
					shls=selectShowHalls(t);
					if(shls==null){
						break;
					}
					 ShowHall sh=getShowHall(shls); 
					 if(sh==null){
						 break;
					 }
					 showhallOptions(sh);
					break;
				case 2:
					updateTheater(t);
					break;
				case 3:
					deleteTheater(t);
					break;
				case 4:
					ShowHall hall=new ShowHall();
					hall.setTheater(t);
					hall.setTheaterId(t.getId());
					addShowHall(hall);
					break;
				default:
					System.out.println("请输入正确选项！");
					break;
			}
		}
		
	}
	
	@Override
	public void showhallOptions(ShowHall sh) {
		int choose=Util.getInt("请输入选项：1.查看影厅2.修改影厅0.返回");
		switch(choose){
		case 0:
			return;
		case 1:
			System.out.println(sh.getTheater().getName()+sh.getTitle()+"，共有座位"+sh.getColums()+"列，"+sh.getRows()+"行");
			break;
		case 2:
			updateShowHall(sh);
			break;
			default:
				break;
		}
	}

	@Override
	public void addTheater() {
		String name=Util.getString("请输入电影院名:0.退出添加");
		if(name.equals("0")){
			return ;
		}
		String adress=Util.getString("请输入电影院地址：");
		ITheaterDao itd=new TheaterDao(); 
		Theater t=new Theater();
		t.setName(name);
		t.setAdress(adress);
		t.setStatus("1");
		if(itd.addTheater(t)){
			int choose=	Util.getInt("添加成功，是否要继续添加影厅：1.添加 2.不添加");
			while(choose==1){
				name=Util.getString("请输入影厅名字：");
				int row=Util.getInt("输入影厅的座位行数");
				int col=Util.getInt("请输入影厅座位的列数");
				ShowHall sh=new ShowHall();
				sh.setTheater(t);
				sh.setTheaterId(t.getId());
				sh.setRows(row);
				sh.setColums(col);
				if(addShowHall(sh)){
					choose=	Util.getInt("添加成功，是否要继续添加影厅：1.添加 2.不添加");
				}
				break;
			}
				return ;
		}
		System.out.println("添加失败，请稍后再试");
	}
	
	@Override
	public boolean deleteTheater(Theater t) {
		ITheaterDao itd=new TheaterDao();
		if(t==null){
			return false;
		}
		if(itd.theaterCanDeleted(t)){
			if(itd.deleteTheater(t)){
				System.out.println("删除成功");
				return true;
			}
		}
		int choose=Util.getInt("该影院暂时无法删除，是否先关闭该影院 1.关闭 2.算了");
		if(choose==1){
			t.setStatus("0");
			if(setTheaterStatus(t)){
				System.out.println("以经关闭了");
				return true;
			}
			
		}
		
		return false;
	}
	
	@Override
	public boolean updateTheater(Theater t) {
		String name=Util.getString("请输入电影院名:0.不修改");
		if(name.equals("0")){
			name=t.getName();
		}
		String adress=Util.getString("请输入电影院地址：0.不修改");
		if(adress.equals("0")){
			adress=t.getAdress();
		}
		ITheaterDao itd=new TheaterDao();
		Theater t2=new Theater();
		t2.setId(t.getId());
		t2.setName(name);
		t2.setAdress(adress);
		t2.setStatus(t.getStatus());
		boolean flag=itd.updateTheater(t);
		if(flag){
			System.out.println("修改成功");
			return true;
		}
		return false;
	}
	
	@Override
	public void showplanOptions() {
		IShowPlanDao ispd=new ShowPlanDao();
		List<ShowPlan> spls=null;
		ShowPlan sp=null;
		int choose=Util.getInt("请输入选项：1.查询所有场次2.查询即将上映的场次3.添加场次0.返回");
		while(true){
			switch(choose){
			case 0:
				return;
			case 1:
				spls=null;
				spls=ispd.selectShowPlans();
				if(spls==null){
					System.out.println("没找到相关的列表");
					return ;
				}
				sp=null;
				 sp=getShowPlan(spls);
				if(sp==null){
					return;
				}
				showplanOptions(sp);
				break;
			case 2:
				spls=null;
				Timestamp time=new Timestamp(System.currentTimeMillis());
				spls=ispd.selectShowPlans(time);
				if(spls==null){
					System.out.println("没找到相关的列表");
					return ;
				}
				sp=null;
				sp=getShowPlan(spls);
				if(sp==null){
					return;
				}
				showplanOptions(sp);
				break;
			case 3:
				addShowPlan();
				break;
				default:
					break;
			}
			choose=Util.getInt("请输入选项：1.查询所有场次2.查询即将上映的场次3.添加场次0.返回");
		}
		
	}
	
	@Override
	public void showplanOptions(ShowPlan sp) {
		if(sp==null){
			return;
		}
		int choose=Util.getInt("输入选项：1.修改场次2.删除场次3.查看详细0.返回");
		switch(choose){
		case 0:
			return;
		case 1:
			if(updateShowPlan(sp)){
				System.out.println("修改成功");
			};
			break;
		case 2:
			if(deleteShowPlan(sp)){
				System.out.println("删除成功");
			}
			break;
		case 3:
			Movie m=sp.getMovie();
			ShowHall hall=sp.getHall();
			Theater theater =hall.getTheater();
			int choose2=Util.getInt("查看：1.电影信息2.影院0.返回");
			if(choose2==0){
				return;
			}if(choose2==1){
				movieOptions(m);
				return;
			}
			if(choose2==2){
				theaterOptions(theater);
				return;
			}
			System.out.println("没有该选项");
			break;
			default:
				System.out.println("没有该选项");
				break;
		}
	}
	
	@Override
	public List<ShowPlan> getShowPlans() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ShowPlan> getShowPlans(Movie m) {
		IShowPlanDao isp=new ShowPlanDao();
		List<ShowPlan> spls=isp.selectAllShowPlans(m);
		if(spls==null){
			System.out.println("没找到相关内容");
			return null;
		}
		return spls;
		
	}
	
	@Override
	public ShowPlan getShowPlan(List<ShowPlan> spls) {
		if(spls==null){
			System.out.println("没有相关场次");
			return null;
		}
		Movie m=null;
		int n=0;
		int count=0;
		while(true){
			count=0;
			List<ShowPlan> spls2=apartTwo(spls,n);
			if(spls2==null){
				System.out.println("没有相关场次");
				return null;
			}
			for(ShowPlan sp:spls2){
				count++;
				IShowHallDao ish=new ShowHallDao();
				ShowHall hall=ish.selectShowHall(sp.getHallId());
					m=sp.getMovie();
					if(m==null){
						IMovieDao imd=new MovieDao();
						m=imd.selectMovie(sp.getMovieId());
						sp.setMovie(m);
					}
				if(hall==null){
					continue;
				}
				Theater theater=hall.getTheater();
				if(theater==null){
					ITheaterDao itd=new TheaterDao();
					theater=itd.selectTheater(hall.getTheaterId());
				}hall.setTheater(theater);
				sp.setHall(hall);
				System.out.println(count+":"+m.getName()+"  "+theater.getAdress()+"  "+theater.getName()+"  影厅："+hall.getTitle()+"\n播放时间："+sp.getShowtime().toString()+"   票价："+sp.getPrices()+"元");
			}
			String str=Util.getString("请输入你要查看的场次序号:\nq.上一页\tw.返回\te.下一页)");
			if(str.equals("q")){
				if(n==0){
					System.out.println("已经是首页啦^_^");
				}else{
					n--;
					continue;
				}
			}else if(str.equals("w")){
				break;
			}else if(str.equals("e")){
				if(20*(n+1)>spls.size()){
					System.out.println("已经到末尾了啦^_^");
				}else{
					n++;
					continue;
				}
			}else if(str.equals("0")){
				return null;
			}
			else{
				try{
					if(Integer.valueOf(str) instanceof Integer){
						int num=Integer.valueOf(str);
						if(num>0&&num<=spls2.size()){
							ShowPlan sp=spls2.get(num-1);
							ShowHall hall=sp.getHall();
							m=sp.getMovie();
							Theater theater =hall.getTheater();
							System.out.println(count+":"+m.getName()+"  "+
							theater.getAdress()+"  "+theater.getName()+
							"  影厅："+hall.getTitle()+
							"\n播放时间："+sp.getShowtime().toString()+
							"   票价："+sp.getPrices()+"元");
							System.out.println("***********************************************************");
							return sp;
						}else{
							System.out.println("你输入的选项有误，请重新输入！！！");
						}
					}
				}catch(Exception e){
					System.out.println("你输入的选项有误，请输入正确的选项！！！");
				}
				
				
			}
			
		}return null;
	}
	
	@Override
	public boolean addShowPlan() {
		Movie m=null;
		m=selectMovie();
		if(m==null){
			return false;
		}
		if(addShowPlan(m)){
			System.out.println("添加成功");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addShowPlan(Movie m) {
		List<Theater> tls=selectTheaters();
		if(tls==null){
			System.out.println("当前没有电影院，先去添加电影院吧");
			return false;
		}
		Theater t=getTheater(tls);
		if(t==null){
			return false;
		}
		List<ShowHall> shls=selectShowHalls(t);
		if(shls==null){
			return false;
		}
		ShowHall sh=getShowHall(shls);
		if(sh==null){
			return false;
		}
		Timestamp time=Util.getTimestamp("请输入演出时间");
		while(true){
			Timestamp time2=new Timestamp(System.currentTimeMillis());
			if(time.before(time2)){
				time=Util.getTimestamp("亲，以前的时间咋没法回去啊，设置的播放时间必须在现在之后呢，换个时间吧");
				continue;
			}
			if(showtimeIsOk(time,m,sh)){
				break;
			}
			time=Util.getTimestamp("该时间段已经有电影在该影院上映了，亲换个时间吧");
		}
		double prices=Util.getDouble("请输入你要定的票价：");
		if(prices==0){
			prices=Util.getDouble("难道你要义演吗，是继续输入0，否则输入票价");
		}
		ShowPlan sp=new ShowPlan();
		sp.setMovie(m);
		sp.setMovieId(m.getId());
		sp.setHall(sh);
		sp.setHallId(sh.getId());
		sp.setShowtime(time);
		sp.setPrices(prices);
		IShowPlanDao ispd=new ShowPlanDao();
		if(ispd.addShowPlan(sp)!=0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean showtimeIsOk(Timestamp time,Movie m,ShowHall hall) {
		if(time==null ||m==null||hall==null){
			return false;
		}
		Timestamp time2=new Timestamp(time.getTime()+m.getMins()*60000);
		IShowPlanDao ispd=new ShowPlanDao();
		if(ispd.timeIsOk(time, time2, hall)){
			return true;
		}
		return false;
	}

	@Override
	public List<ShowHall> selectShowHalls(Theater t) {
		IShowHallDao ishd=new ShowHallDao();
		List<ShowHall> shls=ishd.selectAllShowHalls(t);
		if(shls==null){
			return null;
		}
		return shls;
	}

	@Override
	public ShowHall getShowHall(List<ShowHall> shls) {
		int count=0;
		if(shls==null){
			return null;
		}
		if(shls.isEmpty()){
			System.out.println("没有相关电影厅");
			return null; 
		}
		int n=0;
			while(true){
				count=0;
				List<ShowHall> shls2=apartTwo(shls,n);
				if(shls2==null){
					break;
				}
				for(ShowHall sh :shls2){
					count++;
					Theater t=sh.getTheater();
					System.out.println(count+":"+t.getName()+",地址："+t.getAdress()+",影厅："+sh.getTitle());
				}
				String str=Util.getString("请输入你要查看的电影院序号:\nq.上一页\tw.返回\te.下一页");
				if(str.equals("q")){
					if(n==0){
						System.out.println("已经是首页啦^_^");
					}else{
						n--;
						continue;
					}
				}else if(str.equals("w")){
					break;
				}else if(str.equals("e")){
					if(20*(n+1)>shls.size()){
						System.out.println("已经到末尾了啦^_^");
					}else{
						n++;
						continue;
					}
				}else if(str.equals("0")){
					return null;
				}
				else{
					try{
						if(Integer.valueOf(str) instanceof Integer){
							int num=Integer.valueOf(str);
							if(num>0&&num<=shls2.size()){
								ShowHall sh=shls2.get(num-1);
								System.out.println("***********************************************************");
								return sh;
							}else{
								System.out.println("你输入的选项有误，请重新输入！！！");
							}
						}
					}catch(Exception e){
						System.out.println("你输入的选项有误，请输入正确的选项！！！");
					}
					
					
				}
			}	
			return null;
	}

	@Override
	public boolean addShowHall(ShowHall sh) {
		String title=Util.getString("请输入影厅名字：0.不添加");
		if(title.equals("0")){
			return false;
		}
		int col=Util.getInt("请输入座位列数：");
		while(col==0){
			col=Util.getInt("请输入座位列数：");
		}
		int row=Util.getInt("请输入座位行数：0.不修改");
		while(col==0){
			row=Util.getInt("请输入座位行数：");
		}
		sh.setRows(row);
		sh.setTitle(title);
		sh.setColums(col);
		IShowHallDao ishd=new ShowHallDao();
		if(ishd.addShowHall(sh)){
			System.out.println("添加成功");
			return true;
		}
		return false;
	}
	@Override
	public boolean updateShowHall(ShowHall sh) {
		String title=Util.getString("请输入更改后的影厅名字：0.不修改");
		if(title.equals("0")){
			title=sh.getTitle();
		}
		int col=Util.getInt("请输入座位列数：0不修改");
		if(col==0){
			col=sh.getColums();
		}
		int row=Util.getInt("请输入座位行数：0.不修改");
		if(row==0){
			row=sh.getRows();
		}
		sh.setRows(row);
		sh.setTitle(title);
		sh.setColums(col);
		IShowHallDao ishd=new ShowHallDao();
		if(ishd.updateShowHall(sh)){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteShowHall(ShowHall sh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteShowPlan(ShowPlan sp) {
		if(sp==null){
			return true;
		}
		IShowPlanDao ispd=new ShowPlanDao();
		Timestamp time=sp.getShowtime();
		Timestamp time2=new Timestamp(System.currentTimeMillis());
		if(time.after(time2)){
			System.out.println("该场次已经上映过了，不能再删除了");
			return false;
		}
		List<Ticket> tls=ispd.canDelete(sp);
		int choose=0;
		if(tls==null){
			choose=Util.getInt("确认删除吗 1.删除  2. 不删除");
			if(choose==1){
				return ispd.deleteShowPlan(sp);
			}
			return false;
		}
		choose=Util.getInt("这个场次已经卖出了"+tls.size()+"张票，是否还要删除，1.是 2.否");
		if(choose==1){
			ITicketDao itd=new TicketDao();
			System.out.println("正在退票中");
			int k=itd.deleteTickets(sp);
			if(k==0){
				return false;
			}
			System.out.println("退票成功，票钱都已经成功转回用户手里");
			return ispd.deleteShowPlan(sp);
		}
		return false;
	}
	
	@Override
	public boolean updateShowPlan(ShowPlan sp) {
		System.out.println("场次生成之后不可更改，如需修改请先删除在重新添加");
		return false;
	}
	
	@Override
	public boolean updatePsw(Admin ad) {
		String psw=Util.getString("请输入之前的密码：");
		if(psw.equals(ad.getPsw())){
			psw=Util.getString("请输入新密码：");
			IAdminDao iad=new AdminDao();
			if(iad.updatePsw(ad.getId(), psw)){
				ad.setPsw(psw);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateAdmin(Admin ad) {
		while(true){
			String name=Util.getString("请输入新用户名：0.退出");
			if(name.equals("0")){
				return;
			}
			if(name.equals(ad.getName())){
				
			}else{
				IAdminDao iad=new AdminDao();
				if(iad.nameIsOk(name)){
					System.out.println("该用户名已经存在了");
					continue;
				}

			}
			String adress=Util.getString("输入新地址：0.不修改");
			if(adress.equals("0")){
				adress=ad.getAdress();
			}
			String sex=Util.getString("输入性别：男/女");
			while(!(sex.equals("男")||sex.equals("女"))){
				sex=Util.getString("输入的信息有误，重新输入：");
			}
			int age=Util.getInt("输入年龄：0.不修改");
			if(age==0){
				age=ad.getAge();
			}
			String tel=Util.getString("输入电话：0.不修改");
			if(tel.equals("0")){
				tel=ad.getTel();
			}Admin ad2=new Admin();
			ad2.setId(ad.getId());
			ad2.setPsw(ad.getPsw());
			ad2.setName(name);
			ad2.setSex(sex);
			ad2.setAdress(adress);
			ad2.setTel(tel);
			ad2.setAge(age);
			IAdminDao iad=new AdminDao();
			if(iad.updateAdmin(ad2)){
				ad=ad2;
				System.out.println("修改成功！");
				return;
			}
			System.out.println("修改失败");
			break;
		}
		
		
	}
	
	@Override
	public boolean register(Admin ad) {
		String psw=Util.getString("请输入你的密码：");
		if(psw.equals(ad.getPsw())){
			IAdminDao iad=new AdminDao();
			String name=Util.getString("请输入你要注册的名字：");
			while(iad.nameIsOk(name)){
				name=Util.getString("该名字已经注册过了，请重新输入一个新的名字：");
			}
			psw=Util.getString("请输入用户的密码：(密码长度最多12位)");
			while(psw.length()>12){
				psw=Util.getString("密码长度太长了，请重新输入密码：");
			}
			String adress=Util.getString("请输入地址：");
			String sex=Util.getString("请输入性别：男/女");
			while(!(sex.equals("男")||sex.equals("女"))){
				sex=Util.getString("请输入:男或者女");
			}
			int age=Util.getInt("请输入年龄：");
			String tel=Util.getString("请输入电话号码：");
			
			Admin ad2=new Admin();
			ad2.setName(name);
			ad2.setPsw(psw);
			ad2.setAdress(adress);
			ad2.setAge(age);
			ad2.setSex(sex);
			ad2.setTel(tel);
			if(iad.register(ad2)){
				System.out.println("你注册了一个新管理员");
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Movie> selectDeletedMovies() {
		IMovieDao imd=new MovieDao();
		List<Movie> mls=imd.selectDeletedMovies();
		if(mls==null){
			return null;
		}
		if(mls.isEmpty()){
			return null;
		}
		return mls;
	}

	@Override
	public boolean setTheaterStatus(Theater t) {
		ITheaterDao itd=new TheaterDao();
		if(itd.setTheater(t)){
			System.out.println("修改成功");
			return true;
		}
		return false;
	}

	
}