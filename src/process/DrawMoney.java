package process;

/**
 * Created by liyanzhen on 17/3/28.
 */
public class DrawMoney{
    public static void main(String args[]){
        Account a = new Account(1,10000);
        DrawThread d1 = new DrawThread("第一个取钱的人", a, 5000);
        d1.start();

        DrawThread 	d2 = new DrawThread("第二个取钱的人", a, 6000);
        d2.start();
    }
}

class Account{
    private int mId;
    private int mMoney;

    public Account(){}
    public Account(int id,int money){
        this.mId = id;
        this.mMoney = money;
    }

    public void setMId(int id){
        this.mId = id;
    }
    public void setMMoney(int money){
        this.mMoney = money;
    }
    public int getMId(){
        return this.mId;
    }
    public int getMMoney(){
        return this.mMoney;
    }

    // public int hashCode(){
    // 	return mId.hashCode();
    // }

    // public boolean equals(Object obj){
    // 	if (this == obj) {
    // 		return true;
    // 	}
    // 	if (obj != null && obj.getClass() == Account.class){
    // 		Account target = (Account) obj;
    // 		return target.getMId().equals(mId);
    // 	}
    // 	return false;
    // }
}

class DrawThread extends Thread{
    private Account account;
    private int drawMoney;

    public DrawThread(String name,Account account,int drawMoney){
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    public void run(){
        synchronized(account){
            if(account.getMMoney() >= drawMoney){
                System.out.println(this.getName() + "取钱成功");
                account.setMMoney(account.getMMoney() - drawMoney);
                System.out.println(this.getName() + "取钱后还剩余额为 ：" + account.getMMoney());
            }else{
                System.out.println(this.getName() + "---->余额不足");
            }
        }
    }
}