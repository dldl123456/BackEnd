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

    // 获取用户的注册数
    public int getUserNums() {
        return userNums;
    }

    // 增加用户
    public void insertUserData(UserData userData) {
        userDatas[userNums] = userData;
        userNums++;
    }

    // 查找用户
    public boolean findUserData(UserData userData) {

        for (int index = 0; index < userNums; index++) {
            if (userData.equals(userDatas[index]))
                return true;
        }
        return false;
    }

    // 显示用户
    public void displayUserData() {
        for (int index = 0; index < userNums; index++)
            System.out.println(userDatas[index].toString());
    }

    // 删除用户
    public boolean deleteUserData(UserData userData) {
        int goalPos;

        // 先遍历整个数组，获取需要删除的对象的位置
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
