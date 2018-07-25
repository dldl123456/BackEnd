package view;

import java.util.List;
import java.util.Scanner;

import dao.AssessmentDao;
import dao.impl.AssessmentDaoImpl;
import dao.impl.CinemaDaoImpl;
import dao.impl.MovieDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Assessment;
import help.HandleInputMismatchException;
import help.Time;

public class AssessmentView {
	static Scanner input = new Scanner(System.in);
	static Assessment assessment = new Assessment();
	static AssessmentDao asd = new AssessmentDaoImpl();
	
	public static Assessment AssessmentAddPage(int ticketId) {
		try {
			String assessmentTime = Time.nowTime();
			System.out.println("请输入您要评价的内容：");
			String assmentContent = input.next();
			System.out.println("请打分（0-10）：");
			double assessmentScore=0;
			assessmentScore=HandleInputMismatchException.handleInputMismatchException(assessmentScore);
			assessment = new Assessment(ticketId,assessmentTime,assmentContent,assessmentScore);
			int i = new AssessmentDaoImpl().addAssessment(assessment);
			if(i>0) {
				System.out.println("评价成功！！");
				System.out.println("请选择其他操作：");
				UserView.userMeanPage();
			}else {
				System.out.println("评价失败！！！");
				UserView.userMeanPage();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return assessment;
	}
	
	public static void AssessmentSeeAllPage() {
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessments();
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AssessmentSeeMovieAllPage() throws Exception {
		System.out.println("请输入要查找的电影id：");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)==-1) {
			System.out.println("系统中没有您要查找的电影编号，请重新输入！");
			AssessmentSeeMovieAllPage();
		}
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessmentsByMovie(movieId);
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void AssessmentSeeCinemaMovieAllPage() throws Exception {
		System.out.println("请输入要查找的电影id：");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)==-1) {
			System.out.println("系统中没有您要查找的电影编号，请重新输入！");
			AssessmentSeeMovieAllPage();
		}
		a:while(true) {
			System.out.println("请输入要查找的影院id：");
			int cinemaId=0;
			if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)==-1) {
				System.out.println("系统中没有您要查找的影院编号，请重新输入！");
				continue a;
			}
			cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
			try {
				List<Assessment> assessments;
				assessments = asd.queryAssessmentsByCinemaMovie(movieId, cinemaId);
				for(Assessment assessment :assessments) {
					System.out.println(AssessmentToString(assessment));
				}
				System.out.println("请选择其他操作：");
				AdminView.adminOperateAssessmentPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		}
	}
	
	public static void AssessmentSeeCinemaAllPage() throws Exception {
		System.out.println("请输入要查找的影院id：");
		int cinemaId=0;
		cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
		if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)==-1) {
			System.out.println("系统中没有您要查找的影院编号，请重新输入！");
			AssessmentSeeCinemaAllPage();
		}
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessmentsByCinema(cinemaId);
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AssessmentSeeUserAllPage() throws Exception {
		System.out.println("请输入要查看的用户id：");
		int userId=0;
		userId=HandleInputMismatchException.handleInputMismatchException(userId);
		if(new UserDaoImpl().comparisonUserId(userId)==-1) {
			System.out.println("系统中没有您要查看的用户编号，请重新输入！");
			AssessmentSeeUserAllPage();
		}
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessmentsByUser(userId);
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void AssessmentSeePage() throws Exception {
		System.out.println("请输入你要查看的评价编号：");
		int assessmentId=0;
		assessmentId=HandleInputMismatchException.handleInputMismatchException(assessmentId);
		if(new AssessmentDaoImpl().comparisonAssessmentId(assessmentId)==-1) {
			System.out.println("对不起，没有您要查看的评价，请重新输入！");
			AssessmentSeePage();
		}
		try {
			System.out.println("下面是您要查找的评价详细信息：");
			System.out.println(AssessmentToString(asd.queryAssessment(assessmentId)));
			System.out.println("请选择其他操作：");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String AssessmentToString(Assessment assessment) {		
		return assessment.getAssessmentId()+"\t"+assessment.getAssessmentTime()
		+"\t"+assessment.getAssessmentContent()+"\t"+assessment.getAssessmentScore();
	}
}
