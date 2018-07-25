package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;
import dao.impl.SessionDaoImpl;
import entity.Movie;
import help.HandleInputMismatchException;
import help.Time;

public class MovieView {
	
	static Scanner input = new Scanner(System.in);
	static Movie movie = new Movie();
	static MovieDao md = new MovieDaoImpl();
	
	
	public static Movie MovieAddPage() {
		System.out.println("请输入要添加的电影名称:");
		String movieName = input.next();
		System.out.println("请输入要添加的电影导演:");
		String movieDirect = input.next();
		System.out.println("请输入要添加的电影主演:");
		String movieMainActor = input.next();
		System.out.println("请输入要添加的电影类型:");
		String movieType = input.next();
		System.out.println("请输入要添加的电影语言:");
		String movieLanguage = input.next();
		a:while(true) {
			System.out.println("请输入要添加的电影上映时间（yyyyMMdd）:");
			String movieShowTime = input.next();
			Date date = Time.StringToDate1(movieShowTime);//判断格式是否正确
			if(date==null) {
				continue a;
			}
			movieShowTime = Time.DateToString1(date);//转回来
			System.out.println("请输入要添加的电影时长:");
			String movieTimeLength = input.next();
			System.out.println("请输入要添加的电影票价:");
			double moviePrice=0;
			moviePrice=HandleInputMismatchException.handleInputMismatchException(moviePrice);
			System.out.println("请输入要添加的电影评分:");
			double movieScore=0;
			movieScore=HandleInputMismatchException.handleInputMismatchException(movieScore);
			System.out.println("请输入要添加的电影介绍:");
			String movieIntroduce = input.next();
			Movie movie =new Movie(movieName,movieDirect,movieMainActor,movieType,movieLanguage
					,movieShowTime,movieTimeLength,moviePrice,movieScore,movieIntroduce);
			return movie;
		}		
		
	}
	
