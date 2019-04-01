package ddlspark.core;

public class NN_Estimator{
    int conf;
    public NN_Estimator(int conf){
        this.conf = conf;
	
    }

    public int getConf(){
        return this.conf;
    }

    public void printConf(){
        System.out.println("This is my conf "+this.conf);
    }
}

