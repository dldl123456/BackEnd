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
		System.out.println("������Ҫ��ӵĵ�Ӱ����:");
		String movieName = input.next();
		System.out.println("������Ҫ��ӵĵ�Ӱ����:");
		String movieDirect = input.next();
		System.out.println("������Ҫ��ӵĵ�Ӱ����:");
		String movieMainActor = input.next();
		System.out.println("������Ҫ��ӵĵ�Ӱ����:");
		String movieType = input.next();
		System.out.println("������Ҫ��ӵĵ�Ӱ����:");
		String movieLanguage = input.next();
		a:while(true) {
			System.out.println("������Ҫ��ӵĵ�Ӱ��ӳʱ�䣨yyyyMMdd��:");
			String movieShowTime = input.next();
			Date date = Time.StringToDate1(movieShowTime);//�жϸ�ʽ�Ƿ���ȷ
			if(date==null) {
				continue a;
			}
			movieShowTime = Time.DateToString1(date);//ת����
			System.out.println("������Ҫ��ӵĵ�Ӱʱ��:");
			String movieTimeLength = input.next();
			System.out.println("������Ҫ��ӵĵ�ӰƱ��:");
			double moviePrice=0;
			moviePrice=HandleInputMismatchException.handleInputMismatchException(moviePrice);
			System.out.println("������Ҫ��ӵĵ�Ӱ����:");
			double movieScore=0;
			movieScore=HandleInputMismatchException.handleInputMismatchException(movieScore);
			System.out.println("������Ҫ��ӵĵ�Ӱ����:");
			String movieIntroduce = input.next();
			Movie movie =new Movie(movieName,movieDirect,movieMainActor,movieType,movieLanguage
					,movieShowTime,movieTimeLength,moviePrice,movieScore,movieIntroduce);
			return movie;
		}		
		
	}
	
	public static void MovieDeletePage() throws Exception {
		System.out.println("������Ҫɾ���ĵ�Ӱ����");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)!=-1) {
			if(new MovieDaoImpl().queryMovie(movieName).getMovieStatus()==1) {//�жϵ�Ӱ״̬
				System.out.println("��ǰ��ӰΪ������ӳ״̬������ɾ���������޸�״̬��");
				AdminView.adminOperateMoviePage();
			}
			Date date = new Date();
			if(new SessionDaoImpl().comparisonSession(movieName, date)!=-1) {//�ж�ʱ���Ƿ��ͻ���������ɾ��
				System.out.println("�˵�Ӱ��ǰ���е��ڣ�������ɾ��������");
				AdminView.adminOperateMoviePage();
			}
			System.out.println("��������Ҫɾ���ĵ�Ӱ��Ϣ��ȷ��ɾ��������1,��ɾ�������������֣������ѡ��");
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
						System.out.println("ɾ���ɹ�");
						System.out.println("��ѡ������������");
						AdminView.adminOperateMoviePage();
					}else {
						System.out.println("ɾ��ʧ��");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("��ѡ������������");
				AdminView.adminOperateMoviePage();
				break;
			}
		}else {
			System.out.println("������ĵ�Ӱ�����ڻ��Ѿ�ɾ����");
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
			System.out.println("��ѡ������������");
			AdminView.adminOperateMoviePage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void MovieSeePage() throws Exception {
		System.out.println("��������Ҫ��ѯ�ĵ�Ӱ���֣�");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("ϵͳ��û������Ҫ�鿴�ĵ�Ӱ������������");
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
		System.out.println("������Ҫ�޸ĵĵ�Ӱ���֣�");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("ϵͳ��û������Ҫ�޸ĵĵ�Ӱ������������");
			MovieUpdateStatus();
		}
		try {
			int status = md.queryMovie(movieName).getMovieStatus();
			if(status==0) {
				System.out.println("��ǰ״̬Ϊ�ȴ��ϼܣ��Ƿ��ϼܣ�ȷ���ϼ�����y,����������������ѡ��");
				char choose =input.next().charAt(0);
				switch(choose) {
				case 'y':
					md.updateMovieStatus(movieName, 1);
					System.out.println(movieName+"���ϼܣ�����");
					System.out.println("��ѡ������������");
					AdminView.adminOperateMoviePage();
					break;
				default:
					System.out.println("��ѡ������������");
					AdminView.adminOperateMoviePage();
					break;
				}
			}else if(status==1) {
				System.out.println("��ǰ״̬Ϊ�ϼܣ��Ƿ��¼ܣ�ȷ���¼�����y,����������������ѡ��");
				char choose =input.next().charAt(0);
				switch(choose) {
				case 'y':
					md.updateMovieStatus(movieName, 2);
					System.out.println(movieName+"���ϼܣ�����");
					System.out.println("��ѡ������������");
					AdminView.adminOperateMoviePage();
					break;
				default:
					System.out.println("��ѡ������������");
					AdminView.adminOperateMoviePage();
					break;
				}
			}else {
				System.out.println("��ǰ״̬Ϊ�¼ܣ��Ƿ��ϼܣ�ȷ���ϼ�����y,����������������ѡ��");
				char choose =input.next().charAt(0);
				switch(choose) {
				case 'y':
					md.updateMovieStatus(movieName, 1);
					System.out.println(movieName+"���¼ܣ�����");
					System.out.println("��ѡ������������");
					AdminView.adminOperateMoviePage();
					break;
				default:
					System.out.println("��ѡ������������");
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
		System.out.println("������Ҫ�޸ĵĵ�Ӱ���֣�");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("ϵͳ��û������Ҫ�޸ĵĵ�Ӱ������������");
			MovieUpdateScore();
		}
		try {
			System.out.println(movieName+"��ǰ��������"+md.queryMovie(movieName).getMovieScore());
			a:while(true) {
				System.out.println("������Ҫ���ĵķ�����");
				double score =0;
				score=HandleInputMismatchException.handleInputMismatchException(score);
				if(score>10&&score<0) {
					System.out.println("���������0С�ڵ���10�ķ���");
					continue a;
				}
				md.updateMovieSorce(movieName, score);
				System.out.println("�޸ĳɹ�������");
				System.out.println("��ѡ������������");
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
			//System.out.println("��Ӱ����\t\t\t����\t\t����\t\t\t\t\t����\t\t����\t\t��ӳʱ��\t\t����ʱ��\t\tƱ��\t\t����\t\t�Ƿ���ӳ");
			System.out.println("��Ӱ����");
			for(Movie movie : movies) {
				System.out.println(movieToString3(movie));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String movieToString(Movie movie) {
		return "��Ӱ���ƣ�"+movie.getMovieName()+"\n���ݣ�"+movie.getMovieDirect()+"\n���ݣ�"+movie.getMovieMainactor()
		+"\n���ͣ�"+movie.getMovieType()+"\n���ԣ�"+movie.getMovieLanguage()+"\n��ӳʱ�䣺"+movie.getMovieShowtime()
		+"\n����ʱ����"+movie.getMovieTimelength()+"\nƱ�ۣ�"+movie.getMoviePrice()+"\n���֣�"+movie.getMovieScore()
		+"\n�����飺"+movie.getMovieIntroduce()+"\n�Ƿ���ӳ��"+movie.judgeMovieStatus();
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
