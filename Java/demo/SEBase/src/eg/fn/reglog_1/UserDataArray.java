package eg.fn.reglog_1;

public class UserDataArray {
    private UserData[] userDatas;
    private int userNums;

    public UserDataArray() {
    }

    public UserDataArray(int maxNum) {
        userDatas = new UserData[maxNum];
        userNums = 0;
    }

    // ��ȡ�û���ע����
    public int getUserNums() {
        return userNums;
    }

    // �����û�
    public void insertUserData(UserData userData) {
        userDatas[userNums] = userData;
        userNums++;
    }

    // �����û�
    public boolean findUserData(UserData userData) {

        for (int index = 0; index < userNums; index++) {
            if (userData.equals(userDatas[index]))
                return true;
        }
        return false;
    }

    // ��ʾ�û�
    public void displayUserData() {
        for (int index = 0; index < userNums; index++)
            System.out.println(userDatas[index].toString());
    }

    // ɾ���û�
    public boolean deleteUserData(UserData userData) {
        int goalPos;

        // �ȱ����������飬��ȡ��Ҫɾ���Ķ����λ��
        for (goalPos = 0; goalPos < userNums; goalPos++)
            if (userData.equals(userDatas[goalPos]))
                break;

        if (goalPos == userNums)
            return false;
        else {
            for (int i = goalPos; i < userNums; i++)
                userDatas[i] = userDatas[i + 1];

            userNums--;
            return true;
        }
    }
    
    public static void main(String[] args) {
    	UserDataArray aa = new UserDataArray();
    	aa.displayUserData();
	}
}
