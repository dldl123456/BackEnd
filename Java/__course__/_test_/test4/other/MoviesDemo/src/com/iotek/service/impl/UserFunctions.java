package com.iotek.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.IMovieDao;
import com.iotek.dao.IReviewDao;

import com.iotek.dao.IShowHallDao;
import com.iotek.dao.IShowPlanDao;
import com.iotek.dao.ITheaterDao;
import com.iotek.dao.ITicketDao;
import com.iotek.dao.IUserDao;
import com.iotek.dao.impl.MovieDao;
import com.iotek.dao.impl.ReviewDao;
import com.iotek.dao.impl.ShowHallDao;
import com.iotek.dao.impl.ShowPlanDao;
import com.iotek.dao.impl.TheaterDao;
import com.iotek.dao.impl.TicketDao;
import com.iotek.dao.impl.UserDao;
import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.Seat;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;
import com.iotek.entity.User;
import com.iotek.service.IUserFunctions;
import com.iotek.util.Util;

public class UserFunctions implements IUserFunctions{
	
	@Override
	public boolean register() {
		IUserDao ud=new UserDao();
		String name=Util.getString("请输入你要注册的名字：");
		while(ud.nameIsOk(name)){
			name=Util.getString("该名字已经注册过了，请重新输入一个新的名字：");
		}
		String psw=Util.getString("请输入用户的密码：(密码长度最多12位)");
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
		double balance=Util.getDouble("是否预先充值：0.不充值");
		User u=new User();
		u.setName(name);
		u.setPsw(psw);
		u.setAdress(adress);
		u.setAge(age);
		u.setSex(sex);
		u.setTel(tel);
		u.setCost(0);
		u.setBalance(balance);
		u.setRank();
		if(ud.register(u)){
			return true;
		}
		return false;
	}

