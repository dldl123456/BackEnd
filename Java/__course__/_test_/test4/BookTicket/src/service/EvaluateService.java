package service;

import java.util.List;

import entity.Evaluate;

/**
 * 
 * @param �����۷����ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface EvaluateService {
	//�������
	public boolean addEvaluate(Evaluate evaluate);
	
	//��ѯ��������
	public boolean querryEvaluate(List<Evaluate> evaluatelist);
	
	//����idɾ������
	public boolean deleteEvaluate(int evaluate_id);
}
