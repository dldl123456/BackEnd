package dao;

import java.util.List;

import entity.Evaluate;

/**
 * 
 * @param ���������ṩ���ݽӿ�
 * @author zmx2321
 *
 */

public interface EvaluateDao {
	//�������
	public int addEvaluate(Evaluate evaluate);
	
	//��ѯ��������
	public List<Evaluate> querryEvaluate();
	
	//����idɾ������
	public int deleteEvaluate(int evaluate_id);
}