	public static void MovieDeletePage() throws Exception {
		System.out.println("请输入要删除的电影名：");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)!=-1) {
			if(new MovieDaoImpl().queryMovie(movieName).getMovieStatus()==1) {//判断电影状态
				System.out.println("当前电影为正在热映状态，不能删除，请先修改状态！");
				AdminView.adminOperateMoviePage();
			}
			Date date = new Date();
			if(new SessionDaoImpl().comparisonSession(movieName, date)!=-1) {//判断时间是否冲突如果有则不能删除
				System.out.println("此电影当前还有档期，不可以删除！！！");
				AdminView.adminOperateMoviePage();
			}
			System.out.println("下面是你要删除的电影信息，确认删除请输入1,不删请输入其他数字，请谨慎选择：");
			try {
				movie = md.queryMovie(movieName);
				System.out.println(movieToString(movie));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int choose=0;
			choose=HandleInputMismatchException.handleInputMismatchException(choose);
			switch(choose) {
			case 1:
				try {
					int i=md.deleteMovie(movieName);
					if(i>0) {
						System.out.println("删除成功");
						System.out.println("请选择其他操作：");
						AdminView.adminOperateMoviePage();
					}else {
						System.out.println("删除失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("请选择其他操作：");
				AdminView.adminOperateMoviePage();
				break;
			}
		}else {
			System.out.println("您输入的电影不存在或已经删除！");
			AdminView.adminOperateMoviePage();
		}
	}
	
	public static void MovieSeeAllPage() {
		try {
			List<Movie> movies;
			movies = md.queryMovies();
			for(Movie movie :movies) {
				if(movie.getMovieStatus()>1) {
					continue;
				}
				System.out.println(movieToString1(movie));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateMoviePage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void MovieSeePage() throws Exception {
		System.out.println("请输入你要查询的电影名字：");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("系统中没有你想要查看的电影，请重新输入");
			MovieSeePage();
		}
		try {
			System.out.println(movieToString(md.queryMovie(movieName)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static void MovieUpdateStatus() throws Exception {
		System.out.println("请输入要修改的电影名字：");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("系统中没有你想要修改的电影，请重新输入");
			MovieUpdateStatus();
		}
		try {
			int status = md.queryMovie(movieName).getMovieStatus();
			if(status==0) {
				System.out.println("当前状态为等待上架，是否上架？确认上架输入y,否则输入其他，请选择：");
				char choose =input.next().charAt(0);
				switch(choose) {
				case 'y':
					md.updateMovieStatus(movieName, 1);
					System.out.println(movieName+"已上架！！！");
					System.out.println("请选择其他操作：");
					AdminView.adminOperateMoviePage();
					break;
				default:
					System.out.println("请选择其他操作：");
					AdminView.adminOperateMoviePage();
					break;
				}
			}else if(status==1) {
				System.out.println("当前状态为上架，是否下架？确认下架输入y,否则输入其他，请选择：");
				char choose =input.next().charAt(0);
				switch(choose) {
				case 'y':
					md.updateMovieStatus(movieName, 2);
					System.out.println(movieName+"已上架！！！");
					System.out.println("请选择其他操作：");
					AdminView.adminOperateMoviePage();
					break;
				default:
					System.out.println("请选择其他操作：");
					AdminView.adminOperateMoviePage();
					break;
				}
			}else {
				System.out.println("当前状态为下架，是否上架？确认上架输入y,否则输入其他，请选择：");
				char choose =input.next().charAt(0);
				switch(choose) {
				case 'y':
					md.updateMovieStatus(movieName, 1);
					System.out.println(movieName+"已下架！！！");
					System.out.println("请选择其他操作：");
					AdminView.adminOperateMoviePage();
					break;
				default:
					System.out.println("请选择其他操作：");
					AdminView.adminOperateMoviePage();
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void MovieUpdateScore() throws Exception {
		System.out.println("请输入要修改的电影名字：");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("系统中没有你想要修改的电影，请重新输入");
			MovieUpdateScore();
		}
		try {
			System.out.println(movieName+"当前的评分是"+md.queryMovie(movieName).getMovieScore());
			a:while(true) {
				System.out.println("请输入要更改的分数：");
				double score =0;
				score=HandleInputMismatchException.handleInputMismatchException(score);
				if(score>10&&score<0) {
					System.out.println("请输入大于0小于等于10的分数");
					continue a;
				}
				md.updateMovieSorce(movieName, score);
				System.out.println("修改成功！！！");
				System.out.println("请选择其他操作：");
				AdminView.adminOperateMoviePage();
				break;
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void movieRankListPage() {
		try {
			List<Movie> movies = md.moviesRankList();
			//System.out.println("电影名称\t\t\t导演\t\t主演\t\t\t\t\t类型\t\t语言\t\t上映时间\t\t播放时长\t\t票价\t\t评分\t\t是否上映");
			System.out.println("电影名称");
			for(Movie movie : movies) {
				System.out.println(movieToString3(movie));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String movieToString(Movie movie) {
		return "电影名称："+movie.getMovieName()+"\n导演："+movie.getMovieDirect()+"\n主演："+movie.getMovieMainactor()
		+"\n类型："+movie.getMovieType()+"\n语言："+movie.getMovieLanguage()+"\n上映时间："+movie.getMovieShowtime()
		+"\n播放时长："+movie.getMovieTimelength()+"\n票价："+movie.getMoviePrice()+"\n评分："+movie.getMovieScore()
		+"\n剧情简介："+movie.getMovieIntroduce()+"\n是否上映："+movie.judgeMovieStatus();
	}
	public static String movieToString1(Movie movie) {
		return movie.getMovieName()+"\t\t"+movie.getMovieDirect()+"\t\t"+movie.getMovieMainactor()+"\t\t\t\t\t"+movie.getMovieType()+"\t\t"+movie.getMovieLanguage()
		+"\t\t"+movie.getMovieShowtime()+"\t\t"+movie.getMovieTimelength()+"\t\t"+movie.getMoviePrice()+"\t\t"+movie.getMovieScore()+"\t\t"+movie.judgeMovieStatus()+"\n";
	}
	public static String movieToString2(Movie movie) {
		return movie.getMovieId()+"\t"+movie.getMovieName()+"\n";
	}
	public static String movieToString3(Movie movie) {
		return movie.getMovieName()+"\n";
	}
}