	@Override
	public User login() {
		IUserDao ud=new UserDao();
		String name=Util.getString("请输入用户名");
		while(!ud.nameIsOk(name)){
			name=Util.getString("没找到该用户，请重新输入用户名（输入0退出登录）");
			if(name.equals("0")){
				return null;
			}
		}
		String psw=Util.getString("请输入用户密码：");
		User user=ud.login(name, psw);
		return user;
	}
	@Override
	public void movieOptions(User u) {
		Movie m=null;
		while(true){
			int choose=Util.getInt("请输入选项：1.查看所有电影 2.搜索电影 0.返回");
			switch(choose){
				case 1:
					List<Movie> mls=selectMovies();
					m=selectMovie(mls);
					if(m==null){
						break;
					}
					movieOptions(u,m);
					break;
				case 2:
					m=selectMovie();
					if(m==null){
						break;
					}
					movieOptions(u,m);
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
	public void movieOptions(User u, Movie m) {
		int choose=Util.getInt("请输入选项：1.电影所有场次\t2.查看该电影影评\t0.返回");
		switch(choose){
		case 1:
			IShowPlanDao isp=new ShowPlanDao();
			List<ShowPlan> spls=isp.selectShowPlans(m);
			if(spls==null){
				System.out.println("没找到相关内容");
				return;
			}
			int n=0;
			int count=0;
			while(true){
				count=0;
				List<ShowPlan> spls2=apartTwo(spls,n);
				if(spls2==null){
					System.out.println("没找到相关场次");
					return;
				}
				
				
				for(ShowPlan sp:spls2){
					count++;
					IShowHallDao ish=new ShowHallDao();
					ShowHall hall=ish.selectShowHall(sp.getHallId());
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
					return;
				}
				else{
					try{
						if(Integer.valueOf(str) instanceof Integer){
							int num=Integer.valueOf(str);
							if(num>0&&num<=spls2.size()){
								ShowPlan sp=spls2.get(num-1);
								ShowHall hall=sp.getHall();
								Theater theater =hall.getTheater();
								System.out.println(count+":"+m.getName()+"  "+
								theater.getAdress()+"  "+theater.getName()+
								"  影厅："+hall.getTitle()+
								"\n播放时间："+sp.getShowtime().toString()+
								"   票价："+sp.getPrices()+"元");
								System.out.println("***********************************************************");
								tobuyTicket( u, sp);
								return;
							}else{
								System.out.println("你输入的选项有误，请重新输入！！！");
							}
						}
					}catch(Exception e){
						System.out.println("你输入的选项有误，请输入正确的选项！！！");
					}
					
					
				}
				
			}
			break;
		case 2:
			IReviewDao ird=new ReviewDao();
			List<Review> rls=ird.selectReview(m);
			if(rls==null){
				System.out.println("暂时还没有人填写该电影的影评");
				break;
			}
			int n2=0;
			int count2=0;
			while(true){
				count2=0;
				List<Review> rls2=apartTwo(rls,n2);
				for(Review r:rls2){
					count2++;
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
				}else{
					System.out.println("选项错误，QAQ");
					continue;
				}
			}
			break;
		case 0:
			return;
			default:
				System.out.println("请输入正确选项！！！");
				break;
		}
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
				if(m.getType().contains(type)){
					mls2.add(m);
				}
			}
			break;
		case 0:
			return null;
			default:		
				return null;
		}
		return selectMovie(mls2);
	}

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
	public List<Movie> selectMovies() {
		IMovieDao imd=new MovieDao();
		List<Movie> mls=imd.selecMovies();
		if(mls==null){
			return null;
		}
		if(mls.isEmpty()){
			return null;
		}return mls;
	}
//hallId
	@Override
	public void ticketOptions(User u) {
		ITicketDao itd=new TicketDao();
		List<Ticket> tls=itd.selectTickets(u);
		if(tls==null||tls.isEmpty()){
			System.out.println("目前还没有购票记录，请购票之后再来查看");
			return;
		}
		int n=0;
		int count=0;
		while(true){
			count=0;
			List<Ticket> tls2=apartTwo(tls,n);
			if(tls2==null){
				return ;
			}
			for(Ticket t :tls2){
				count++;
				IShowPlanDao isp=new ShowPlanDao();
//				System.out.println(t.getPlanId());
				ShowPlan sp=isp.getShowPlan(t.getPlanId());
				if(sp==null){
					continue ;
				}
				IShowHallDao ishd=new ShowHallDao();
				ShowHall hall=ishd.selectShowHall(sp.getHallId());
				if(hall==null){
					continue;
				}
				ITheaterDao ithd=new TheaterDao();
				
				Theater theater=ithd.selectTheater(hall.getTheaterId());
				if(theater==null){
					continue;
				}
				Seat s=t.getSeat();
				System.out.println(count+":电影名："+t.getMovieName()+
						"播放地点："+theater.getAdress()+
						","+theater.getName()+","+hall.getTitle()+
						"，播放时间："+t.getShowtime()+
						"，购买时间："+t.getBuytime()+
						"票价:"+t.getPrice()+",座位号："+s.getRow()+"行，"+s.getColum()+"列");
				hall.setTheater(theater);
				sp.setHall(hall);
				t.setPlan(sp);
			}
			String str=Util.getString("请输入你要查看的场次序号:\nq.上一页\tw.返回\te.下一页)");
			if(str.equals("q")){
				if(n==0){
					System.out.println("已经到首页了");
					
				}else{
					n--;
				}
				continue;
			}else if(str.equals("w")){
				return;
			}else if(str.equals("e")){
				if(tls.size()>(n+1)*20){
					System.out.println("已经到尾页了");
					
				}else{
					n++;
				}
				continue;
			}try{
				if(Integer.valueOf(str) instanceof Integer){
					int num=Integer.valueOf(str);
					if(num>0&&num<=tls2.size()){
						Ticket t=tls2.get(num-1);
						ShowPlan sp=t.getPlan();
						ShowHall hall=sp.getHall();
						Theater theater =hall.getTheater();
						Seat s=t.getSeat();
						System.out.println(count+":电影名："+t.getMovieName()+
								"播放地点："+theater.getAdress()+
								","+theater.getName()+","+hall.getTitle()+
								"，播放时间："+t.getShowtime()+
								"，购买时间："+t.getBuytime()+
								"票价:"+t.getPrice()+",座位号："+s.getRow()+"行，"+s.getColum()+"列");

						System.out.println("***********************************************************");
						Timestamp time=t.getShowtime();
						Timestamp time2=new Timestamp(System.currentTimeMillis());
						if(time.after(time2)){
							int choose2=Util.getInt("是否退票 ,1.退票");
							if(choose2==1){
								if(returnTicket(u,t)){
									tls.remove(t);
									System.out.println("电影票退票成功，购票钱已成功退回到用户余额");
									continue;
								}
							}
						}else{
						System.out.println("这个电影票已经过期，无法操作");
						}
					}else{
						System.out.println("你输入的选项有误，请重新输入！！！");
					}
				}
			}catch(Exception e){
				System.out.println("你输入的选项有误，请输入正确的选项！！！");
			}
		}
		
		
	}
	


	@Override
	public void tobuyTicket(User u,ShowPlan sp) {
		int choose=Util.getInt("是否购票？1.是\t2.否");
		switch(choose){
			case 1:
				if(buyTicket(u, sp)){
					System.out.println("您的账户余额为："+u.getBalance());
					System.out.println("购买成功，你可以去更多选项中去查看自己的电影票了");
				}else{
					System.out.println("购票失败");
				}
				break;
			case 2:
				break;
				default :
					System.out.println("输入选项有误，放弃此次购票");
					break;
		}
	}

	@Override
	public boolean buyTicket(User u,ShowPlan sp) {
		ITicketDao itd=new TicketDao();
		List<Seat> sls=itd.selectSeats(sp);
		if(sls==null){
			sls=new ArrayList<>();
		}
		ShowHall hall=sp.getHall();
		if((hall.getColums()*hall.getRows())>sls.size()){
			System.out.println("现已售出票数："+sls.size()+"剩余票数："+((hall.getColums()*hall.getRows())-sls.size()));
			Seat s=selectSeat(sls,hall);
			if(s==null){
				return false;
			}
			IUserDao iud=new UserDao();
			double prices=u.getDiscount()*sp.getPrices();
			while(u.getBalance()<prices){
				double choose=Util.getInt("充值金额：0.否");
				if(choose==0){
					return false;
					
				}else{
					double choose2=iud.recharge(u.getId(), choose, u.getRank(u.getBalance()+u.getCost()+choose));
					if(choose2==0){
					 return false;
					}
					u.setBalance(u.getBalance()+choose);
					u.setRank();
				}
			}
			if(itd.addTicket(u, sp, s.getRow(), s.getColum())){
				if(iud.payment(u.getId(), prices)){
					System.out.println("你已经购买成功本场电影的电影票，本次共花费："+prices+"元，记得准时去观看哦");
					u.setBalance(u.getBalance()-prices);
					u.setCost(u.getCost()+prices);
					return true;
				}else{
					
				}
			}
			
		}else{
			System.out.println("没有票了，请看其他的场次吧");
		}
		return false;
	}

	@Override
	public Seat selectSeat(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> selectTickets(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean returnTicket(User u,Ticket t) {
		ITicketDao itd=new TicketDao();
		if(itd.deleteTicket(u,t)){
			u.setBalance(u.getBalance()+t.getPrice());
			u.setCost(u.getCost()-t.getPrice());;
			return true;
		}
		return false ;
	}

	@Override
	public List<Theater> selectTheaters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theater selectTheater() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void theaterOptions(User u) {
		List<Theater> tls=null;
		ITheaterDao itd =new TheaterDao();
		tls=itd.selectTheaters();
		if(tls==null){
			System.out.println("没有电影院可以看电影");
			return;
		}
		Theater t=getTheater(tls);
		if(t==null){
			System.out.println("没有该电影院");
			return;
		}
		
		
		List<ShowPlan> spls=getShowPlan(t);
		if(spls==null){
			System.out.println("没有找到相关场次");
			return;
		}else{
			ShowPlan sp=getShowPlan(spls);
			if(sp==null){
				System.out.println("没有找到");
				return;
			}
			tobuyTicket(u,sp);
		}
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
					
					return null;
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
	public List<ShowPlan> getShowPlan(Theater t) {
		if(t==null){
			return null;
		}
		IShowPlanDao ispd=new ShowPlanDao();
		List<ShowPlan> spls=ispd.selectShowPlans(t);
		if(spls==null){
			return null;
		}
		return spls;
	}

	@Override
	public ShowPlan getShowPlan(List<ShowPlan> spls) {
		if(spls==null){
			return null;
		}
		Movie m=null;
		int n=0;
		int count=0;
		while(true){
			count=0;
			List<ShowPlan> spls2=apartTwo(spls,n);
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
	public void topMovies(User u) {
		IMovieDao imd=new MovieDao();
		List<Movie> mls=imd.selecTopMovies();
		Movie m=selectMovie(mls);
		if(m==null){
			return ;
		}
		movieOptions(u,m);
	}

	@Override
	public void reviewOptions(User u) {
		IReviewDao ird=new ReviewDao();
		int choose=Util.getInt("请输入选项：1.查看已写影评2.新增影评 0.返回");
		switch(choose){
		case 1:
			List<Review> rls=ird.selectReview(u);
			Review r=selectReview(u,rls);
			if(r==null){
				break;
			}
			 int choose2=Util.getInt("请输入选项：1.删除该影评 2.修改影评0.返回");
			 if(choose2==1){
				if( deleteReview(r)){
					System.out.println("删除成功");
					break;
				}
			 }if(choose2==2){
				 if(updateReview(r)){
					 System.out.println("修改成功。");
				 }else{
					 System.out.println("修改失败");
				 }
			 }
			break;
		case 2:
			ITicketDao itd=new TicketDao();
			int count=0;
			List<Review> orls=itd.selectUnwriteTickets(u);
			if(orls.isEmpty()||orls==null){
				System.out.println("没有可添加的影评，请先购票之后再来评价");
				break;
			}
			while(true){
				System.out.println("这是你目前已经购票却没有写影评的电影");
				count=0;
				for(Review re:orls){
					count++;
					Movie m=re.getMovie();
					System.out.println(count+":电影名："+m.getName()+"，简介："+m.getIntro());
				}
				int choose3=Util.getInt("你想添加那部电影的影评：（0.返回）");
				if(choose3==0){
					break;
				}else if(choose3>orls.size()){
					System.out.println("没有找到该序号");
				}else{
					Review re=orls.get(choose3-1);
					 double mark=Util.getDouble("输入评分：(最高10分)");
					 while(mark>10){
						 mark=Util.getDouble("输入评分：(最高10分)");
					 }
					 String comments=Util.getString("请输入你的影评");
					 re.setComments(comments);
					 re.setMark(mark);
					if(ird.addReview(re)){
						System.out.println("添加成功");
						orls.remove(choose3-1);
					}else{
						System.out.println("添加失败");
					}
				}
			}
			
			break;
		case 0:
			return;
			default:
				System.out.println("没有该选项！");
				break;
		}
	}
	@Override
	public Review selectReview(User u, List<Review> rls) {
		if(rls.isEmpty()){
			System.out.println("目前你还没有写影评");
			return null;
		}
		int n=0;
		int count=0;
		while(true){
			count=0;
			List<Review> rls2=apartTwo(rls,n);
			if(rls2.isEmpty()){
				return null;
			}
			for(Review r :rls2){
				count++;
				//IMovieDao imd=new MovieDao();
				Movie m=r.getMovie();
				if(m==null){
					continue ;
				}
				String comments=r.getComments();
				String showComment=comments;
				if(comments.length()<20){
					showComment=comments;
				}else{
					showComment=comments.substring(0, 20);
				}
				System.out.println(count+":电影名："+m.getName()+"，用户名："+u.getName()+"，评分"+r.getMark()+"，评论："+showComment);
			}
			String str=Util.getString("请输入你要操作的影评序号:\nq.上一页\tw.返回\te.下一页)");
			if(str.equals("q")){
				if(n==0){
					System.out.println("已经到首页了");
					
				}else{
					n--;
				}
				continue;
			}else if(str.equals("w")){
				return null;
			}else if(str.equals("e")){
				if(rls.size()>(n+1)*20){
					System.out.println("已经到尾页了");
					
				}else{
					n++;
				}
				continue;
			}try{
				if(Integer.valueOf(str) instanceof Integer){
					int num=Integer.valueOf(str);
					if(num>0&&num<=rls2.size()){
						Review r=rls2.get(num-1);
						Movie m=r.getMovie();
						System.out.println("***********************************************************");
						System.out.println(count+":电影名："+m.getName()+"，用户名："+u.getName()+"，评分"+r.getMark()+"，评论："+r.getComments());
						return r;
					}else{
						System.out.println("你输入的选项有误，请重新输入！！！");
					}
				}
			}catch(Exception e){
				System.out.println("你输入的选项有误，请输入正确的选项！！！");
			}
		}
		
	}

	@Override
	public boolean addReview(User u, Ticket t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReview(Review r) {
		if(r==null){
			return false;
		}
		 double mark=Util.getDouble("输入评分：(最高10分)");
		 while(mark>10){
			 mark=Util.getDouble("输入评分：(最高10分)");
		 }
		 String comments=Util.getString("请输入你要修改后的影评");
		 r.setComments(comments);
		 r.setMark(mark);
		 IReviewDao ird=new ReviewDao();
		 return ird.updateReview(r);
	}

	@Override
	public boolean deleteReview(Review r) {
		if(r==null){
			return true;
		}
		IReviewDao ird=new ReviewDao();
		
		return ird.deleteReview(r);
	}

	@Override
	public void rechargeOptions(User u) {
		double money=Util.getDouble("输入你要充值的金额:");
		if(money==0){
			System.out.println("取消充值。");
			return;
		}else{
			IUserDao iud=new UserDao();
			double balance=u.getBalance()+money;
			String rank=u.getRank(balance);
			double i=iud.recharge(u.getId(), balance, rank);
			if(i==-1){
				System.out.println("充值失败。");
				return;
			}else if(i==0){
				System.out.println("取消充值。");
				return;
			}else{
				u.setBalance(balance);
				u.setRank();
				System.out.println("此次充值了"+money+"元,您当前账户余额："+i);
				return;
			}
		}
		
	}

	@Override
	public boolean updatePsw(User u) {
		String psw=Util.getString("请输入之前的密码：");
		if(psw.equals(u.getPsw())){
			psw=Util.getString("请输入密码：");
			IUserDao iud=new UserDao();
			if(iud.updatePsw(u.getId(), psw)){
				u.setPsw(psw);
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 分页功能 （mysql中庸limit也可以实现）
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
			for(int i=0;i<20;i++){
				if((ls.size()-1)<i){
					break;
				}
				mid.add(ls.get(i));
			}
			return mid;
		}
		if(ls.size()<(n*20)){
			return apartTwo(ls,n-1);
		}
		else if(ls.size()<((n+1)*20)){
			for(int i=n*20;i<ls.size();i++){
				mid.add(ls.get(i));
			}
		}else{
			for(int i=n*20;i<(n+1)*20;i++){
				mid.add(ls.get(i));
			}
		}
		return mid;
	}

	@Override
	public Seat selectSeat(List<Seat> sls,ShowHall hall) {
		Seat seat=null;
		int row=hall.getRows();
		int colum=hall.getColums();
		int size=0;
		int flag=0;
		for(int i=row;i>0;i--){
			if(i<10){
				System.out.print("行0"+i+":");
			}else{
				System.out.print("行"+i+":");
			}
			
			for(int j=1;j<colum+1;j++){
				if(size<sls.size()){
					flag=0;
					for(Seat s:sls){
						if(s.getRow()==i&&s.getColum()==j){
							System.out.print("[Y]");
							size++;
							flag=1;
							break;
						}
					
				}if(flag==0){
					System.out.print("[N]");	
					}
				}else{
					System.out.print("[N]");
				}	
			}
			System.out.print(" \n");
		}
		System.out.print("    列  :");
		for(int i=1;i<=colum;i++){
			if(i<10){
				System.out.print("0"+i+" ");
			}else{
				System.out.print(i+" ");
			}
			
		}
		System.out.println("\n\t\t\t\t[  屏 幕     ]");
		while(true){
			row=Util.getInt("请输入你要选择的座位行号：(0.放弃购票)");
			if(row==0){
				return null;
			}else if(row<=hall.getRows()){
				colum=Util.getInt("请输入你要选择的座位列号：(0.放弃购票)");
				if(colum==0){
					return null;
				}else if(colum<=hall.getColums()){
					boolean isOk=true;
					for(Seat s:sls){
						if(s.getColum()==colum&&s.getRow()==row){
							System.out.println("你输入的该座位已经被买了，请重新选择");
							isOk=false;
							break;
						}
					}
					if(isOk){
						seat=new Seat();
						seat.setColum(colum);
						seat.setRow(row);
						seat.setHall(hall);
						return seat;
					}
				}else{
					System.out.println("请输入正确的座位号！！！");
				}
			}else{
				System.out.println("请输入正确的座位号！！！");
			}
			
		}
	}
}
