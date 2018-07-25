package contro;

import java.util.List;

import dao.EvaluateDao;
import dao.impl.EvaluateDaoImpl;
import entity.Evaluate;
import service.EvaluateService;
import service.impl.EvaluateServiceImpl;
import util.Help;

/**
 * 
 * @param ���ۿ��Ʋ�
 * @author zmx2321
 * 
 */


public class EvaluateContro {
	static EvaluateService evaluateService = new EvaluateServiceImpl();
	static EvaluateDao evaluateDao = new EvaluateDaoImpl();
	
	//��ѯ��������
	public static void queryEvaluate(){
		List<Evaluate> evaluateList = evaluateDao.querryEvaluate();
		
		if (evaluateList.isEmpty()) {
			System.out.println("�������ۣ�");
			return;
		}
		
		boolean success = evaluateService.querryEvaluate(evaluateList);
		
		if(success){
			for(Evaluate evaluate : evaluateList){
				System.out.println(evaluate.getEvaluate_id() + "��" + 
					evaluate.getMovie().getMovie_name() + "\n" + 
					evaluate.getUser().getUser_name() + "\n" + 
					evaluate.getEvaluate_content() + " \n" + 
					evaluate.getEvaluate_time() + "\n"
				);
			}
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		evaluateList.clear();
	}
	
	//�������
	public static Evaluate addEvaluate(int user_id){
		int movie_id = Help.getInt("����������Ҫ���۵ĵ�Ӱ��ţ�");
		String evaluate_content = Help.getString("����д�������ۣ�");
		
		Evaluate evaluate = new Evaluate(evaluate_content, movie_id, user_id);
		
		boolean success = evaluateService.addEvaluate(evaluate);
		
		if (success) {
			System.out.println("���۳ɹ���\n");
			return evaluate;
		} else {
			System.out.println("����ʧ�ܣ�\n");
			return null;
		}
	}
	
	//����idɾ������
	public static void deleteEvaluate(){
		queryEvaluate();
		
		int evaluate_id = Help.getInt("��������Ҫɾ�������۱�ţ�");
		
		boolean success = evaluateService.deleteEvaluate(evaluate_id);
		
		if(success){
			System.out.println("����ɾ���ɹ���\n");
			queryEvaluate();
		}else{
			System.out.println("����ɾ��ʧ�ܣ�\n");
		}
	}
	
	//test
	public static void main(String[] args) {
		//�������
		//addEvaluate(1);
		
		//��ѯ��������
		queryEvaluate();
		
		//����idɾ������
		//deleteEvaluate();
	}
}
