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
			System.out.println("��������Ҫ���۵����ݣ�");
			String assmentContent = input.next();
			System.out.println("���֣�0-10����");
			double assessmentScore=0;
			assessmentScore=HandleInputMismatchException.handleInputMismatchException(assessmentScore);
			assessment = new Assessment(ticketId,assessmentTime,assmentContent,assessmentScore);
			int i = new AssessmentDaoImpl().addAssessment(assessment);
			if(i>0) {
				System.out.println("���۳ɹ�����");
				System.out.println("��ѡ������������");
				UserView.userMeanPage();
			}else {
				System.out.println("����ʧ�ܣ�����");
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
			System.out.println("��ѡ������������");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AssessmentSeeMovieAllPage() throws Exception {
		System.out.println("������Ҫ���ҵĵ�Ӱid��");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)==-1) {
			System.out.println("ϵͳ��û����Ҫ���ҵĵ�Ӱ��ţ����������룡");
			AssessmentSeeMovieAllPage();
		}
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessmentsByMovie(movieId);
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("��ѡ������������");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void AssessmentSeeCinemaMovieAllPage() throws Exception {
		System.out.println("������Ҫ���ҵĵ�Ӱid��");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)==-1) {
			System.out.println("ϵͳ��û����Ҫ���ҵĵ�Ӱ��ţ����������룡");
			AssessmentSeeMovieAllPage();
		}
		a:while(true) {
			System.out.println("������Ҫ���ҵ�ӰԺid��");
			int cinemaId=0;
			if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)==-1) {
				System.out.println("ϵͳ��û����Ҫ���ҵ�ӰԺ��ţ����������룡");
				continue a;
			}
			cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
			try {
				List<Assessment> assessments;
				assessments = asd.queryAssessmentsByCinemaMovie(movieId, cinemaId);
				for(Assessment assessment :assessments) {
					System.out.println(AssessmentToString(assessment));
				}
				System.out.println("��ѡ������������");
				AdminView.adminOperateAssessmentPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		}
	}
	
	public static void AssessmentSeeCinemaAllPage() throws Exception {
		System.out.println("������Ҫ���ҵ�ӰԺid��");
		int cinemaId=0;
		cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
		if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)==-1) {
			System.out.println("ϵͳ��û����Ҫ���ҵ�ӰԺ��ţ����������룡");
			AssessmentSeeCinemaAllPage();
		}
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessmentsByCinema(cinemaId);
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("��ѡ������������");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AssessmentSeeUserAllPage() throws Exception {
		System.out.println("������Ҫ�鿴���û�id��");
		int userId=0;
		userId=HandleInputMismatchException.handleInputMismatchException(userId);
		if(new UserDaoImpl().comparisonUserId(userId)==-1) {
			System.out.println("ϵͳ��û����Ҫ�鿴���û���ţ����������룡");
			AssessmentSeeUserAllPage();
		}
		try {
			List<Assessment> assessments;
			assessments = asd.queryAssessmentsByUser(userId);
			for(Assessment assessment :assessments) {
				System.out.println(AssessmentToString(assessment));
			}
			System.out.println("��ѡ������������");
			AdminView.adminOperateAssessmentPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void AssessmentSeePage() throws Exception {
		System.out.println("��������Ҫ�鿴�����۱�ţ�");
		int assessmentId=0;
		assessmentId=HandleInputMismatchException.handleInputMismatchException(assessmentId);
		if(new AssessmentDaoImpl().comparisonAssessmentId(assessmentId)==-1) {
			System.out.println("�Բ���û����Ҫ�鿴�����ۣ����������룡");
			AssessmentSeePage();
		}
		try {
			System.out.println("��������Ҫ���ҵ�������ϸ��Ϣ��");
			System.out.println(AssessmentToString(asd.queryAssessment(assessmentId)));
			System.out.println("��ѡ������������");
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
