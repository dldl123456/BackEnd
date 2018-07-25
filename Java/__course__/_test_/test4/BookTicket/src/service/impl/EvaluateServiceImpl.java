package service.impl;

import java.util.List;

import dao.EvaluateDao;
import dao.impl.EvaluateDaoImpl;
import entity.Evaluate;
import service.EvaluateService;

/**
 * 
 * @param ʵ�����۷���ӿ�
 * @author zmx2321
 * 
 */

public class EvaluateServiceImpl implements EvaluateService {
	private int code = 0;  //sqlִ��״̬
	
	private EvaluateDao evaluateDao;
	
	public EvaluateServiceImpl() {
		evaluateDao = new EvaluateDaoImpl();
	}
	
	//��ѯ��������
	@Override
	public boolean querryEvaluate(List<Evaluate> evaluatelist){
		evaluatelist = evaluateDao.querryEvaluate();
		
		return evaluatelist == null ? false : true;
	}
	
	//�������
	@Override
	public boolean addEvaluate(Evaluate evaluate) {
		code = evaluateDao.addEvaluate(evaluate);
		
		return code == 0 ? false : true;
	}
	
	//����idɾ������
	@Override
	public boolean deleteEvaluate(int evaluate_id) {
		code = evaluateDao.deleteEvaluate(evaluate_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		EvaluateServiceImpl esi = new EvaluateServiceImpl();
		
		//Evaluate evaluate = new Evaluate("123123", 1, 4);
		
		//��ѯ��������
		//System.out.println(esi.querryEvaluate(evaluatelist));
		
		//�������
		/*Evaluate evaluate1 = new Evaluate("123123", 1, 4);
		System.out.println(esi.addEvaluate(evaluate1));*/
		
		//����idɾ������
		System.out.println(esi.deleteEvaluate(1));
	}
}
